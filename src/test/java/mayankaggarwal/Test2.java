package mayankaggarwal;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.sun.net.httpserver.Authenticator.Retry;

import mayankaggarwal.TestComponents.Basetest;
import mayankaggarwal.pageobjects.Cartpage;
import mayankaggarwal.pageobjects.Checkoutpage;
import mayankaggarwal.pageobjects.Productcatalogue;
import mayankaggarwal.pageobjects.confirmpage;

public class Test2 extends Basetest {

	@Test(groups = {"ErrorH"},retryAnalyzer=mayankaggarwal.TestComponents.Retry.class)

	public void Test1() throws IOException, InterruptedException {
		
		
        landingPage.action11("luciferwalker@gmail.com", "Lucifr@98");
		Assert.assertEquals("Incorrect email or password.", landingPage.geterrormessage());
	}



		@Test

		public void Test11() throws IOException, InterruptedException {

			String productName = "ZARA COAT 3";
			Productcatalogue pc = landingPage.action11("luciferwalke@gmail.com", "Lucifer@98");
			List<WebElement> products = pc.getproductlist();
			pc.addproducttocart(productName);
			pc.gotocart();
			Cartpage page = new Cartpage(driver);
			Boolean match = page.pd("ZARA COAT 33");
			Assert.assertFalse(match);
		
		}

	}


