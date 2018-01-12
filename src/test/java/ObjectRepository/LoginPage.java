package ObjectRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public static final By LoginId = By.xpath("//*[@id='userID']");
    public static final By password = By.xpath("//*[@id='password']");
    public static final By Companycode = By.xpath("//*[@id='companyCode']");
    public static final By Submit = By.xpath("//*[@id='button']");
    public static final By Closetuto = By.xpath("/html/body/div[14]");
}
