import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    public WebDriver driver;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "/html/body/div[1]/div[3]/div/div/div/div/input")
    private WebElement searchField;

    @FindBy(xpath = "/html/body/div[1]/div[3]/div/div/div/div/div[2]")
    private WebElement startSearchBtn;

    @FindBy(xpath = "/html/body/div[1]/div[4]/x-app-content/div[3]/div/div[2]/div[2]/div/div[3]/div/div[4]/div/div/div/div[1]")
    private WebElement chooseSizeField;

    @FindBy(xpath = "/html/body/div[1]/div[4]/x-app-content/div[3]/div/div[2]/div[2]/div/div[3]/div/div[4]/div/div/div/div[3]/div[2]/div[2]/div/div[1]/div[1]")
    private WebElement size;

    @FindBy(xpath = "/html/body/div[1]/div[4]/x-app-content/div[3]/div/div[2]/div[2]/div/div[3]/div/div[5]/button/span")
    private WebElement addToCartBtn;

    @FindBy(xpath = "/html/body/div[1]/div[9]/div/div/div[3]/div[1]/span")
    private WebElement contShopping;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div/a[2]/span")
    private WebElement openCartBtn;

    @FindBy(xpath = "/html/body/div[1]/div[6]/div[3]/div[3]/div[2]/div/div[2]/div/div/div[1]/div[1]")
    private WebElement cartPosition;

    @FindBy(xpath = "/html/body/div[16]/div/div/div/div[2]/div/div[2]/a/span")
    private WebElement positionInfoBtn;

    @FindBy(xpath = "/html/body/div[1]/div[4]/x-app-content/div[3]/div/div[2]/div[2]/div/div[4]/div[2]/div/div[10]/span[2]")
    private WebElement articule;

    public void addToCartByArt(String art) {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.visibilityOf(searchField));
        searchField.click();
        searchField.sendKeys(art);
        startSearchBtn.click();
        chooseSizeField.click();

        wait.until(ExpectedConditions.visibilityOf(size));
        size.click();

        addToCartBtn.click();
        wait.until(ExpectedConditions.visibilityOf(contShopping));

        contShopping.click();
    }

    public String getArtFromCart() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.visibilityOf(openCartBtn));
        openCartBtn.click();
        js.executeScript("window.scrollBy(0,1000)");
        wait.until(ExpectedConditions.visibilityOf(cartPosition));

        int arg = 1;
        String xpath = "/html/body/div[1]/div[6]/div[3]/div[3]/div[2]/div/div[2]/div[" + arg + "]";

        js.executeScript("window.scrollBy(0,1400)");
        WebElement product = driver.findElement(By.xpath(xpath));

        while (product != null) {
            if (getArtByProduct(xpath).equals(Constant.adidasOzw)) {
                js.executeScript("window.scrollBy(0,300)");

                return articule.getText();
            }
            openCartBtn.click();
            arg++;
            xpath = "/html/body/div[1]/div[6]/div[3]/div[3]/div[2]/div/div[2]/div[" + arg + "]";
            product = driver.findElement(By.xpath(xpath));
        }
        return "";
    }


    public void deleteFromCartByArt(String art) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        openCartBtn.click();
        int arg = 1;
        String xpath = "/html/body/div[1]/div[6]/div[3]/div[3]/div[2]/div/div[2]/div[" + arg + "]";

        js.executeScript("window.scrollBy(0,1400)");
        WebElement product = driver.findElement(By.xpath(xpath));

        while (product != null) {
            if (getArtByProduct(xpath).equals(art)) {
                openCartBtn.click();
                js.executeScript("window.scrollBy(0,1400)");
                deleteBtnByXpath(xpath);
                break;
            }
            openCartBtn.click();
            arg++;
            xpath = "/html/body/div[1]/div[6]/div[3]/div[3]/div[2]/div/div[2]/div[" + arg + "]";
            product = driver.findElement(By.xpath(xpath));
        }
    }

    public void deleteBtnByXpath(String xpath) {
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement((By.xpath(xpath + "/div/div[3]/div[2]/button")))).click().build().perform();
    }

    public String getArtByProduct(String xpath) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.findElement(By.xpath(xpath + "/div/div[1]/div[1]")).click();
        positionInfoBtn.click();
        js.executeScript("window.scrollBy(0,700)");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(articule));
        return articule.getText();
    }
}
