package org.demo;

import java.awt.AWTException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowH8 {
	public static void main(String args[]) throws InterruptedException, AWTException   {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\BHASKAR REDDY\\eclipse-workspace\\Day8Task\\Driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
		
		driver.findElement(By.xpath("(//input[@autocomplete='off'])[2]")).sendKeys("hand sanitizer");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@class='searchTextSpan']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@class='product-image wooble'])[1]")).click();
		String parId=driver.getWindowHandle();
    	System.out.println("Parent window Id:"+parId);
    	Set<String>allwindId=driver.getWindowHandles();
    	System.out.println("All window Id:"+allwindId);
    	for(String itr:allwindId) {
    		if(itr!=parId) {
    			driver.switchTo().window(itr);
    		}
    		
    	}
    	driver.findElement(By.xpath("//div[@class='col-xs-6 marR15 btn btn-xl btn-theme-secondary rippleWhite buyLink']")).click();
		
}
}
