import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class AnswerPage {
    @FindBy(xpath = "//textarea[@class='autosize_3eNTQag5']")
    private WebElement answerField;

    @FindBy(xpath = "/html/body/div[2]/div[4]/div[2]/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/form/div[2]/a")
    private WebElement answerButton;

    @FindBy(xpath = "//div[@class='error_HR1dcLLP']")
    private WebElement error;

    public AnswerPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public WebElement getAnswerField() {
        return answerField;
    }

    public WebElement getAnswerButton() {
        return answerButton;
    }

    public WebElement getError() {
        return error;
    }
}
