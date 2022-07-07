 package SeptemberSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "G:\\ArulPrasad Academy\\backup selenium and JDK\\New folder\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		
		driver.switchTo().frame(0);
		WebElement button1=driver.findElement(By.id("Click")); 
		button1.click();
		
		String text = driver.findElement(By.id("Click")).getText();
		System.out.println(text);
		driver.switchTo().defaultContent();
		
		
		driver.switchTo().frame(1);
		
		driver.switchTo().frame("frame2");
		WebElement button2 = driver.findElement(By.id("Click1"));
		button2.click();
		
		String text2 = driver.findElement(By.id("Click1")).getText();
		System.out.println(text2);
		
		driver.switchTo().defaultContent();
		
		List<WebElement> totalFrame = driver.findElements(By.tagName("iframe"));
		int totalsize = totalFrame.size();
		System.out.println(totalsize);
		
		
		

		
		
	}

}
