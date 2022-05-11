package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentWindow {

	public static void main(String[] args) {

		// Setting up Browser property
		WebDriverManager.chromedriver().setup();

		// Launch Chrome Browser
		ChromeDriver driver = new ChromeDriver();

		// Load the URL
		driver.get("http://leafground.com/pages/Window.html");

		// Maximize web page
		driver.manage().window().maximize();

		// Implicit timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		System.out.println("Clicking Home Button");
		System.out.println("=========================================================");

		// Clicking on Home button
		driver.findElement(By.id("home")).click();

		// Assigning new windowsHandles and switching to new window
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		String newwindowHandles = list.get(1);
		driver.switchTo().window(newwindowHandles);

		// Closing new window
		driver.close();

		System.out.println("=========================================================");
		System.out.println("Clicking Open Multiple Windows Button");
		System.out.println("=========================================================");

		// Switching control back to base window
		driver.switchTo().window(list.get(0));

		// Clicking Open Multiple Windows button
		driver.findElement(By.xpath("//button[contains(text(),'Open Multiple Windows')]")).click();

		// Assigning new windowsHandles
		String parent = driver.getWindowHandle();
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> list1 = new ArrayList<String>(windowHandles2);
		System.out.println("The Number of Opened Windows " + list1.size());

		for (int i = 0; i < list1.size(); i++) {

			String newwindowHandles1 = list1.get(i);

			if (!parent.equals(newwindowHandles1)) {

				driver.switchTo().window(newwindowHandles1);
				System.out.println("The title of the page is " + driver.getTitle());
				driver.close();
			}

			else {

				System.out.println("The tilte of the page is " + driver.getTitle());

			}

		}

		// Switching control to base window
		driver.switchTo().window(parent);

		System.out.println("=========================================================");
		System.out.println("Clicking Do not close me button");
		System.out.println("=========================================================");

		// Clicking Do not close me button
		driver.findElement(By.xpath("//button[contains(text(),'Do not close me')]")).click();

		// Assigning new windowsHandles
		Set<String> windowHandles3 = driver.getWindowHandles();
		List<String> list2 = new ArrayList<String>(windowHandles3);

		for (int i = 0; i < list2.size(); i++) {

			String newwindowHandles2 = list2.get(i);

			if (!parent.equals(newwindowHandles2)) {

				driver.switchTo().window(newwindowHandles2);
				driver.close();
			}

			else {

				System.out.println("The title of the page is " + driver.getTitle());

			}

		}

		// Switching control to base window
		driver.switchTo().window(parent);

		System.out.println("=========================================================");
		System.out.println("Clicking Wait for 5 Seconds Button");
		System.out.println("=========================================================");

		// Clicking wait for 5 seconds button
		driver.findElement(By.xpath("//button[contains(text(),'Wait for 5 seconds')]")).click();

		// Assigning new windowsHandles
		Set<String> windowHandles4 = driver.getWindowHandles();
		List<String> list3 = new ArrayList<String>(windowHandles4);

		for (int i = 0; i < list3.size(); i++) {

			String newwindowHandles3 = list3.get(i);

			if (!parent.equals(newwindowHandles3)) {

				driver.switchTo().window(newwindowHandles3);
				driver.close();
			}

			else {

				System.out.println("The title of the page is " + driver.getTitle());

			}

		}

		// Switching control to base window
		driver.switchTo().window(parent);

	}
}
