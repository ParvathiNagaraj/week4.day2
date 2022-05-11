package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {

		// Setting up Browser property
		WebDriverManager.chromedriver().setup();

		// Launch Chrome Browser
		ChromeDriver driver = new ChromeDriver();

		// Load the URL
		driver.get("http://leaftaps.com/opentaps/control/login");

		// Maximize web page
		driver.manage().window().maximize();

		// Implicit timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// locating username by id locator and sending keys
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");

		// locating password by id locator and sending keys
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// locating submit using classname and login
		driver.findElement(By.className("decorativeSubmit")).click();

		// clicking on CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();

		// clicking on Contacts link
		driver.findElement(By.linkText("Contacts")).click();

		// clicking on Merge Contact Link using xpath
		driver.findElement(By.xpath("//a[contains(text(),'Merge Contacts')]")).click();

		// Clicking on From Contact widget
		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[1]")).click();

		// Assigning new windowsHandles and switching to new window
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		String newwindowHandles = list.get(1);
		driver.switchTo().window(newwindowHandles);

		// Clicking first Resulting contact
		driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();

		// giving control back to base window
		driver.switchTo().window(list.get(0));

		// Clicking on To Contact widget
		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();

		// Assigning new windowsHandles and switching to new window

		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> list1 = new ArrayList<String>(windowHandles1);
		String newwindowHandles1 = list1.get(1);
		driver.switchTo().window(newwindowHandles1);

		// Clicking first Resulting contact
		driver.findElement(By.xpath("(//a[@class='linktext'])[6]")).click();

		// giving control back to base window
		driver.switchTo().window(list1.get(0));

		// Clicking on Merge button
		driver.findElement(By.xpath("//a[text()='Merge']")).click();

		// Switching to alert
		Alert alert = driver.switchTo().alert();

		// Accepting Alert
		alert.accept();

		// Viewing title of the page
		System.out.println("The Title of the Page is " + driver.getTitle());
	}

}
