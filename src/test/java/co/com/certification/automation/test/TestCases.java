package co.com.certification.automation.test;

import co.com.certification.automation.pages.MainPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TestCases extends ConfigTest {

    @Test
    public void login(){
       testOfExtentReport = extentReports.createTest("Prueba de login grupo exito");
        mainPage=new MainPage(androidDriver, testOfExtentReport);
        mainPage.getInToLogin();
    }

    @AfterTest
    public void closeTests(){
        androidDriver.quit();
    }


}
