package it.com.bd.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseDriver {
	//browser initialization

	public static String url ="https://www.rokomari.com/book";
	public WebDriver driver = null;
	
	@BeforeSuite
	public void start() {
		String browser = System.getProperty("browser","chrome");
		
		if(browser.contains("chrome")) {

        	System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Downloads\\2nd Aug\\chromedriver-win64\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Users\\USER\\Downloads\\2nd Aug\\chrome-win64\\chrome.exe");
            
            options.addArguments("--user-data-dir=C:\\Users\\USER\\AppData\\Local\\Google\\Chrome for Testing\\User Data");

			driver = new ChromeDriver(options);
	        
		}
		else if(browser.contains("edge")){
			WebDriverManager.edgedriver().setup();
//			driver=new EdgeDriver();
			EdgeOptions options = new EdgeOptions();
			
	        options.addArguments("user-data-dir=C:\\Users\\muhsina.rifa\\AppData\\Local\\Microsoft\\Edge\\User Data");
	        driver = new EdgeDriver(options);
			
		}else {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		PageDriver.getInstance().setDriver(driver);
	}
	@AfterSuite
	public void close() {
		PageDriver.getCurrentDriver().quit();
	}

}


//body/div[7]/div[1]/div[1]/div[1]/section[1]

//body/div[7]/div[1]/div[1]/div[1]/section[1]