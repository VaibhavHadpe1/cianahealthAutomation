package pomClasses;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utility.Utility;

import java.io.IOException;
import java.time.Duration;

import static steps.Base.driver;

public class LoginPage
{
   public LoginPage(AndroidDriver driver)
   {
       PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2)),this);
   }
    public static Logger logger= LoggerFactory.getLogger(LoginPage.class);
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='cianahealth']") private WebElement cianahealthApplication;
    @AndroidFindBy(xpath = "(//android.widget.EditText[@content-desc=\"pedit_fn_id\"])[1]")private WebElement mobileNumberField;
    @AndroidFindBy(xpath = "(//android.widget.EditText[@content-desc=\"pedit_fn_id\"])[2]")private WebElement passwordField;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sign In']")private WebElement signInButton;
    @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"home_prof_pic_id\"])[1]")private WebElement primaryUserOnSwitchProfile;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Home\"]") private WebElement homeButtonOnDashboard;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"home_nav_to_prof_id\"]") private WebElement profileIconOnDashboard;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Log Out\"]") private WebElement logoutOPtionOnAccountDetailsScreen;
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button2\"]")private WebElement logoutButton;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"header_goback\"]") private WebElement goBackHeaderButton;




    public void opencianahealth()
    {
        cianahealthApplication.click();
        logger.info("Clicked on cianahealth application");
    }
    public void enterValidMobileNumber() throws IOException, InterruptedException {
        Utility.explicitlyWait(mobileNumberField,driver,5);
        mobileNumberField.sendKeys(Utility.readDataFromPropertyFile("validMobileNumber"));
        logger.info("Valid mobile number entered");
    }
    public void enterInValidMobileNumber() throws IOException {
        Utility.explicitlyWait(mobileNumberField,driver,10);
        mobileNumberField.sendKeys(Utility.readDataFromPropertyFile("invalidMobileNumber"));
        logger.info("InValid mobile number entered");
    }
    public void enterValidPassword() throws IOException {
        Utility.explicitlyWait(passwordField,driver,10);
        passwordField.sendKeys(Utility.readDataFromPropertyFile("validPassword"));
        logger.info("Valid password entered");
    }
    public void enterInValidPassword() throws IOException {
        Utility.explicitlyWait(passwordField,driver,10);
        passwordField.sendKeys(Utility.readDataFromPropertyFile("invalidPassword"));
        logger.info("InValid password entered");
    }
    public void clickOnSignInButton()
    {
        signInButton.click();
        logger.info("Clicked on SignIn Button");
    }

    public void selectPrimaryUser() {
        Utility.explicitlyWait(primaryUserOnSwitchProfile,driver,10);
        primaryUserOnSwitchProfile.click();
        logger.info("Primary user is selected");
    }
    public void verifyUserIsOnDashboard()
    {
        Utility.explicitlyWait(homeButtonOnDashboard,driver,10);
        if(homeButtonOnDashboard.isDisplayed())
        {
            logger.info("User is present on dashboard and Home button is displayed");
        }
        else {
            logger.error("Home button is not displayed");
        }
    }
    public void viewAccountDetailsScreen()
    {
        Utility.explicitlyWait(profileIconOnDashboard,driver,10);
        profileIconOnDashboard.click();
        Utility.implicitlyWait(driver,15);
        if(logoutOPtionOnAccountDetailsScreen.isDisplayed())
        {
            logger.info("Account details screen is loaded");
        }
        else if (!logoutOPtionOnAccountDetailsScreen.isDisplayed())
        {
            logger.info("Retrying to load Account details screen");
           goBackHeaderButton.click();
           Utility.explicitlyWait(logoutOPtionOnAccountDetailsScreen,driver,5);
           profileIconOnDashboard.click();
        }
    }
    public void logout()
    {
        Utility.explicitlyWait(logoutOPtionOnAccountDetailsScreen,driver,10);
        logoutOPtionOnAccountDetailsScreen.click();
        logoutButton.click();
        if (signInButton.isDisplayed())
        {
            logger.info("User is logged out and navigates to login screen.");
        }
    }
    public void clickOnHome() throws InterruptedException {
        ((PressesKey)driver).pressKey(new KeyEvent().withKey(AndroidKey.HOME));
        logger.info("Clicked on HOME button.");
    }

}
