import jdk.Exported;
import org.junit.jupiter.api.*;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class QuestionPageTest {
    public static WebDriver webDriver;
    public static MainPage mainPage;
    public QuestionPage questionPage;
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


        mainPage.getQuestionButton().click();
        questionPage = new QuestionPage(webDriver);
    }

    @Test
    @DisplayName("Simple question")
    public void simpleTest() {
        String topic = "iloveyou";
        String text = "ilove";

        questionPage.getQuestionTopicField().click();
        questionPage.getQuestionTopicField().sendKeys(topic);

        questionPage.getQuestionTextField().click();
        questionPage.getQuestionTextField().sendKeys(text);

        questionPage.getCategoryButton().click();
        questionPage.getCategoryWithSubcategory().click();

        questionPage.getSubcategoryButton().click();
        questionPage.getSubcategory().click();

        questionPage.getPublishButton().click();

        try {
            new WebDriverWait(webDriver, 10).until(ExpectedConditions.visibilityOf(questionPage.getIsPublished()));
        } catch (TimeoutException exception) {
            Assertions.fail("Fail");
        }
    }

    @Test
    @DisplayName("Question without subcategory")
    public void withoutSubcategory() {
        String topic = "DHSKFDJSHFKDSHFKDSJ";
        String text = "How to work with TestNG";

        questionPage.getQuestionTopicField().click();
        questionPage.getQuestionTopicField().sendKeys(topic);

        questionPage.getQuestionTextField().click();
        questionPage.getQuestionTextField().sendKeys(text);

        questionPage.getCategoryButton().click();
        questionPage.getCategoryWithoutSubcategory().click();

        try {
            new WebDriverWait(webDriver, 10).until(ExpectedConditions.invisibilityOf(questionPage.getSubcategoryButton()));
        } catch (TimeoutException exception) {
            Assertions.fail();
        }
    }

    @Test
    @DisplayName("Question without topic")
    public void withoutTopic() {
        String topic = "";
        String text = "How to work with TestNG";

        questionPage.getQuestionTopicField().click();
        questionPage.getQuestionTopicField().sendKeys(topic);

        questionPage.getQuestionTextField().click();
        questionPage.getQuestionTextField().sendKeys(text);

        questionPage.getCategoryButton().click();
        questionPage.getCategoryWithoutSubcategory().click();

        try {
            new WebDriverWait(webDriver, 10).until(ExpectedConditions.visibilityOf(questionPage.getError()));
        } catch (TimeoutException exception) {
            Assertions.fail();
        }
    }
}
