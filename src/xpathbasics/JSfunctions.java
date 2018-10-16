import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSfunctions {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\\\kxc212\\\\Desktop\\\\Equifax_GDS\\\\Softwares\\\\AutomationTesting\\\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
		driver.get("https://www.softwaretestingmaterial.com/javascriptexecutor-selenium-webdriver");
		driver.manage().window().maximize();

		System.out.println(getTitleUsingJS());
		System.out.println(getAllElementsfromPage());
		//refreshPage();

		//HighlightElement(driver.findElement(By.xpath("//button[contains(text(),'Subscribe')]")));
		//scrollDown();

		scrolltoElement(driver.findElement(By.xpath("//button[contains(text(),'Subscribe')]")));
		clickElementUsingJS(driver.findElement(By.xpath("//button[contains(text(),'Subscribe')]")));
		Thread.sleep(5000);
		driver.quit();

	}

	public static String getTitleUsingJS() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("return document.title").toString();

	}

	public static String getAllElementsfromPage() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("return document.documentElement.innerText;").toString();

	}

	public static void refreshPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(0)");
		System.out.println("Refreshed");
	}

	public static void HighlightElement(WebElement element) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'",element);
		Thread.sleep(1000);
	}
	
	public static void scrollDown() {
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public static void scrolltoElement(WebElement element) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	public static void clickElementUsingJS(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",element);
	}
}
