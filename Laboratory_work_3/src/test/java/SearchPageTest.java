import org.junit.jupiter.api.*;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class SearchPageTest {
    public static WebDriver webDriver;
    public static MainPage mainPage;
    public SearchPage searchPage;
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
        String login = "ivan_for_lab3";
        String password = "testing_lab4";

        loginPage.getLoginField().sendKeys(login);
        loginPage.getButtonToThePassword().click();

        loginPage.getPasswordField().sendKeys(password);
        loginPage.getEntryButton().click();

        new WebDriverWait(webDriver, 10).until(visibilityOf(loginPage.getExpectedLogin()));


        mainPage.getSearchField().click();
        searchPage = new SearchPage(webDriver);
    }

    @Test
    @DisplayName("Valid query")
    public void validQueryTest() {
        mainPage.getSearchField().sendKeys("My name is");
        mainPage.getSearchButton().click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Assertions.fail();
            e.printStackTrace();
        }
        int value = Integer.parseInt(searchPage.getIsValid().getText().split(" ")[1]);
        Assertions.assertNotEquals(0, value);
    }

    @Test
    @DisplayName("invalid query")
    public void ValidquerryTest() {
        mainPage.getSearchField().sendKeys("AKD;LFAKHSDFBVSDJC");
        mainPage.getSearchButton().click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Assertions.fail();
            e.printStackTrace();
        }

        try {
            new WebDriverWait(webDriver, 10).until(ExpectedConditions.visibilityOf(searchPage.getNonValid()));
        } catch (TimeoutException exception) {
            Assertions.fail("Fail");
        }
    }
}
