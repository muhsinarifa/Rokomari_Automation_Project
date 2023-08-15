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

public class BookSelectionPage extends CommonMethods {
	ExtentTest test;
	public BookSelectionPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test=test;
	}
	
//	public String addtocartFirstItemJs = "document.querySelector(\"div.books-wrapper__item:nth-child(1) div.book-list-wrapper > a:nth-child(1)\")";
	
	 @FindBys({
		 @FindBy(xpath="//*[@id='cart-icon']")
	 })
	 WebElement cart;
	 
	 @FindBys({
		 @FindBy(xpath="//body[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/a[2]/span[1]")
	 })
	 WebElement placeOrder;
	 
	 
	public String addtocartItemJs = "document.querySelectorAll(\".btn.cart-btn.js--add-to-cart\")[3]";
    public void cart() throws IOException {
	System.out.println("Cart entered");
	
	JavascriptExecutor js = (JavascriptExecutor) (PageDriver.getCurrentDriver());
	try{
		    System.out.println("Before book page scroll done");
		    js.executeScript("window.scrollBy(0,500)");
		    //Thread.sleep(3000);
		    timeout();			    
			System.out.println("After books page scroll done");
		
	}catch(Exception e){
		System.out.println(e);
	}
	try {
		js.executeScript(addtocartItemJs + ".click();");
		timeout();
		System.out.println("added to cart");
	}
	catch(Exception e) {
		System.out.println(e);
	}
	
	 try {
		 cart.click();
		 timeout();
		 
			test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>You have successfully clicked to cart.</b></p>");
			@SuppressWarnings("unused")
			String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "cart");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "cart.png";
			test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
	 }catch(Exception e) {
			test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Cart is not locateable.Please check the error message.</b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "cartLocator");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "cartLocator.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			Assert.assertTrue(cart.isDisplayed());
			PageDriver.getCurrentDriver().quit();
			
		 System.out.println(e);
	 }
	 
	 try {
		 placeOrder.click();
		 timeout();
		 
			test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>You have successfully clicked place order.</b></p>");
			@SuppressWarnings("unused")
			String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "placeOrder");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "placeOrder.png";
			test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
	 }catch(Exception e) {
			test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>PlaceOrder is not locateable.Please check the error message.</b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "placeOrder");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "placeOrderLocator.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			Assert.assertTrue(placeOrder.isDisplayed());
			PageDriver.getCurrentDriver().quit();
		 
		 System.out.println(e);
	 }
    }
}