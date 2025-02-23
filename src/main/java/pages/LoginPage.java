package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage extends BasePage {



    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver,10);

        // Wait for Username Field to be Visible
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.sendKeys(username);

        // Wait for Password Field to be Visible
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);

        // Wait for Login Button to be Clickable
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }
}
