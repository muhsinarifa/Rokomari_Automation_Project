package it.com.bd.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import it.com.bd.drivers.BaseDriver;
import it.com.bd.drivers.PageDriver;
import it.com.bd.pages.CartPage;

import java.io.IOException;

import org.testng.annotations.AfterClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import it.com.bd.utilities.ExtentFactory;


public class CartPageTest extends BaseDriver{
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	

	@BeforeClass
	public void openUrl() {
		PageDriver.getCurrentDriver().manage().window().maximize();
		//PageDriver.getCurrentDriver().get(url);

		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>CART PAGE TEST</b></p>").assignAuthor("QA TEAM").assignDevice("Windows");
	}
	@Test(priority=0)	
	public void cartPageTest() throws InterruptedException, IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Cart Page Test</b></p>");
		CartPage cartPage = new CartPage(childTest);
//		CartPage cartPage = new CartPage();
		cartPage.cartOrder();		
	}
	@AfterClass
	public void afterClass() {
		report.flush();
	}

}
