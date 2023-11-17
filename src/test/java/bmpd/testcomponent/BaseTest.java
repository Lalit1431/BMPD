package bmpd.testcomponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import bmpd.pageobjet.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
public static WebDriver driver;
public LandingPage page;

public WebDriver initializeDriver() throws IOException {
	Properties prop=new Properties();
	FileInputStream fsi=new FileInputStream((System.getProperty("user.dir")+"//src//main//java//bmpd//resources//globaldata.properties"));
	prop.load(fsi);
	String browserName = prop.getProperty("browser");
	if (browserName.contains("Chrome")){
		ChromeOptions options=new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver(options);
		}
		else if(browserName.equalsIgnoreCase("edge")) {
		WebDriverManager.edgedriver().setup();
		 driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;	
	}
	

@BeforeMethod(alwaysRun = true)
public LandingPage launchApplication() throws IOException {
	driver=initializeDriver();
	page=new LandingPage(driver);
	page.goTo();
	return page;
	}
	
@AfterMethod(alwaysRun = true)
public void closeApplacation() {
	driver.close();
}
		
public String getScreenshot(String testCaseName,WebDriver driver) throws IOException {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	File file=new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
	FileUtils.copyFile(source, file);
	return System.getProperty("user.dir"+"//reports"+testCaseName+".png");
}
	
	
	
}
	
	
	
	

