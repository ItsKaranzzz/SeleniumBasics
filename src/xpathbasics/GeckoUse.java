import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GeckoUse {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\\\kxc212\\\\Desktop\\\\Equifax_GDS\\\\Softwares\\\\AutomationTesting\\\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		
		driver.get("https://identity.equifax.com/iiq/login.jsf?prompt=true#/accessRequest?quickLink=Request+Access");
		System.out.println(driver.getTitle());

	}

}
