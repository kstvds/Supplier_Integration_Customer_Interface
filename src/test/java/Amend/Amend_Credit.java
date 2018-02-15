package Amend;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ObjectRepository.Amend;
import ObjectRepository.Booking;
import ObjectRepository.LoginPage;
import ObjectRepository.PaymentPage;
import ObjectRepository.Search;
import Utility.Configuration;
import lib.DriverAndObjectDetails;
import lib.ExcelDataConfig;
import lib.ExtentManager;
import lib.Takescreenshot;
import lib.DriverAndObjectDetails.DriverName;

/* #######  Test for accommodation booking and amend for Credit user #########
######  Scenario Logs In, Books a specified hotel and amends the booking ##### */

public class Amend_Credit {
	public WebDriver driverqa;
	ExtentTest test;
	String errorpath;
	String Roomtype;
	ExcelDataConfig excel;
	String ActualAmendDateChkIn;
	String ExpectedAmendDateChkIn;
	String ActualAmendDateChkOut;
	String ExpectedAmendDateChkOut;
	String ActualConfirmedAmendTitle;
	String ExpectedConfirmedAmendTitle;
	String ActualAfterAmendDateChkIn;
	String ExpectedAfterAmendDateChkIn;
	String ActualAfterAmendDateChkOut;
	String ExpectedAfterAmendDateChkOut;
	String ExpectedNoOfAdults;
	String ActualNoOfAdults;
	Configuration Config = new Configuration();
	Takescreenshot obj = new Takescreenshot();
	ExtentReports rep = ExtentManager.getInstance();
	LoginPage login = new LoginPage();
	Logger logger = Logger.getLogger("Credit_Amend");

	/* ####### Passing browser as parameters in test ######### **/

