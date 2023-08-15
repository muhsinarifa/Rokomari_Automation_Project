package it.com.bd.pages;


import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import it.com.bd.drivers.PageDriver;
import it.com.bd.utilities.CommonMethods;
import it.com.bd.utilities.GetScreenShot;
import junit.framework.Assert;

public class CartPage extends CommonMethods{
	ExtentTest test;
 public CartPage(ExtentTest test) {
	 PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	 this.test=test;
 }
 
 @FindBys({
	 @FindBy(xpath="//body/div[@id='shipping-payment']/div[1]/div[1]")
 })
 WebElement shippingForm;
 
 
 @FindBys({
	 @FindBy(xpath="//body/div[@id='shipping-payment']/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[2]/fieldset[1]/input[1]")
 })
 WebElement name;
 
 @FindBys({
	 @FindBy(xpath="//select[@id='js--city']")
 })
 WebElement city;
 
 @FindBys({
	 @FindBy(xpath="//select[@id='js--area']")
 })
 WebElement area;
 
 @FindBys({
	 @FindBy(css="#address")
 })
 WebElement detailAddress;
 
 @FindBys({
	 @FindBy(css="#shipping-payment > div > div > div.content__wrapper > form > div.content__wrapper--payment > div > div.card-body.pt-2 > div")
 })
 WebElement paymentDiv;
 @FindBys({
	 @FindBy(xpath="//body/div[@id='shipping-payment']/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[1]/div[1]/label[1]")

 })
 WebElement cod;

 
 public void cartOrder() throws IOException {
	 
	 try {
		 if(shippingForm.isDisplayed()) {
	     name.sendKeys("Muhsina");
		 timeout();
		 
		 city.click();
		 timeout();
		 
		 Select selectCity = new Select(city);
		 selectCity.selectByIndex(1);
		 timeout();
		 
		 area.click();
		 timeout();
		 Select selectArea = new Select(area);
		 selectArea.selectByIndex(1);
		 timeout();

		 detailAddress.sendKeys("Building 15/A, 5th Floor\r\n"
		 		+ "Block F, Road 5\r\n"
		 		+ "Banani, Dhaka");
		 timeout();
		 
		 System.out.println("Form Filled Up!");
		 
			test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>You have successfully filled up form.</b></p>");
			@SuppressWarnings("unused")
			String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "detailAddress");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "detailAddress.png";
			test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		 }
 	}catch(Exception e) {
 		
		test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Detail Address is not locateable.Please check the error message.</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		@SuppressWarnings("unused")
		String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "detailAddressLocator");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + "detailAddressLocator.png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		Assert.assertTrue(detailAddress.isDisplayed());
		PageDriver.getCurrentDriver().quit();
 		System.out.println(e);
    }
	 
 }
}
