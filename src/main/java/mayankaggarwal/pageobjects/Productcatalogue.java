package mayankaggarwal.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Abstractcomponent.Abstract1;

public class Productcatalogue extends Abstract1 {

	WebDriver driver;

	public Productcatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;
	@FindBy(css = ".ng-animating")
	WebElement spinner;
	By productsBy = By.cssSelector(".mb-3");
	By addtocart = By.cssSelector(".card-body button:last-of-type");
	By toastmsg =By.cssSelector("#toast-container");

	public List<WebElement> getproductlist() {

		Wait5(productsBy);
		return products;
	}

	public WebElement  getproductByname(String pn) {

		WebElement prod = getproductlist().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(pn)).findFirst()
				.orElse(null);

		return prod;

	}

	
	public void addproducttocart(String pn) throws InterruptedException
	{
		WebElement prod = getproductByname(pn);
		prod.findElement(addtocart).click();
		Wait5(toastmsg);
		waitelement(spinner);

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