	@Test
	@Parameters({ "browsername" })
	public void CreditAmend(String browsername) throws Exception {
		test = rep.startTest("Credit Amend");
		excel = new ExcelDataConfig(Config.getExcelPathBook());
		PropertyConfigurator.configure("Log4j.properties");
		logger.info("Test Case Started");
		if (browsername.equalsIgnoreCase("CH")) {
			driverqa = new DriverAndObjectDetails(DriverName.CH).CreateDriver();
		} else if (browsername.equalsIgnoreCase("IE")) {
			driverqa = new DriverAndObjectDetails(DriverName.IE).CreateDriver();
		} else {
			driverqa = new DriverAndObjectDetails(DriverName.FF).CreateDriver();
		}
		WebDriverWait wait = new WebDriverWait(driverqa, 80);
		Actions action = new Actions(driverqa);

		/* ####### Login functionality ######### **/

		try {
			logger.info("Browser Opened");
			String URL = excel.getData(0, 1, 5) + "/interface/en";
			driverqa.get(URL);
			logger.info("Test Case Started");
			test.log(LogStatus.INFO, "Starting Login");
			WebElement username = driverqa.findElement(LoginPage.LoginId);
			username.clear();
			username.sendKeys(excel.getData(0, 48, 1));
			wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.password));
			driverqa.findElement(LoginPage.password).sendKeys(excel.getData(0, 48, 2));
			Thread.sleep(1000);
			WebElement company = driverqa.findElement(LoginPage.Companycode);
			company.clear();
			company.sendKeys(excel.getData(0, 48, 3));
			driverqa.findElement(LoginPage.Submit).click();
			Thread.sleep(2000);
			String expectedtitle = "DOTWconnect.com";
			String atualtitle = driverqa.getTitle();
			Assert.assertEquals(atualtitle, expectedtitle);
			test.log(LogStatus.INFO, "Ending Login");
			test.log(LogStatus.PASS, "PASSED Login");
			logger.info("Login Successful");
			// Thread.sleep(7000);
			ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					return ((JavascriptExecutor) driverqa).executeScript("return document.readyState")
							.equals("complete");
				}
			};
			// WebDriverWait waiting = new WebDriverWait(driverqa, 30);
			wait.until(pageLoadCondition);
			// wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.Closetuto));
			// driverqa.findElement(LoginPage.Closetuto).click();
			action.sendKeys(Keys.ESCAPE).build().perform();
			Thread.sleep(2000);
			obj.Takesnap(driverqa, Config.SnapShotPath() + "/Amend/Accommodation_Amend_Credit/Log-In.jpg");

		} catch (Throwable e) {

			obj.Takesnap(driverqa, Config.SnapShotPath() + "/Amend/Error/Accommodation_Amend_Credit/Log-In.jpg");
			test.log(LogStatus.FAIL, "Login");
			errorpath = Config.SnapShotPath() + "/Amend/Error/Accommodation_Amend_Credit/Log-In.jpg";
			logger.info(e.getMessage());
			test.log(LogStatus.FAIL, e.getMessage());
			rep.endTest(test);
			rep.flush();
			Assert.assertTrue(false, e.getMessage());

		}

		/* ####### Applying filters and searching for filters ######### **/

		try {
			logger.info("Applying search Filters");
			logger.info("Starting HotelSearch Credit");
			test.log(LogStatus.INFO, "Starting HotelSearch Credit");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(Search.dest));
			driverqa.findElement(Search.dest).sendKeys(excel.getData(0, 9, 1));
			Thread.sleep(3000);
			action.sendKeys(Keys.ARROW_DOWN).build().perform();
			// action.sendKeys(Keys.ARROW_DOWN).build().perform();
			action.sendKeys(Keys.ENTER).build().perform();
			test.log(LogStatus.INFO, "Selecting dates");
			driverqa.findElement(Search.InDate).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Search.CalenderIN));
			driverqa.findElement(Search.nextmnth).click();
			driverqa.findElement(Search.nextmnth).click();
			List<WebElement> allDates = driverqa.findElements(Search.CalenderIN);

			for (WebElement ele : allDates) {

				String date = ele.getText();

				if (date.equalsIgnoreCase(excel.getData(0, 51, 1))) {
					ele.click();
					break;
				}

			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(Search.CalenderIN));
			// driverqa.findElement(Search.nextmnth).click();
			// driverqa.findElement(Search.nextmnth).click();
			List<WebElement> allDates2 = driverqa.findElements(Search.CalenderIN);

			for (WebElement ele : allDates2) {

				String date = ele.getText();

				if (date.equalsIgnoreCase(excel.getData(0, 51, 2))) {
					ele.click();
					break;
				}

			}
			test.log(LogStatus.PASS, "Selection of Dates");
			WebElement Noofchilds = driverqa.findElement(Search.NoOfChilds);
			Noofchilds.clear();
			Noofchilds.sendKeys("1");
			driverqa.findElement(Search.PaymentOption).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Search.NetPay));
			Thread.sleep(1000);
			WebElement element = driverqa.findElement(Search.NetPay);

			Actions actions = new Actions(driverqa);

			actions.moveToElement(element).click().perform();
			Thread.sleep(2000);
			obj.Takesnap(driverqa, Config.SnapShotPath() + "/Amend/Accommodation_Amend_Credit/Filters.jpg");
			String expectedresult = excel.getData(0, 9, 1);
			driverqa.findElement(Search.SearchBtn).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Search.HotelTitle));
			Thread.sleep(2000);
			obj.Takesnap(driverqa, Config.SnapShotPath() + "/Amend/Accommodation_Amend_Credit/Search-Result.jpg");
			String actualresult = driverqa.findElement(Search.HotelTitle).getText();
			Assert.assertTrue(actualresult.equalsIgnoreCase(expectedresult));
			test.log(LogStatus.INFO, "Ending HotelSearch Credit");
			test.log(LogStatus.PASS, "PASSED HotelSearch Credit");
			logger.info("Hotel Search Complete Credit");
		} catch (Throwable e) {
			test.log(LogStatus.FAIL, "Hotel Search Credit");

			obj.Takesnap(driverqa, Config.SnapShotPath() + "/Amend/Error/Accommodation_Amend_Credit/Search-Result.jpg");
			errorpath = Config.SnapShotPath() + "/Amend/Error/Accommodation_Amend_Credit/Search-Result.jpg";
			logger.info(e.getMessage());
			test.log(LogStatus.FAIL, e.getMessage());
			rep.endTest(test);
			rep.flush();
			Assert.assertTrue(false, e.getMessage());
		}

		/* ####### Booking Hotel for the specified date ######### **/

		try {
			test.log(LogStatus.INFO, "Starting Hotel Book");
			logger.info("Starting Hotel Book");
			wait.until(ExpectedConditions.visibilityOfElementLocated(Booking.Bookroom));
			test.log(LogStatus.INFO, "Selecting Room");
			logger.info("Selecting Room");
			driverqa.findElement(Booking.Bookroom).click();
			test.log(LogStatus.INFO, "Room Selected");
			logger.info("Room Selected");
			logger.info("Entering Passenger details");
			test.log(LogStatus.INFO, "Entering Passenger details");
			wait.until(ExpectedConditions.visibilityOfElementLocated(Booking.OnePaxFirstName));
			driverqa.findElement(Booking.OnePaxFirstName).sendKeys(excel.getData(0, 21, 1));
			Thread.sleep(2000);
			driverqa.findElement(Booking.OnePaxlastName).sendKeys(excel.getData(0, 21, 2));
			Select passengertitle = new Select(driverqa.findElement(Booking.OnePaxTitle));
			passengertitle.selectByIndex(1);
			if (driverqa.findElements(Booking.TwoPaxFirstName).size() != 0) {
				driverqa.findElement(Booking.TwoPaxFirstName).sendKeys(excel.getData(0, 22, 1));
				Thread.sleep(2000);
				driverqa.findElement(Booking.TwoPaxLastName).sendKeys(excel.getData(0, 22, 2));
				Select passengertitle2 = new Select(driverqa.findElement(Booking.TwoPaxTitle));
				passengertitle2.selectByIndex(1);
			}
			if (driverqa.findElements(Booking.ThirdPaxFirstName).size() != 0) {
				driverqa.findElement(Booking.ThirdPaxFirstName).sendKeys(excel.getData(0, 22, 1));
				Thread.sleep(2000);
				driverqa.findElement(Booking.ThirdPaxLastName).sendKeys(excel.getData(0, 22, 2));
				Select passengertitle3 = new Select(driverqa.findElement(Booking.ThirdPaxTitle));
				passengertitle3.selectByIndex(1);
			}
			driverqa.findElement(Booking.PrcdToBookChckBox).click();
			Thread.sleep(2000);
			obj.Takesnap(driverqa, Config.SnapShotPath() + "/Amend/Accommodation_Amend_Credit/Passenger-Details.jpg");
			logger.info("Entered Passenger details");
			test.log(LogStatus.INFO, "Entered Passenger details");
			test.log(LogStatus.PASS, "Passenger details");
			driverqa.findElement(Booking.ConfirmBook).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Booking.ProccedToBook));
			Thread.sleep(2000);
			obj.Takesnap(driverqa, Config.SnapShotPath() + "/Amend/Accommodation_Amend_Credit/Confirm-Booking.jpg");
			driverqa.findElement(Booking.ProccedToBook).click();
			logger.info("Entering Payment details");
			test.log(LogStatus.INFO, "Entering Payment details");
			wait.until(ExpectedConditions.visibilityOfElementLocated(Booking.BookingCost));
			/*
			 * String HotelCost =
			 * driverqa.findElement(Booking.BookingCost).getText();
			 * System.out.println(HotelCost); Thread.sleep(2000);
			 * driverqa.findElement(Booking.CreditCost).sendKeys(HotelCost);
			 */
			// or any locator strategy that you find suitable
			WebElement locOfOrder = driverqa.findElement(Booking.BookingCost);
			Actions act = new Actions(driverqa);
			act.moveToElement(locOfOrder).doubleClick().build().perform();
			// catch here is double click on the text will by default select the
			// text
			// now apply copy command
			driverqa.findElement(Booking.BookingCost).sendKeys(Keys.chord(Keys.CONTROL, "c"));
			Thread.sleep(2000);
			// now apply the command to paste
			driverqa.findElement(Booking.CreditCost).sendKeys(Keys.chord(Keys.CONTROL, "v"));
			logger.info("Entered Payment details");
			test.log(LogStatus.INFO, "Entered Payment details");
			test.log(LogStatus.PASS, "Payment details");
			Thread.sleep(2000);
			obj.Takesnap(driverqa, Config.SnapShotPath() + "/Amend/Accommodation_Amend_Credit/Payment-Details.jpg");
			driverqa.findElement(PaymentPage.AcceptTerms).click();
			Thread.sleep(3000);
			driverqa.findElement(PaymentPage.AcceptTerms).click();
			driverqa.findElement(PaymentPage.Acceptpayment).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Booking.ViewBooking));
			JavascriptExecutor js = (JavascriptExecutor) driverqa;
			Thread.sleep(2000);
			obj.Takesnap(driverqa, Config.SnapShotPath() + "/Amend/Accommodation_Amend_Credit/Search-Booking-Page.jpg");
			// WebElement Element = driverqa.findElement(Booking.Invoice);
			// This will scroll the page till the element is found
			/*
			 * Assert.assertTrue(ActualStatus.equalsIgnoreCase(ExpectedStatus));
			 * Assert.assertTrue(ActualNoOfAdults.equalsIgnoreCase(
			 * ExpectedNoOfAdults));
			 */
			driverqa.findElement(Booking.ViewBooking).click();
			Thread.sleep(2000);
			obj.Takesnap(driverqa, Config.SnapShotPath() + "/Amend/Accommodation_Amend_Credit/Booking-Details1.jpg");

			// This will scroll the page till the element is found

			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(2000);
			obj.Takesnap(driverqa, Config.SnapShotPath() + "/Amend/Accommodation_Amend_Credit/Booking-Details2.jpg");
			wait.until(ExpectedConditions.visibilityOfElementLocated(Booking.BookingStatusPrepay));
			String ExpectedStatus = "Confirmed";
			String ExpectedNoOfAdults = "2 Adults";
			String ExpectedNoOfChild = "1 Child";
			String ActualNoOfAdults = driverqa.findElement(Booking.noOfAdultsPrepay).getText();
			String ActualStatus = driverqa.findElement(Booking.BookingStatusPrepay).getText();
			Assert.assertTrue(ActualStatus.equalsIgnoreCase(ExpectedStatus));
			Assert.assertTrue(ActualNoOfAdults.contains(ExpectedNoOfAdults));
			Assert.assertTrue(ActualNoOfAdults.contains(ExpectedNoOfChild));
			test.log(LogStatus.INFO, "Ending Hotel Book");
			test.log(LogStatus.PASS, "Hotel Book");
			logger.info("Hotel Booked");

		} catch (Throwable e) {
			test.log(LogStatus.FAIL, "Hotel Book Credit");
			obj.Takesnap(driverqa, Config.SnapShotPath() + "/Amend/Error/Accommodation_Amend_Credit/Booking.jpg");
			errorpath = Config.SnapShotPath() + "/Amend/Error/Accommodation_Amend_Credit/Booking.jpg";
			logger.info(e.getMessage());
			test.log(LogStatus.FAIL, e.getMessage());
			rep.endTest(test);
			rep.flush();
			Assert.assertTrue(false, e.getMessage());
		}
		test.log(LogStatus.INFO, "Starting Hotel Amend");
		logger.info("Starting Hotel Amend");
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Amend.AmendButton));
			driverqa.findElement(Amend.AmendButton).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Amend.VerifyAmendPage));
			test.log(LogStatus.INFO, "Changing No Of Passengers");
			Select Adults = new Select(driverqa.findElement(Amend.Adults));
			Adults.selectByIndex(2);
			Select Child = new Select(driverqa.findElement(Amend.Children));
			Child.selectByIndex(0);

			test.log(LogStatus.PASS, "Changing No Of Passengers");

			Thread.sleep(2000);
			obj.Takesnap(driverqa, Config.SnapShotPath() + "/Amend/Accommodation_Amend_Credit/Changed-Dates.jpg");
			driverqa.findElement(Amend.AfterAmendButton).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(Amend.AmendConfirmPageCheckIn));
			// ActualAmendDateChkIn =
			// driverqa.findElement(Amend.AmendConfirmPageCheckIn).getText();
			// ActualAmendDateChkOut =
			// driverqa.findElement(Amend.AmendConfirmPageCheckOut).getText();
			// ExpectedAmendDateChkIn = excel.getData(0, 52, 1);
			// ExpectedAmendDateChkOut = excel.getData(0, 52, 2);
			// Assert.assertTrue(ActualAmendDateChkIn.contains(ExpectedAmendDateChkIn));
			// Assert.assertTrue(ActualAmendDateChkOut.contains(ExpectedAmendDateChkOut));
			Thread.sleep(2000);
			obj.Takesnap(driverqa,
					Config.SnapShotPath() + "/Amend/Accommodation_Amend_Credit/Amend-Confirmation-Page.jpg");
			test.log(LogStatus.INFO, "Confirming Changes");
			logger.info("Confirming Changes");
			driverqa.findElement(Amend.ConfirmChanges).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Amend.AmendSuccessTitle));
			ActualConfirmedAmendTitle = driverqa.findElement(Amend.AmendSuccessTitle).getText();
			/*
			 * ActualAfterAmendDateChkIn =
			 * driverqa.findElement(Amend.AfterAmendChckIn).getText();
			 * ActualAfterAmendDateChkOut =
			 * driverqa.findElement(Amend.AfterAmendChckOut).getText();
			 */
			System.out.println(ActualConfirmedAmendTitle);
			/*
			 * ExpectedAfterAmendDateChkIn = excel.getData(0, 52, 1);
			 * ExpectedAfterAmendDateChkOut = excel.getData(0, 52, 2);
			 */
			ExpectedNoOfAdults = "3 Adults";
			ActualNoOfAdults = driverqa.findElement(Amend.AfterAmendNoOfPassengers).getText();
			ExpectedConfirmedAmendTitle = "Successfully amended";
			Assert.assertTrue(ActualConfirmedAmendTitle.contains(ExpectedConfirmedAmendTitle));
			Assert.assertTrue(ActualNoOfAdults.contains(ExpectedNoOfAdults));
			Thread.sleep(2000);
			obj.Takesnap(driverqa, Config.SnapShotPath() + "/Amend/Accommodation_Amend_Credit/Amend-Confirmed1.jpg");
			JavascriptExecutor js = (JavascriptExecutor) driverqa;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(2000);
			obj.Takesnap(driverqa, Config.SnapShotPath() + "/Amend/Accommodation_Amend_Credit/Amend-Confirmed2.jpg");
			/*
			 * Assert.assertTrue(ActualAfterAmendDateChkIn.contains(
			 * ExpectedAfterAmendDateChkIn));
			 * Assert.assertTrue(ActualAfterAmendDateChkOut.contains(
			 * ExpectedAfterAmendDateChkOut));
			 */
			test.log(LogStatus.PASS, "Confirmed Changes");
			logger.info("Confirmed Changes");
			test.log(LogStatus.INFO, "Ending Hotel Amend");
			test.log(LogStatus.PASS, "Hotel Amend");
			logger.info("Hotel Amended");

		} catch (Throwable e) {
			test.log(LogStatus.FAIL, "Hotel Amend Credit");
			obj.Takesnap(driverqa, Config.SnapShotPath() + "/Amend/Error/Accommodation_Amend_Credit/Amending.jpg");
			errorpath = Config.SnapShotPath() + "/Amend/Error/Accommodation_Amend_Credit/Amending.jpg";
			logger.info(e.getMessage());
			test.log(LogStatus.FAIL, e.getMessage());
			rep.endTest(test);
			rep.flush();
			Assert.assertTrue(false, e.getMessage());
		}
	}

	/* ####### Generating the Failure Reports and Screenshots ######### **/

	@AfterMethod
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {

			test.log(LogStatus.FAIL, test.addScreenCapture(errorpath));
			test.log(LogStatus.FAIL, result.getThrowable());
		}
		rep.endTest(test);
	}

	/* ####### Ending Tests ######### **/

	@AfterTest
	public void afterTest() {

		rep.endTest(test);
		rep.flush();
		driverqa.close();
	}
}
