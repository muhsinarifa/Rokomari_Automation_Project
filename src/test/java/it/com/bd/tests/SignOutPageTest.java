package it.com.bd.tests;

import org.testng.annotations.Test;

import it.com.bd.drivers.BaseDriver;
import it.com.bd.drivers.PageDriver;
import it.com.bd.pages.SignOutPage;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import it.com.bd.utilities.ExtentFactory;

public class SignOutPageTest extends BaseDriver{
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	@BeforeClass
	public void OpenUrl() {
		PageDriver.getCurrentDriver().manage().window().maximize();
		
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>SIGNOUT PAGE TEST</b></p>").assignAuthor("QA TEAM").assignDevice("Windows");
	}
	@Test(priority=0)	
	public void signOutPageTest() throws InterruptedException, IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Sign Out Page Test</b></p>");
		SignOutPage signOutPage = new SignOutPage(childTest);
//		SignOutPage signOutPage = new SignOutPage();

		signOutPage.signOut();
	}
	@AfterClass
	public void afterClass() {
		report.flush();
	}
}
