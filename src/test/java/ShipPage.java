import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShipPage {
    public WebDriver driver;

    public ShipPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "/html/body/div[1]/div[6]/div[3]/div[3]/div[1]/form/fieldset/div[1]/div/div/span/input")
    private WebElement telNumInput;

    @FindBy(xpath = "/html/body/div[1]/div[6]/div[3]/div[3]/div[1]/form/fieldset/fieldset[2]/div[1]/div/div/span/input")
    private WebElement nameInput;

    @FindBy(xpath = "/html/body/div[1]/div[6]/div[3]/div[3]/div[1]/form/fieldset/fieldset[2]/div[2]/div/div/span/input")
    private WebElement surnameInput;

    @FindBy(xpath = "/html/body/div[1]/div[6]/div[3]/div[3]/div[1]/form/fieldset/fieldset[1]/div/div/div/span/input[1]")
    private WebElement cityInput;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div/a[2]/span")
    private WebElement openCartBtn;

    public void setShipData(String telnum, String name, String surname, String city) throws InterruptedException {
        openCartBtn.click();

        surnameInput.sendKeys(surname);

        nameInput.click();
        Thread.sleep(2000);
        nameInput.sendKeys(name);

        cityInput.click();
        Thread.sleep(2000);
        cityInput.clear();
        Thread.sleep(2000);
        cityInput.sendKeys(city);

        telNumInput.click();
        Thread.sleep(2000);
        telNumInput.sendKeys(telnum);

    }

}