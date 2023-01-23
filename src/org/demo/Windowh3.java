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

public class Windowh3 {
	public static void main(String args[]) throws InterruptedException, AWTException   {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\BHASKAR REDDY\\eclipse-workspace\\Day8Task\\Driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.homedepot.com/\r\n"
				+ " ");
		driver.findElement(By.xpath("//input[@class='SearchBox__input']")).sendKeys("ceiling fan"); 
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='headerSearchButton']")).click();
		driver.findElement(By.xpath("//img[@alt='Indoor Ceiling Fans with Lights']")).click();
		WebElement fan=driver.findElement(By.xpath("(//img[@alt='Black'])[1]"));
		Actions a=new Actions(driver);
		a.contextClick(fan).perform();
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
    	driver.findElement(By.xpath("(//a[@class='vis-nav__link'])[4]")).click();
}
}
