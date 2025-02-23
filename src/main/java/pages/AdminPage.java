package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AdminPage extends BasePage {

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a")
    private WebElement adminTab;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")
    private WebElement addButton;

    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span")
    private WebElement recordsText;

    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input")
    private WebElement usernameField;

    @FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "(//input[@type='password'])[2]")
    private WebElement confirmPassword;

    @FindBy(xpath = "(//div[@class='oxd-select-text-input'][normalize-space()='-- Select --'])[1]")
    private WebElement UserRole;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement EmplyeeName;

    @FindBy(xpath = "//div[@class='oxd-select-text oxd-select-text--active']")
    private WebElement Status;

    @FindBy(xpath = "//button[text()=' Save ']")
    private WebElement saveButton;

    @FindBy(xpath = "//button[text()=' Search ']")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement searchField;

    @FindBy(xpath = "//button[text()=' Delete ']")
    private WebElement deleteButton;

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToAdmin() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(adminTab));
        adminTab.click();
        Thread.sleep(100);
    }

    public int getNumberOfRecords() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(recordsText));
        return Integer.parseInt(recordsText.getText().replaceAll("[^0-9]", ""));
    }

    public void addUser(String username, String password) {
        addButton.click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        confirmPassword.sendKeys(password);
        UserRole.click();
        WebElement firstOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@role='listbox']//div[@role='option'][1]")  // Finds the first option
        ));
        firstOption.click();



        EmplyeeName.sendKeys("deek 425 5TlV");
        Status.click();
        WebElement firstOption2 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//div[@role='listbox']//div[@role='option'])[1]")  // Finds the first Status option
        ));
        firstOption2.click();

        saveButton.click();
    }

    public void searchUser(String username) {
        searchField.sendKeys(username);
        searchButton.click();
    }

    public void deleteUser() {
        deleteButton.click();
    }
}
