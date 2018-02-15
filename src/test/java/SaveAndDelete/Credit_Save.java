package SaveAndDelete;

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

//import ObjectRepository.Amend;
import ObjectRepository.Booking;
import ObjectRepository.LoginPage;
import ObjectRepository.Search;
import Utility.Configuration;
import lib.DriverAndObjectDetails;
import lib.ExcelDataConfig;
import lib.ExtentManager;
import lib.Takescreenshot;
import lib.DriverAndObjectDetails.DriverName;

/* #######  Test for accommodation saving itenary for Credit user #########
######  Scenario Logs In, Searches a specified hotel and then saves the itenary   ##### */


public class Credit_Save {
	public WebDriver driverqa;
	ExtentTest test;
	String errorpath;
	String Roomtype;
	ExcelDataConfig excel;
	Configuration Config = new Configuration();
	Takescreenshot obj= new Takescreenshot();
	ExtentReports rep = ExtentManager.getInstance();
	LoginPage login = new LoginPage();
	Logger logger = Logger.getLogger("Credit_Save");
	
	/* ####### Passing browser as parameters in test ######### **/
	
	 @Test
	 @Parameters({ "browsername" })
	  public void CreditSave(String browsername) throws Exception {
		  test = rep.startTest("Credit Save");
		  
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
			    
			    /* ####### Login functionality ######### **/
			    
	           try{
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
				//Thread.sleep(7000);
				ExpectedCondition<Boolean> pageLoadCondition = new
		                ExpectedCondition<Boolean>() {
		                    public Boolean apply(WebDriver driver) {
		                        return ((JavascriptExecutor)driverqa).executeScript("return document.readyState").equals("complete");
		                    }
		                };
		        wait.until(pageLoadCondition);
				action.sendKeys(Keys.ESCAPE).build().perform();
				Thread.sleep(2000);
				obj.Takesnap(driverqa, Config.SnapShotPath() + "/Save/Accommodation_Save_Credit/Log-In.jpg");

		} catch (Exception e) {
			
			obj.Takesnap(driverqa, Config.SnapShotPath() + "/Save/Error/Accommodation_Save_Credit/Log-In.jpg");
			test.log(LogStatus.FAIL, "Login");
			errorpath=Config.SnapShotPath() + "/Save/Error/Accommodation_Save_Credit/Log-In.jpg";
			logger.info(e.getMessage());
			test.log(LogStatus.FAIL, e.getMessage());
			rep.endTest(test);
			rep.flush();
			Assert.assertTrue(false, e.getMessage());
						
		}
	           /* ####### Applying filters and searching for Hotel ######### **/   
	           
	           try {
				logger.info("Applying search Filters");
				   logger.info("Starting HotelSearch Credit");
				   test.log(LogStatus.INFO, "Starting HotelSearch Credit");
				   Thread.sleep(2000);
				   wait.until(ExpectedConditions.visibilityOfElementLocated(Search.dest));
				   driverqa.findElement(Search.dest).sendKeys(excel.getData(0, 9, 1));
				   Thread.sleep(3000);
				   action.sendKeys(Keys.ARROW_DOWN).build().perform();
				   action.sendKeys(Keys.ENTER).build().perform();
				   test.log(LogStatus.INFO, "Selecting dates");
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
						test.log(LogStatus.PASS, "Selection of Dates");
						Thread.sleep(2000);
						obj.Takesnap(driverqa, Config.SnapShotPath() + "/Save/Accommodation_Save_Credit/Filters.jpg");
					    String expectedresult=excel.getData(0, 9, 1);
						 driverqa.findElement(Search.SearchBtn).click();
						 wait.until(ExpectedConditions.visibilityOfElementLocated(Search.HotelTitle));
	                     Thread.sleep(2000);
						 obj.Takesnap(driverqa, Config.SnapShotPath() + "/Save/Accommodation_Save_Credit/Search-Result.jpg");
                         String actualresult= driverqa.findElement(Search.HotelTitle).getText();
						 Assert.assertTrue(actualresult.equalsIgnoreCase(expectedresult));
						 test.log(LogStatus.INFO, "Ending HotelSearch Credit");
						 test.log(LogStatus.PASS, "PASSED HotelSearch Credit");
						 logger.info("Hotel Search Complete Credit");
			} catch (Exception e) {
				test.log(LogStatus.FAIL, "Hotel Search Credit");
				
				obj.Takesnap(driverqa, Config.SnapShotPath() + "/Save/Error/Accommodation_Save_Credit/Search-Result.jpg");
				errorpath=Config.SnapShotPath() + "/Save/Error/Accommodation_Save_Credit/Search-Result.jpg";
				logger.info(e.getMessage());
				test.log(LogStatus.FAIL, e.getMessage());
				rep.endTest(test);
				rep.flush();
				Assert.assertTrue(false, e.getMessage());
			}
	           /* ####### Saving Itenary for the specified hotel ######### **/
	           
	           try {
				test.log(LogStatus.INFO, "Starting Hotel Save Itenary");
				   logger.info("Starting Hotel Save");
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
					if (driverqa.findElements(Booking.TwoPaxFirstName).size() != 0)
					{
					driverqa.findElement(Booking.TwoPaxFirstName).sendKeys(excel.getData(0, 22, 1));
					Thread.sleep(1000);
					driverqa.findElement(Booking.TwoPaxLastName).sendKeys(excel.getData(0, 22, 2));
					Select passengertitle2 = new Select(driverqa.findElement(Booking.TwoPaxTitle));
					passengertitle2.selectByIndex(1);
					}
					driverqa.findElement(Booking.PrcdToBookChckBox).click();
					Thread.sleep(2000);
					obj.Takesnap(driverqa, Config.SnapShotPath() + "/Save/Accommodation_Save_Credit/Passenger-Details.jpg");
					logger.info("Entered Passenger details");
					test.log(LogStatus.INFO, "Entered Passenger details");
					test.log(LogStatus.PASS, "Passenger details");
					driverqa.findElement(Booking.ConfirmBook).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(Booking.Closeconfirmbook));
					wait.until(ExpectedConditions.elementToBeClickable(Booking.Closeconfirmbook));
					driverqa.findElement(Booking.Closeconfirmbook).click();
					Thread.sleep(2000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(Booking.ItnCart));
					wait.until(ExpectedConditions.elementToBeClickable(Booking.ItnCart));
					driverqa.findElement(Booking.ItnCart).click();
					Thread.sleep(2000);
					obj.Takesnap(driverqa, Config.SnapShotPath() + "/Save/Accommodation_Save_Credit/Itn-Cart.jpg");
                    
					wait.until(ExpectedConditions.visibilityOfElementLocated(Booking.ItnCart));
					String expectedaftrsavehotel = excel.getData(0, 9, 1);
					String actualaftrsavehotel = driverqa.findElement(Booking.AfterSaveHotel).getText();
					Assert.assertTrue(actualaftrsavehotel.equalsIgnoreCase(expectedaftrsavehotel));
					test.log(LogStatus.PASS, "Hotel Saved");
					logger.info("Hotel Saved");
					logger.info("Deleting itenary from Cart");
					test.log(LogStatus.INFO, "Deleting itenary from Cart");
					Thread.sleep(2000);
					driverqa.findElement(Booking.DeletefrmITN).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(Booking.ConfirmDeletefrmITN));
					driverqa.findElement(Booking.ConfirmDeletefrmITN).click();
					Thread.sleep(2000);
					obj.Takesnap(driverqa, Config.SnapShotPath() + "/Save/Accommodation_Save_Credit/Deleted-from-Cart.jpg");
					//Assert.assertEquals(0, driverqa.findElements(Booking.ItnCart).size());
					logger.info("Deleted from Cart");
					test.log(LogStatus.INFO, "Deleted itenary from Cart");
			} catch (Exception e) {
				test.log(LogStatus.FAIL, "Hotel Save Credit");
				obj.Takesnap(driverqa, Config.SnapShotPath() + "/Save/Error/Accommodation_Save_Credit/Itn-Save.jpg");
				errorpath=Config.SnapShotPath() + "/Save/Error/Accommodation_Save_Credit/Itn-Save.jpg";
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


