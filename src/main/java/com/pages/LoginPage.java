package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
		private WebDriver driver;
		
		//By locators
		private By emailId = By.id("email");
		private By password = By.id("passwd");
		private By signinButton = By.id("SubmitLogin");
		private By forgotPasswordLink = By.linkText("Forgot your password?");
		
		//constructor of the page class
		 public LoginPage(WebDriver driver) {
			 this.driver = driver;
		 }
		 
		 //page actions - features of the page in the form of methods
		 
		 public String getPageTitle() {
			 return driver.getTitle();
		 }
		 
		 public boolean isForgotPasswordLinkPresent() {
			 return driver.findElement(forgotPasswordLink).isDisplayed();
		 }
		 
		 public void enterUsername(String username) {
			 driver.findElement(emailId).sendKeys(username);
		 }
		 
		 public void enterPassword(String pwd) {
			 driver.findElement(password).sendKeys(pwd);
		 }
		
		 public void clickLoginButton() {
			 driver.findElement(signinButton).click();
		 }
		 
		 public AccountPage doLogin(String username, String pwd) {
			 driver.findElement(emailId).sendKeys(username);
			 driver.findElement(password).sendKeys(pwd);
			 driver.findElement(signinButton).click();
			return new AccountPage(driver);
			 
			}

}
