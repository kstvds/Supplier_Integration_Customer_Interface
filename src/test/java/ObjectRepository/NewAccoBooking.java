package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NewAccoBooking {

	// public static final By destCity = By.id("City");
	public static final By AccomUnit = By.id("destination");
	public static final By inDate = By.xpath("//*[@id='fromDate']");
	public static final By outDate = By.xpath("//*[@id='toDate']");
	//public static final By searchButton = By.xpath("//*[@id='searchForm']/div/div[3]/button");
	public static final By searchButton = By.xpath("//button[@type='submit']");
	public static final By resultHotel = By.xpath("//*[@id='searchResults']/div[3]/h4");
	public static final By roomtypes = By.xpath("//*[@id='searchResults']/div[3]/div[3]/button");
	public static final By child = By.xpath("//*[contains(@id,'children')]");
	//public static final By childage = By.xpath("//*[@id='addRoomsHere']/tr[2]/td[3]/select[1]");
	public static final By childage = By.xpath("//*[contains(@name,'childrenAges[0][0]')]");
	//public static final By roomselection = By.xpath("//*[@id='roomtype_84722_0_0_0']");
	//public static final By allcheckbox = By.xpath("//*[@id='roomtype_84722_0_0_0']");
	//public static final By procedetoBook = By.xpath("//*[@id='roomList_84722']/div[4]/div[3]/button");

	public static final By paxtitle = By.xpath("//*[@id='passengerDetails']/div[1]/div/div[1]/select");
	
	public static final By paxtitle2 = By.xpath("//*[@id='passengerDetails']/div[1]/div[2]/div[1]/select");
	
	public static final By paxtitle3 = By.xpath("//*[@id='passengerDetails']/div[1]/div[3]/div[1]/select");
	
	public static final By paxFname = By.xpath("//*[@id='passengerDetails']/div[1]/div/div[2]/input");
	
	public static final By paxFname2 = By.xpath("//*[@id='passengerDetails']/div[1]/div[2]/div[2]/input");

	public static final By paxLname = By.xpath("//*[@id='passengerDetails']/div[1]/div/div[3]/input");
	
	public static final By paxLname2 = By.xpath("//*[@id='passengerDetails']/div[1]/div[2]/div[3]/input");
	
	public static final By paxLname3 = By.xpath("//*[@id='passengerDetails']/div[1]/div[3]/div[3]/input");
	
	public static final By paxFname3 = By.xpath("//*[@id='passengerDetails']/div[1]/div[3]/div[2]/input");
	
	public static final By paxLnameCHILD = By.xpath("//*[@id='passengerDetails']/div[1]/div[3]/div[3]/input");

	public static final By paxFnameCHILD = By.xpath("//*[@id='passengerDetails']/div[1]/div[3]/div[2]/input");
	
	public static final By acceptChkBX = By.xpath("//*[@id='acceptRateNotes_0']");

	
	public static final By bookBtn = By.xpath("//*[@id='continueToBook']");

	public static final By confirmBook = By.xpath("//a[contains(text(),'Confirm Booking')]");

	public static final By bookChannel = By.xpath("//*[@id='allSuppliers']/span/span[1]");

	public static final By thirdPartyChannel = By.xpath("//*[@id='Suppliers[Third Party Channels]']/span/span[1]");
	
	public static final By thirdParty = By.xpath("//*[@id='Suppliers[1818]']/span/span[2]");

	public static final By thirdPartyresultHotel = By.xpath("//*[@id='searchResults']/div[3]/h4");
	
	public static final By thirdPartyDeadline = By.xpath("//span[contains(text(),'Within Deadline')]");
	public static final By thirdPartyNFR = By.xpath("//span[contains(text(),'Strictly Non Refundable')]");
	public static final By thirdPartyroomType = By.xpath("//*[@id='searchResults']/div[3]/div[3]/button");
	
	public static final By thirdPartyroomSelectionsaveoutdead = By.xpath("//input[@type='radio']");
	
	public static final By thirdPartyroomSelectionbookoutdead = By.xpath("//input[@type='radio']");
	
	public static final By thirdPartyroom2Selectionbookoutdead = By.xpath("//*[@id='roomtype_845095_1_0_0']");
	
	//public static final By thirdPartyprocedetoBooksaveoutdead = By.xpath("//*[@id='roomList_102042']/div[4]/div[3]/button");
	public static final By thirdPartyprocedetoBooksaveoutdead = By.xpath("//button[contains(text(),'Proceed to booking')]"); 
	//public static final By thirdPartyBooking = By.xpath("//*[@id="continueToBook"]");
	public static final By thirdPartyprocedetoBookingoutdead = By.xpath("//button[contains(text(),'Proceed to booking')]");
	
	public static final By thirdPartsavebooking = By.xpath("//*[@id='saveBooking']");
	
	public static final By thirdPartyaftersavehotel = By.xpath("//*[@id='dracovenie']/div/table/tbody/tr/td[2]");
	
	public static final By thirdPartyaftersavehotel2 = By.xpath("//*[@id='dracovenie']/div/table/tbody/tr[2]/td[2]");
	
	public static final By thirdPartyaftersaveCheckin = By.xpath("//*[@id='dracovenie']/div/table/tbody/tr/td[4]/span[1]");
	
	public static final By thirdPartyaftersaveCheckin2 = By.xpath("//*[@id='dracovenie']/div/table/tbody/tr[2]/td[4]/span[1]");
	
	public static final By thirdPartyaftersaveCheckout = By.xpath("//*[@id='dracovenie']/div/table/tbody/tr/td[4]/span[2]");
	
	public static final By thirdPartyaftersaveCheckout2 = By.xpath("//*[@id='dracovenie']/div/table/tbody/tr[2]/td[4]/span[2]");
	
	public static final By Selectitenary = By.xpath("//*[@id='mainContainer']/div[1]/div/div[1]/div[1]/h5[1]/a");

	public static final By Selectbooking = By.xpath("//*[@id='resultsBody']/tbody/tr[2]/td[2]/strong");

	public static final By Bookingstatusincro = By.xpath("//*[@id='bookingContainer']/div[1]/div/div[1]/div[1]/h5[2]");

	public static final By thirdPartsaveItncart = By.xpath("//div[@id='sidebar']/span");
	
	public static final By thirdPartyafterbookhotelprepay = By.xpath("//*[@id='mainContainer']/div[1]/div/div[2]/div[2]/table/tbody/tr[2]/td[2]");
	
	public static final By thirdPartyafterbookhotelcredit = By.xpath("//*[@id='mainContainer']/div[1]/div/div[2]/div[1]/table/tbody/tr[2]/td[2]");
	
	public static final By thirdPartyafterbookhotelcreditcard = By.xpath("//*[@id='mainContainer']/div[1]/div/div[2]/div[2]/table/tbody/tr[2]/td[2]");
	
	public static final By thirdPartyafterbookCheckInCreditOutDead = By.xpath("//*[@id='mainContainer']/div[1]/div/div[2]/div[2]/table/tbody/tr[2]/td[2]");
	
	public static final By thirdPartyafterbookCheckOutCreditOutDead = By.xpath("//*[@id='mainContainer']/div[1]/div/div[2]/div[2]/table/tbody/tr[3]/td[2]");
	
    public static final By thirdPartyafterbookCheckInPrepayOutDead = By.xpath("//*[@id='mainContainer']/div[1]/div/div[2]/div[3]/table/tbody/tr[2]/td[2]");
	
	public static final By thirdPartyafterbookCheckOutPrepayOutDead = By.xpath("//*[@id='mainContainer']/div[1]/div/div[2]/div[3]/table/tbody/tr[3]/td[2]");
	
	public static final By thirdPartyafterbookCheckInCreditCardOutDead = By.xpath("//*[@id='mainContainer']/div[1]/div/div[2]/div[3]/table/tbody/tr[2]/td[2]");
	
	public static final By thirdPartyafterbookCheckOutCreditCardOutDead = By.xpath("//*[@id='mainContainer']/div[1]/div/div[2]/div[3]/table/tbody/tr[3]/td[2]");

	public static final By thirdPartyconfirmStatus= By.xpath("//*[contains(text(),'Status: Confirmed')]");
	
	public static final By thirdPartyremovefromcart= By.xpath("//a[contains(text(),'Remove')]");
	
	public static final By thirdPartyconfirmremovefromcart= By.xpath("//button[contains(text(),'OK')]");
	
	public static final By thirdPartyremovefromcartconfirmtext= By.xpath("//div[contains(text(),'Successfully cancelled booking.')]");
	
	public static final By OfflineContract = By.xpath("//*[@id='Suppliers[Offline Contracts]']/span/span[2]");
	
	public static final By CloseCancelBooking = By.xpath("//button[@type='button' and @class='close']");
	
	public static final By BookSavedITN = By.xpath("//button[@type='button' and @id='bookItinerary']");
	
	public static final By SameLastNameFirstName = By.xpath("//td[contains(text(),'Kaustav Kaustav')]");
	
	public static final By ConfirmbuttonafterbookingsavedITN = By.xpath("//a[contains(text(),'Confirm Booking')]");

	public static final By SameNameConfirm = By.xpath("//button[contains(text(),'OK')]");	
	
	public static final By SameLastNameFirstNameTwoPax = By.xpath("//td[contains(text(),'Kaustav Das')]");
	
	public static final By SameLastNameFirstNameCreditCard = By.xpath("//td[contains(text(),'Kaustav Kaustav')]");
	
	public static final By NoofAdults = By.xpath("//*[@id='addRoomsHere']/tr[2]/td[1]/select");
}
