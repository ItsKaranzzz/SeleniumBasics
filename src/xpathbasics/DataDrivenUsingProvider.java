import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenUsingProvider {

	public WebDriver driver;

	@BeforeMethod
	public void initialize() {

		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\kxc212\\\\Desktop\\\\Equifax_GDS\\\\Softwares\\\\AutomationTesting\\\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://identity.equifax.com/iiq/login.jsf?prompt=true#/accessRequest?quickLink=Request+Access");
	}

	@Test
	public void test1() {

		Assert.assertEquals("Equifax Access Manager", driver.getTitle());
	}

	@Test(dataProvider="getData")
	public void test2(String username, String password) {

		driver.findElement(By.id("loginForm:accountId")).sendKeys(username);
		driver.findElement(By.id("loginForm:password")).sendKeys(password);
		driver.findElement(By.id("loginForm:loginButton")).click();
		Assert.assertEquals("Karan Chaudhary", driver.findElement(By.xpath("//span[contains(text(),'Karan Chaudhary')]")).getText());
	}

	@AfterMethod
	public void tearDown() {

		driver.close();
	}

	@DataProvider(name = "getData")
	public String[][] getData() {
		String arr[][]=new String[2][2];
		
		arr[0][0]="kdfsd";
		arr[0][1]="asds";
		arr[1][0]="kjhjk";
		arr[1][1]="kjuju";
				
		return  arr;

	}
}
