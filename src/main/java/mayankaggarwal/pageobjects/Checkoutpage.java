package mayankaggarwal.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Abstractcomponent.Abstract1;

public class Checkoutpage extends Abstract1 {

	WebDriver driver;

	public Checkoutpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".action__submit")
	WebElement submit;

	@FindBy(css = "[placeholder='Select Country']")
	WebElement country;

	@FindBy(css = ".ta-item:nth-of-type(2)")
	WebElement selectCountry;

	By results = By.cssSelector(".ta-results");

	public void selectCountry() {
		Actions a = new Actions(driver);
		a.sendKeys(country,"India").build().perform();
		Wait5(By.cssSelector(".ta-results"));
		selectCountry.click();

	}

	public confirmpage submitorder() {

		submit.click();
		return new confirmpage(driver);
	}

}
