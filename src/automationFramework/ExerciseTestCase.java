package automationFramework;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;

public class ExerciseTestCase {
	public static void main(String[] args) throws InterruptedException {
		// Create a new instance of the Chrome driver
		System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
 
		// Put an Implicit wait, 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
		/******1. Launch Application******/
		//Launch the URL
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
	    System.out.println("1. Successfully opened the website www.amazon.com"+"\n");
		
		/******2. Select product by Departments -> Electronics, Computers & Office -> TV & Video******/
		//Action class object
		Actions actions = new Actions(driver);
		WebElement main = driver.findElement(By.xpath("//*[@id=\"nav-link-shopall\"]"));
		//Mouse the cursor focus to mouse element
		actions.moveToElement(main);
		
		actions.build().perform();
		//Verify the selected category is from Departments
	    System.out.println("2. Successfully select product from Departments");
	    Thread.sleep(3000);
	    
	    //Check Data
	    String title=driver.findElement(By.xpath("//*[@id=\"nav-link-shopall\"]/span[2]")).getText();
	  	System.out.println("title :::::"+title);
	  	String expectedResult="Departments";
		
	  	if(expectedResult.equalsIgnoreCase(title)) {
	  		System.out.println("Test case Pass :::"+title+"\n");
	  	}else {
	  		System.out.println("Test case Fail :::"+title+"\n");
	  	}
		
		//Mouseover on the Electronics, Computers & Office
	  	main = driver.findElement(By.xpath("//*[@id=\"nav-flyout-shopAll\"]/div[2]/span[10]/span"));
	  	//Mouse the cursor focus to mouse element
	  	actions.moveToElement(main);
	  	actions.build().perform();
	    System.out.println("Successfully select product from Electronics, Computers & Office");
	  	Thread.sleep(3000);
	  	
	  	//Check Data
	  	title=driver.findElement(By.xpath("//*[@id=\"nav-flyout-shopAll\"]/div[2]/span[10]/span")).getText();
	  	System.out.println("title :::::"+title);
	  	expectedResult="Electronics, Computers & Office";
	  	
	  	if(expectedResult.equalsIgnoreCase(title)) {
	  		System.out.println("Test case Pass :::"+title+"\n");
	  	}else {
	  		System.out.println("Test case Fail :::"+title+"\n");
	  	}
	  	
	  	//Mouse on the TV & Video
	  	main = driver.findElement(By.xpath("//*[@id=\"nav-flyout-shopAll\"]/div[3]/div[10]/div[1]/div/a[1]/span"));
	  	//Mouse the cursor focus to mouse element
	  	actions.moveToElement(main);
	  	actions.click().build().perform();
	    System.out.println("Successfully select product from TV & Video");
	  	Thread.sleep(3000);
	  	
	  	//Check Data
	  	title=driver.findElement(By.xpath("//*[@id=\"top\"]/div[2]/div[1]/div/h1")).getText();
	  	System.out.println("title :::::"+title);
	  	expectedResult="Television & Video";
	  	
	  	if(expectedResult.equalsIgnoreCase(title)) {
	  		System.out.println("Test case Pass :::"+title+"\n");
	  	}else {
	  		System.out.println("Test case Fail :::"+title+"\n");
	  	}
	  	
	  	/******3. Select the Televisions under 32 inches from right side refinery.******/
	  	//Mouse on the 32 inches and Under
	  	main = driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[4]/div/div[2]/div/div[1]/div[1]/ul[3]/li[1]"));
	  	//Mouse the cursor focus to mouse element
	  	actions.moveToElement(main);
	  	actions.click().build().perform();
	    System.out.println("3. Successfully select product from Screen Size 32 Inches & Under");
	  	Thread.sleep(3000);
	  	
	  	//Check Data
	  	title=driver.findElement(By.xpath("//*[@id=\"s-result-count\"]/span/span")).getText();
	  	System.out.println("title :::::"+title);
	  	expectedResult="32 Inches & Under";
	  	
	  	if(expectedResult.equalsIgnoreCase(title)) {
	  		System.out.println("Test case Pass :::"+title+"\n");
	  	}else {
	  		System.out.println("Test case Fail :::"+title+"\n");
	  	}
	  	
	  	/******4. Sort by the given option on price. Options for sorting by price -(low to high or high to low).******/
	  	//Filter Price from Low to High
		main = driver.findElement(By.id("sort"));
	  	//Mouse the cursor focus to mouse element
	  	actions.moveToElement(main);
	  	actions.click().build().perform();
	    System.out.println("4. Successfully sorting the product from High to Low"+"\n");
	  	
	  	Select oSelect = new Select(driver.findElement(By.id("sort")));
	  	Thread.sleep(2000);
		// Select option 'High to Low' (Use selectByIndex)
		oSelect.selectByVisibleText("Price: High to Low");
		Thread.sleep(3000);
		
		/******5. Return Product Whose price less than $150 and Model Year is 2017******/
		//List Array Model Year is 2017
		//Mouse on the 32 inches and Under
	  	main = driver.findElement(By.xpath("//*[@id=\"leftNavContainer\"]/ul[6]/div/li[2]/span/span/div/label/span/span"));
	  	//Mouse the cursor focus to mouse element
	  	actions.moveToElement(main);
	  	actions.click().build().perform();
	    System.out.println("Successfully select product from Model Year is 2017");
	  	Thread.sleep(3000);
	  	
		//Input the Maximum Price
		main = driver.findElement(By.xpath("//*[@id=\"high-price\"]"));
	  	actions.moveToElement(main);
	  	actions.build().perform();
		driver.findElement(By.cssSelector("#high-price")).sendKeys("150");
		//click on Go button
		driver.findElement(By.cssSelector("#leftNavContainer > ul:nth-child(9) > div > li:nth-child(3) > span > form > span.a-button.a-spacing-top-mini.s-small-margin-left > span > input")).click();
	    System.out.println("5. Successfully sorting the product by input the maximum price"+"\n");
	    Thread.sleep(2000);
	    
		/******6. Click on the product link for the first product in search result and go to the product page******/
		//select item product
		main = driver.findElement(By.xpath("//*[@id=\"result_0\"]/div/div[2]/div[2]/div[1]/a/h2"));
		actions.moveToElement(main);
	  	actions.click().build().perform();
	  	System.out.println("6. Successfully click on product for the first product in search result and go to the product page"+"\n");
	  	Thread.sleep(3000);
	  	
	  	/******7. Click on 'Add to list'.******/
	  	//add to list
	  	main = driver.findElement(By.xpath("//*[@id=\"add-to-wishlist-button-submit\"]"));
		actions.moveToElement(main);
	  	actions.click().build().perform();
	 	System.out.println("7. Successfully click on product for the first product in search result and go to the product page"+"\n");
	 	Thread.sleep(3000);
	 	
	 	/*****8. Verify if the Sign In page is showing up. (Since user isn't logged in yet).*****/
	 	//Verify the Sign page is showing up
	 	driver.findElement(By.cssSelector("#authportal-main-section > div:nth-child(2) > div > div.a-section > form > div > div > div > h1"));
	 	System.out.println("8. Successfully go to Sign In page/ Sign In page is showing Up"+"\n");
	 	Thread.sleep(3000);
	 	
	 	/******9. Enter some random Username and Submit******/
	 	//sign in
		main = driver.findElement(By.cssSelector("#ap_email"));
	  	actions.moveToElement(main);
	  	actions.build().perform();
		driver.findElement(By.cssSelector("#ap_email")).sendKeys("annisa rahmawati");
		//click on Go button
		driver.findElement(By.cssSelector("#continue")).click();
	    System.out.println("9. Successfully input random username and click Submit button"+"\n");
	    Thread.sleep(2000);
	  	
	    /******10. Kill the browser******/
		// Kill the browser
		driver.quit();
		System.out.println("10. Successfully kill the browser");
		
	}
}