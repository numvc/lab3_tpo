import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {

    public WebDriver driver;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div/div/div/div/span/a")
    private WebElement profile;

    @FindBy(xpath = "/html/body/div[15]/div/div[1]/div/div/div/a[7]")
    private WebElement logoutBtn;

    @FindBy(xpath = "/html/body/div[15]/div/div[1]/div/div/div/a[5]")
    private WebElement userDataBtn;

    @FindBy(xpath = "/html/body/div[1]/div[4]/div/div[2]/div/div[2]/div[2]/div[2]/div[2]")
    private WebElement login;

    public void logout(){
        Actions builder = new Actions(driver);
        builder.moveToElement(profile).build().perform();

        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.visibilityOf(logoutBtn));

        logoutBtn.click();
    }

    public String getLogin(){
        Actions builder = new Actions(driver);
        builder.moveToElement(profile).build().perform();

        WebDriverWait wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.visibilityOf(userDataBtn));

        userDataBtn.click();
        return login.getText();
    }


}
