package co.com.certification.automation.test;


import co.com.certification.automation.connection.ConectionAppium;
import co.com.certification.automation.pages.MainPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.android.AndroidDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;

public class ConfigTest {
    protected static ExtentTest testOfExtentReport;
    protected static ExtentSparkReporter extentHtmlReport;

    protected static ExtentReports extentReports;

    protected AndroidDriver androidDriver;

    protected MainPage mainPage;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        androidDriver= ConectionAppium.getConectionAppium().getAndroidDriver();
    }
    @BeforeMethod
    public static void startTest()
    {
        extentHtmlReport = new ExtentSparkReporter("reportes/reporterTestResult.html");
        extentReports=new ExtentReports();
        extentReports.attachReporter(extentHtmlReport);

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        // Lógica para capturar el resultado del caso de prueba y agregarlo al informe
        if (result.getStatus() == ITestResult.FAILURE) {
            testOfExtentReport.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            testOfExtentReport.pass("Test passed");
        } else if (result.getStatus() == ITestResult.SKIP) {
            testOfExtentReport.skip("Test skipped");
        }
        extentReports.flush();

    }




}
