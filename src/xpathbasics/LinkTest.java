package xpathbasics;

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

public class LinkTest {

	public static void main(String[] args) throws MalformedURLException, IOException {

		WebDriver driver;

		System.setProperty("webdriver.chrome.driver", "E:\\Program Files\\MyDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

		driver.get(
				"https://www.jagranjosh.com/current-affairs/current-affairs-recap-of-the-day-28-january-2016-1453988942-1");

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		allLinks.addAll(driver.findElements(By.tagName("img")));
		System.out.println("Total Links: " + allLinks.size());
		List<WebElement> activeLinks = new ArrayList<WebElement>();
		for (WebElement link : allLinks) {

			if((link.getAttribute("href") != null)&&(!link.getAttribute("href").contains("javascript"))) {
				activeLinks.add(link);
			}
		}

		System.out.println("Active Links Count:" + activeLinks.size());
		for (WebElement activeLink : activeLinks) {

			HttpURLConnection con = (HttpURLConnection) new URL(activeLink.getAttribute("href")).openConnection();
			con.connect();
			System.out.println(activeLink.getAttribute("href") + "--->" + con.getResponseMessage());
			con.disconnect();
		}

	}

}
