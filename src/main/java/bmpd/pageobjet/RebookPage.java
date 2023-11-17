package bmpd.pageobjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bmpd.Abstractcomponent.Abstract;

public class RebookPage extends Abstract {
WebDriver driver;
	public RebookPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By flightDetailtext=By.xpath("//*[contains(text(),'Your Flight Details')]");
	@FindBy(name="flightNo")
	WebElement flightno;
	
	@FindBy(css=".MuiIconButton-root")
	WebElement calander;
	
	@FindBy(xpath="//button[@title='Next month']")
	WebElement nextMonth;
	
	By daysVisibility=By.xpath("//button[@class='MuiButtonBase-root MuiPickersDay-root MuiPickersDay-dayWithMargin css-ub1r1'][1]");
	
	@FindBy (xpath="//*[contains(text(),'SEARCH FLIGHT')]")
	WebElement searchFlight;
		
	public RebookFlights addFlightDetails() {
		waitForElementAppear(flightDetailtext);
		flightno.sendKeys("UK972");
		calander.click();
		nextMonth.click();
		waitForElementAppear(daysVisibility);
		driver.findElement(daysVisibility).click();
		searchFlight.click();
		RebookFlights rebookflights=new RebookFlights(driver);
		return rebookflights;
		
	}

}
