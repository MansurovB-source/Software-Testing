import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class LoginPageTest {
    public static WebDriver webDriver;
    private static MainPage mainPage;
    public LoginPage loginPage;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Behruz Mansurov\\Desktop\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.get("https://otvet.mail.ru/");
        mainPage = new MainPage(webDriver);
    }

    @AfterAll
    public static void setDown() {
        webDriver.close();
    }

    @BeforeEach
    public void setLoginPage() {
        mainPage.getLoginButton().click();
        webDriver.switchTo().frame(1);
        loginPage = new LoginPage(webDriver);
    }

    @Test
    @DisplayName("Test for correct login and password")
    public void authCorrectTest() {
        String login = "ivan_for_lab3";
        String password = "testing_lab4";

        loginPage.getLoginField().sendKeys(login);
        loginPage.getButtonToThePassword().click();

        loginPage.getPasswordField().sendKeys(password);
        loginPage.getEntryButton().click();

        try {
            new WebDriverWait(webDriver, 10).until(ExpectedConditions.visibilityOf(loginPage.getExpectedLogin()));
        } catch (TimeoutException exception) {
            Assertions.fail("Fail");
        }
    }
}
