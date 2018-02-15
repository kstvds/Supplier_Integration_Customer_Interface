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
import ObjectRepository.Search;
import Utility.Configuration;
import lib.DriverAndObjectDetails;
import lib.ExcelDataConfig;
import lib.ExtentManager;
import lib.Takescreenshot;
import lib.DriverAndObjectDetails.DriverName;

/* #######  Test for accommodation booking for Prepay user #########
######  Scenario Logs In, Books a specified hotel with single passenger same first and last name  ##### */

public class Prepay_Book_Same_First_Name_Last_Name {
	public WebDriver driverqa;
	String errorpath;
	String Roomtype;
	ExtentTest test;
	ExcelDataConfig excel;
	Configuration Config = new Configuration();
	Takescreenshot obj = new Takescreenshot();
	ExtentReports rep = ExtentManager.getInstance();
	LoginPage login = new LoginPage();
	Logger logger = Logger.getLogger("Prepay_Book_Same_First_Name_Last_Name");

	/* ####### Passing browser as parameters in test ######### **/

	@Test
	@Parameters({ "browsername" })
	public void PrepayBook(String browsername) throws Exception {
		test = rep.startTest("Prepay Book Same First Name Last Name");
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
		WebDriverWait wait = new WebDriverWait(driverqa, 70);
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
			username.sendKeys(excel.getData(0, 47, 1));

			// WebElement password = driverqa.findElement(LoginPage.password);
			// password.clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.password));
			driverqa.findElement(LoginPage.password).sendKeys(excel.getData(0, 47, 2));
			Thread.sleep(1000);
			WebElement company = driverqa.findElement(LoginPage.Companycode);
			company.clear();
			company.sendKeys(excel.getData(0, 47, 3));
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
			obj.Takesnap(driverqa,
					Config.SnapShotPath() + "/Book/Accommodation_Book_Prepay_Same_First_Name_Last_Name/Log-In.jpg");

		} catch (Throwable e) {

			obj.Takesnap(driverqa, Config.SnapShotPath()
					+ "/Book/Error/Accommodation_Book_Prepay_Same_First_Name_Last_Name/Log-In.jpg");
			test.log(LogStatus.FAIL, "Login");
			errorpath = Config.SnapShotPath()
					+ "/Book/Error/Accommodation_Book_Prepay_Same_First_Name_Last_Name/Log-In.jpg";
			logger.info(e.getMessage());
			test.log(LogStatus.FAIL, e.getMessage());
			rep.endTest(test);
			rep.flush();
			Assert.assertTrue(false, e.getMessage());

		}
		/* ####### Applying filters and searching for filters ######### **/

		try {
			logger.info("Applying search Filters");
			logger.info("Starting HotelSearch Prepay");
			test.log(LogStatus.INFO, "Starting HotelSearch Prepay");
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
			WebElement Noofadults = driverqa.findElement(Search.NoOfAdults);
			Noofadults.clear();
			Noofadults.sendKeys("01");
			Thread.sleep(2000);
			obj.Takesnap(driverqa,
					Config.SnapShotPath() + "/Book/Accommodation_Book_Prepay_Same_First_Name_Last_Name/Filters.jpg");
			String expectedresult = excel.getData(0, 9, 1);
			driverqa.findElement(Search.SearchBtn).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Search.HotelTitle));
			Thread.sleep(2000);
			obj.Takesnap(driverqa, Config.SnapShotPath()
					+ "/Book/Accommodation_Book_Prepay_Same_First_Name_Last_Name/Search-Result.jpg");
			String actualresult = driverqa.findElement(Search.HotelTitle).getText();
			Assert.assertTrue(actualresult.equalsIgnoreCase(expectedresult));
			test.log(LogStatus.INFO, "Ending HotelSearch Prepay");
			test.log(LogStatus.PASS, "PASSED HotelSearch Prepay");
			logger.info("Hotel Search Complete Prepay");
		} catch (Throwable e) {
			test.log(LogStatus.FAIL, "Hotel Search Prepay");

			obj.Takesnap(driverqa, Config.SnapShotPath()
					+ "/Book/Error/Accommodation_Book_Prepay_Same_First_Name_Last_Name/Search-Result.jpg");
			errorpath = Config.SnapShotPath()
					+ "/Book/Error/Accommodation_Book_Prepay_Same_First_Name_Last_Name/Search-Result.jpg";
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
			driverqa.findElement(Booking.OnePaxlastName).sendKeys(excel.getData(0, 21, 1));
			Select passengertitle = new Select(driverqa.findElement(Booking.OnePaxTitle));
			passengertitle.selectByIndex(1);
			driverqa.findElement(Booking.PrcdToBookChckBox).click();
			Thread.sleep(2000);
			obj.Takesnap(driverqa, Config.SnapShotPath()
					+ "/Book/Accommodation_Book_Prepay_Same_First_Name_Last_Name/Passenger-Details.jpg");
			logger.info("Entered Passenger details");
			test.log(LogStatus.INFO, "Entered Passenger details");
			test.log(LogStatus.PASS, "Passenger details");
			driverqa.findElement(Booking.ConfirmBook).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(Booking.BookingStatusPrepay));
			String ExpectedStatus = "Confirmed";
			String ExpectedNoOfAdults = "01 Adult";
			String ActualNoOfAdults = driverqa.findElement(Booking.noOfAdultsPrepay).getText();
			String ActualStatus = driverqa.findElement(Booking.BookingStatusPrepay).getText();
			// System.out.println(ActualNoOfAdults);
			// System.out.println(ActualStatus);
			JavascriptExecutor js = (JavascriptExecutor) driverqa;
			Thread.sleep(2000);
			obj.Takesnap(driverqa, Config.SnapShotPath()
					+ "/Book/Accommodation_Book_Prepay_Same_First_Name_Last_Name/Booking-Details1.jpg");
			WebElement Element = driverqa.findElement(Booking.Invoice);

			// This will scroll the page till the element is found

			js.executeScript("arguments[0].scrollIntoView();", Element);
			Thread.sleep(2000);
			obj.Takesnap(driverqa, Config.SnapShotPath()
					+ "/Book/Accommodation_Book_Prepay_Same_First_Name_Last_Name/Booking-Details2.jpg");
			Assert.assertTrue(ActualStatus.equalsIgnoreCase(ExpectedStatus));
			Assert.assertTrue(ActualNoOfAdults.equalsIgnoreCase(ExpectedNoOfAdults));
			test.log(LogStatus.INFO, "Ending Hotel Book");
			test.log(LogStatus.PASS, "Hotel Book");
			logger.info("Hotel Booked");

		} catch (Throwable e) {
			test.log(LogStatus.FAIL, "Hotel Book Prepay");
			obj.Takesnap(driverqa, Config.SnapShotPath()
					+ "/Book/Error/Accommodation_Book_Prepay_Same_First_Name_Last_Name/Booking.jpg");
			errorpath = Config.SnapShotPath()
					+ "/Book/Error/Accommodation_Book_Prepay_Same_First_Name_Last_Name/Booking.jpg";
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
