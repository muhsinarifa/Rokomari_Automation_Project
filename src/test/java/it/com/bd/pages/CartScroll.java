package it.com.bd.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
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

public class CartScroll extends CommonMethods{
	ExtentTest test;
	 public CartScroll(ExtentTest test) {
		 PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		 this.test=test;
	 }

	 @FindBys({
		 @FindBy(css="#shipping-payment > div > div > div.content__wrapper > form > div.content__wrapper--payment > div > div.card-body.pt-2 > div")
	 })
	 WebElement paymentDiv;
	 @FindBys({
		 @FindBy(xpath="//input[@id='COD']")
	 })
	 WebElement RKT;

	 @FindBys({
		 @FindBy(xpath="//body/div[@id='shipping-payment']/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[1]/div[5]/label[1]")
	 })
	 WebElement rocket;
	 
	 @FindBys({
		 @FindBy(xpath="//label[contains(text(),'এই শর্তগুলো মেনে অর্ডার প্রদান করছি।')]")
	 })
	 WebElement condition;
	 public void cs() throws IOException {
		 //JavascriptExecutor js = (JavascriptExecutor) (PageDriver.getCurrentDriver());
			try{
				if(paymentDiv.isDisplayed()) {
				 System.out.println("Before JS WORKED!");
				 JavascriptExecutor js = (JavascriptExecutor) (PageDriver.getCurrentDriver());
				// js.executeScript("window.scrollBy(0,2500)");
				 js.executeScript("arguments[0].scrollIntoView(true);", RKT);
				 timeout();
				 rocket.click();
				 System.out.println("JS WORKED!");
				 timeout();
				 
				 condition.click();
				 timeout();
				 
				 js.executeScript("window.scrollTo(0,0)");
				 timeout();
				 
					test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>You have scrolled to the last of page and checked out condition.</b></p>");
					@SuppressWarnings("unused")
					String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "condition");
					String dest = System.getProperty("user.dir") + "\\screenshots\\" + "condition.png";
					test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
				}
			}catch(Exception e){
				test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Condition is not locateable.Please check the error message.</b></p>");
				Throwable t = new InterruptedException("Exception");
				test.fail(t);
				@SuppressWarnings("unused")
				String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "conditionLocator");
				String dest = System.getProperty("user.dir") + "\\screenshots\\" + "conditionLocator.png";
				test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
				Assert.assertTrue(condition.isDisplayed());
				PageDriver.getCurrentDriver().quit();
				
				System.out.println(e);
			}
	 }
}
