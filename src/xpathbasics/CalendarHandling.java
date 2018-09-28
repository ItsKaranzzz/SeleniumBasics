package xpathbasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class CalendarHandling {

	private static WebDriver driver;
	private static String chromePath = "E:\\Program Files\\MyDriver\\chromedriver.exe";
	private static String URL = "http://www.seleniumeasy.com/test/";
	private static String date="12-01-18";
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", chromePath);
		// System.setProperty("webdriver.ie.driver", IE);
		// driver = new InternetExplorerDriver();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		driver.get(URL);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[starts-with(text(),'Date pickers') and @class='dropdown-toggle']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Bootstrap Date Picker') ]")).click();;
		
		driver.findElement(By.xpath("//div[@class='input-group date']/input[@type='text']")).click();
		try {
		CalendarHandlingWithGivenDate(date);
		}
		catch(ElementNotVisibleException e) {
			System.out.println("Please enter correct date");
		}
	
		
	}
	
	public static void CalendarHandlingWithGivenDate(String date) {
		
		try{
		
		date=date.trim();
		String dateArr[]=date.split("-");
		String day=dateArr[0];
		String month=dateArr[1];
		//String year=dateArr[2];
	
		int flag=0;
		
		int intmonth=Integer.parseInt(month);
		int intday=Integer.parseInt(day);
		if((intmonth==2)&&(intday>28)||(intday>31))
			{
			throw new Exception ("Please correct the date");
			
			}
		
		
		
		while(true) {
		int fetchedmonth=getMonth();
		System.out.println(fetchedmonth);
		System.out.println(intmonth);
		
		if(fetchedmonth>intmonth)
			driver.findElement(By.xpath("//div[@class='datepicker-days']/descendant::th[@class='prev']")).click();
			
		else if(fetchedmonth<intmonth)
			driver.findElement(By.xpath("//div[@class='datepicker-days']/descendant::th[@class='next']")).click();
		
		else if(fetchedmonth==intmonth)
			break;
		
		}
		String getday;
		
		
		String xpathbefore="//table[@class='table-condensed']/tbody/tr[";
		String xpathafter="]/td[";
		for(int i=1;i<=6;i++) {
			for(int j=1;j<=7;j++) {
				
				getday=driver.findElement(By.xpath(xpathbefore+i+xpathafter+j+"]")).getText();
				
				if(getday.equals(day)) {
					if(driver.findElement(By.xpath(xpathbefore+i+xpathafter+j+"]")).isEnabled()) {
					driver.findElement(By.xpath(xpathbefore+i+xpathafter+j+"]")).click();
					
					flag=1;
					break;
					}
				}
				}
				

			if(flag==1)
				break;
		}
		}
		catch(Exception e) {
			System.out.println("This Date can not be selected");
		}
		
	}
	public static int getMonth() {
		int f=0;
		String rmonth=driver.findElement(By.xpath("//div[@class='datepicker-days']/descendant::th[@class='datepicker-switch']")).getText();
		
		rmonth=rmonth.trim();
		String returnedmonthArr[]=rmonth.split(" ");
		if(returnedmonthArr[0].equalsIgnoreCase("January"))
			f=1;
		if(returnedmonthArr[0].equalsIgnoreCase("February"))
			f=2;
		if(returnedmonthArr[0].equalsIgnoreCase("March"))
			f=3;
		if(returnedmonthArr[0].equalsIgnoreCase("April"))
			f=4;
		if(returnedmonthArr[0].equalsIgnoreCase("May"))
			f=5;
		if(returnedmonthArr[0].equalsIgnoreCase("June"))
			f=6;
		if(returnedmonthArr[0].equalsIgnoreCase("July"))
			f=7;
		if(returnedmonthArr[0].equalsIgnoreCase("August"))
			f=8;
		if(returnedmonthArr[0].equalsIgnoreCase("September"))
			f=9;
		if(returnedmonthArr[0].equalsIgnoreCase("October"))
			f=10;
		if(returnedmonthArr[0].equalsIgnoreCase("November"))
			f=11;
		if(returnedmonthArr[0].equalsIgnoreCase("December"))
			f=12;
		
		return f;
	}

}
