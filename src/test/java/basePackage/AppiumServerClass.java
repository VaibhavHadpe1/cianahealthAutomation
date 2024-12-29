package basePackage;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.cucumber.java.After;

import java.io.File;

public class AppiumServerClass
{
    public static AppiumDriverLocalService server;

    //Set the instance of server.
    public static void setInstance()
    {
        AppiumServiceBuilder builder=new AppiumServiceBuilder();
        builder.withAppiumJS(new File("/Users/vaibhavrajendrahadpe/.npm-global/lib/node_modules/appium/build/lib/main.js"))
                .usingDriverExecutable(new File("/Users/vaibhavrajendrahadpe/usr/local/bin/node"))
                .usingPort(4723)
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                .withLogFile(new File("/Users/vaibhavrajendrahadpe/PracticeProjects/cnHealth/LogFile.txt"))
                .withIPAddress("127.0.0.1");
        server=AppiumDriverLocalService.buildService(builder);
    }

    //Get the instance of server when it is not running.
    public static AppiumDriverLocalService getInstance()
    {
        if(server==null)
        {
            setInstance();
        }
        return server;
    }

    //Start the server
    public static void startAppium() throws InterruptedException {
        Thread.sleep(5000);
        getInstance().start();
        System.out.println("Server URL is "+server.getUrl());
        System.out.println("Server is Started "+server.isRunning());
        Thread.sleep(2000);
    }
    public static void stopAppium() throws InterruptedException {
        Thread.sleep(2000);
        if(server!=null)
        {
            getInstance().stop();
            System.out.println("Server is stopped");
        }
    }

//    public static void main(String[] args) throws InterruptedException {
//        Thread.sleep(5000);
//        stopAppium();
//    }

    @After
    public void tearDown() throws InterruptedException {
        // Stop the Appium server after each test
        stopAppium();
    }


}
