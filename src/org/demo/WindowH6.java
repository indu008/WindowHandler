package org.demo;

import java.awt.AWTException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowH6 {
	public static void main(String args[]) throws InterruptedException, AWTException   {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\BHASKAR REDDY\\eclipse-workspace\\Day8Task\\Driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://greenstech.in/selenium-course-content.html");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='heading304']")).click();
		WebElement s=driver.findElement(By.xpath("//a[text()=' JUNIT']"));
		Thread.sleep(1000);
		s.click();
		String parId=driver.getWindowHandle();
    	System.out.println("Parent window Id:"+parId);
    	Set<String>allwindId=driver.getWindowHandles();
    	System.out.println("All window Id:"+allwindId);
    	for(String itr:allwindId) {
    		if(itr!=parId) {
    			driver.switchTo().window(itr);
    		}
    		
    	}
       	WebElement s1=driver.findElement(By.xpath("//pre[@style='word-wrap: break-word; white-space: pre-wrap;']"));
    	String text=s1.getText();
    	System.out.println(text);
		System.out.println("end1");
}
}
