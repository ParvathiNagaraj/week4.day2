package week4.day2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassroomSession1 {

	public static void main(String[] args) {

		// Setting up Browser property
		WebDriverManager.chromedriver().setup();

		// Launch Chrome Browser
		ChromeDriver driver = new ChromeDriver();

		// Load the URL
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");

		// Maximize web page
		driver.manage().window().maximize();

		// Implicit timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Switch to Frame
		driver.switchTo().frame("iframeResult");

		// clicking Tryit button
		driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();

		// Switching to Alert
		Alert alert = driver.switchTo().alert();

		// sending keys to text box
		alert.sendKeys("Parvathi");

		// Clicking ok button
		alert.accept();

		// Verifying the text
		String text = driver.findElement(By.id("demo")).getText();

		if (text.contains("Parvathi")) {
			System.out.println("The text contains the word Parvathi");
		}

		else {
			System.out.println("The text doesn't contains word Parvathi");
		}

	}
}
