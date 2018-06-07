package automationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestCase {

	public static void main(String[] args) {
		
		//Create a new instance of the Firefox driver
		System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
        //Launch the Online Store Website
		driver.get("http://www.store.demoqa.com");

        //Print a Log In message to the screen
        System.out.println("Successfully opened the website www.Store.Demoqa.com");
		
        // Close the driver
        driver.quit();
        
    }
}