package bmpd.Abstractcomponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bmpd.pageobjet.BookPage;
import bmpd.pageobjet.RebookPage;

public class Abstract {
WebDriver driver;
	
	public Abstract(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	public void waitForElementAppear(By findby) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
		
	}
	
	 
	@FindBy(linkText="Rebook")
	WebElement rebook;
	
	@FindBy(linkText = "Book")
	WebElement Book;
	
	By waitForLogin=By.linkText("Rebook");
	By book=By.linkText("Book");
		
	public RebookPage navigatetoRebook() {
		
		waitForElementAppear(waitForLogin);
		rebook.click();
		RebookPage rebookpage=new RebookPage(driver);
		return rebookpage;
	}
	
	public BookPage navigateToBook() {
		waitForElementAppear(book);
		Book.click();
		BookPage bookpage=new BookPage(driver);
		return bookpage;
	}
	
	public void waitForElementClickable(WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	public void javaexcutor() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
			
	}








	
}
