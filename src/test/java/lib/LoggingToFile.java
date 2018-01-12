package lib;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Utility.Configuration;

public class LoggingToFile {
	static Configuration propData;
	static Date strDate = new Date();
	static SimpleDateFormat dateFormat = new SimpleDateFormat("E, dd:mm:yy'_' hh_mm_ss Z");
	private static String newDate = dateFormat.format(strDate);
	private static final String LogFilePath = propData.LogFile();
	public static void insertIntoLogFile(String Message) {
		System.out.print("Done");
		File objFile = new File(LogFilePath);
		if (!(objFile.exists())) {
			try {
				objFile.createNewFile();
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
		try {
			FileWriter FW = new FileWriter(objFile, true);
			BufferedWriter BW = new BufferedWriter(FW);
			BW.write("\n");
			BW.write(newDate);
			BW.write("\n");
			BW.write(
					"--------------------------------------------------------------------------------------------------------------------");
			BW.write("\n");
			BW.write(Message);
			BW.write("\n");
			BW.write(
					"--------------------------------------------------------------------------------------------------------------------");
			BW.close();

		} catch (Exception e) {
			System.out.println(e.toString());

		}
		System.out.println(LogFilePath);
	}

}
