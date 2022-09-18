package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;
	String packageName;
	
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h3[normalize-space()='Choose Your Plan']")
	WebElement pageTitle;
	
	@FindBy(xpath = "//a[@class='header-btns-country hide-mobile']")
	WebElement countryButton;
	
	@FindBy(css = ".header-btns-sign-in")
	WebElement signinButton;
	
	@FindBy(css = "#changeLanguageButton")
	WebElement languageButton;
	
	@FindBy(xpath = "//div[@class='package-container']/child::div[contains(@class,'packages packages')]")
	List<WebElement> packageList;
	
	@FindBy(css = ".hide-mobile.alogo")
	WebElement stcLogo;

	@FindBy(xpath = "//span[@class='hide-mobile']")
	WebElement languageButtonText;
	
	@FindBy(css = ".countryList-items>li[id = \"bh\"]")
	WebElement countryBahrain;
	
	@FindBy(css = ".countryList-items>li[id = \"sa\"]")
	WebElement countrySaudiArabia;
	
	@FindBy(css = ".countryList-items>li[id = \"kw\"]")
	WebElement countryKuwait;
	
	@FindBy(xpath = "(//div[@class='package-container']//h1)[1]")
	WebElement packageLite;
	
	@FindBy(xpath = "(//div[@class='package-container']//h1)[2]")
	WebElement packageClassic;
	
	@FindBy(xpath = "(//div[@class='package-container']//h1)[3]")
	WebElement packagePremium;
	
	@FindBy(css = "div[class='packages packages Light'] span[class='currency']")
	WebElement PackageCurrencyLite;
	
	@FindBy(css = "div[class='packages packages Classic'] span[class='currency']")
	WebElement PackageCurrencyClassic;
	
	@FindBy(css = "div[class='packages packages Premium'] span[class='currency']")
	WebElement PackageCurrencyPremium;
	
	public String getTitle()
	{
		return pageTitle.getText();
	}
	
	public WebElement getCountryButtonElement()
	{
		return countryButton;
	}
	public WebElement getSigninButtonElement()
	{
		return signinButton;
	}
	public WebElement getLanguageButtonElement()
	{
		return languageButton;
	}
	public List<WebElement> getPackageListElement()
	{
		return packageList;
	}
	public WebElement getStcLogoElement()
	{
		return stcLogo;
	}
	public String getLanguageButtonText() 
	{
		return languageButtonText.getText();
	}
	public String getPageURL()
	{
		return driver.getCurrentUrl();
		
	}
	
	public WebElement clickOnSelectedCountry(String Country)
	{
		if(Country.equals("KSA"))
		{
			return countrySaudiArabia;
		}
		else if(Country.equals("Kuwait"))
		{
			return countryKuwait;
		}
		else if(Country.equals("Bahrain"))
		{
			return countryBahrain;
		}
		
		return null;
		
	}
	
	public List<WebElement> getPackageCurrency()
	{
		 List<WebElement> packType = new ArrayList<>();
		  
		  packType.add(PackageCurrencyLite);
		  packType.add(PackageCurrencyClassic);  
		  packType.add(PackageCurrencyPremium);
		  
		  return packType;
	}
	
	public WebElement getPackageLite()
	{
		return packageLite;
	}
	public WebElement getpackageClassic()
	{
		return packageClassic;
	}
	public WebElement getpackagePremiumL()
	{
		return packagePremium;
	}
	
	

}
