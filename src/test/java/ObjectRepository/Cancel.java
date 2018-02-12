package ObjectRepository;

import org.openqa.selenium.By;

public class Cancel {
	public static final By CancelButton = By.xpath("//*[@id='cancelBookingBtn']");
	public static final By UnableToCancelNFR = By.xpath("//*[contains(text(),'Cancel is not allowed')]");
	public static final By ProceedWithCancel = By.xpath("//*[@class ='btn btn-primary']");
	public static final By AfterCancelStatus = By.xpath("//*[contains(text(),'Cancelled')]");
	public static final By BookingCancellation = By.xpath("//span[contains(text(),'Booking Details')]");
	public static final By ConfirmWithinDeadLineCancel = By.xpath("//*[@class='btn btn-primary']");
}
