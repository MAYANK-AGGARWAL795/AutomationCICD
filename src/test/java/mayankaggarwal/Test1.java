package mayankaggarwal;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import mayankaggarwal.TestComponents.Basetest;
import mayankaggarwal.pageobjects.Cartpage;
import mayankaggarwal.pageobjects.Checkoutpage;
import mayankaggarwal.pageobjects.OderPage;
import mayankaggarwal.pageobjects.Productcatalogue;
import mayankaggarwal.pageobjects.confirmpage;

public class Test1 extends Basetest {
	String productName = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups = { "Purchase" })

	public void Test1(HashMap<String, String> input) throws IOException, InterruptedException {

		Productcatalogue pc = landingPage.action11(input.get("email"), input.get("password"));
		List<WebElement> products = pc.getproductlist();
		pc.addproducttocart(input.get("productName"));
		pc.gotocart();
		Cartpage page = new Cartpage(driver);
		Boolean match = page.pd(input.get("productName"));
		Assert.assertTrue(match);
		Checkoutpage checkpage1 = page.tocheck();
		checkpage1.selectCountry();
		confirmpage CP1 = checkpage1.submitorder();
		String msg = CP1.VCM();
		Assert.assertTrue(msg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}

	@Test(dependsOnMethods = { "Test1" })
	public void OrderHistoryTest() {
		Productcatalogue pc = landingPage.action11("luciferwalker@gmail.com", "Lucifer@98");
		OderPage oderPage = pc.gotoordercart();
		Assert.assertTrue(oderPage.verifyorderdisplay(productName));

	}

	
	
	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJsonDatatomap(
				System.getProperty("user.dir") + "\\src\\test\\java\\mayankaggarwal\\data\\PurchaseOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };

	}
}
//HashMap<String,String> map= new HashMap<String,String>();
//map.put("email", "luciferwalker@gmail.com");
//map.put("password", "Lucifer@98");
//map.put("productName", "ZARA COAT 3");

//HashMap<String,String> map1= new HashMap<String,String>();
//map1.put("email", "luciferwalke@gmail.com");
//map1.put("password", "Lucifer@98");
//map1.put("productName", "ADIDAS ORIGINAL");
