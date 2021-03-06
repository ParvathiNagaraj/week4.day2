package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentFrames {

	public static void main(String[] args) {

		// Setting up Browser property
		WebDriverManager.chromedriver().setup();

		// Launch Chrome Browser
		ChromeDriver driver = new ChromeDriver();

		// Load the URL
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");

		// Maximize web page
		driver.manage().window().maximize();

		// Implicit timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Switching Frame1
		driver.switchTo().frame("frame1");

		// Sending values to Topic tab
		driver.findElement(By.tagName("input")).sendKeys("Frames", Keys.ENTER);

		// swirching to frame3 from frame1
		driver.switchTo().frame("frame3");

		// clicking checkbox in frame3
		driver.findElement(By.id("a")).click();

		// switching back to webpage
		driver.switchTo().defaultContent();

		// switching to frame2
		driver.switchTo().frame("frame2");

		// accessing Animals dropdown in frame2
		WebElement element = driver.findElement(By.id("animals"));
		Select select = new Select(element);

		// selecting values from dropdown
		select.selectByVisibleText("Avatar");

		// switching back to webpage
		driver.switchTo().defaultContent();

	}

}
