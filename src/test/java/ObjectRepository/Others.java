package ObjectRepository;

import org.openqa.selenium.By;

public class Others {
	public static final By settings = By.xpath(".//*[@id='MenuBar_0']/div[2]/ul[1]/li[3]/a");
    public static final By Framework = By.name("//a[@class='dropdown-toggle'][@data-toggle='dropdown']//following-sibling::b");
    public static final By BookingChannelSetup = By.xpath("//a[contains(text(),'Booking Channels Setup')]");
    public static final By SupplierChannel = By.xpath("//*[@id='supplier_1807']/td[10]/a");
  
    public static final By SetFlag = By.xpath("//*[contains(text(),'Disable Multiple Room Bookings Within CXL')]//following-sibling::div//following-sibling::div[1]");
    public static final By Homebutton = By.xpath("//*[@id='home-button']");
    public static final By Updatechannel = By.xpath("//button[@type='submit']");
    public static final By Unabletobook = By.xpath("//*[contains(text(),'Unable to block all rooms for this booking')]");
}
