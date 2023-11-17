package bmpd.pageobjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bmpd.Abstractcomponent.Abstract;

public class FareSelect extends Abstract {
	WebDriver driver;
	public FareSelect(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[text()='Round trip 1 passenger']")
	WebElement fareselecttext;
	
	By fareSelecttext1=By.xpath("//span[text()='Round trip 1 passenger']");
	
	@FindBy(xpath="(//button[contains(@class,'FareSelection_continueButton')])[2]")
	WebElement Continue;
	
	@FindBy(xpath="//h5[contains(@class,'FareSelection_cabinPrice')]")
	WebElement flightPrice;
	
	
	public String getFlightPrice() {
		return flightPrice.getText();
	}
	
	
	
	public ReviewFlight continueBooking() throws InterruptedException {
		waitForElementAppear(fareSelecttext1);
		javaexcutor();
		Thread.sleep(3000);
		waitForElementClickable(Continue);
		Continue.click();
		ReviewFlight reviewFlight=new ReviewFlight(driver);
		return reviewFlight;
	}
	
	

}
