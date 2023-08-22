package Screens;

import Models.User;
import io.appium.java_client.AppiumDriver;

public class SignupScreen {
    private AppiumDriver appiumDriver;
    public SignupScreen(AppiumDriver mobileDriver) {
        this.appiumDriver = mobileDriver;
    }

    public HomeScreen signup(User client) {
        return new HomeScreen(appiumDriver);
    }
}
