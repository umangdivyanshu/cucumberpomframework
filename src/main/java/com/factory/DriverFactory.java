package com.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
		public WebDriver driver;
		public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();	//using ThreadLocal for parallel execution
		
		/* This method is used to initialize the thread local driver on the basis of given browser
		 * @param browser
		 * @return this will return tldriver
		 */
		public WebDriver initDriver(String browser) {
			System.out.println("Browser value is - " + browser);
			
			if(browser.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				tlDriver.set(new ChromeDriver());
			}
			else if(browser.equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				tlDriver.set(new FirefoxDriver());
			}
			else if(browser.equals("safari")) {
				tlDriver.set(new SafariDriver());
			}
			else {
				System.out.println("Please select the correct browser value");
			}
			
			getDriver().manage().deleteAllCookies();
			getDriver().manage().window().maximize();
			return getDriver();
		}
		
		/*
		 * This is used to get the driver with Thread local
		 * @return
		 * Multiple threads will be running in parallel execution and they all will be calling this getDriver method
		 *  so all the thread should be in sync therefore, synchronized keyword is used
		 */
		
		public static synchronized WebDriver getDriver() {
			return tlDriver.get();
		}
}
