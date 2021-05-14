import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class MainPage {
    @FindBy(xpath = "/html/body/div[1]/div[3]/table/tbody/tr/td[2]/div[2]/table/tbody/tr/td/a[2]")
    private WebElement loginButton;

    @FindBy(xpath = "//span[@name='clb3917180']/a[@class='js-link pm-toolbar__button__inner']")
    private WebElement questionButton;

    @FindBy(xpath = "/html/body/div[1]/div[5]/div[2]/div[1]/div/div[2]/div/span/span[2]/span[3]/span/form/span[1]/span[1]/input")
    private WebElement searchField;

    @FindBy(xpath = "/html/body/div[1]/div[5]/div[2]/div[1]/div/div[2]/div/span/span[2]/span[3]/span/form/span[2]/button")
    private WebElement searchButton;

    private WebElement questionFromAnotherButton;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div/div/iframe")
    private WebElement frame;

    public MainPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getQuestionButton() {
        return questionButton;
    }

    public WebElement getQuestionFromAnotherButton() {
        return questionFromAnotherButton;
    }

    public WebElement getFrame() {
        return frame;
    }
}
