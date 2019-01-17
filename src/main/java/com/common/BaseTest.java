package com.common;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.common.IConstantValues;

public class BaseTest implements IConstantValues{
	static {
		System.setProperty(CHROME_KEY, CHROME_VALUE);
	}
	public static WebDriver driver;
	
	@SuppressWarnings("deprecation")
	@BeforeTest
	@Parameters({"browser"})
public static WebDriver setup(String browser) throws Exception{
		String ITO=Lib.getProperty(CONFIG_PATH, "ImplicitTimeOut");
		int timeoutPeriod=Integer.parseInt(ITO);
		if (browser.equalsIgnoreCase("chrome")){
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(timeoutPeriod, TimeUnit.SECONDS);
		}else if(browser.equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();
			}else if(browser.equalsIgnoreCase("IE")){
			DesiredCapabilities capabilities = DesiredCapabilities
					.internetExplorer();
			capabilities
			.setCapability(
					InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
					true);
			capabilities.setCapability("requireWindowFocus", true);
			driver = new InternetExplorerDriver(capabilities);
		}
		return driver;
		}
	
	public static void openURL() throws Exception {
		String url=Lib.getProperty(CONFIG_PATH, "URL");
		driver.get(url);
	}
	public static void openURLCN(String text) throws Exception {
		String url=Lib.getProperty(CONFIG_PATH, "URL");
		driver.get(url+"/consignments/"+text);
		System.out.println("url launched");
	}
	public static WebDriver driver() {
		return driver;
	}
	public void takeScreeshot(String testname){
		Date d=new Date();
		String currentdate = d.toString().replaceAll(":", "_");
		TakesScreenshot ts=(TakesScreenshot)driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		
		File destFile=new File(".\\screenshots\\"+currentdate+"\\"+testname+"_screenshot.png");
		
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void tofindWindow(WebElement element) throws Exception  {
		String Parentwindow = driver.getWindowHandle();
		System.out.println(Parentwindow+"Parentwindow");
		Set<String> allWh = driver.getWindowHandles();
		int size = allWh.size();
		System.out.println(allWh.size()+": windows before if");
		while(size<2) {
			System.out.println("ented while loop");
				//toSwitchTab();
				System.out.println("ented toSwitchTab loop");		
		}
		
		for (String wh : allWh) {
			System.out.println(wh+":wh is");
			if(!wh.equals(Parentwindow)) {
				System.out.println(wh+"child browser");
				driver.switchTo().window(wh);
				break;
			}
		}
		
	}
	public void toSwitchTab(int tabs) throws Exception  {
		Robot robot;
		try {
			for (int i = 0; i < tabs; i++) {
				
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_TAB);
	        robot.keyRelease(KeyEvent.VK_TAB);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
			}
			String Parentwindow = driver.getWindowHandle();
			System.out.println(Parentwindow+"Parentwindow");
			Set<String> allWh = driver.getWindowHandles();
			int size = allWh.size();
			System.out.println(allWh.size()+": windows before if");
			
			System.out.println(allWh.size()+": windows after if");
			for (String wh : allWh) {
				System.out.println(wh+":wh is");
				if(!wh.equals(Parentwindow)) {
					System.out.println(wh+"child browser");
					driver.switchTo().window(wh);
					break;
				}
	            System.out.println("ParentWindow="+wh);
	            
	            System.out.println("Child="+driver.getCurrentUrl());
	}
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	@AfterTest
	public void closeApplication()  {
		driver.quit();
	}
}
