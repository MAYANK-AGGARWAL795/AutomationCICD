package mayankaggarwal.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstractcomponent.Abstract1;

public class LandingPage extends Abstract1 {

	 WebDriver driver;

	public LandingPage(WebDriver driver) {
        super(driver);

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement password;

	@FindBy(id = "login")
	WebElement submit;
	
	@FindBy(css = "[class*='flyInOut']")
	WebElement errorMessage;
	
	    public Productcatalogue  action11(String email, String pass) {
		userEmail.sendKeys(email);
		password.sendKeys(pass);
		submit.click();
		Productcatalogue  pc =new Productcatalogue(driver);
		return pc;
	}
	    
	    public String geterrormessage()
	    
	    {
	    	Wait56(errorMessage);
	    return	errorMessage.getText();
	    	
	    }
	    

	public void goto1() {
		driver.get("https://rahulshettyacademy.com/client");

	}

}
