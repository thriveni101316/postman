package stepDefinations;

import org.junit.runner.RunWith;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import pageObject.LandingPage;
import pageObject.LoginPage;
import pageObject.pageHomepage;
import resources.BaseClass;




@RunWith(Cucumber.class)
public class stepDefination extends BaseClass{

	@Given("^Intialize the browser with chrome$")
	public void intialize_the_browser_with_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver=initializeDriver();
	}

	@And("^navigate to \"([^\"]*)\" site$")
    public void navigate_to_something_site(String strArg1) throws Throwable {
		driver.get(strArg1);
	}
	
	@And("^click on login link in homepage to land on Secure signin page$")
	public void click_on_login_link_in_homepage_to_land_on_Secure_signin_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		LandingPage lo = new LandingPage(driver);
		if(lo.getPopupSize().size()>0)
		{
			lo.getPopup().click();
		}
		lo.getLogin().click();
	    
	}
	@When("^User enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
		LoginPage lg = new LoginPage(driver);
		lg.getEmail().sendKeys(username);
		lg.getPassword().sendKeys(password);
		lg.getLogin().click();
    }
	@Then("^verify that user is successfully logged in$")
	public void verify_that_user_is_successfully_logged_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		  pageHomepage p = new pageHomepage(driver); 
		  boolean k = p.getsearchBox().isDisplayed(); 
		  Assert.assertTrue(k);
		 
	}

}