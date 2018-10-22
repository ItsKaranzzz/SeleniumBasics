import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BootStrapTesting {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\\\kxc212\\\\Desktop\\\\Equifax_GDS\\\\Softwares\\\\AutomationTesting\\\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("window-size=1400,800");
		option.addArguments("headless");
		driver = new ChromeDriver(option);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
		driver.get("https://www.jquery-az.com/jquery/demo.php?ex=152.0_1");
		// driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		WebElement dropdown = driver.findElement(By.id("btndropdown"));
		clearbootstrapDropdown(dropdown);
		bootstrapbuttonHandling(dropdown);
		SavebootstrapDropdown(dropdown);

		 driver.close();

	}

	public static void clearbootstrapDropdown(WebElement dropdown) {
		dropdown.click();
		driver.findElement(By.xpath(
				"//ul[@class='dropdown-menu' and @aria-labelledby='btndropdown']//button[contains(text(),'Clear')]"))
				.click();

	}

	public static void SavebootstrapDropdown(WebElement dropdown) {
		dropdown.click();
		driver.findElement(By.xpath(
				"//ul[@class='dropdown-menu' and @aria-labelledby='btndropdown']//button[contains(text(),'Save')]"))
				.click();

	}

	public static void bootstrapbuttonHandling(WebElement dropdown) throws InterruptedException {

		dropdown.click();
		List<WebElement> elementList = driver.findElements(By
				.xpath("//ul[@class='dropdown-menu' and @aria-labelledby='btndropdown']/li/label[@class='radio-btn']"));

		System.out.println("Size of List:" + (elementList.size()));
		for (int i = 0; i < elementList.size(); i++) {
			System.out.println("Element  " + elementList.get(i).getText() + "  Clicked");
			elementList.get(i).click();

		}

		driver.findElement(By.xpath(
				"//ul[@class='dropdown-menu' and @aria-labelledby='btndropdown']//button[contains(text(),'Save')]"))
				.click();

	}
}
