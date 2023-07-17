package co.com.certification.automation.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class MainPage {

    private AndroidDriver androidDriver;

    public MainPage(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    private final By locatorButtonLogin=By.id("com.exito.appcompania:id/AppCompatButton_ingresar");
    private final By locatorButtonRegister=By.id("com.exito.appcompania:id/AppCompatButton_registrarse");

    public void getInToLogin(){
        androidDriver.findElement(locatorButtonLogin).click();
        System.out.println( androidDriver.findElement(locatorButtonLogin).getText());
    }


}
