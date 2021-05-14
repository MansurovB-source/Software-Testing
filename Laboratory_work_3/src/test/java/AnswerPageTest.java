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
public class AnswerPageTest {
    public static WebDriver webDriver;
    public static MainPage mainPage;
    public AnswerPage answerPage;
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

        webDriver.get("https://otvet.mail.ru/question/224864593");
        answerPage = new AnswerPage(webDriver);
    }

    @Test
    @DisplayName("empty answer")
    public void fail() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        answerPage.getAnswerField().click();
        answerPage.getAnswerField().sendKeys("   ");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        answerPage.getAnswerButton().click();


        try {
            new WebDriverWait(webDriver, 10).until(ExpectedConditions.visibilityOf(answerPage.getError()));
        } catch (TimeoutException exception) {
            Assertions.fail();
        }
    }

    @Test
    @DisplayName("just answer")
    public void publishing() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        answerPage.getAnswerField().click();
        answerPage.getAnswerField().sendKeys("It's just test");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        answerPage.getAnswerButton().click();


        try {
            new WebDriverWait(webDriver, 10).until(ExpectedConditions.invisibilityOf(answerPage.getError()));
        } catch (TimeoutException exception) {
            Assertions.fail();
        }
    }
}
