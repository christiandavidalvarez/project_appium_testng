package co.com.certification.automation.pages;

import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    public LoginPage(AndroidDriver androidDriver, ExtentTest extentTest) {
        super(androidDriver, extentTest);
    }
    private final By locatorEmailUser=By.id("com.exito.appcompania:id/TextInputEditText_email");

    private final By locatorEmaiPassword=By.xpath("/hierarchy/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/" +
            "android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/" +
            "android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android." +
            "widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.EditText");
    private final By locatorButtonLogin=By.id("com.exito.appcompania:id/AppCompatButton_ingresar");

    private final By locatorButtonDennyPermission=By.id("com.android.permissioncontroller:id/permission_deny_button");

    public void login(String userEmail,String password){
        androidDriver.findElement(locatorEmailUser).sendKeys(userEmail);
        androidDriver.findElement(locatorEmaiPassword).sendKeys(password);
        attachedScreenShotTotest("El usuario ingresa datos de login");
        androidDriver.findElement(locatorButtonLogin).click();
        androidDriver.findElement(locatorButtonDennyPermission).click();
        attachedScreenShotTotest("El usuario ingresa con credenciales");
    }



}
