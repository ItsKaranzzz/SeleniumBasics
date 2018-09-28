package xpathbasics;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetPageLinks {

	private static WebDriver driver;
	private static String chromePath="E:\\Program Files\\MyDriver\\chromedriver.exe";
	private static String URL="https://www.yatra.com/";
	
	public static void main(String[] args) {
		try {
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get(URL);
		getAllPageLinks();
		driver.close();
		
		}
		catch(Exception e)
		{
			System.out.println("TimeoutException");
		}

	}

	
	public static void getAllPageLinks() {
			
		List<WebElement> ElementList=driver.findElements(By.tagName("a"));
		System.out.println("Total number of Links are: "+ ElementList.size());
		
		for(WebElement e:ElementList) {
			System.out.println(e.getText());
			}
		
		}
	
	}

	

