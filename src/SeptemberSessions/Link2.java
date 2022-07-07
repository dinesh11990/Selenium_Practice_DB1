package SeptemberSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Link2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","G:\\ArulPrasad Academy\\backup selenium and JDK\\New folder\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
	driver.navigate().to("http://www.leafground.com/pages/Link.html");
		
		WebElement homePageLink = driver.findElement(By.linkText("Go to Home Page"));
		homePageLink.click();
		
		driver.navigate().back();
		
		//2. Where to go ///Important ******************
		
		WebElement whereToGo = driver.findElement(By.partialLinkText("Find where"));
		String where =  whereToGo.getAttribute("href");
		System.out.println("This link is going to: " +where);
		
		WebElement brokenLink = driver.findElement(By.linkText("Verify am I broken?"));
		brokenLink.click();
		
		String title = driver.getTitle();
		
		if (title.contains("404")) {
			
			System.out.println("Link is broken");
		}
		driver.navigate().back();
			
			
			
		}

	}

