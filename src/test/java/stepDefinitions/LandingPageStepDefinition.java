package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.TextContextSetup;


public class LandingPageStepDefinition {
	

	public WebDriver driver;
	TextContextSetup textContextSetup;
	public WebElement countryButton;
	public WebElement signinButton;
	public WebElement languageButton;
	public List<WebElement> packageList;
	public WebElement stcLogo;
	public WebElement countrySelect;
	public String packageLite;
	public String packageClassic;
	public String packagePremium;
	String pageTitle;
	String pageURL;
	String languageButtonText;
	
	public LandingPageStepDefinition(TextContextSetup textContextSetup) 
	{
		this.textContextSetup = textContextSetup;
		this.countryButton = textContextSetup.pageObjectManager.landingPage.getCountryButtonElement();
		this.signinButton = textContextSetup.pageObjectManager.landingPage.getSigninButtonElement();
		this.languageButton = textContextSetup.pageObjectManager.landingPage.getLanguageButtonElement();
		this.packageList = textContextSetup.pageObjectManager.landingPage.getPackageListElement();
		this.stcLogo = textContextSetup.pageObjectManager.landingPage.getStcLogoElement();
		this.pageURL = textContextSetup.pageObjectManager.landingPage.getPageURL();
		this.languageButtonText = textContextSetup.pageObjectManager.landingPage.getLanguageButtonText();
		this.packageLite = textContextSetup.pageObjectManager.landingPage.getPackageLite().getText();
		this.packageClassic = textContextSetup.pageObjectManager.landingPage.getpackageClassic().getText();
		this.packagePremium = textContextSetup.pageObjectManager.landingPage.getpackagePremiumL().getText();
	}
	
	//Scenario 1
	@Given("user is on stc tv landing page")
	public void user_is_on_stc_tv_landing_page() throws Exception {
		
		pageTitle = textContextSetup.pageObjectManager.landingPage.getTitle();
		Assert.assertEquals(pageTitle, "Choose Your Plan");
		
	    
	}
	
	@Then("user checks all the key buttons and links are visible")
	public void user_checks_all_the_key_buttons_and_links_are_visible() {
		
	    Assert.assertEquals(true, countryButton.isDisplayed());
	    Assert.assertEquals(true, signinButton.isDisplayed());
	    Assert.assertEquals(true, languageButton.isDisplayed()); 
	    Assert.assertEquals(false, packageList.isEmpty());
	    Assert.assertEquals(true, stcLogo.isDisplayed());
	}
	
		//Scenario 2
	    @When("^user changes the language to arabic$")
	    public void user_changes_the_language_to_arabic() throws Throwable {
	    	
	    //	textContextSetup.testbase.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By)languageButton));
	    	languageButton.click();
	        
	    }
	    
	    @Then("^page language is modifed to arabic language$")
	    public void page_language_is_modifed_to_arabic_language() throws Throwable {
	        
	    	
	    	//textContextSetup.testbase.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By)languageButton));
	    	System.out.println("URL " + pageURL);
	    	Assert.assertEquals(languageButtonText, "العربية");
	    	System.out.print("language button text Selected for arabic check " + languageButtonText);
	    	Assert.assertTrue(pageURL.contains("ar"));
	    	
	    }

	    @Then("^user change the language back to english$")
	    public void user_change_the_language_back_to_english() throws Throwable {
	    	
	    	//textContextSetup.testbase.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By)languageButton));
	    	languageButton.click();
	    	System.out.println("URL " + pageURL);
	    	Assert.assertEquals(languageButtonText, "العربية");
	    	System.out.print("language button text Selected for english check " + languageButtonText);
	    	Assert.assertTrue(pageURL.contains("en"));
	        
	    }
	    
	    //Scenario 3
	    @When("^user click on country button")
	    public void user_click_on_country_button() throws Throwable {
	        
	    	countryButton.click();
	    }
	    
	    @Then("^user select country (.+) checks currency (.+) URL (.+) is modified$")
	    public void user_select_country_checks_currency_url_is_modified(String country, String currency, String url) throws Throwable {
	        
	    	countrySelect = textContextSetup.pageObjectManager.landingPage.clickOnSelectedCountry(country);
	    	System.out.print("Country Selected " + country);
	    	if(countrySelect != null)
	    	{
	    		countrySelect.click();
	    		List<WebElement> packType = textContextSetup.pageObjectManager.landingPage.getPackageCurrency();
		        Assert.assertEquals(packType.get(0).getText(), currency);
		        Assert.assertEquals(packType.get(1).getText(), currency);
		        Assert.assertEquals(packType.get(2).getText(), currency);
		        System.out.print("Currency Selected " + currency);
		        pageURL.contains(url);
		        Assert.assertTrue(pageURL.contains(url)); 
		        System.out.print("URL Selected " + url);
	    	}
	    	else {
	    		System.out.print("No Country is selected");
	    	}
	    	
	    }

	    //Scenario 4

	    @Then("^user checks all the package types are displayed$")
	    public void user_checks_all_the_package_types_are_displayed() throws Throwable {
	    	
	    	Assert.assertEquals(packageLite, "LITE");
	    	Assert.assertEquals(packageClassic, "CLASSIC");
	    	Assert.assertEquals(packagePremium, "PREMIUM");
	    	
	    }
	    
	
}
