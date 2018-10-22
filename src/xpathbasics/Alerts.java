import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {


		static String URL = "http://www.seleniumeasy.com/test/javascript-alert-box-demo.html";
		static String ChromePath = "C:\\Users\\kxc212\\Desktop\\Equifax_GDS\\Softwares\\AutomationTesting\\chromedriver.exe";
		static WebDriver driver;

		public static void main(String[] args)  {

			Alert a1,a2,a3;
			System.setProperty("webdriver.chrome.driver", ChromePath);
			driver=new ChromeDriver();
			driver.get(URL);
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();

			driver.findElement(By.xpath("//button[@class='btn btn-default' and contains(text(),'Click me!')]")).click();
			a1=driver.switchTo().alert();
			System.out.println(a1.getText());
			a1.accept();
			System.out.println("Alert got accepted");
			
			
			driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg' and contains(text(),'Click me!')]")).click();
			a2=driver.switchTo().alert();
			System.out.println(a2.getText());
			a2.dismiss();
			System.out.println(driver.findElement(By.id("confirm-demo")).getText());
			
			driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg' and contains(text(),'Click for Prompt Box')]")).click();
			a3=driver.switchTo().alert();
			System.out.println(a3.getText());
			
			a3.sendKeys("Finally Alert got handled please take it as a feedback");
			a3.accept();
			System.out.println(driver.findElement(By.id("prompt-demo")).getText());
			
			driver.close();
	}

}
