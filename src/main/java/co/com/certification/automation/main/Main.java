package co.com.certification.automation.main;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void connectToAppium() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "your_device_name");
        caps.setCapability("app", "path_to_your_apk_file");
        // Set the Appium server URL
        URL appiumServerURL = new URL("http://localhost:4723/wd/hub");
        // Create an instance of the AppiumDriver
        AppiumDriver<MobileElement> driver = new AndroidDriver<>(appiumServerURL, caps);
        // Now you can perform actions on the connected app using the 'driver' object
        // For example, you can find elements, click buttons, etc.
        // Close the driver session
        driver.quit();
    }
    public static void main(String[] args) {

        System.out.println("Hello world!");
    }
}