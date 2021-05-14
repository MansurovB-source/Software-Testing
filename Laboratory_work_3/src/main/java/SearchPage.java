import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class SearchPage {

    /*
    * Если по запросу что-то найдено
    * */
    @FindBy(xpath = "//div[@class='totalResults_3siw3HHo']")
    private WebElement isValid;

    /*
    * Если по запросу ничего не найдено
    * */
    @FindBy(xpath = "//div[@class='noResultsTitle_LOyHfs6z']")
    private WebElement nonValid;


    public SearchPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public WebElement getIsValid() {
        return isValid;
    }

    public WebElement getNonValid() {
        return nonValid;
    }
}
