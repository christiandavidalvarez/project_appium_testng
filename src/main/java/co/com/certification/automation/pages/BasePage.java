package co.com.certification.automation.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BasePage {

    protected AndroidDriver androidDriver;
    protected ExtentTest testOfExtentReport;

    public BasePage(AndroidDriver androidDriver ,ExtentTest extentTest) {
        this.androidDriver = androidDriver;
        this.testOfExtentReport=extentTest;

    }
    private String captureScreenshot()  {
        // Capturar la captura de pantalla utilizando Appium y WebDriverException
        DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String dateTimeScreenshoot= LocalDateTime.now().format(formatDateTime);
        String screenshotPath =
                String.format("reportes/capturasDePantalla/screenshot_%s.png",dateTimeScreenshoot);
        try {
            Object androidDriver;
            TakesScreenshot ts = (TakesScreenshot)this.androidDriver;
            byte[] screenshotBytes = ts.getScreenshotAs(OutputType.BYTES);
            FileUtils.writeByteArrayToFile(new File(screenshotPath), screenshotBytes);
        } catch (WebDriverException | IOException e) {
            System.err.println("Error al tomar la captura de pantalla: " + e.getMessage());
        }
        return screenshotPath.replace("reportes/","");
    }

    protected void attachedScreenShotTotest(String tittleOfStep){
        String screenshotPath = captureScreenshot();
        testOfExtentReport.info(tittleOfStep,
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

    }
}