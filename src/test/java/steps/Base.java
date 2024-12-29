package steps;

import basePackage.AppiumServerClass;
import basePackage.EmulatorLauncher;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.URL;

public class Base
{
    public static AndroidDriver driver;

    public static void setDriver() throws InterruptedException {
        EmulatorLauncher.startEmulator();
        AppiumServerClass.startAppium();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel_7_API_34")
                .setPlatformVersion("14.0")
                .setUdid("emulator-5554")
                .setAutomationName("UiAutomator2")
                .setPlatformName("Android")
                .setAutoGrantPermissions(true)
                .setNoReset(true)
                .setAppPackage("com.aciana.docisn")
                .setAppActivity("com.aciana.docisn.MainActivity");
        try
        {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
            System.out.println("Driver initiated");
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public static AndroidDriver getDriver()
    {
        System.out.println("This is get driver");
        return driver;

    }

}
