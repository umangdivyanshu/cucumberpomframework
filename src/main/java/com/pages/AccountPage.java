package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
	
	private WebDriver driver;
	private By accountSection = By.xpath(".//div[@id='center_column']//span");
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public int getAccountSectionCount() {
		return driver.findElements(accountSection).size();
	}
	
	public List<String> getAccountSectionItemList() {
		List<String> accountItemList = new ArrayList<>();
		List<WebElement> list = driver.findElements(accountSection); 
		
		for(WebElement elem : list) {
			String itemText = elem.getText();
			//System.out.println(itemText);
			accountItemList.add(itemText);
		
		}
		
		return accountItemList;
		
	}
	
	 public String getAccountPageTitle() {
		 return driver.getTitle();
	 }

}
