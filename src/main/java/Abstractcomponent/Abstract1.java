package Abstractcomponent;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import mayankaggarwal.pageobjects.Cartpage;
import mayankaggarwal.pageobjects.OderPage;

public class Abstract1 {

	protected WebDriver driver;

	public Abstract1(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);


	}
	@FindBy(css = "[routerlink*='cart']")
	WebElement cart;
	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderheader;
	

	public void Wait5(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}
	
	public void Wait56(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(findBy));

	}

	public Cartpage gotocart()
	{
		
		
		cart.click();
		Cartpage cartp =new Cartpage(driver);
		return cartp;
		
	}
	public OderPage gotoordercart()
	{
		
		
		orderheader.click();
		OderPage oderPage =new OderPage(driver);
		return oderPage;
		
	}
	
	public void waitelement(WebElement ele) throws InterruptedException

	{
		Thread.sleep(1000);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		//wait.until(ExpectedConditions.invisibilityOf(ele));

		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
