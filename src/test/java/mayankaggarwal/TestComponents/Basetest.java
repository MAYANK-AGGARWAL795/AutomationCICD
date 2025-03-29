package mayankaggarwal.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import mayankaggarwal.pageobjects.LandingPage;

public class Basetest {
	public WebDriver driver;
	public LandingPage landingPage;

	public WebDriver initializedriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\mayankaggarwal\\resources\\GlobalData.properties");
		prop.load(fis);
		String BN= System.getProperty("browser")!=null ?  System.getProperty("browser") : prop.getProperty("browser");
	//	String BN = prop.getProperty("browser");

		if (BN.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(BN.contains("headless")) {
			options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));

		}

		else if (BN.equalsIgnoreCase("firefox")) {
			System.setProperty("WebDriver.gecko.driver","C://Users//MAYANK AGGARWAL//Documents//geckodriver");
			driver = new FirefoxDriver();
		} else if (BN.equalsIgnoreCase("edge")) {
			// edge
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	public List<HashMap<String, String>> getJsonDatatomap(String filepath) throws IOException

	{
		// read json to string
		String jsoncontent=FileUtils.readFileToString(new File(filepath),
		StandardCharsets.UTF_8);
	// string to hashmap jackson databind
		ObjectMapper mapper=new ObjectMapper();
List<HashMap<String,String>> data = mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String, String>>>(){		
});
return data;
	
	}
	public String getss(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName +".jpg");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName +".jpg";
	}
	
	

	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException {

		driver = initializedriver();
		landingPage = new LandingPage(driver);
		landingPage.goto1();
		return landingPage;

	}

	@AfterMethod(alwaysRun=true)
	public void close() {
		driver.close();

	}

}
