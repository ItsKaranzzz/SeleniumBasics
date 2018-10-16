import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessChrome {

	public static void main(String[] args) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("set-size(1400,800)");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kxc212\\Desktop\\Equifax_GDS\\Softwares\\AutomationTesting\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("http://yahoo.com");
		System.out.println(driver.getTitle());
	}
}
