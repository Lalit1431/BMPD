package bmpd.pageobjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bmpd.Abstractcomponent.Abstract;

public class FareBooking extends Abstract {
	WebDriver driver;

	public FareBooking(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	/*wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("py-4")));
		String Secure=driver.findElement(By.className("py-4")).getText();
		System.out.println(Secure);
		Assert.assertEquals("Secure booking", Secure);
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='myTabContent']//button")).click();*/
	
	By secureText=By.className("py-4");
	
	@FindBy(xpath="//div[@id='myTabContent']//button")
	WebElement completeBooking;
	
	@FindBy(xpath="(//div[contains(@class,'FareBooking_total_')]//div[contains(@class,'b4')])[2]")
	WebElement flightPrice;
	
	
	public String getSecureText() {
		waitForElementAppear(secureText);
		WebElement secure = driver.findElement(secureText);
		String secureText=secure.getText();
		return secureText;
		}
	
	public String getFlightPrice() {
		String text=flightPrice.getText();
		 String[] textStr = text.split(" ", 2);
		return textStr[1];
	}

	public BookingComplete completeBooking() throws InterruptedException {
		Thread.sleep(2000);
		javaexcutor();
		Thread.sleep(2000);
		completeBooking.click();
		BookingComplete bookingcomplete=new BookingComplete(driver);
		return bookingcomplete;
		
	}
	
	
}
