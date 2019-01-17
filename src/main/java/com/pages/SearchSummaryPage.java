package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.common.BaseTest;

public class SearchSummaryPage {
	
	@FindBy(xpath="//strong[contains(text(),'Create Summary Search')]")
	public WebElement summarySearch;
	
	@FindBy(xpath="//a[text()='Summary Search']")
	public WebElement searchSummary;
	
	
	@FindBy(xpath="//section/label[text()='Carrier']/following-sibling::span/div/div/div/button[@type='button']")
	public WebElement carrier;
	
	@FindBy(xpath="//section/label[text()='Destination DO']/following-sibling::span/div/div/div/button[@type='button']")
	public WebElement destinationDO;
	
	@FindBy(xpath="//section/label[text()='Destination DO']/following-sibling::span/div/div/ul/li/a[contains(text(),' Select All')]")
	public WebElement destinationDODropDown;
	
	@FindBy(xpath="//section/label[text()='Carrier']/following-sibling::span/div/div/ul/li/a[contains(text(),'Select All')]")
	public WebElement carrierDropDown;
	
	@FindBy(xpath="//button[text()='Search']")
	public WebElement searchButton;
	
	@FindBy(xpath="//button[text()='Detailed View']")
	public WebElement detailedView;
	
	@FindBy(xpath="//th[text()='SUMMARY DETAILS']")
	public WebElement summaryDetails;
	
	@FindBy(xpath="//span[@class='glyphicon glyphicon-arrow-left']")
	public WebElement backArrow;	
	
	@FindBy(xpath="//section[text()='TOTAL']/../following-sibling::section/section")
	public WebElement totalField;	
	
	
	 public SearchSummaryPage(WebDriver driver){
         //This initElements method will create all WebElements
         PageFactory.initElements(driver, this);
     }
	 
	 public void getsearchButton() {
		  new Actions(BaseTest.driver()).moveToElement(searchButton).click().perform();
		  
	 }

}
