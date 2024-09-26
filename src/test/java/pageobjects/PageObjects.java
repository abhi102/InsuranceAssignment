package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lemonade.base.BaseClass;


public class PageObjects extends BaseClass{

	public PageObjects(WebDriver driver) 
	{
		this.driver=driver;		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//*[@id=\"gtm_button_main_check_prices\"]")
	public WebElement CheckPrices;
	
	@FindBy(xpath="//a[contains(text(), 'Check our prices')]")
	public WebElement CheckPricesRentLink;
	
	@FindBy(xpath="//h5[text()='Nope']")
	public WebElement NoLemonadeAccount;
	
	@FindBy(xpath="//*[text()='Next']")
	public WebElement NextButton;
	
	@FindBy(xpath="//button[text()=\"Let's do this\"]")
	public WebElement LetsDoThisButton;
	
	@FindBy(xpath="//input[@data-testid=\"car-checkbox\"]/following-sibling::*")
	public WebElement CarCheckBox;
	
	@FindBy(xpath="//input[@name=\"first_name\"]")
	public WebElement FirstName;
	
	@FindBy(xpath="//input[@name=\"last_name\"]")
	public WebElement LastName;
	
	@FindBy(xpath="//*[contains(@class,'locationName')]")
	public WebElement DetailName;
	
	@FindBy(xpath="//*[text()=\"STREET ADDRESS, CITY, STATE\"]/preceding-sibling::input")
	public WebElement Location;
	
	@FindBy(xpath="//ul[@role=\"listbox\"]/li")
	public WebElement LocationListBox;
	
	@FindBy(xpath="//input[@name=\"invitation_email\"]")
	public WebElement Email;
	
	@FindBy(xpath="//*[text()='Let me know']")
	public WebElement LetMeKnow;
	
	@FindBy(xpath="//*[text()=\"You're in!\"]")
	public WebElement SignupConfirmation;
	
	@FindBy(xpath="//*[@id=\"__next\"]//h1")
	public WebElement PageTextLocator;
	
	@FindBy(xpath="(//*[@id=\"__next\"]//h2)[1]")
	public WebElement GiveBackPageTextLocator;
	
	@FindBy(xpath="//input[@type=\"email\"]")
	public WebElement MyAccountEmail;
	
	@FindBy(xpath="//a[text()='Renters']")
	public WebElement RentersLink;
	
	@FindBy(xpath="//a[contains(text(),'Homeowners')]")
	public WebElement HomeOwnersPageLink;
	
	@FindBy(xpath="//a[contains(text(),'Car')]")
	public WebElement CarPageLink;
	
	@FindBy(xpath="//a[contains(text(),'Pet')]")
	public WebElement PetPageLink;
	
	@FindBy(xpath="//a[contains(text(),'Life')]")
	public WebElement LifePageLink;
	
	@FindBy(xpath="//a[contains(text(), 'Giveback')]")
	public WebElement GiveBackPageLink;
	
	@FindBy(xpath="//a[contains(text(), 'My Account')]")
	public WebElement MyAccountPageLink;
	
	@FindBy(xpath="//input[@name=\"user_first_name\"]")
	public WebElement RentersFirstName;
	
	@FindBy(xpath="//input[@name=\"user_last_name\"]")
	public WebElement RentersLastName;
	
	@FindBy(xpath="//*[@id=\"geosuggest__input--address-autocomplete\"]")
	public WebElement RentersLocation;
	
	@FindBy(xpath="//*[@id=\"questions_form\"]//h5[text()=\"ROOMMATES\"]/following-sibling::i")
	public WebElement RentersRoommates;
	
	@FindBy(xpath="//h5[text()='No']")
	public WebElement NoCheckBox;
	
	@FindBy(xpath="//h5[text()=\"FIRE ALARM\"]")
	public WebElement FireAlarmCheckBox;
	
	@FindBy(xpath="//h5[contains(text(), \"APARTMENT\")]")
	public WebElement ApartmentCheckBox ;
	
	@FindBy(xpath="//button[text()=\"NEXT\"]")
	public WebElement CarNextButton ;
	
	@FindBy(xpath="//input[@id=\"email-input\"]")
	public WebElement RentersEmail;
	
	@FindBy(xpath="//input[@name=\"birth_month\"]")
	public WebElement Month;
	
	@FindBy(xpath="//input[@name=\"birth_day\"]")
	public WebElement Day;
	
	@FindBy(xpath="//input[@name=\"birth_year\"]")
	public WebElement Year;
	
	@FindBy(xpath="//input[@name=\"terms_of_service_approved\"]")
	public WebElement TermsCheckBox;
	
	@FindBy(xpath="//h5[text()=\"NONE\"]")
	public WebElement None;
	
	@FindBy(xpath="//button[text()=\"Let's go!\"]")
	public WebElement LetsGo;
	
	@FindBy(xpath="//*[text()='next']")
	public WebElement NextButton2;
	
	@FindBy(xpath="//h1[text()=\"Lemonade Renters Insurance\"]")
	public WebElement LemonadeInsuranceQuoteText;
	
	@FindBy(xpath="//h2[text()=\"Choose Your Deductible\"]")
	public WebElement ChooseDeductableText;
	
	public String HomePageLink = "https://www.lemonade.com";
	public String HomePageTitle = "Lemonade: An Insurance Company Built for the 21st Century";
	public String HomePageText = "Forget Everything You\n"+ "Know About Insurance";
	public String HomeOwnersPageText = "America’s most loved\n"+ "homeowners insurance";
	public String CarPageText = "Protect Your Car,\n"+ "Help The Planet.";
	public String PetPageText = "Pet Insurance With\n"+ "Super Fast Everything";
	public String LifePageText = "Term Life Insurance For The Next Generation";
	public String GiveBackPageText = "What is the Lemonade Giveback?";
	public String RentersPageText = "Renters insurance that\n"+ "keeps your stuff safe";	
}
