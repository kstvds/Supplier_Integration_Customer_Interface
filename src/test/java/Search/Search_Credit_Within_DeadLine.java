package Search;

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

/* #######  Test for accommodation Search for Credit within DeadLine #########
######  Scenario Logs In, Searches a specified hotel within DeadLine  ##### */

public class Search_Credit_Within_DeadLine {
	public WebDriver driverqa;
	String expectedresult;
	String expectedDaedline;
	String actualresult;
	String errorpath;
	ExcelDataConfig excel;
	ExtentTest test;
	String ActualDeadLine;
	Configuration Config = new Configuration();
	Takescreenshot obj = new Takescreenshot();
	ExtentReports rep = ExtentManager.getInstance();
	LoginPage login = new LoginPage();
    Logger logger = Logger.getLogger("Search_Credit_Within_DeadLine");
	
    /* ####### Passing browser as parameters in test ######### **/
	
	@Test
	@Parameters({ "browsername" })
	public void SearchCreditWithinDeadLine(String browsername) throws Exception {
		test = rep.startTest("Credit Search Within DeadLine");
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
		WebDriverWait wait = new WebDriverWait(driverqa, 30);
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
			obj.Takesnap(driverqa,
					Config.SnapShotPath() + "/Search/Accommodation_Search_Credit_Within_DeadLine/Log-In.jpg");

		} catch (Throwable e) {

			obj.Takesnap(driverqa,
					Config.SnapShotPath() + "/Search/Error/Accommodation_Search_Credit_Within_DeadLine/Log-In.jpg");
			errorpath = Config.SnapShotPath() + "/Search/Error/Accommodation_Search_Credit_Within_DeadLine/Log-In.jpg";
			test.log(LogStatus.FAIL, "Login");
			logger.info(e.getMessage());
			test.log(LogStatus.FAIL, e.getMessage());
			rep.endTest(test);
			rep.flush();
			Assert.assertTrue(false, e.getMessage());

		}
		
		/* ####### Applying filters and searching for Hotel ######### **/
		
		try {
			logger.info("Applying search Filters");
			logger.info("Starting HotelSearch Credit Within DeadLine");
			test.log(LogStatus.INFO, "Starting HotelSearch Credit Within DeadLine");
			wait.until(ExpectedConditions.visibilityOfElementLocated(Search.dest));
			driverqa.findElement(Search.dest).sendKeys(excel.getData(0, 9, 1));
			Thread.sleep(4000);
			action.sendKeys(Keys.ARROW_DOWN).build().perform();
			action.sendKeys(Keys.ENTER).build().perform();
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
			Thread.sleep(2000);
			obj.Takesnap(driverqa,
					Config.SnapShotPath() + "/Search/Accommodation_Search_Credit_Within_DeadLine/Filters.jpg");
			expectedresult = excel.getData(0, 9, 1);
			expectedDaedline = excel.getData(0, 30, 1);
			driverqa.findElement(Search.SearchBtn).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Search.HotelTitle));
			if (driverqa.findElements(Booking.ClickDeadline).size() != 0) {
				WebElement element = driverqa.findElement(Booking.ClickDeadline);
				JavascriptExecutor js = (JavascriptExecutor) driverqa;
				js.executeScript("var evt = document.createEvent('MouseEvents');"
						+ "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
						+ "arguments[0].dispatchEvent(evt);", element);
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(Search.Deadlinetext));
			}
			Thread.sleep(2000);
			obj.Takesnap(driverqa,
					Config.SnapShotPath() + "/Search/Accommodation_Search_Credit_Within_DeadLine/Search-Result.jpg");
			actualresult = driverqa.findElement(Search.HotelTitle).getText();
			ActualDeadLine = driverqa.findElement(Search.Deadlinetext).getText();
            Assert.assertTrue(ActualDeadLine.contains(expectedDaedline));
			Assert.assertTrue(actualresult.equalsIgnoreCase(expectedresult));
			test.log(LogStatus.INFO, "Ending HotelSearch Credit Within DeadLine");
			test.log(LogStatus.PASS, "PASSED HotelSearch Credit Within DeadLine");
			logger.info("Hotel Search Complete Credit Within DeadLine");
		} catch (Throwable e) {
			test.log(LogStatus.FAIL, "Hotel Search Credit Within DeadLine");
			obj.Takesnap(driverqa,
					Config.SnapShotPath() + "/Search/Accommodation_Search_Credit_Within_DeadLine/Search-Result.jpg");
			errorpath = Config.SnapShotPath()
					+ "/Search/Error/Accommodation_Search_Credit_Within_DeadLine/Search-Result.jpg";
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

	/* ####### Generating the Failure Reports and Screenshots ######### **/
	
	@AfterTest
	public void afterTest() {

		rep.endTest(test);
		rep.flush();
		driverqa.close();
	}
}
