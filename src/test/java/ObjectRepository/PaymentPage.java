package ObjectRepository;

import org.openqa.selenium.By;


public class PaymentPage {

	public static final By fName = By.xpath("//*[@id='ccFields']/fieldset[1]/div[1]/div[1]/input");

	public static final By LName = By.xpath("//*[@id='ccFields']/fieldset[1]/div[1]/div[2]/input");

	public static final By address = By.xpath("//*[@id='ccFields']/fieldset[1]/div[2]/div/input");

	public static final By zip = By.xpath("//input[@name='ccZipCode']");

	public static final By country = By.xpath("//*[@id='ccFields']/fieldset[1]/div[4]/div[1]/select");

	public static final By city = By.xpath("//*[@id='ccFields']/fieldset[1]/div[4]/div[2]/input");

	public static final By ccType = By.xpath("//select[@name='ccCardType']");

	public static final By ccNum = By.xpath("//input[@name='ccCardNumber']");

	public static final By ccName = By.xpath("//input[@name='ccHolderName']");

	public static final By expMonth = By.xpath("//select[@name='ccExpireMonth']");

	public static final By expYear = By.xpath("//select[@name='ccExpireYear']");

	public static final By cvv = By.xpath("//input[@name='ccCVCCode']");

	public static final By termsconditions = By.xpath("//*[@id='creditCardDetailsForm']/div[1]/div/div[2]/label/input");

	public static final By confirmPayment = By.xpath("//a[@id='completedCreditCardDetails']");

	public static final By confirmationStatus = By.xpath("//*[@id='mainContainer']/div[1]/div/div[1]/div[1]/h5[2]");
	
	

}
