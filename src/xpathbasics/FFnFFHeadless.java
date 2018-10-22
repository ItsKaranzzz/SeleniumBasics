import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FFnFFHeadless {

	
	public static void main(String[] args) {
		
	
		FirefoxBinary dv= new FirefoxBinary();
		dv.addCommandLineOptions("--headless");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\kxc212\\Desktop\\Equifax_GDS\\Softwares\\AutomationTesting\\geckodriver.exe");
		FirefoxOptions options=new FirefoxOptions();
		options.setBinary(dv);
		WebDriver d=new FirefoxDriver(options);
		
		
		d.get("http://yahoo.com");
		System.out.println(d.getTitle());
		
	}
}
