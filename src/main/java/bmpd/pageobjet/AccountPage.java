package bmpd.pageobjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import bmpd.Abstractcomponent.Abstract;

public class AccountPage extends Abstract {
	WebDriver driver;
	public AccountPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	

}
