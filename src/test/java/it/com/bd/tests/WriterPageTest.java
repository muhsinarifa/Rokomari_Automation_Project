package it.com.bd.tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import it.com.bd.drivers.BaseDriver;
import it.com.bd.drivers.PageDriver;

import it.com.bd.pages.WriterPage;
import it.com.bd.utilities.ExtentFactory;

public class WriterPageTest extends BaseDriver{
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	@BeforeClass
	public void openUrl() {
		PageDriver.getCurrentDriver().manage().window().maximize();
		//PageDriver.getCurrentDriver().get(url);
		
		
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>WRITER PAGE TEST</b></p>").assignAuthor("QA TEAM").assignDevice("Windows");
	}
	@Test(priority=0)	
	public void writerPageTest() throws InterruptedException, IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Writer Page Test</b></p>");

		WriterPage writerPage = new WriterPage(childTest);
//		WriterPage writerPage = new WriterPage();

		writerPage.book();
	}
	@AfterClass
	public void afterClass() {
		report.flush();
	}
}
