package bmpd.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import bmpd.pageobjet.AccountPage;
import bmpd.pageobjet.BookPage;
import bmpd.pageobjet.BookingComplete;
import bmpd.pageobjet.FareBooking;
import bmpd.pageobjet.FareSelect;
import bmpd.pageobjet.FlightOption;
import bmpd.pageobjet.ReviewFlight;
import bmpd.testcomponent.BaseTest;

public class main extends BaseTest{

	@Test()
	public void roundTrip()  throws InterruptedException {
		AccountPage accountpage = page.loginApplication("lalit.jadhav@flairminds.com", "Lalit@123");
		BookPage bookpage = accountpage.navigateToBook();
		FlightOption flightoption = bookpage.roundtrip();
		String fromcitytext = flightoption.verifyingFromCity();
		Assert.assertEquals(fromcitytext, "Pune");
		String flightPrice=flightoption.getFlightPriceText();
		FareSelect fareselect = flightoption.bookFlights();
		Assert.assertEquals(fareselect.getFlightPrice(), flightPrice);
		ReviewFlight reviewFlight = fareselect.continueBooking();
		String reviewFlightText=reviewFlight.reviewFlightTextverify();
		Assert.assertEquals("Back to Selection Fare", reviewFlightText);
		Assert.assertEquals(reviewFlight.getFlightprice(), flightPrice);
		FareBooking farebooking=reviewFlight.continueClick();
		String secureText=farebooking.getSecureText();
		Thread.sleep(2000);
		Assert.assertEquals("Secure booking", secureText);
		Assert.assertEquals(farebooking.getFlightPrice(), flightPrice);
		BookingComplete completebooking = farebooking.completeBooking();
		Thread.sleep(2000);
		String thankyouText=completebooking.getThankYouText();
		Thread.sleep(2000);
		Assert.assertEquals("Thank you! Your trip is booked.", thankyouText);
	}
	
	
	
	
	
}
