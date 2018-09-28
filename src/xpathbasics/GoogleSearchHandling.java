package xpathbasics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class GoogleSearchHandling {

	private static WebDriver driver;
	private static String chromePath = "E:\\Program Files\\MyDriver\\chromedriver.exe";
	private static String URL = "https://www.google.com/";
	private static String searchedString = "Karan Cha";
	private static String IE = "E:\\Program Files\\MyDriver\\IEDriverServer.exe";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", chromePath);
		// System.setProperty("webdriver.ie.driver", IE);
		// driver = new InternetExplorerDriver();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		driver.get(URL);
		getGoogleSearchHandled();
		driver.findElement(By.xpath("//a[contains(text(),'Images for karan chaudhary')]")).click();
		WebElement t=driver.findElement(By.xpath("//img[@class='rg_ic rg_i' and @src='https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRQmmRjzoBvcWQduCcU0CVNIIgj7vNLp9wepT9HBzPu6HbVB7WecA']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(t);
		actions.perform();
		t.click();
		System.out.println("That's Me");
		Thread.sleep(500);
		driver.close();

	}

	public static void getGoogleSearchHandled() {
		String matchingString = "Karan Chaudhary";
		driver.findElement(By.xpath("//input[contains(@id,'lst-ib')]")).sendKeys(searchedString);

		List<WebElement> elementSet = driver
				.findElements(By.xpath("//ul[@class='sbsb_b']/li/descendant::div[@class='sbqs_c']"));

		for (int i = 0; i < elementSet.size(); i++) {

			String temp = elementSet.get(i).getText();
			System.out.println(temp);
			if (temp.equalsIgnoreCase(matchingString)) {

				elementSet.get(i).click();
				System.out.println(temp + "  found and clicked");
				break;
			}
		}

	}

}
