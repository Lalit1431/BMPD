package bmpd.pageobjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import bmpd.Abstractcomponent.Abstract;

public class BookingComplete extends Abstract {
	WebDriver driver;
	public BookingComplete(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}

	/*	Thread.sleep(30000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h4")));
		String thankYou=driver.findElement(By.tagName("h4")).getText();
		*/
	By thankyouText=By.tagName("h4");
	
	public String getThankYouText() throws InterruptedException {
		Thread.sleep(30000);
		waitForElementAppear(thankyouText);
		WebElement thankyou=driver.findElement(thankyouText);
		return thankyou.getText();
	}
	
}
