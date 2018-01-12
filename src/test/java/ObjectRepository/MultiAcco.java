package ObjectRepository;

import org.openqa.selenium.By;

public class MultiAcco {

	public static final By Plusroom = By.xpath("//button[@id='addNewRoom']");
	public static final By adult1 = By.xpath("//*[@name='adults[0]']");
	public static final By adult2 = By.xpath("//*[@name='adults[1]']");
	public static final By child1 = By.xpath("//*[contains(@id,'children_0')]");
	public static final By nohotelresult = By.xpath("//div[contains(text(),'Sorry, no results found. Please modify your search criteria')]");
	public static final By multisupplierstatus = By.xpath("//div[contains(text(),'Confirmed')]");
	public static final By multisupplierDOTWHotel= By.xpath("//*[@id='resultsBody']/tbody/tr[2]/td[7]/strong[1]");
	public static final By multisupplierSupplierHotel= By.xpath("//*[@id='resultsBody']/tbody/tr[3]/td[7]/strong[1]");
	public static final By multisupplierSupplierDOTWCheckIn= By.xpath("//*[@id='resultsBody']/tbody/tr[2]/td[9]");
	public static final By multisupplierSupplierDOTWCheckOut= By.xpath("//*[@id='resultsBody']/tbody/tr[2]/td[10]");
	public static final By multisupplierSupplierThirdPartyCheckIN= By.xpath("//*[@id='resultsBody']/tbody/tr[3]/td[9]");
	public static final By multisupplierSupplierThirdPartyCheckout= By.xpath("//*[@id='resultsBody']/tbody/tr[3]/td[10]");
	public static final By paxtitle1room1 = By.xpath("//*[@id='passengerDetails']/div[1]/div[1]/div[1]/select");
	public static final By paxtitle2room1 = By.xpath("//*[@id='passengerDetails']/div[1]/div[2]/div[1]/select");
	public static final By paxtitle3room1 = By.xpath("//*[@id='passengerDetails']/div[1]/div[3]/div[1]/select");
    public static final By paxFname1room1 = By.xpath("//*[@id='passengerDetails']/div[1]/div[1]/div[2]/input");
	public static final By paxLname1room1 = By.xpath("//*[@id='passengerDetails']/div[1]/div[1]/div[3]/input");
	public static final By paxFname2room1 = By.xpath("//*[@id='passengerDetails']/div[1]/div[2]/div[2]/input");
	public static final By paxLname2room1 = By.xpath("//*[@id='passengerDetails']/div[1]/div[2]/div[3]/input");
	public static final By paxFname3room1 = By.xpath("//*[@id='passengerDetails']/div[1]/div[3]/div[2]/input");
	public static final By paxLname3room1 = By.xpath("//*[@id='passengerDetails']/div[1]/div[3]/div[3]/input");
	public static final By paxtitle1room2 = By.xpath("//*[@id='passengerDetails']/div[5]/div[1]/div[1]/select");
	public static final By paxtitle2room2 = By.xpath("//*[@id='passengerDetails']/div[5]/div[2]/div[1]/select");
	public static final By paxFname1room2 = By.xpath("//*[@id='passengerDetails']/div[5]/div[1]/div[2]/input");
	public static final By paxLname1room2 = By.xpath("//*[@id='passengerDetails']/div[5]/div[1]/div[3]/input");
	public static final By paxFname2room2 = By.xpath("//*[@id='passengerDetails']/div[5]/div[2]/div[2]/input");
	public static final By paxLname2room2 = By.xpath("//*[@id='passengerDetails']/div[5]/div[2]/div[3]/input");
	public static final By chkboxroom2 = By.xpath("//*[@id='acceptRateNotes_1']");
	public static final By roomstatus1 = By.xpath("//*[@id='resultsBody']/tbody/tr[2]/td[5]/div[1]/div");
	public static final By roomstatus2 = By.xpath("//*[@id='resultsBody']/tbody/tr[3]/td[5]/div[1]/div");
	public static final By Hotel = By.xpath("//*[@id='resultsBody']/tbody/tr[2]/td[7]/strong[1]");
	public static final By Room1CheckIn = By.xpath("//*[@id='resultsBody']/tbody/tr[2]/td[9]");
	public static final By Room1CheckOut = By.xpath("//*[@id='resultsBody']/tbody/tr[2]/td[10]");
	public static final By Room2CheckIn = By.xpath("//*[@id='resultsBody']/tbody/tr[3]/td[9]");
	public static final By Room2CheckOut = By.xpath("//*[@id='resultsBody']/tbody/tr[3]/td[10]");

}
