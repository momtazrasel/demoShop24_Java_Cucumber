package stepDefinitions.Login;

import ReusableMethods.ExcelDataReader;
import base.PageObjectManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.DriverSetup;

import java.io.IOException;
import java.util.List;

public class LoginSteps {
    private WebDriver driver;
    private PageObjectManager pom;
    private LoginPage loginPage = new LoginPage();

    public LoginSteps(DriverSetup driverSetup) {
        this.driver = driverSetup.driver;
        this.pom = new PageObjectManager(driver);
    }

    @When("User enter valid username and password in login form")
    public void userEnterValidUsernameAndPasswordInLoginForm() throws IOException {
        String filePath = "TestData/Credentials.xlsx";
        String sheetName = "Sheet1";
        List<String[]> excelData = ExcelDataReader.readDataFromExcel(filePath, sheetName);

        for (String[] row : excelData) {
            if (row.length >= 2){
                String username1 = row[0];
                String password = row[1];

                pom.sendKeysToElement(loginPage.emailTextField, username1);
                pom.sendKeysToElement(loginPage.passwordTextField, String.valueOf(password));
            }else {
                System.out.println("Invalid data format in Excel row.");

            }

        }
    }
    @When("User enter invalid username and password in login form")
    public void userEnterInvalidUsernameAndPasswordInLoginForm() throws IOException {
        String filePath = "TestData/Credentials.xlsx";
        String sheetName = "Sheet1";
        List<String[]> excelData = ExcelDataReader.readDataFromExcel(filePath, sheetName);

        for (String[] row : excelData) {
            String username1 = row[0];
            String password = row[2];

            pom.sendKeysToElement(loginPage.emailTextField, username1);
            pom.sendKeysToElement(loginPage.passwordTextField, password);
        }
    }
    @And("Clicks on Log in button")
    public void clicksOnLogInButton() {
        pom.clickElement(loginPage.loginButton);
    }
    @Then("Verify that the username or password is invalid")
    public void verifyThatTheUsernameOrPasswordIsInvalid() {
        Assert.assertEquals(pom.getTextOfElement(loginPage.alertText),"Warning: No match for E-Mail Address and/or Password.");
    }

    @When("Click on the My Account Button")
    public void clickOnTheMyAccountButton() {
        pom.waitUntilElementIsVisible(loginPage.myAccountButton);
        pom.clickElement(loginPage.myAccountButton);
    }

    @And("Click on the Login Option")
    public void clickOnTheLoginOption() {
        pom.waitUntilElementIsVisible(loginPage.loginOption);
        pom.clickElement(loginPage.loginOption);
    }

    @When("User enter valid username and invalid password in login form")
    public void userEnterValidUsernameAndInvalidPasswordInLoginForm() throws IOException {
        String filePath = "TestData/Credentials.xlsx";
        String sheetName = "Sheet1";
        List<String[]> excelData = ExcelDataReader.readDataFromExcel(filePath, sheetName);

        for (String[] row : excelData) {
            String username1 = row[0];
            String password = row[2];

            pom.sendKeysToElement(loginPage.emailTextField, username1);
            pom.sendKeysToElement(loginPage.passwordTextField, password);
        }
    }

    @When("User enter invalid username and valid password in login form")
    public void userEnterInvalidUsernameAndValidPasswordInLoginForm() throws IOException {
        String filePath = "TestData/Credentials.xlsx";
        String sheetName = "Sheet1";
        List<String[]> excelData = ExcelDataReader.readDataFromExcel(filePath, sheetName);

        for (String[] row : excelData) {
            String username1 = row[3];
            String password = row[1];

            pom.sendKeysToElement(loginPage.emailTextField, username1);
            pom.sendKeysToElement(loginPage.passwordTextField, password);
        }
    }
}
