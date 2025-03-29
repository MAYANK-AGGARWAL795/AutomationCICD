package mayankaggarwal.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstractcomponent.Abstract1;

public class confirmpage extends Abstract1{
	
	
	WebDriver driver;

	public confirmpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
		@FindBy(css = ".hero-primary")
		WebElement submit1;

		public String VCM()
		{
			 return submit1.getText();
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	

}
