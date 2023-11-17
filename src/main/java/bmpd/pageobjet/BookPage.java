package bmpd.pageobjet;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bmpd.Abstractcomponent.Abstract;

public class BookPage extends Abstract {
	WebDriver driver;
		
	
	public BookPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By booktext=By.xpath("//*[contains(text(),'Let‘s book an original flight')]");
	
	@FindBy(id = "ROUND TRIP-tab-pane")
	WebElement roundtab;
	
	@FindBy(css = ".css-m3jgd1 input[id='react-select-5-input']")
	WebElement from;
	
	By visiblefrom=By.cssSelector(".css-m3jgd1 input[id='react-select-5-input']");
	
	@FindBy (css=".css-44yown input[id='react-select-6-input']")
	WebElement to;
	
	@FindBy(xpath = "(//div[contains(@class,'CustomeDatePicker_dateInput')])[2]")
	WebElement fromDate;
	
	By calander=By.cssSelector(".MuiCalendarPicker-root");
	
	@FindBy(xpath = "//button[@title='Next month']")
	WebElement nextMonth;
	
	@FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiPickersDay-root MuiPickersDay-dayWithMargin css-ub1r1'])[5]")
	WebElement fromDay;
	
	@FindBy(xpath = "(//div[contains(@class,'CustomeDatePicker_dateInput')])[3]")
	WebElement toDate;
	
	@FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiPickersDay-root MuiPickersDay-dayWithMargin css-ub1r1'])[25]")
	WebElement to_Day;
		
	@FindBy(xpath = "//button[contains(@class,'TwoWayTripForm_searchButton__RQjMm ButtonWithLoader_buttonContainer__39NK4')]")
	WebElement searchFlights;
	
	public FlightOption roundtrip() throws InterruptedException {
		waitForElementAppear(booktext);
		roundtab.click();
		Thread.sleep(5000);
	/*waitForElementAppear(visiblefrom);
		waitForElementClickable(from);
		from.clear();
		Thread.sleep(5000);
		//driver.findElement(visiblefrom).sendKeys("Pune");
		from.sendKeys("Pune");
		Thread.sleep(10000);
		from.sendKeys(Keys.ENTER);
		to.sendKeys("Delhi");
		Thread.sleep(5000);
		to.sendKeys(Keys.ENTER);*/
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement from = driver.findElement(By.cssSelector(".css-m3jgd1 input[id='react-select-5-input']"));
		wait.until(ExpectedConditions.visibilityOf(from));
		WebElement text_box = wait.until(ExpectedConditions.elementToBeClickable(from));
		text_box.clear();
		from.sendKeys("Pune");
		Thread.sleep(10000);
		from.sendKeys(Keys.ENTER);
		WebElement to=driver.findElement(By.cssSelector(".css-44yown input[id=\"react-select-6-input\"]"));
		to.sendKeys("Delhi");
		Thread.sleep(5000);
		to.sendKeys(Keys.ENTER);
		
		
		
		fromDate.click();
		waitForElementAppear(calander);
		nextMonth.click();
		Thread.sleep(2000);
		fromDay.click();
		Thread.sleep(2000);
		toDate.click();
		Thread.sleep(2000);
		nextMonth.click();
		Thread.sleep(2000);
		to_Day.click();
		searchFlights.click();	
		FlightOption flightoptions=new FlightOption(driver);
		return flightoptions;
	}
	
	
	
	

}
