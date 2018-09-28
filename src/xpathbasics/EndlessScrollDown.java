package xpathbasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EndlessScrollDown {
	WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "E:\\\\Program Files\\\\MyDriver\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://infinite-scroll.com/");

		driver.manage().window().maximize();
		WebElement infinityscrollbutton = driver
				.findElement(By.xpath("//button[contains(text(),'Infinite scroll rest of site')]"));

		infinityscrollbutton.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.out.print(js.executeScript(
				"window.scrollTo(0,document.body.scrollHeight);var lenOfPage=document.body.scrollHeight; return lenOfPage;")
				.toString());

	}

}
