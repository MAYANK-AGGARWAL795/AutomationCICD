package mayankaggarwal.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstractcomponent.Abstract1;

public class OderPage extends Abstract1 {

	@FindBy(css = ".totalRow button")
	WebElement row;

	@FindBy(css = "tr td:nth-child(3)")
	private List<WebElement> productsnames;

	public OderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Boolean verifyorderdisplay(String productName) {

		Boolean match = productsnames.stream()
				.anyMatch(cartproduct -> cartproduct.getText().equalsIgnoreCase(productName));

		return match;

	}

}
