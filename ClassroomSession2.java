package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassroomSession2 {
	
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
				
				//getting URL and Title of current Window
				System.out.println("The URL of Current Window is " + driver.getCurrentUrl());
				System.out.println("The Title of Current Window is " + driver.getTitle());
				
				//Clicking Home button
				driver.findElement(By.id("home")).click();
				
				//Navigating to home window
				Set<String> windowHandles = driver.getWindowHandles();
				List<String> windowList = new ArrayList<String>(windowHandles);
				String str = windowList.get(1);
				driver.switchTo().window(str);
				
				System.out.println("====================================================");
				
				//getting URL and Title of current Window
				System.out.println("The URL of Current Window is " + driver.getCurrentUrl());
				System.out.println("The Title of Current Window is " + driver.getTitle());
				
				//going back to main window
				driver.switchTo().window(windowList.get(0));
				
				System.out.println("====================================================");
				
				//getting URL and Title of current Window
				System.out.println("The URL of Current Window is " + driver.getCurrentUrl());
				System.out.println("The Title of Current Window is " + driver.getTitle());
				
				//Closing all Windows
				driver.quit();
	}

}
