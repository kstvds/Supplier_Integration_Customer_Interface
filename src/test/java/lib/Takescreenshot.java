package lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Takescreenshot 
{
public void Takesnap(WebDriver driver,String excelPath)
    {
    try 
    {
    	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File(excelPath));
	 } 
    catch (Exception e) 
    {
	System.out.println(e.getMessage());
    }
  }
}