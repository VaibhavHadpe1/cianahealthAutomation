package steps;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import basePackage.AppiumServerClass;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pomClasses.LoginPage;


public class Hooks extends Base{
    private static ExtentReports extentReports;
    private static ExtentTest extentTest;

    @Before
    public void beforeScenario(Scenario scenario) {
        // Any setup you need before each scenario
        // e.g., initializing the Appium driver if not done in BaseTest
        // driver = new AppiumDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
        // Set up ExtentHtmlReporter and create a report file

        // Set up ExtentSparkReporter and create a report file
        if (extentReports == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/extent-report/extent-report.html");
            extentReports = new ExtentReports();
            extentReports.attachReporter(sparkReporter);
        }

        // Create a new test for each scenario
        extentTest = extentReports.createTest(scenario.getName());

    }

    @After
    public void afterScenario(Scenario scenario) throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.viewAccountDetailsScreen();
        loginPage.logout();
        loginPage.clickOnHome();
        Thread.sleep(2000);

        if (scenario.isFailed()) {
            extentTest.fail(scenario.getName() + " failed: " + scenario.getStatus());
        } else {
            extentTest.pass(scenario.getName() + " passed.");
        }
        // Write the results to the report
        extentReports.flush();

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

