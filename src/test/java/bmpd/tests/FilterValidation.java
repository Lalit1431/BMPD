package bmpd.tests;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import bmpd.pageobjet.AccountPage;
import bmpd.pageobjet.BookPage;
import bmpd.pageobjet.FlightOption;
import bmpd.testcomponent.BaseTest;

public class FilterValidation extends BaseTest {

	@Test
	public void numberofAirlinesValidation() throws InterruptedException {
		AccountPage accountpage = page.loginApplication("lalit.jadhav@flairminds.com", "Lalit@123");
		BookPage bookpage = accountpage.navigateToBook();
		FlightOption flightoption = bookpage.roundtrip();
		String fromcitytext = flightoption.verifyingFromCity();
		Assert.assertEquals(fromcitytext, "Pune");
		ArrayList<String> Selectedairlinedata = flightoption.selectAirlines();
		String airlinename=Selectedairlinedata.get(1);
		String airlineqty=Selectedairlinedata.get(0);
		int countofairline=flightoption.getAirlinesNameonCont(airlinename);
		int countofcont=flightoption.getNumberofCont();
		int maincount=countofairline-countofcont;
		int airlineqty1=Integer.parseInt(airlineqty);
		Assert.assertEquals(maincount, airlineqty1);
	}
}
