package com.w2a.listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.w2a.utilities.TestUtil;

public class CustomListeners implements ITestListener {
	
	public void onTestFailure(ITestResult result) {
		
		System.setProperty("org.uncommons.reportng.escape-output","false");
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Reporter.log("Capturing screenshot");
		 Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+">Screenshot</a>");
		 Reporter.log("<br");
		 
		 
		//Reporter.log("<a target=\"_blank\" href=\"C:\\Users\\User\\Desktop\\myscreenshot\\above.jpg\" height=200 width=200><img src=\"C:\\Users\\User\\Desktop\\myscreenshot\\above.jpg\"></img></a>");
		 
		 Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+"><img src="+TestUtil.screenshotName+" height=200 width=200></img></a>");
	}

}
