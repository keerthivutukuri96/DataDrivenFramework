package com.w2a.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class LoginTest extends TestBase {
	
	@Test
	public void loginAsBankManager() throws InterruptedException {
		 log.info("In login bank manager");
		 driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
		 log.debug("going to sleep");
		 Thread.sleep(3000);
		 log.debug("last message");
	}
	
	
	
}
