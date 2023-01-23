package org.demo;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowH5 {
	public static void main(String args[]) throws InterruptedException, AWTException   {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\BHASKAR REDDY\\eclipse-workspace\\Day8Task\\Driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.greenstechnologys.com/python-training.html");
}
}
