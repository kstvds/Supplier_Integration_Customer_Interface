package ObjectRepository;

import org.openqa.selenium.By;

public class Search {
	public static final By dest = By.xpath("//*[@id='destination']");
	public static final By InDate = By.xpath("//input[@name='DateFrom']");
	public static final By CalenderIN = By.xpath("//table[@class='ui-datepicker-calendar']//td");
	public static final By nextmnth = By.xpath("//span[contains(text(),'Next')]");
	public static final By SearchBtn = By.xpath("//*[@id='searchButton']");
    public static final By HotelTitle = By.xpath("//h3[@class='unitName']");
    public static final By Deadlinetext = By.xpath("//span[contains(text(),'Within Deadline')]");
    public static final By NFRtext = By.xpath("//span[contains(text(),'Strictly Non Refundable')]");
    //public static final By Submit = By.xpath("//*[@id='button']");
    // static final By Closetuto = By.xpath("/html/body/div[13]");
}
