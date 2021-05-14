/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class LoginPage {
    @FindBy(xpath = "//input[@name='username']")
    private WebElement loginField;

    @FindBy(xpath = "//button[@data-test-id='next-button']")
    private WebElement buttonToThePassword;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@data-test-id='submit-button']")
    private WebElement entryButton;

    @FindBy(xpath = "/html/body/div[1]/div[3]/table/tbody/tr/td[2]/div[1]/table/tbody/tr/td[1]/div/div/div/span/i[3]")
    private WebElement expectedLogin;

    public LoginPage(final WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public WebElement getLoginField() {
        return loginField;
    }

    public WebElement getButtonToThePassword() {
        return buttonToThePassword;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getEntryButton() {
        return entryButton;
    }

    public WebElement getExpectedLogin() {
        return expectedLogin;
    }
}
