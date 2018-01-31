package lib;

import java.io.*;

import com.relevantcodes.extentreports.ExtentReports;

import Utility.Configuration;

public class ExtentManager {

	private static ExtentReports extent;
	static Configuration Config = new Configuration();

	public static ExtentReports getInstance() {

		if (extent == null) {

			extent = new ExtentReports(Config.GenerateReport());
			
			extent.loadConfig(new File(System.getProperty("user.dir") + "//ReportsConfig.xml"));
			//("D:\\Supplier MyAdmin\\Supplier_Integration_MyAdmin\\Supplier_Admin\\") + "ReportsConfig.xml")
			extent.addSystemInfo("Selenium Version", "2.53.0").addSystemInfo("Environment", "QA");

		}
		return extent;
	}

}
