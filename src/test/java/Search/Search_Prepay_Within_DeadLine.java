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

public class Search_Prepay_Within_DeadLine {
	public WebDriver driverqa;
	Configuration Config = new Configuration();
	Takescreenshot obj= new Takescreenshot();
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test;
	LoginPage login = new LoginPage();
	//HomePage home = new HomePage();
	//NewAccoBooking acco = new NewAccoBooking();
	//Operations opo = new Operations();
	Logger logger = Logger.getLogger("Search_Prepay_Within_DeadLine");
	String errorpath;
	 @Test
	 @Parameters({ "browsername" })
	  public void SearchPrepayWithinDeadLine(String browsername) throws Exception {
		  test = rep.startTest("PrePay Search Within DeadLine");
		  ExcelDataConfig excel;
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
			    WebDriverWait wait= new WebDriverWait(driverqa, 30);
			    Actions action = new Actions(driverqa);
	           try{
			    logger.info("Browser Opened");
			    String URL = excel.getData(0, 1, 5) + "/interface/en";
				driverqa.get(URL);
				logger.info("Test Case Started");
				test.log(LogStatus.INFO, "Starting Login");
				WebElement username = driverqa.findElement(LoginPage.LoginId);
				username.clear();
				username.sendKeys(excel.getData(0, 47, 1));
				
				//WebElement password = driverqa.findElement(LoginPage.password);
				//password.clear();
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
				//Thread.sleep(7000);
				ExpectedCondition<Boolean> pageLoadCondition = new
		                ExpectedCondition<Boolean>() {
		                    public Boolean apply(WebDriver driver) {
		                        return ((JavascriptExecutor)driverqa).executeScript("return document.readyState").equals("complete");
		                    }
		                };
		        //WebDriverWait waiting = new WebDriverWait(driverqa, 30);
		        wait.until(pageLoadCondition);
				//wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.Closetuto));
				//driverqa.findElement(LoginPage.Closetuto).click();
				action.sendKeys(Keys.ESCAPE).build().perform();
				Thread.sleep(2000);
				obj.Takesnap(driverqa, Config.SnapShotPath() + "/Search/Accommodation_Search_Prepay_Within_DeadLine/Log-In.jpg");

		} catch (Exception e) {
			
			obj.Takesnap(driverqa, Config.SnapShotPath() + "/Search/Error/Accommodation_Search_Prepay_Within_DeadLine/Log-In.jpg");
			errorpath=Config.SnapShotPath() + "/Search/Error/Accommodation_Search_Prepay_Within_DeadLine/Log-In.jpg";
			test.log(LogStatus.FAIL, "Login");
			logger.info(e.getMessage());
			test.log(LogStatus.FAIL, e.getMessage());
			rep.endTest(test);
			rep.flush();
			Assert.assertTrue(false, e.getMessage());
						
		}
	           try {
				logger.info("Applying search Filters");
				   logger.info("Starting HotelSearch Prepay Within DeadLine");
				   test.log(LogStatus.INFO, "Starting HotelSearch Prepay Within DeadLine");
				   wait.until(ExpectedConditions.visibilityOfElementLocated(Search.dest));
				   driverqa.findElement(Search.dest).sendKeys(excel.getData(0, 9, 1));
				   Thread.sleep(2000);
				   action.sendKeys(Keys.ARROW_DOWN).build().perform();
				   action.sendKeys(Keys.ENTER).build().perform();
				   /*test.log(LogStatus.INFO, "Selecting dates");
				   driverqa.findElement(Search.InDate).click();
				   wait.until(ExpectedConditions.visibilityOfElementLocated(Search.CalenderIN));
				   driverqa.findElement(Search.nextmnth).click();
				   driverqa.findElement(Search.nextmnth).click();
					List<WebElement> allDates=driverqa.findElements(Search.CalenderIN);
					
					for(WebElement ele:allDates)
					{
						
						String date=ele.getText();
						
						if(date.equalsIgnoreCase(excel.getData(0, 51, 1)))
						{
							ele.click();
							break;
						}
						
					}
					wait.until(ExpectedConditions.visibilityOfElementLocated(Search.CalenderIN));
					   //driverqa.findElement(Search.nextmnth).click();
					   //driverqa.findElement(Search.nextmnth).click();
						List<WebElement> allDates2=driverqa.findElements(Search.CalenderIN);
						
						for(WebElement ele:allDates2)
						{
							
							String date=ele.getText();
							
							if(date.equalsIgnoreCase(excel.getData(0, 51, 2)))
							{
								ele.click();
								break;
							}
							
						}
						test.log(LogStatus.PASS, "Selection of Dates");*/
						Thread.sleep(2000);
						obj.Takesnap(driverqa, Config.SnapShotPath() + "/Search/Accommodation_Search_Prepay_Within_DeadLine/Filters.jpg");
						 String expectedresult=excel.getData(0, 9, 1);
						 String expectedDaedline=excel.getData(0, 30, 1);
						 driverqa.findElement(Search.SearchBtn).click();
						 wait.until(ExpectedConditions.visibilityOfElementLocated(Search.HotelTitle));
						 WebElement element = driverqa.findElement(Booking.ClickDeadline);
						 JavascriptExecutor js = (JavascriptExecutor) driverqa;
						 js.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", element); 
						 wait.until(ExpectedConditions.visibilityOfElementLocated(Search.Deadlinetext));

						 Thread.sleep(2000);
						 obj.Takesnap(driverqa, Config.SnapShotPath() + "/Search/Accommodation_Search_Prepay_Within_DeadLine/Search-Result.jpg");
                         String actualresult= driverqa.findElement(Search.HotelTitle).getText();
                         String ActualDeadLine = driverqa.findElement(Search.Deadlinetext).getText();
                         Assert.assertTrue(ActualDeadLine.contains(expectedDaedline));
						 Assert.assertTrue(actualresult.equalsIgnoreCase(expectedresult));
						 test.log(LogStatus.INFO, "Ending HotelSearch Prepay Within DeadLine");
						 test.log(LogStatus.PASS, "PASSED HotelSearch Prepay Within DeadLine");
						 logger.info("Hotel Search Complete Prepay Within DeadLine");
			} catch (Exception e) {
				test.log(LogStatus.FAIL, "Hotel Search Prepay Within DeadLine");
				obj.Takesnap(driverqa, Config.SnapShotPath() + "/Search/Accommodation_Search_Prepay_Within_DeadLine/Search-Result.jpg");
				errorpath=Config.SnapShotPath() + "/Search/Error/Accommodation_Search_Prepay_Within_DeadLine/Search-Result.jpg";
				logger.info(e.getMessage());
				test.log(LogStatus.FAIL, e.getMessage());
				rep.endTest(test);
				rep.flush();
				Assert.assertTrue(false, e.getMessage());
			}
				
			  	 }
	 @AfterMethod
	 public void getResult(ITestResult result) {
		  if (result.getStatus() == ITestResult.FAILURE) {
		 
		
		test.log(LogStatus.FAIL, test.addScreenCapture(errorpath));
		  test.log(LogStatus.FAIL, result.getThrowable());
		  }
		  rep.endTest(test);
		  }

		@AfterTest
		public void afterTest() {

			rep.endTest(test);
			rep.flush();
			driverqa.close();
		}
	 }


