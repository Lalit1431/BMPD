package bmpd.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bmpd.pageobjet.AccountPage;
import bmpd.pageobjet.LandingPage;
import bmpd.pageobjet.RebookFlights;
import bmpd.pageobjet.RebookPage;

public class RebookBooking {
	public static void main(String[] args) throws InterruptedException {

	WebDriver driver=new ChromeDriver();
	LandingPage landingpage=new LandingPage(driver);
	landingpage.goTo();
	AccountPage accountpage = landingpage.loginApplication("lalit.jadhav@flairminds.com", "Lalit@123");
	RebookPage rebookpage = accountpage.navigatetoRebook();
	 RebookFlights rebookflights = rebookpage.addFlightDetails();
	 
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	Thread.sleep(15000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h2")));
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,500)");
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'AA123')]//ancestor::div[@class=\\\"FlightCard_card__bIz4p \\\"]//div[contains(text(),'Rebook')]")));
//	driver.findElement(By.xpath("//*[contains(text(),'AA123')]//ancestor::div[@class=\"FlightCard_card__bIz4p \"]//div[contains(text(),'Rebook')]")).click();
	driver.findElement(By.xpath("//*[contains(text(),'UK972')]//ancestor::div[@class=\"FlightCard_card__bIz4p \"]//div[@class='FlightCard_link__c9B__']")).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".MainFooter_navBrand__zF_rd")));
	//Thread.sleep(5000);
	driver.close();
	
	
	
	
	
	
}
}