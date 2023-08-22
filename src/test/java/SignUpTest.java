import Models.User;
import Screens.HomeScreen;
import Screens.LauncherScreen;
import Screens.ProfileScreen;
import Screens.SignupScreen;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest {
    @Test
    public void shouldClientShouldSignUp(){
        // 1.Arrange
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel_6");
        caps.setCapability("udid", "emulator-5554"); // You can get it from 'adb devices' command
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("app", "/Users/testvagrant/Files/MobileAutomation/app/ul-coach.apk"); // Replace with your app's path
        caps.setCapability("appPackage", "com.ultralesson.coach");
        caps.setCapability("appActivity", "com.ultralesson.coach.MainActivity");
        caps.setCapability("noReset", true);
        AppiumDriver mobileDriver = null;
            
        // 2.Actions
        LauncherScreen launcherScreen = new LauncherScreen(mobileDriver);
        launcherScreen.navToClientSignup();
        User client = new User("randomclient@gmail.com",
                "password",
                "Automation Client",
                "1234567890",
                "12-12-22");

        //Act
        SignupScreen signupScreen = new SignupScreen(mobileDriver);
        HomeScreen homeScreen = signupScreen.signup(client);

        ProfileScreen profileScreen = homeScreen.navToProfile();
        User clientProfile = profileScreen.getProfileDetails();

        // Assert
        Assert.assertEquals(clientProfile.getEmail(), client.getEmail());
        Assert.assertEquals(clientProfile.getFullName(), client.getFullName());
        Assert.assertEquals(clientProfile.getMobile(), client.getMobile());

        // Assume we have called a date utility to supply Today's Date
        Assert.assertEquals(clientProfile.getMembershipStartDate(), "Today's Date");
    }
}
