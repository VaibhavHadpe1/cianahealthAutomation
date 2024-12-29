package steps;

import basePackage.AppiumServerClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends Base{

//    @Before
//    public void beforeScenario() {
//        // Any setup you need before each scenario
//        // e.g., initializing the Appium driver if not done in BaseTest
//        // driver = new AppiumDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
//    }

    @After
    public void afterScenario() throws InterruptedException {
        // This will stop the Appium server after each scenario
        if (driver != null) {
            System.out.println("CleanedUp Appium session");
            driver.quit(); // This will stop the Appium server and close the app
            AppiumServerClass.stopAppium();
        }
        else {
            System.out.println("Server is not stopped");
        }
    }
}

