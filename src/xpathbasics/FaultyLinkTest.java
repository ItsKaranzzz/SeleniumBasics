import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FaultyLinkTest {

	public static WebDriver driver;
	public static void main(String[] args) throws MalformedURLException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\kxc212\\\\Desktop\\\\Equifax_GDS\\\\Softwares\\\\AutomationTesting\\\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.thegeekstuff.com/2010/11/50-linux-commands/");
		checkBrokenLinks();

	}
	public static void checkBrokenLinks() throws MalformedURLException, IOException {
		
		List<WebElement> allElements=driver.findElements(By.tagName("a"));
		allElements.addAll(driver.findElements(By.tagName("img")));
	
		System.out.println("Total Links  ::"+allElements.size());
		
		List<WebElement> activeLinks=new ArrayList<WebElement>();
		for(int i=0;i<allElements.size();i++) {
			
			if(allElements.get(i).getAttribute("href")!=null) {
				activeLinks.add(allElements.get(i));
				System.out.println(allElements.get(i).getAttribute("href"));
			}
		}
	
		System.out.println("Total Valid active links  ::"+activeLinks.size());
		for(int j=0;j<activeLinks.size();j++) {
			URL url=new URL(activeLinks.get(j).getAttribute("href"));
			
			HttpURLConnection con=(HttpURLConnection) url.openConnection();
			
			con.connect();
			System.out.println(activeLinks.get(j).getAttribute("href")+"--->"+con.getResponseMessage());
			con.disconnect();
			
		}
	
		/*for(WebElement activeElement: activeLinks) {
			
			HttpURLConnection con=(HttpURLConnection) new URL(activeElement.getAttribute("href")).openConnection();
			
			con.connect();
			System.out.println(activeElement.getText()+"--->"+con.getResponseMessage());
			con.disconnect();
			
			
		}*/
	}

}
