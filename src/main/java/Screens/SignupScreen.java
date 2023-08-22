package Screens;

import Models.User;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SignupScreen {
    private AppiumDriver appiumDriver;
    By email = By.xpath("//*[@text()='id:email']");
    By password = By.xpath("//*[@text()='id:password']");
    By fullName = By.xpath("//*[@text()='id:fullname']");
    By signupBtn = By.xpath("//*[@text='SIGNUP']");
    public SignupScreen(AppiumDriver mobileDriver) {
        this.appiumDriver = mobileDriver;
    }

    public HomeScreen signup(User client) {
        appiumDriver.findElement(email).sendKeys(client.getEmail());
        appiumDriver.findElement(password).sendKeys(client.getPassword());
        appiumDriver.findElement(fullName).sendKeys(client.getFullName());
        appiumDriver.findElement(signupBtn).click();

        // Return the HomeScreen as it navigates to HomeScreen on clicking signup.
        return new HomeScreen(appiumDriver);
    }
}
