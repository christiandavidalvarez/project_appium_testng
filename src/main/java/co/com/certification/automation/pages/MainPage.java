package co.com.certification.automation.pages;

import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class MainPage extends BasePage {

    public MainPage(AndroidDriver androidDriver , ExtentTest extentTest) {
        super(androidDriver,extentTest);
    }

    private final By locatorButtonLogin=By.id("com.exito.appcompania:id/AppCompatButton_ingresar");
    private final By locatorButtonRegister=By.id("com.exito.appcompania:id/AppCompatButton_registrarse");

    public void getInToLogin(){
        androidDriver.findElement(locatorButtonLogin).click();
        attachedScreenShotTotest("Se realiza login en exito");
    }


}
