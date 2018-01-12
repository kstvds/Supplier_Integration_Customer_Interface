package ObjectRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Operations {
    public static final By newBooking = By.xpath("//a[contains(text(),'New Booking')]");
    public static final By AccomBook = By.xpath("//a[contains(text(),'Accommodation Booking')]");
    public static final By city = By.id("cityName");
    public static final By chooseCust = By.xpath("//*[contains(text(),'Choose')]");
    public static final By company = By.xpath("//*[@id='companyName']");
    public static final By chooseCustbook = By.xpath("//*[contains(text(),'Choose')]");
    public static final By centralReservOffc=By.xpath("//*[contains(text(), 'Central Reservation Office')]");
    public static final By transferBooking = By.xpath("//*[contains(text(), 'Transfer Booking')]");
    public static final By TourBook = By.xpath(".//*[@id='MenuBar_212']/div[2]/ul[1]/li[2]/ul/li[2]/a");
    public static final By VisaBook = By.xpath(".//*[@id='MenuBar_212']/div[2]/ul[1]/li[2]/ul/li[4]/a");
    public static final By CentralReservation = By.xpath(".//*[@id='MenuBar_212']/div[2]/ul[1]/li[1]/a");
    public static final By ProductType = By.xpath(".//*[@id='productType']");
    public static final By RefNo = By.xpath(".//*[@id='referenceNumber']");
    public static final By SearchBtnCRO = By.xpath(".//*[@id='croSearchForm']/div/div[3]/button");
    public static final By Result = By.xpath(".//*[@id='resultsBody']/tbody/tr[2]/td[2]/strong");
}
