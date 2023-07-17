package co.com.certification.automation.test;

import co.com.certification.automation.connection.ConectionAppium;
import co.com.certification.automation.pages.MainPage;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class TestCases {

    private AndroidDriver androidDriver;

    private MainPage mainPage;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        androidDriver= ConectionAppium.getConectionAppium().getAndroidDriver();
        mainPage=new MainPage(androidDriver);
    }

    @Test
    public void login(){
        mainPage.getInToLogin();
    }

    @AfterTest
    public void closeTests(){
        androidDriver.quit();
    }


}
