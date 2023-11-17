package bmpd.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class extracide {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
	
		driver.get("https://bmpdtravel.com/login");
		driver.findElement(By.name("userEmail")).sendKeys("lalit.jadhav@flairminds.com");
		driver.findElement(By.name("password")).sendKeys("Lalit@123");
		driver.findElement(By.xpath("//button[@class=\"Login_loginButton__sFn9e ButtonWithLoader_buttonContainer__bl9l7 \"]")).click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Rebook")));
		driver.findElement(By.linkText("Rebook")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Your Flight Details')]")));
		driver.findElement(By.name("flightNo")).sendKeys("UK972");
		driver.findElement(By.cssSelector(".MuiIconButton-root")).click();	
		driver.findElement(By.xpath("//button[@title=\"Next month\"]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=\"MuiButtonBase-root MuiPickersDay-root MuiPickersDay-dayWithMargin css-ub1r1\"][1]")));
		driver.findElement(By.xpath("//button[@class=\"MuiButtonBase-root MuiPickersDay-root MuiPickersDay-dayWithMargin css-ub1r1\"][1]")).click();
		//	Thread.sleep(5000);
		driver.findElement(By.xpath("//*[contains(text(),'SEARCH FLIGHT')]")).click();
		Thread.sleep(15000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h2")));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'AA123')]//ancestor::div[@class=\\\"FlightCard_card__bIz4p \\\"]//div[contains(text(),'Rebook')]")));
//		driver.findElement(By.xpath("//*[contains(text(),'AA123')]//ancestor::div[@class=\"FlightCard_card__bIz4p \"]//div[contains(text(),'Rebook')]")).click();
		driver.findElement(By.xpath("//*[contains(text(),'UK972')]//ancestor::div[@class=\"FlightCard_card__bIz4p \"]//div[@class='FlightCard_link__c9B__']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".MainFooter_navBrand__zF_rd")));
		//Thread.sleep(5000);
		driver.close();
	}

}
