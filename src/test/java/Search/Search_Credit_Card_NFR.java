package Search;

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

import ObjectRepository.LoginPage;
import ObjectRepository.Search;
import Utility.Configuration;
import lib.DriverAndObjectDetails;
import lib.ExcelDataConfig;
import lib.ExtentManager;
import lib.Takescreenshot;
import lib.DriverAndObjectDetails.DriverName;

public class Search_Credit_Card_NFR {
	public WebDriver driverqa;
	Configuration Config = new Configuration();
	Takescreenshot obj= new Takescreenshot();
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test;
	LoginPage login = new LoginPage();
	//HomePage home = new HomePage();
	//NewAccoBooking acco = new NewAccoBooking();
	//Operations opo = new Operations();
	Logger logger = Logger.getLogger("Search_Credit_Card_NFR");
	String errorpath;
	 @Test
	 @Parameters({ "browsername" })
	  public void SearchCreditCardNFR(String browsername) throws Exception {
		  test = rep.startTest("Credit Card Search NFR");
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
				username.sendKeys(excel.getData(0, 48, 1));
				
				//WebElement password = driverqa.findElement(LoginPage.password);
				//password.clear();
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
		        //WebDriverWait waiting = new WebDriverWait(driverqa, 30);
		        wait.until(pageLoadCondition);
				//wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.Closetuto));
				//driverqa.findElement(LoginPage.Closetuto).click();
				action.sendKeys(Keys.ESCAPE).build().perform();
				Thread.sleep(2000);
				obj.Takesnap(driverqa, Config.SnapShotPath() + "/Search/Accommodation_Search_Credit_Card_NFR/Log-In.jpg");

		} catch (Exception e) {
			
			obj.Takesnap(driverqa, Config.SnapShotPath() + "/Search/Error/Accommodation_Search_Credit_Card_NFR/Log-In.jpg");
			errorpath=Config.SnapShotPath() + "/Search/Error/Accommodation_Search_Credit_Card_NFR/Log-In.jpg";
			test.log(LogStatus.FAIL, "Login");
			logger.info(e.getMessage());
			test.log(LogStatus.FAIL, e.getMessage());
			rep.endTest(test);
			rep.flush();
			Assert.assertTrue(false, e.getMessage());
						
		}
	           try {
				logger.info("Applying search Filters");
				   logger.info("Starting HotelSearch Credit Card NFR");
				   test.log(LogStatus.INFO, "Starting HotelSearch Credit Card NFR");
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
						obj.Takesnap(driverqa, Config.SnapShotPath() + "/Search/Accommodation_Search_Credit_Card_NFR/Filters.jpg");
						 String expectedresult=excel.getData(0, 9, 1);
						 String expectedNFR=excel.getData(0, 32, 1);
						 driverqa.findElement(Search.SearchBtn).click();
						 wait.until(ExpectedConditions.visibilityOfElementLocated(Search.HotelTitle));
						 Thread.sleep(2000);
						 obj.Takesnap(driverqa, Config.SnapShotPath() + "/Search/Accommodation_Search_Credit_Card_NFR/Search-Result.jpg");
                         String actualresult= driverqa.findElement(Search.HotelTitle).getText();
                         String ActualNFR = driverqa.findElement(Search.Deadlinetext).getText();
                         Assert.assertTrue(ActualNFR.contains(expectedNFR));
						 Assert.assertTrue(actualresult.equalsIgnoreCase(expectedresult));
						 test.log(LogStatus.INFO, "Ending HotelSearch Credit Card NFR");
						 test.log(LogStatus.PASS, "PASSED HotelSearch Credit Card NFR");
						 logger.info("Hotel Search Complete Credit Card NFR");
			} catch (Exception e) {
				test.log(LogStatus.FAIL, "Hotel Search Prepay NFR");
				obj.Takesnap(driverqa, Config.SnapShotPath() + "/Search/Accommodation_Search_Credit_Card_NFR/Search-Result.jpg");
				errorpath=Config.SnapShotPath() + "/Search/Error/Accommodation_Search_Credit_Card_NFR/Search-Result.jpg";
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




