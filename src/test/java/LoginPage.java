import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.driver = webDriver;
    }


    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div/a[1]")
    private WebElement toLoginBtn;

    @FindBy(xpath = "/html/body/div[1]/div[5]/div[4]/div/div/div[2]/div/div/div[2]/div/div[2]/div[1]/form/div[2]/div/div[1]/input")
    private WebElement loginField;

    @FindBy(xpath = "/html/body/div[1]/div[5]/div[4]/div/div/div[2]/div/div/div[2]/div/div[2]/div[1]/form/div[3]/div[1]/input")
    private WebElement passwordField;

    @FindBy(xpath = "/html/body/div[1]/div[5]/div[5]/div/div/div[2]/div/div/div[2]/div/div[2]/div[1]/form/div[4]/button")
    private WebElement loginSubBtn;

    public void clickToStartLogin() {
        toLoginBtn.click();
    }

    public void loginInput(String login) {
        loginField.sendKeys(login);
    }

    public void passwordInput(String pswd) {
        passwordField.sendKeys(pswd);
    }


    public void clickToLogin() {
        loginSubBtn.click();
    }

}
