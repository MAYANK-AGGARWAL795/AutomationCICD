package mayankaggarwal.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstractcomponent.Abstract1;

public class Cartpage extends Abstract1 {

	@FindBy(css = ".totalRow button")
	WebElement row;

	@FindBy(css = ".cartSection h3")
	private List<WebElement> cartsection;

	public Cartpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Boolean pd(String productName) {

		Boolean match = cartsection.stream()
				.anyMatch(cartproduct -> cartproduct.getText().equalsIgnoreCase(productName));

		return match;

	}

	public Checkoutpage tocheck() {

		row.click();
		 return new Checkoutpage(driver);

	}

}
