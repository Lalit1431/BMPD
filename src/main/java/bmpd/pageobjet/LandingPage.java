package bmpd.pageobjet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bmpd.Abstractcomponent.Abstract;

public class LandingPage extends Abstract {
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	
	@FindBy(name="userEmail")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement pass;
	
	@FindBy(xpath = "//button[contains(@class,'Login_loginButton')]")
	WebElement login;
	
	
	
	public AccountPage loginApplication(String Username,String Pwd) {
		userName.sendKeys(Username);
		pass.sendKeys(Pwd);
		login.click();
		AccountPage accountpage=new AccountPage(driver);
		return accountpage;
	}
	public void goTo() {
		driver.get("https://bmpdtravel.com/login");
	}
	
	

}
