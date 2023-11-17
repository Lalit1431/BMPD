package bmpd.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RoundTripBooking {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://bmpdtravel.com/login");
		driver.findElement(By.name("userEmail")).sendKeys("lalit.jadhav@flairminds.com");
		driver.findElement(By.name("password")).sendKeys("Lalit@123");
		driver.findElement(By.xpath("//button[contains(@class,'Login_loginButton')]")).click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		//Thread.sleep(30000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Book")));
		driver.findElement(By.linkText("Book")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Let‘s book an original flight')]")));
		driver.findElement(By.id("ROUND TRIP-tab-pane")).click();
		Thread.sleep(5000);
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
		/*driver.findElement(By.className("FlightBookingForm_selectedTraveler__lXjeQ")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class=\"FlightBookingForm_travelers__Pjz5A\"]//span[text()='+'])[1]")).click();
		Thread.sleep(2000);*/
		driver.findElement(By.xpath("(//div[contains(@class,'CustomeDatePicker_dateInput__a0eLa ')])[2]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".MuiCalendarPicker-root")));
		driver.findElement(By.xpath("//button[@title=\"Next month\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@class=\"MuiButtonBase-root MuiPickersDay-root MuiPickersDay-dayWithMargin css-ub1r1\"])[5]")).click();
		 Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[contains(@class,'CustomeDatePicker_dateInput__a0eLa ')])[3]")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@title=\"Next month\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@class=\"MuiButtonBase-root MuiPickersDay-root MuiPickersDay-dayWithMargin css-ub1r1\"])[15]")).click();
		driver.findElement(By.xpath("//button[contains(@class,'TwoWayTripForm_searchButton__RQjMm ButtonWithLoader_buttonContainer__39NK4')]")).click();
		Thread.sleep(20000);
		WebElement from1 = driver.findElement(By.xpath("//h5[text()='Pune']"));
		String fromsearch=from1.getText();
		//System.out.println(fromsearch);
		Assert.assertEquals("Pune", fromsearch);
		wait.until(ExpectedConditions.visibilityOf(from1));
		driver.findElement(By.xpath("((//div[@class=\"BookFlightMultiOptionCard_mainTicketContainer__sl_Fw\"])[1]//button[@type=\"button\"]) [1]")).click();
		Thread.sleep(3000);
		WebElement faresectionpage=driver.findElement(By.xpath("//span[text()='Round trip 1 passenger']"));
		wait.until(ExpectedConditions.visibilityOf(faresectionpage));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(3000);
	//	Actions actions=new Actions(driver);
		WebElement Continue=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(@class,'FareSelection_continueButton__FBzqT ButtonWithLoader_buttonContainer__39NK4')])[2]")));
		//WebElement Continue=driver.findElement(By.xpath("//div[contains(@class,'FareSelection_actionDiv__TMa4O')]//button"));
		Continue.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'ReviewFlight_backButton')]")));
		String selection=driver.findElement(By.xpath("//span[contains(@class,'ReviewFlight_backButton')]")).getText();
		//System.out.println(selection);
		Assert.assertEquals("Back to Selection Fare", selection);
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(5000);
		WebElement Continue1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'PriceSummary_actionButton')]")));
		Continue1.click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("py-4")));
		String Secure=driver.findElement(By.className("py-4")).getText();
		System.out.println(Secure);
		Assert.assertEquals("Secure booking", Secure);
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='myTabContent']//button")).click();
		Thread.sleep(30000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h4")));
		String thankYou=driver.findElement(By.tagName("h4")).getText();
		System.out.println(thankYou);
		Assert.assertEquals("Thank you! Your trip is booked.", thankYou);
		driver.close();
		
		
		
		
	}	

}
