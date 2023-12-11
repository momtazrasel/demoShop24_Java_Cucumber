package locators;

import org.openqa.selenium.By;

public class LoginPage {
    public By usernameField = By.id("username");
    public By passwordField = By.id("password");
    public By loginButton = By.xpath("(//input[@value='Login'])[1]");
    public By invalidUserInfo = By.id("userMessageText");
    public By myAccountButton = By.xpath("(//span[normalize-space()='My Account'])[1]");
    public By loginOption = By.xpath("(//a[normalize-space()='Login'])[1]");
    public By emailTextField = By.xpath("(//input[@id='input-email'])[1]");
    public By passwordTextField = By.xpath("(//input[@id='input-password'])[1]");
    public By alertText = By.xpath("(//div[@class='alert alert-danger alert-dismissible'])[1]");
}
