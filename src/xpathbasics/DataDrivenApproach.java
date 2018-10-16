import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class DataDrivenApproach {
	public WebDriver driver;

	@BeforeMethod
	public void initialize() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kxc212\\Desktop\\Equifax_GDS\\Softwares\\AutomationTesting\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://identity.equifax.com/iiq/login.jsf?prompt=true#/accessRequest?quickLink=Request+Access");

	}

	@Test

	public void testcase() {

		Assert.assertEquals("Equifax Access Manager", driver.getTitle());

	}

	@Test
	@Parameters({"Username","Password"})
	public void testcase2(String Username, String Password) {

		driver.findElement(By.id("loginForm:accountId")).sendKeys(Username);
		driver.findElement(By.id("loginForm:password")).sendKeys(Password);
		driver.findElement(By.id("loginForm:loginButton")).click();
		Assert.assertEquals("Karan Chaudhary",
				driver.findElement(By.xpath("//span[contains(text(),'Karan Chaudhary')]")).getText());

	}

	@AfterMethod
	public void dropdown() {
		driver.quit();
	}

}
