package bmpd.pageobjet;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bmpd.Abstractcomponent.Abstract;

public class FlightOption extends Abstract{
	WebDriver driver;
	
	public FlightOption(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//h5[text()='Pune']")
	WebElement fromCityText;
	
	@FindBy(xpath = "((//div[contains(@class,'BookFlightMultiOptionCard_mainTicketContainer')])[1]//button[@type='button'])[1]")
	WebElement bookNow;

	@FindBy(xpath = "(//div[contains(@class,'BookFlightMultiOptionCard_mainTicketContainer')])[1]//h5")
	WebElement flightPrice;
	
	@FindBy(xpath="(//div[contains(@class,'FilterForm_actionSection')]//button[contains(text(),'Search')])[1]")
	WebElement search;
	
	@FindBy(xpath="(//div[contains(@class,'FilterForm_airlineList_')]//input[contains(@class,'FilterForm_checkbox')])[1]")
	WebElement Airlinecheckbox;
	
	@FindBy(xpath="(//span[@class=\"FilterForm_itemValue__D9B83\"])[1]")
	WebElement Airlinecheckboxtext;
	
	@FindBy(xpath="//div[contains(@class,'BookFlightMultiOptionCard_mainTicketContainer')]")
	List<WebElement> bookingContainer;
	
	public String verifyingFromCity() throws InterruptedException {
		Thread.sleep(20000);
		String fromcitytext=fromCityText.getText();
		return fromcitytext;
	}
	
	public String getFlightPriceText() {
		return flightPrice.getText();
			
	}
	
	public FareSelect bookFlights() {
		bookNow.click();
		FareSelect fareselect=new FareSelect(driver);
		return fareselect;
	}
	
	public void clickOnSearchbutton() {
		search.click();
	}
	
	public ArrayList<String> selectAirlines() {
		Airlinecheckbox.click();
		String airlineName=Airlinecheckboxtext.getText();
		String[] arrOfStr = airlineName.split("\\(", 2);
	    String text1=arrOfStr[1];
	    String text2=text1.replace(")","");
	    ArrayList<String> arr = new ArrayList<>(); 
	    arr.add(text2);
	    arr.add(arrOfStr[0].trim());
		search.click();
		return arr;
	}
	
	public int getAirlinesNameonCont(String Selectedairline) {
		String path="//div[contains(@class,'BookFlightMultiOptionCard_mainTicketContainer')]//span[contains(text(),'airline name')]";
		path=path.replace("airline name", Selectedairline);
		List<WebElement> countOfAirlines = driver.findElements(By.xpath(path));
		return countOfAirlines.size();
	}
	
	public int getNumberofCont() {
		return bookingContainer.size();
		
		
	}
}
