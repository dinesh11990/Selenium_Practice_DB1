package SeptemberSessions;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandling4 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "G:\\ArulPrasad Academy\\backup selenium and JDK\\New folder\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Window.html");
		
		String oldWindow = driver.getWindowHandle();
		
		WebElement firstButton = driver.findElement(By.id("home"));
		firstButton.click();
		
		
		////////////////////////////////
		
		Set<String>handles = driver.getWindowHandles();
		
		for (String newWindow : handles) {
			
			driver.switchTo().window(newWindow);
		}
		
		WebElement editbox = driver.findElement(By.xpath("//*[@id=\'post-153\']/div[2]/div/ul/li[1]/a"));
		editbox.click();
		driver.close();
		driver.switchTo().window(oldWindow);
		
		
		WebElement openMultiple = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[2]/div/div/button"));
		openMultiple.click();
		Thread.sleep(3000);
		int NoOfWindows = driver.getWindowHandles().size();
		System.out.println(+NoOfWindows);
		
		WebElement dontCloseMe = driver.findElement(By.id("color"));
		dontCloseMe.click();
		Thread.sleep(3000);
		Set<String> newWindowHandles = driver.getWindowHandles();
		
		for (String allWindows : newWindowHandles) {
			
			if(!allWindows.equals(oldWindow)) {
				
				driver.switchTo().window(allWindows);
				driver.close();
			}
			
		}
		driver.quit();
		
		
		
		
		
		
	}

}
