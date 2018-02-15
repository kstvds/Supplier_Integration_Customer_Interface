package Booking;

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

import ObjectRepository.Booking;
import ObjectRepository.LoginPage;
import ObjectRepository.Others;
import ObjectRepository.Search;
import Utility.Configuration;
import lib.DriverAndObjectDetails;
import lib.ExcelDataConfig;
import lib.ExtentManager;
import lib.Takescreenshot;
import lib.DriverAndObjectDetails.DriverName;

/* #######  Test for accommodation booking for Credit user #########
######  Scenario Logs In, Books Multi rooms for a specified hotel within Deadline with Deadline Flag set ##### */

public class Book_Credit_DeadLine_Flag_Set {
	public WebDriver driverqa;
	String ActualUnabletoBlockRooms;
	String ExpectedUnabletoBlockRooms;
	String SearchRateexpected;
	String errorpath;
	String expectedDaedline;
	String ActualDeadLine;
	ExcelDataConfig excel;
	Configuration Config = new Configuration();
	Takescreenshot obj = new Takescreenshot();
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test;
	LoginPage login = new LoginPage();
	Logger logger = Logger.getLogger("Book_Credit_DeadLine_Flag_Set");

	/* ####### Passing browser as parameters in test ######### **/

	@Test
	@Parameters({ "browsername" })
	public void BookCreditCardDeadlineFlagset(String browsername) throws Exception {
		test = rep.startTest("Credit Book MultiRoom within Deadline with Flag set");

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
		WebDriverWait wait = new WebDriverWait(driverqa, 40);
		Actions action = new Actions(driverqa);

		/* ####### Login functionality MyAdmin ######### **/

		try {
			logger.info("Browser Opened");
			String URL = excel.getData(0, 1, 5) + "/_myadmin";
			// driverqa.get(URL);
			driverqa.get(URL + "/settings/framework/accommodation/booking-channels");
			logger.info("Test Case Started");
			test.log(LogStatus.INFO, "Starting Login");
			WebElement username = driverqa.findElement(LoginPage.uname);
			username.clear();
			username.sendKeys(excel.getData(0, 1, 1));
			WebElement password = driverqa.findElement(LoginPage.pwd);
			password.clear();
			password.sendKeys(excel.getData(0, 1, 2));
			driverqa.findElement(LoginPage.submit).click();
			Thread.sleep(1000);
			String expectedtitle = "DOTWconnect.com::";
			String atualtitle = driverqa.getTitle();
			Assert.assertEquals(atualtitle, expectedtitle);
			test.log(LogStatus.INFO, "Ending Login");
			test.log(LogStatus.PASS, "PASSED Login");
			logger.info("Login Successful");
			wait.until(ExpectedConditions.visibilityOfElementLocated(Others.SupplierChannel));
			Thread.sleep(2000);
			obj.Takesnap(driverqa,
					Config.SnapShotPath() + "/Book/Accommodation_Book_Credit_DeadLine_Flag_Set/Log-In.jpg");

		} catch (Exception e) {
			obj.Takesnap(driverqa,
					Config.SnapShotPath() + "/Book/Error/Accommodation_Book_Credit_DeadLine_Flag_Set/Log-In.jpg");
			test.log(LogStatus.FAIL, "Login");
			errorpath = Config.SnapShotPath() + "/Book/Error/Accommodation_Book_Credit_DeadLine_Flag_Set/Log-In.jpg";
			logger.info(e.getMessage());
			test.log(LogStatus.FAIL, e.getMessage());
			rep.endTest(test);
			rep.flush();
			Assert.assertTrue(false, e.getMessage());

		}

		/* ####### Selecting supplier channel and setting Flag ######### **/

		try {
			driverqa.findElement(Others.SupplierChannel).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Others.SetFlag));
			String elementval = driverqa.findElement(Others.SetFlag).getAttribute("class");
			System.out.println(elementval);
			if (elementval.equals("has-switch switch-animate switch-off")) {
				driverqa.findElement(Others.SetFlag).click();
				Thread.sleep(2000);
				obj.Takesnap(driverqa, Config.SnapShotPath()
						+ "/Book/Accommodation_Book_Credit_DeadLine_Flag_Set/Before-Flag-Update.jpg");
				driverqa.findElement(Others.Updatechannel).click();
				Thread.sleep(2000);
				obj.Takesnap(driverqa,
						Config.SnapShotPath() + "/Book/Accommodation_Book_Credit_DeadLine_Flag_Set/Flag-Set.jpg");
				driverqa.findElement(Others.Homebutton).click();
			} else {
				Thread.sleep(2000);
				obj.Takesnap(driverqa,
						Config.SnapShotPath() + "/Book/Accommodation_Book_Credit_DeadLine_Flag_Set/Flag-Set.jpg");
				driverqa.findElement(Others.Homebutton).click();
			}
			driverqa.close();
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Setting Flag");
			errorpath = Config.SnapShotPath()
					+ "/Book/Error/Accommodation_Book_Credit_DeadLine_Flag_Set/Flag-Setting.jpg";
			obj.Takesnap(driverqa,
					Config.SnapShotPath() + "/Book/Error/Accommodation_Book_Credit_DeadLine_Flag_Set/Flag-Setting.jpg");
			logger.info(e.getMessage());
			test.log(LogStatus.FAIL, e.getMessage());
			rep.endTest(test);
			rep.flush();
			Assert.assertTrue(false, e.getMessage());

		}

		/* ####### Login functionality CI ######### **/

		if (browsername.equalsIgnoreCase("CH")) {
			driverqa = new DriverAndObjectDetails(DriverName.CH).CreateDriver();
		} else if (browsername.equalsIgnoreCase("IE")) {
			driverqa = new DriverAndObjectDetails(DriverName.IE).CreateDriver();
		} else {
			driverqa = new DriverAndObjectDetails(DriverName.FF).CreateDriver();
		}
		WebDriverWait wait1 = new WebDriverWait(driverqa, 50);
		Actions action1 = new Actions(driverqa);
		try {
			logger.info("Browser Opened");
			String URL = excel.getData(0, 1, 5) + "/interface/en";
			driverqa.get(URL);
			logger.info("Test Case Started");
			test.log(LogStatus.INFO, "Starting Login");
			WebElement username = driverqa.findElement(LoginPage.LoginId);
			username.clear();
			username.sendKeys(excel.getData(0, 48, 1));
			wait1.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.password));
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
			wait1.until(pageLoadCondition);
			action1.sendKeys(Keys.ESCAPE).build().perform();
			Thread.sleep(2000);
			obj.Takesnap(driverqa,
					Config.SnapShotPath() + "/Book/Accommodation_Book_Credit_DeadLine_Flag_Set/Log-In-CI.jpg");
		}

		catch (Throwable e) {

			obj.Takesnap(driverqa,
					Config.SnapShotPath() + "/Book/Error/Accommodation_Book_Credit_DeadLine_Flag_Set/Log-In-CI.jpg");
			test.log(LogStatus.FAIL, "Login");
			errorpath = Config.SnapShotPath() + "/Book/Error/Accommodation_Book_Credit_DeadLine_Flag_Set/Log-In-CI.jpg";
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
			wait1.until(ExpectedConditions.visibilityOfElementLocated(Search.dest));
			driverqa.findElement(Search.dest).sendKeys(excel.getData(0, 9, 1));
			Thread.sleep(3000);
			action1.sendKeys(Keys.ARROW_DOWN).build().perform();
			// action.sendKeys(Keys.ARROW_DOWN).build().perform();
			action1.sendKeys(Keys.ENTER).build().perform();
			test.log(LogStatus.INFO, "Selecting dates");
			driverqa.findElement(Search.InDate).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Search.CalenderIN));

			List<WebElement> allDates = driverqa.findElements(Search.CalenderIN);

			for (WebElement ele : allDates) {

				String date = ele.getText();

				if (date.equalsIgnoreCase(excel.getData(0, 54, 1))) {
					ele.click();
					break;
				}

			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(Search.CalenderIN));
			List<WebElement> allDates2 = driverqa.findElements(Search.CalenderIN);

			for (WebElement ele : allDates2) {

				String date = ele.getText();

				if (date.equalsIgnoreCase(excel.getData(0, 54, 2))) {
					ele.click();
					break;
				}

			}
			test.log(LogStatus.PASS, "Selection of Dates");
			driverqa.findElement(Search.NoOfRoomList).click();
			Thread.sleep(1000);
			WebElement element1 = driverqa.findElement(Search.NoOfRooms);
			Actions actions = new Actions(driverqa);
			actions.moveToElement(element1).click().perform();
			driverqa.findElement(Search.PaymentOption).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(Search.NetPay));
			Thread.sleep(1000);
			WebElement element = driverqa.findElement(Search.NetPay);

			Actions actions2 = new Actions(driverqa);

			actions2.moveToElement(element).click().perform();
			/*
			 * WebElement Noofadults = driverqa.findElement(Search.NoOfAdults);
			 * Noofadults.clear(); Noofadults.sendKeys("01");
			 */
			Thread.sleep(2000);
			obj.Takesnap(driverqa,
					Config.SnapShotPath() + "/Book/Accommodation_Book_Credit_DeadLine_Flag_Set/Filters.jpg");
			String expectedresult = excel.getData(0, 9, 1);
			expectedDaedline = excel.getData(0, 30, 1);
			driverqa.findElement(Search.SearchBtn).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(Search.HotelTitle));
			if (driverqa.findElements(Booking.ClickDeadline).size() != 0) {
				WebElement element2 = driverqa.findElement(Booking.ClickDeadline);
				JavascriptExecutor js = (JavascriptExecutor) driverqa;
				js.executeScript("var evt = document.createEvent('MouseEvents');"
						+ "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
						+ "arguments[0].dispatchEvent(evt);", element2);
				Thread.sleep(2000);
				wait1.until(ExpectedConditions.visibilityOfElementLocated(Search.Deadlinetext));
			}
			Thread.sleep(2000);
			obj.Takesnap(driverqa,
					Config.SnapShotPath() + "/Book/Accommodation_Book_Credit_DeadLine_Flag_Set/Search-Result.jpg");
			String actualresult = driverqa.findElement(Search.HotelTitle).getText();
			ActualDeadLine = driverqa.findElement(Search.Deadlinetext).getText();
			Assert.assertTrue(ActualDeadLine.contains(expectedDaedline));
			Assert.assertTrue(actualresult.equalsIgnoreCase(expectedresult));
			test.log(LogStatus.INFO, "Ending HotelSearch Credit");
			test.log(LogStatus.PASS, "PASSED HotelSearch Credit");
			logger.info("Hotel Search Complete Credit");
		} catch (Throwable e) {
			test.log(LogStatus.FAIL, "Hotel Search Credit");

			obj.Takesnap(driverqa, Config.SnapShotPath()
					+ "/Book/Error/Accommodation_Book_Credit_DeadLine_Flag_Set/Search-Result.jpg");
			errorpath = Config.SnapShotPath()
					+ "/Book/Error/Accommodation_Book_Credit_DeadLine_Flag_Set/Search-Result.jpg";
			logger.info(e.getMessage());
			test.log(LogStatus.FAIL, e.getMessage());
			rep.endTest(test);
			rep.flush();
			Assert.assertTrue(false, e.getMessage());
		}

		/*
		 * ####### Booking Hotel for the specified date with Deadline Flag set
		 * #########
		 **/

		try {
			test.log(LogStatus.INFO, "Starting Hotel Book Credit with Deadline flag set");
			logger.info("Starting Hotel Book Credit with Deadline flag set");
			wait1.until(ExpectedConditions.visibilityOfElementLocated(Booking.BookMultiRoom));
			test.log(LogStatus.INFO, "Starting MultiRoom Selection");
			logger.info("Starting MultiRoom Selection");
			wait1.until(ExpectedConditions.visibilityOfElementLocated(Search.MultiRoomNoSelection));
			Select NoOfRooms = new Select(driverqa.findElement(Search.MultiRoomNoSelection));
			NoOfRooms.selectByIndex(2);
			test.log(LogStatus.INFO, "MultiRoom Selected");
			logger.info("MultiRoom Selected");
			Thread.sleep(2000);
			obj.Takesnap(driverqa,
					Config.SnapShotPath() + "/Book/Accommodation_Book_Credit_DeadLine_Flag_Set/MultiRoom.jpg");
			WebElement element = driverqa.findElement(Booking.BookMultiRoom);
			JavascriptExecutor js = (JavascriptExecutor) driverqa;
			js.executeScript("var evt = document.createEvent('MouseEvents');"
					+ "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
					+ "arguments[0].dispatchEvent(evt);", element);
			// Thread.sleep(10000);
			// wait1.until(ExpectedConditions.visibilityOfElementLocated(Search.Deadlinetext));
			wait1.until(ExpectedConditions.visibilityOfElementLocated(Booking.Unabletoblockmultiroom));
			ActualUnabletoBlockRooms = driverqa.findElement(Booking.Unabletoblockmultiroom).getText();
			ExpectedUnabletoBlockRooms = "Unable to block all rooms for this booking.";
			Thread.sleep(2000);
			obj.Takesnap(driverqa, Config.SnapShotPath()
					+ "/Book/Accommodation_Book_Credit_DeadLine_Flag_Set/Unable-To-book-MultiRoom.jpg");
			// wait1.until(ExpectedConditions.visibilityOfElementLocated(Booking.BookingStatusPrepay));

			Assert.assertTrue(ActualUnabletoBlockRooms.contains(ExpectedUnabletoBlockRooms));
			// Assert.assertTrue(ActualNoOfAdults.equalsIgnoreCase(ExpectedNoOfAdults));
			test.log(LogStatus.INFO, "Ending Hotel Book Credit with Deadline flag set");
			test.log(LogStatus.PASS, "Hotel Book Credit with Deadline flag set");
			logger.info("Hotel Booked Credit with Deadline flag set");

		} catch (Throwable e) {
			test.log(LogStatus.FAIL, "Hotel Book Credit with Deadline flag set");
			obj.Takesnap(driverqa, Config.SnapShotPath()
					+ "/Book/Error/Accommodation_Book_Credit_DeadLine_Flag_Set/Unable-To-book-MultiRoom.jpg");
			errorpath = Config.SnapShotPath()
					+ "/Book/Error/Accommodation_Book_Credit_DeadLine_Flag_Set/Unable-To-book-MultiRoom.jpg";
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
