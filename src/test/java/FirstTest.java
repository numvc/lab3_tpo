import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class FirstTest {

    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;
    public static CartPage cartPage;
    public static ShipPage shipPage;


    @BeforeAll
    public static void setup() {

        System.setProperty("webdriver.chrome.driver", "C:/All/InstrumentsProga/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/Users/Victor/AppData/Local/Google/Chrome/User Data/Profile 1");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.get(Constant.website);


        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        cartPage = new CartPage(driver);
        shipPage = new ShipPage(driver);
    }

    @Test
    void loginTest() throws InterruptedException {
        loginPage.clickToStartLogin();
        loginPage.loginInput(Constant.login);
        loginPage.passwordInput(Constant.password);
        loginPage.clickToLogin();
        Assertions.assertEquals(Constant.login, profilePage.getLogin());
    }

    @Test
    void addToCart(){
        cartPage.addToCartByArt(Constant.adidasOzw);
        Assertions.assertEquals(cartPage.getArtFromCart(), Constant.adidasOzw);
    }

    @Test
    void deleteFromCart(){
        cartPage.deleteFromCartByArt(Constant.adidasOzw);
    }

    @Test
    void setShipData() throws InterruptedException {
        shipPage.setShipData(Constant.telnum, Constant.name, Constant.surname, Constant.city);
    }

    @Test
    void logout(){
        profilePage.logout();
    }
}
