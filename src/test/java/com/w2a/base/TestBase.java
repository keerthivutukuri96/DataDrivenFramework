package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

	/*
	 * WebDriver 
	 * Properties 
	 * logs 
	 * extent 
	 * reports 
	 * db 
	 * excel 
	 * mail
	 * 
	 */

	public WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	
	Date d = new Date();
	public static Logger log = Logger.getLogger(TestBase.class.getName());
	
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("current.date",d.toString().replace(":","_").replace(" ","_"));
		PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");
		  

		if (driver == null) {

			
			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			try {
				config.load(fis);
				log.info("Config file loaded");
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.error("OR file loaded");

			} catch (IOException e) {
				e.printStackTrace();
			}

			if (config.getProperty("browser").equals("firefox")) {
				driver = new FirefoxDriver();
			} else if (config.getProperty("browser").equals("chrome")) {
				driver = new ChromeDriver();
				log.debug("Chrome launched");

			} else if (config.getProperty("browser").equals("ie")) {
				driver = new InternetExplorerDriver();
			}
			
			driver.get(config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),TimeUnit.SECONDS);
			
		}
	}

	@AfterSuite
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
