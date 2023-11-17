package bmpd.pageobjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bmpd.Abstractcomponent.Abstract;

public class ReviewFlight extends Abstract {
	WebDriver driver;
	
	public ReviewFlight(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	By reviewFlightText=By.xpath("//span[contains(@class,'ReviewFlight_backButton')]");
	
	@FindBy(xpath = "//button[contains(@class,'PriceSummary_actionButton')]")
	WebElement continuebtn;
	
	@FindBy(xpath = "(//div[contains(@class,'PriceSummary_priceDetails_')]//h4)[2]")
	WebElement flightPrice;
	
	
	public String reviewFlightTextverify() {
		waitForElementAppear(reviewFlightText);
		String reviewText = driver.findElement(reviewFlightText).getText();
		return reviewText;
	}
	
	public String getFlightprice() {
		return flightPrice.getText();
	}
	
	public FareBooking continueClick() throws InterruptedException {
		javaexcutor();
		Thread.sleep(5000);
		continuebtn.click();
		FareBooking farebooking=new FareBooking(driver);
		return farebooking;
	}

	
	
}
