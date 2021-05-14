import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class QuestionPage {
    @FindBy(xpath = "//textarea[@name='question_text']")
    private WebElement questionTopicField;

    @FindBy(xpath = "//textarea[@name='question_additional']")
    private WebElement questionTextField;

    // /html/body/div[2]/div[4]/div[2]/div/div[2]/div/div/div/form/div/div[2]/label/div[4]/div[1]/div/textarea

    @FindBy(xpath = "//div[@class='bg_1wfFyRZG']")
    private WebElement publishButton;

    @FindBy(css = ".categories__col_left_htnOx8nf > .wrapper_3TiBmL6t span")
    private WebElement categoryButton;

    @FindBy(css = ".select_empty_3WXn_WLl path")
    private WebElement subcategoryButton;

    @FindBy(xpath = "//span[@class='content__text_2EFZnJ4i'][text()='Образование']")
    private WebElement categoryWithSubcategory;

    @FindBy(xpath = "//span[@class='content__text_2EFZnJ4i'][text()='Другое']")
    private WebElement categoryWithoutSubcategory;

    @FindBy(xpath = "//span[@class='content__text_2EFZnJ4i'][text()='ВУЗы, Колледжи']")
    private WebElement subcategory;

    @FindBy(xpath = "//div[@class='wrapper_1qMJ11sU']")
    private WebElement isPublished;

    @FindBy(xpath = "//div[@class='error_HR1dcLLP']")
    private WebElement error;

    public QuestionPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public WebElement getQuestionTopicField() {
        return questionTopicField;
    }

    public WebElement getQuestionTextField() {
        return questionTextField;
    }

    public WebElement getPublishButton() {
        return publishButton;
    }

    public WebElement getCategoryButton() {
        return categoryButton;
    }

    public WebElement getSubcategoryButton() {
        return subcategoryButton;
    }

    public WebElement getCategoryWithSubcategory() {
        return categoryWithSubcategory;
    }

    public WebElement getCategoryWithoutSubcategory() {
        return categoryWithoutSubcategory;
    }

    public WebElement getSubcategory() {
        return subcategory;
    }

    public WebElement getIsPublished() {
        return isPublished;
    }

    public WebElement getError() {
        return error;
    }
}