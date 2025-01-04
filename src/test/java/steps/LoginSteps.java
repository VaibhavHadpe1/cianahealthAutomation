package steps;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pomClasses.LoginPage;
import utility.Utility;

import java.io.IOException;

public class LoginSteps {
    AndroidDriver driver;
    LoginPage loginPage;
    public LoginSteps() throws InterruptedException {

        Utility.setDriver();
        driver=Utility.getDriver();
        loginPage=new LoginPage(driver);
    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() throws InterruptedException {
        loginPage.opencianahealth();
    }
    @When("the user enters their valid username and password")
    public void the_user_enters_their_valid_username_and_password() throws IOException, InterruptedException {
        loginPage.enterValidMobileNumber();
        loginPage.enterValidPassword();
    }
    @When("clicks the Sign In button")
    public void clicks_the_Sign_In_button() {
        loginPage.clickOnSignInButton();
    }
    @Then("the user should be redirected to switch profile screen")
    public void the_user_should_be_redirected_to_switch_profile_screen() {
        loginPage.selectPrimaryUser();
    }
    @Then("the user should see a dashboard")
    public void the_user_should_see_a_dashboard() {
        loginPage.verifyUserIsOnDashboard();
    }

}
