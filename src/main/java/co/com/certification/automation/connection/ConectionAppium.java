package co.com.certification.automation.connection;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ConectionAppium {
    private static ConectionAppium conectionAppium;

    private final AndroidDriver androidDriver;

  public static ConectionAppium getConectionAppium() throws MalformedURLException {
        if(conectionAppium==null)
            return new ConectionAppium();
        else
            return conectionAppium;
    }

    private ConectionAppium() throws MalformedURLException {
       androidDriver= configAndroidDriver();
    }

    public  AndroidDriver getAndroidDriver() {
        return androidDriver;
    }

    private static AndroidDriver configAndroidDriver() throws MalformedURLException {

        UiAutomator2Options options=new UiAutomator2Options();
        options.setDeviceName("emulator-5554");

        File file=new File("src/main/resources/exito_3.5.1_apkcombo.com.apk");
        options.setApp(file.getAbsolutePath());
        options.setAppPackage("com.exito.appcompania");
        options.setAppActivity("com.exito.appcompania.views.initialaccess.activities.SplashActivity");

        AndroidDriver androidDriver=new AndroidDriver(new URL("http://127.0.0.1:4723"),options);

        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        return androidDriver;

    }
}
