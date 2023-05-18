package com.w2a.testcases;

import org.openqa.selenium.By;


import org.testng.Assert;

import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class BankManagerLoginTest extends TestBase {
	
	@Test
	public void loginAsBankManager() throws InterruptedException {
		
		System.setProperty("org.uncommons.reportng.escape-output","false");
		 log.info("In login bank manager");
		 driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
		 //driver.findElement(By.cssSelector(" div > div:last-child > .btn.btn-primary.btn-lg")).click();
		 Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustBtn"))),"Login Not Successfull");
		 Thread.sleep(3000);
		 log.debug("Login successfully executed");
		 
		 
		 
		 
	}
	
	
	
}
