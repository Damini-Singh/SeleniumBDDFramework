package utilities;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.PageObjectManager;

public class TextContextSetup{

	public WebDriver driver;
	public PageObjectManager pageObjectManager;
	public TestBase testbase;
	
	
	public TextContextSetup() throws IOException, InterruptedException
	{
		this.testbase = new TestBase();
		this.driver = testbase.webDriverManager();
		this.pageObjectManager = new PageObjectManager(testbase.webDriverManager());
		
	}
	
	/*
	 * public void initializeVaraibleLanding() { countryButton =
	 * pageObjectManager.landingPage.getCountryButtonElement(); signinButton =
	 * pageObjectManager.landingPage.getSigninButtonElement(); languageButton =
	 * pageObjectManager.landingPage.getLanguageButtonElement(); packageList =
	 * pageObjectManager.landingPage.getPackageListElement(); stcLogo =
	 * pageObjectManager.landingPage.getStcLogoElement(); }
	 */
}
