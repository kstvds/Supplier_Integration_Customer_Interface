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
    public static final By NoOfAdults = By.xpath("//*[@id='search_row1']/div[2]/span[1]/input//following::input[1]");
    public static final By NoOfChilds = By.xpath("//*[@id='search_row1']/div[2]/span[1]/input//following::input[2]");
    public static final By PaymentOption = By.xpath("//*[@id='searchFieldsContainer']/div[6]/div[2]/button");
    public static final By NetPay = By.xpath("//*[@id='searchFieldsContainer']/div[6]/div[2]/div/ul/li[1]/a/span[1]");
    public static final By DeadLine = By.xpath("//*[@class='icon-cancel cancelInfoIcon infoBoxTrigger']");
    public static final By NFR = By.xpath("//*[@name='cancellationRulesJson']");
    public static final By NoOfRoomList = By.xpath("//*[@class='btn dropdown-toggle selectpicker btn-search']");
    public static final By NoOfRooms = By.xpath("//*[@id='searchFieldsContainer']/div[4]/div[2]/div/ul/li[2]/a");
    public static final By NoRoomsAvailable = By.xpath("//*[@id='noResultsFoundErrorMessage']/h4");
    public static final By MultiRoomNoSelection = By.xpath("//select[@class='multipleRoomsSelect']");
    //public static final By Submit = By.xpath("//*[@id='button']");
    // static final By Closetuto = By.xpath("/html/body/div[13]");
}
