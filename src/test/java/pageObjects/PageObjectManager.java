package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	public WebDriver driver;
	public LandingPage landingPage;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
		getLandingPage();
		
	}
	
	
	public LandingPage getLandingPage()
	{
		landingPage = new LandingPage(driver);
		return landingPage;
		
	}
	
	
	

}
