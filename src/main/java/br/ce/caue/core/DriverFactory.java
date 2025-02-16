package br.ce.caue.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	
	private static WebDriver driver;
	
	public DriverFactory() {}
	
	public static WebDriver getDriver() {

		if(driver == null) {
			driver = new ChromeDriver();
		driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

			
		}
		return driver;
	}
	
	public static void killDriver() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
	
}
	
	
