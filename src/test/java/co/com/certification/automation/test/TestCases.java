package co.com.certification.automation.test;

import co.com.certification.automation.pages.LoginPage;
import co.com.certification.automation.pages.MainPage;
import co.com.certification.automation.pages.SearchProductPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TestCases extends ConfigTest {

    private MainPage mainPage;
    private LoginPage loginPage;

    private static final String USER_EMAIL="correopruebapruebachoucair@gmail.com";

    private static final String USER_PASSWORD="Choucair1121++";

    @Test
    public void testLogin(){
       testOfExtentReport = extentReports.createTest("Prueba de login grupo exito");
        mainPage=new MainPage(androidDriver, testOfExtentReport);
        mainPage.getInToLogin();
        loginPage=new LoginPage(androidDriver,testOfExtentReport);
        loginPage.login(USER_EMAIL,USER_PASSWORD);

    }

    @Test
    public void addProductToShoppingCart(){
        testOfExtentReport = extentReports.createTest("Prueba de agregar un producto a carrito de compras");
        mainPage=new MainPage(androidDriver,testOfExtentReport);
        mainPage.getInToLogin();
        loginPage=new LoginPage(androidDriver,testOfExtentReport);
        loginPage.login(USER_EMAIL,USER_PASSWORD);
        SearchProductPage searchProductPage=new SearchProductPage(androidDriver,testOfExtentReport);
        String product="Celular";
        searchProductPage.addProductToShopping(product);
        boolean elementIsDisplayed=searchProductPage.productIsDisplayed();
        Assert.assertTrue(elementIsDisplayed);
    }

    @AfterTest
    public void closeTests(){
        androidDriver.quit();
    }


}
