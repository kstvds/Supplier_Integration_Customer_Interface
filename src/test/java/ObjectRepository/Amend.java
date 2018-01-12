package ObjectRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Amend {

	
		
		public static final By amendBtn= By.xpath("//button[@class='btn btn-success']");
		
		public static final By newChckIn= By.name("checkInDate"); 
		
		public static final By newChckOut= By.name("checkOutDate");
		
		//public static final By specialReq= By.xpath("//*[@id='amendForm']/div[1]/div[2]/div[3]/div/div/label[1]/input");
		
		//public static final By VIP= By.xpath("//*[@id='SpecialRequests_0']");
		
		public static final By newFname= By.xpath("//input[@name='passengerFirstName[0]']");
		
		public static final By newFname2= By.xpath("//input[@name='passengerFirstName[1]']");
		
		public static final By proceedAmend= By.xpath("//*[@id='mainContainer']/div/div/div/div[4]/div/button[2]");
		
		public static final By confirmAmend= By.xpath("//*[@id='confirmAmend']");
		
		public static final By StatusAmend= By.xpath("//*[contains(text(),'Amended Confirmed')]");
		
		public static final By verifysupplierChkinCredit= By.xpath("//*[@id='mainContainer']/div[1]/div/div[2]/div[2]/table/tbody/tr[2]/td[2]");
		
		
		public static final By verifysupplierChkoutCredit= By.xpath("//*[@id='mainContainer']/div[1]/div/div[2]/div[2]/table/tbody/tr[3]/td[2]");
		
		public static final By verifyfNamesuppliercredit= By.xpath("//*[@id='mainContainer']/div[1]/div/div[2]/div[2]/table/tbody/tr[4]/td[2]");
		
		public static final By newLname= By.xpath("//input[@name='passengerLastName[0]']");
		
		public static final By verifysupplierChkinPrePay= By.xpath("//*[@id='mainContainer']/div[1]/div/div[2]/div[2]/table/tbody/tr[2]/td[2]");
		
		public static final By verifysupplierChkinPrePayafteramend= By.xpath("//*[@id='mainContainer']/div[1]/div/div[2]/div[3]/table/tbody/tr[2]/td[2]");
		
		public static final By verifysupplierChkoutPrePay= By.xpath("//*[@id='mainContainer']/div[1]/div/div[2]/div[2]/table/tbody/tr[3]/td[2]");
		
		public static final By verifysupplierChkoutPrePayafteramend= By.xpath("//*[@id='mainContainer']/div[1]/div/div[2]/div[3]/table/tbody/tr[3]/td[2]");
		
		public static final By verifyfNamesupplierPrePay= By.xpath("//*[@id='mainContainer']/div[1]/div/div[2]/div[3]/table/tbody/tr[4]/td[2]");
		
		//public static final By verifyfNamesupplierPrePay= By.xpath("//*[@id='mainContainer']/div[1]/div/div[2]/div[3]/table/tbody/tr[4]/td[2]");
		
		public static final By ChangeNoOfChilds= By.xpath("//select [@name='Children']");
		
		public static final By ChangeNoOfAdults= By.xpath("//select [@name='Adults']");
		
		public static final By AfterAmendOccupancyCreditCard= By.xpath("//*[@id='mainContainer']/div[1]/div/div[2]/div[3]/table/tbody/tr[8]/td[2]");
		
		public static final By verifysupplierChkinCreditCardafteramend= By.xpath("//*[@id='mainContainer']/div[1]/div/div[2]/div[3]/table/tbody/tr[2]/td[2]");
		
		public static final By verifysupplierChkOutCreditCardafteramend= By.xpath("//*[@id='mainContainer']/div[1]/div/div[2]/div[3]/table/tbody/tr[3]/td[2]");
		
		public static final By verifyfNamesupplierCreditCard= By.xpath("//*[@id='mainContainer']/div[1]/div/div[2]/div[3]/table/tbody/tr[4]/td[2]");
		
		public static final By AfterAmendOccupancyPrePay= By.xpath("//*[@id='mainContainer']/div[1]/div/div[2]/div[3]/table/tbody/tr[8]/td[2]");
		
		public static final By AfterAmendOccupancyCredit= By.xpath("//*[@id='mainContainer']/div[1]/div/div[2]/div[2]/table/tbody/tr[8]/td[2]");
		
		public static final By AmendCheckBox= By.xpath("//*[@id='agreeCancellation_0']");
		
		public static final By ProceedToAmend= By.xpath("//*[@id='confirmAmend']");
		
		public static final By SelectDOTWBooking= By.xpath("//*[@id='resultsBody']/tbody/tr[2]/td[2]");
		
		public static final By SelectSupplierBooking= By.xpath("//*[@id='resultsBody']/tbody/tr[3]/td[2]/strong");
		
		public static final By AddingSupplementDOTW= By.xpath("//*[@id='extraMealsContainer']/a");
		
		public static final By RatePlanSelect= By.xpath("//*[@id='ratePlan0']");
		
		public static final By Supplement= By.xpath("//*[@id='ratePlan0']");
		
		public static final By verifyfNameDOTWrPrePay= By.xpath("//*[@id='mainContainer']/div[1]/div/div[2]/div[4]/table/tbody/tr[4]/td[2]");
		
		public static final By cancelButton= By.xpath("//*[@id='cancelBooking']");
		
		public static final By ProcdwithCancltn= By.xpath("//*[@id='confirmCancellation']");
		
		public static final By CancellationTitlePrePay= By.xpath("//h5[contains(text(),'Cancelled')]");
		
		public static final By ProceedwithwithinDeadlineCancellation= By.xpath("//button[contains(text(),'Yes')]");
	}



