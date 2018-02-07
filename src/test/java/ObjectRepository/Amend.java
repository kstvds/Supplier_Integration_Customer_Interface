package ObjectRepository;

import org.openqa.selenium.By;

public class Amend {
	public static final By AmendButton = By.xpath("//*[@id='amendBookingBtn']");
	public static final By VerifyAmendPage = By.xpath("//*[@id='bookingDetailsContainer']/div[1]/h1");
	public static final By Checkin = By.xpath("//*[@id='CheckInDate']");
	public static final By Checkout = By.xpath("//*[@id='CheckOutDate']");
	public static final By AfterAmendButton = By.xpath("//input[@class='from_update_btn']");
	public static final By AmendConfirmPageCheckIn = By.xpath("//*[@id='bookingAmendForm']/div[1]/table/tbody/tr[3]/td[2]");
	public static final By AmendConfirmPageCheckOut = By.xpath("//*[@id='bookingAmendForm']/div[1]/table/tbody/tr[3]/td[4]");
	public static final By AmendConfirmPagenoOfAdults = By.xpath("//*[@id='bookingAmendForm']/div[1]/table/tbody/tr[2]/td[2]");
	public static final By ConfirmChanges = By.xpath("//input[@value='Confirm Changes']");
	public static final By AmendSuccessTitle = By.xpath("//*[contains(text(),'Successfully amended')]");
	public static final By AfterAmendChckIn= By.xpath("//*[@id='bookingDetailsContainer']/div[1]/div[6]/table/tbody/tr[1]/td[2]");
	public static final By AfterAmendChckOut= By.xpath("//*[@id='bookingDetailsContainer']/div[1]/div[6]/table/tbody/tr[1]/td[4]");
	public static final By Adults = By.xpath("//*[@id='Adults']");
	public static final By Children = By.xpath("//*[@id='Children']");
	public static final By AfterAmendNoOfPassengers = By.xpath("//*[@id='bookingDetailsContainer']/div[1]/div[6]/table/tbody/tr[3]/td[2]");
	public static final By AcceptAmendCharge = By.xpath("//*[@id='agreeCancellation_0']");
	public static final By UnableToAmendNFR = By.xpath("//*[contains(text(),'Amend is not allowed')]");
}
