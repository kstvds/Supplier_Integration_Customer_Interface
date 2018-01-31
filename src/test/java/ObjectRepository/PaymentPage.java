package ObjectRepository;

import org.openqa.selenium.By;

public class PaymentPage {
	public static final By FirstName = By.xpath("//input[@name='ccFirstName']");
	public static final By LastName = By.xpath("//input[@name='ccLastName']");
	public static final By AcceptTerms = By.xpath("//*[@name='ccAccept']");
	public static final By Acceptpayment = By.xpath("//button[contains(text(),'Confirm Payment')]");
	public static final By Address = By.xpath("//*[@name='ccAddress']");
	public static final By CardNumber = By.xpath("//*[@name='ccCardNumber']");
	public static final By CVVNumber = By.xpath("//*[@name='ccCVCCode']");
	public static final By Acceptterms = By.xpath("//*[contains(text(),'I accept the')]");
}
