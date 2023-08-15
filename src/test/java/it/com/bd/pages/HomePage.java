package it.com.bd.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;


import it.com.bd.drivers.PageDriver;
import it.com.bd.utilities.CommonMethods;
import it.com.bd.utilities.GetScreenShot;
import junit.framework.Assert;

public class HomePage extends CommonMethods{
	ExtentTest test;
	public HomePage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
	}
	
	@FindBys({
		@FindBy(css="#js--notification-btn-close > img")
	})
	WebElement closeOffer1;

	@FindBys({
		@FindBy(xpath="//body/div[@id='js--entry-popup']/div[1]/button[1]/i[1]")
	})
	WebElement closeOffer2;
	@FindBys({
		@FindBy(xpath="//a[@id='js--authors']")
	})
	WebElement  writer;
	
	@FindBys({
		@FindBy(xpath="//a[contains(text(),'হুমায়ূন আহমেদ')]")
	})
	WebElement  chooseWriter;
	
	public void signin() throws IOException {
		System.out.println("Method entered");
		Actions action = new Actions(PageDriver.getCurrentDriver());
		try{
			if(closeOffer1.isDisplayed()) {
				System.out.println("Close Offer1 clicked");
				closeOffer1.click();
				timeout(5000);
				//timeout();
			}
		}catch(Exception e){
			System.out.println(e);
		}

		try{

			if(closeOffer2.isDisplayed()) {
				System.out.println("Close Offer2 clicked");
				closeOffer2.click();
				timeout(5000);
				//timeout();
			}
		}catch(Exception e){
			System.out.println(e);
		}
		try{

			if(writer.isDisplayed()) {		
				
				action.moveToElement(writer).perform();	
				timeout();
				action.moveToElement(chooseWriter).perform();	
				//Thread.sleep(5000);
				timeout();
				System.out.println("Hover and click done");
				
				test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>You have successfully hovered writer.</b></p>");
				@SuppressWarnings("unused")
				String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "writer");
				String dest = System.getProperty("user.dir") + "\\screenshots\\" + "writer.png";
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			}
		}catch(Exception e){
			test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Writer is not locateable.Please check the error message.</b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "writerLocator");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "writerLocator.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			Assert.assertTrue(writer.isDisplayed());
			PageDriver.getCurrentDriver().quit();
		}
		
		try{
			if(writer.isDisplayed()) {
				System.out.println("Second condition");		
				chooseWriter.click();
				timeout();
				//timeout();
				
				test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>You have successfully chosen writer.</b></p>");
				@SuppressWarnings("unused")
				String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "chooseWriter");
				String dest = System.getProperty("user.dir") + "\\screenshots\\" + "chooseWriter.png";
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			}
		}catch(Exception e){
			test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>ChooseWriter is not locateable.Please check the error message.</b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "chooseWriterLocator");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "chooseWriterLocator.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			Assert.assertTrue(writer.isDisplayed());
			PageDriver.getCurrentDriver().quit();
		}
	}
}
