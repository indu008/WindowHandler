package org.demo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WindowHandling1 {
	public static void main(String args[]) throws InterruptedException, AWTException   {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\BHASKAR REDDY\\eclipse-workspace\\Day8Task\\Driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(" https://www.amazon.com/");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("iphone x"); 
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click(); 
		WebElement iphone=driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-fixed-height'])[1]")); 
		Actions a=new Actions(driver);
		a.contextClick(iphone).perform();
		Robot r=new Robot();
        for(int i=0;i<1;i++) {
        	r.keyPress(KeyEvent.VK_DOWN);
        	r.keyRelease(KeyEvent.VK_DOWN);
        	
        }
        r.keyPress(KeyEvent.VK_ENTER);
    	r.keyRelease(KeyEvent.VK_ENTER);
    	String parId=driver.getWindowHandle();
    	System.out.println("Parent window Id:"+parId);
    	Set<String>allwindId=driver.getWindowHandles();
    	System.out.println("All window Id:"+allwindId);
    	for(String itr:allwindId) {
    		if(itr!=parId) {
    			driver.switchTo().window(itr);
    		}
    		
    	}
    	WebElement price=driver.findElement(By.xpath("//span[@id='productTitle']"));
    	String text=price.getText();
    	System.out.println(text);
    	WebElement price1=driver.findElement(By.xpath("(//span[text()='$329.00'])[6]"));
    	String text1=price1.getText();
    	System.out.println(text1);
    	driver.close();
}
}
