package it.com.bd.utilities;

import it.com.bd.drivers.BaseDriver;

public class CommonMethods extends BaseDriver{
	public static void timeout() throws InterruptedException {
		Thread.sleep(3000);
	}
	
	public static void timeout(int time) throws InterruptedException {
		Thread.sleep(time);
	}
}
