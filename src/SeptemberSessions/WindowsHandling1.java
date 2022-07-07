package SeptemberSessions;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandling1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		
		String oldWindow = driver.getWindowHandle();
		
		WebElement firstButton = driver.findElement(By.id("home"));
		firstButton.click();
		
		Set<String> handles = driver.getWindowHandles();
		
		for (String newWindow : handles) {
			
			driver.switchTo().window(newWindow);
			
		}
		
		WebElement editbox = driver.findElement(By.xpath("//*[@id=\'post-153\']/div[2]/div/ul/li[1]/a"));
		editbox.click();
		
		driver.close();
		
		Thread.sleep(3000);
		
		driver.switchTo().window(oldWindow);
		
		WebElement openMultiple = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[2]/div/div/button"));
		
		openMultiple.click();
		
		int numberOfWindows = driver.getWindowHandles().size();
		System.out.println("No of windows opened:" + numberOfWindows);
		
		WebElement dontCloseMe = driver.findElement(By.id("color"));
		dontCloseMe.click();
		Thread.sleep(3000);
		
		Set<String> newWindowHandles = driver.getWindowHandles();
		
		for (String allwindows : newWindowHandles) {
			
				if (!allwindows.equals(oldWindow)) {
					
					driver.switchTo().window(allwindows);
					
					driver.close();
				}
		}
		

	}

}
