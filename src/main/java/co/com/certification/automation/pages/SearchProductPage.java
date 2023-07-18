package co.com.certification.automation.pages;

import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class SearchProductPage extends BasePage{

    private final By locatorSearchBar=By.id("com.exito.appcompania:id/appCompatEditText_search_bar");

    private final By locatorEditInputSearchData=By.id("com.exito.appcompania:id/appCompatEditText_search_data_edit");



    private final By locatorSearchButton=By.id("com.exito.appcompania:id/text_input_start_icon");


    private final By locatorButtonReceivedInHome =By.id("com.exito.appcompania:id/constraitLayout_user_address");

    private final By locatorListCities=By.id("com.exito.appcompania:id/filled_exposed_dropdown_city");

    private final By locatorListStores=By.id("com.exito.appcompania:id/filled_exposed_dropdown_store");

    private final By locatorButtonConfirmAdress =By.id("com.exito.appcompania:id/appCompatButton_continue");

    private final By locatorButtonFinishLocation =By.id("com.exito.appcompania:id/appCompatButton_continue");

    private final By locatorButtonAddToCart =By.id("com.exito.appcompania:id/add_to_cart_button");


    private final By locatorTextInSearch=By.xpath("/hierarchy/android.widget.FrameLayout/android" +
            ".widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget" +
            ".FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/androidx" +
            ".appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/android.view.ViewGroup/androidx" +
            ".recyclerview.widget.RecyclerView/android.widget.FrameLayout[3]");


    private final By locatorFirstProduct=By.xpath("/hierarchy/android.widget.FrameLayout/android.widget" +
            ".LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android" +
            ".view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx" +
            ".recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/android" +
            ".view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView");

    private final By locatorDontSendDonationButton=By.xpath("/hierarchy/android.widget" +
            ".FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget" +
            ".LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup" +
            "/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android" +
            ".webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android" +
            ".view.View[2]/android.view.View[1]/android.widget.TextView");

    private final By locatorButtonPay=By.xpath("/hierarchy/android.widget.FrameLayout/android" +
            ".widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget" +
            ".FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android" +
            ".view.ViewGroup/android.view.ViewGroup[2]/android.webkit.WebView/android.webkit.WebView/android" +
            ".view.View/android.view.View[4]/android.widget.Button");

    private final By locatorButtonShoppingCart=By.id("com.exito.appcompania:id/appCompatImageView_shopping_cart");

    private final By locatorProductInShoppingCart=By.xpath("/hierarchy/android.widget.FrameLayout/android.widget" +
            ".LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view" +
            ".ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]" +
            "/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[5]");



    public SearchProductPage(AndroidDriver androidDriver, ExtentTest extentTest) {
        super(androidDriver, extentTest);
    }

    public void addProductToShopping(String product){

        androidDriver.findElement(locatorSearchBar).sendKeys(product);
        androidDriver.findElement(locatorSearchBar).click();
        androidDriver.findElement(locatorButtonReceivedInHome).click();
        attachedScreenShotTotest("Confirmar direccion de envio");
        androidDriver.findElement(locatorButtonConfirmAdress).click();

        androidDriver.findElement(locatorEditInputSearchData).sendKeys(product);
        attachedScreenShotTotest("Ingresar parametros de busqueda");
        androidDriver.findElement(locatorEditInputSearchData).click();
        androidDriver.findElement(locatorTextInSearch).click();
        androidDriver.findElement(locatorFirstProduct).click();
        attachedScreenShotTotest("Agregar a carrito");
        androidDriver.findElement(locatorButtonShoppingCart).click();
    }

    public boolean productIsDisplayed(){
        boolean isProductDisplayed= androidDriver.findElement(locatorProductInShoppingCart).isDisplayed();
        attachedScreenShotTotest("Pantalla de carrito con productos agregados");
        return isProductDisplayed;
    }


}
