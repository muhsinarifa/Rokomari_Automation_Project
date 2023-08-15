package it.com.bd.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import it.com.bd.drivers.PageDriver;
import it.com.bd.utilities.CommonMethods;
import it.com.bd.utilities.GetScreenShot;
import junit.framework.Assert;

public class SignOutPage extends CommonMethods{
	ExtentTest test;
 public SignOutPage(ExtentTest test) {
	 PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	 this.test=test;
 }
 
 @FindBys({
	 @FindBy(xpath="//header/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[3]/a[1]/i[1]")
 })
 WebElement profile;
 
 @FindBys({
	 @FindBy(xpath="//a[contains(text(),'Sign Out')]")
 })
 WebElement signOut;

 public void signOut() throws IOException {
	 try {
		 profile.click();
		 timeout(2000);
		 signOut.click();
		 timeout();
		 
			test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>You have successfully signed out.</b></p>");
			@SuppressWarnings("unused")
			String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "signOut");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "signOut.png";
			test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		 System.out.println("Signout done");
	 }catch(Exception e) {
			test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>SignOut is not locateable.Please check the error message.</b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "signOutLocator");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "signOutLocator.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			Assert.assertTrue(signOut.isDisplayed());
			PageDriver.getCurrentDriver().quit();
	 }
 }
}
