package SeptemberSessions;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandling3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "G:\\ArulPrasad Academy\\backup selenium and JDK\\New folder\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Window.html");
		
		String oldWindow = driver.getWindowHandle();
		
		WebElement firstButton = driver.findElement(By.id("home"));
		firstButton.click();
		
		
		Set<String> handles = driver.getWindowHandles();
		
		for (String iterates : handles) {
			
			driver.switchTo().window(iterates);
			
		}
		WebElement editbox = driver.findElement(By.xpath("//*[@id=\'post-153\']/div[2]/div/ul/li[1]/a"));
		editbox.click();
		driver.close();
		
		
		driver.switchTo().window(oldWindow);
		
		
	   //Set<String> obj = driver.getWindowHandles();
		
		WebElement openMultiple = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[2]/div/div/button"));
		
		openMultiple.click();
		Thread.sleep(3000);
		
		int size = driver.getWindowHandles().size();
	   
		System.out.println(size);
		
	
		
		
		
		WebElement dontCloseMe = driver.findElement(By.id("color"));
		dontCloseMe.click();
		
		Thread.sleep(3000);
		
		Set<String> allWindows = driver.getWindowHandles();
		
		for (String handles2 : allWindows) {
			
			if(!handles2.equals(oldWindow)) {
				
				driver.switchTo().window(handles2);
				
				driver.close();
			}
			
		}
		
		driver.quit();
		
		
	}

}
