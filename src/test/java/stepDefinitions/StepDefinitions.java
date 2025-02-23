package stepDefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AdminPage;
import pages.LoginPage;

public class StepDefinitions {

    WebDriver driver;
    LoginPage loginPage;
    AdminPage adminPage;
    int initialRecords;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        loginPage = new LoginPage(driver);
        adminPage = new AdminPage(driver);
    }

    @When("I log in with {string} and {string}")
    public void i_log_in_with(String username, String password) {
        loginPage.login(username, password);
    }

    @When("I navigate to the Admin section")
    public void i_navigate_to_the_admin_section() throws InterruptedException {
        adminPage.navigateToAdmin();
    }

    @When("I get the number of records")
    public void i_get_the_number_of_records() {
        initialRecords = adminPage.getNumberOfRecords();
    }

    @When("I add a new user with {string} and {string}")
    public void i_add_a_new_user_with(String username, String password) {
        adminPage.addUser(username, password);
    }

    @Then("I verify the number of records increased by 1")
    public void i_verify_the_number_of_records_increased_by_1() {
        Assert.assertEquals(initialRecords + 1, adminPage.getNumberOfRecords());
    }

    @When("I search for {string}")
    public void i_search_for(String username) {
        adminPage.searchUser(username);
    }

    @When("I delete the user")
    public void i_delete_the_user() {
        adminPage.deleteUser();
    }

    @Then("I verify the number of records decreased by 1")
    public void i_verify_the_number_of_records_decreased_by_1() {
        Assert.assertEquals(initialRecords, adminPage.getNumberOfRecords());
        driver.quit();
    }
}
