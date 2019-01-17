package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.common.BaseTest;
import com.common.IConstantValues;
import com.common.Lib;
import com.common.WebTable2;

public class SearchConsignmentPage implements IConstantValues{
	
	@FindBy(xpath="//a[@href='#!/searchConsign']")
	public WebElement searchConsignment;

    @FindBy(xpath="//input[@id='input-search']")
    public WebElement consignmentNumber;
    
    @FindBy(xpath="//button[@id='find-btn']")
    public WebElement findItem;
    
    @FindBy(xpath="//strong[contains(text(),'Active Search')]")
    public WebElement activeSearch;
    
    @FindBy(xpath="//span[@ng-bind='errorMsg']")
    public WebElement errorMsg;
    
  
    
    @FindBy(xpath="//span[@id='Carrier']/div/div/div/button")
    public WebElement activeCarrier;
    
    @FindBy(xpath="//section/label[text()='Carrier']/following-sibling::span/div/div/ul/li/a[contains(text(),'Select All')]")
    public WebElement activeCarrierdropdown;
    
    @FindBy(xpath="//span[@id='Status']/div/div/div/button")
    public WebElement activeStatus;
    
    @FindBy(xpath="//span[@id='Status']/div/div/ul/li/a[contains(text(),'Select All')]")
    public WebElement activeStatusdropdown;
    
    @FindBy(xpath="//span[@id='DestinationAirport']/div/div/div/button")
    public WebElement activeDO;
    
    @FindBy(xpath="//span[@id='DestinationAirport']/div/div/ul/li/a[contains(text(),'Select All')]")
    public WebElement activeDOdropdown;
    
    @FindBy(xpath="(//span/button[@id='Search'])[1]")
	public WebElement activeSearchbtn;
    
    @FindBy(xpath="//span[@id='CreatedStart']//input")
	public WebElement createdStart;
    
    @FindBy(xpath="//span[@id='CreatedEnd']//input")
  	public WebElement createdEnd;
    
    @FindBy(xpath=" //table[@class='ui-datepicker-calendar']/tbody/tr/td/a[text()='1']")
  	public WebElement nov1st;
    
    @FindBy(xpath=" //table[@class='ui-datepicker-calendar']/tbody/tr/td/a[text()='7']")
  	public WebElement nov7th;
    
    
    WebTable2 wt2;
    
    public WebElement activeSearchResults() {
		return BaseTest.driver.findElement(By.xpath("//section/h3/*[text()='Active search']/../following-sibling::table"));
	}
    
      public SearchConsignmentPage(WebDriver driver){
            //This initElements method will create all WebElements
            PageFactory.initElements(driver, this);
        }
      
      public String getActiveSearchText() {
 		 return activeSearch.getText();
 		  
 	 }
      
      public void navigateToSearchConsignment() {
                      searchConsignment.click();
      }
      
      public void enterConsignmentNumber(int k, int j) {
    	  String consignNo = Lib.getCellValue(EXCEL_PATH,"consignmentnumber",k,j);
    	  consignmentNumber.sendKeys(consignNo);
      }
      
      public void clickFindItem() {
                      findItem.click();
      }
      public String errorMsgText() {
          String text = errorMsg.getText();
          return text;
}
      public int getActiveCount(WebElement element) {
    	  wt2=new WebTable2(element);
    	  
    	return  wt2.getRowCount();
      }
      
      public void getSpecificRowtext(WebElement element,String columnText) {
    	  
    	  wt2=new WebTable2(element);
    	  int rowsize=wt2.getrowCount(columnText);
    	  int headindex1 = wt2.getheaderindex(columnText);
    	 
    	  
    	  for (int i = 1; i <= rowsize; i++) {
    		  String cellData = wt2.getCellData(i, headindex1);
    		  System.out.println("cellData: "+cellData);
		}
    	  
    	  
      }
      
      
      /*@SuppressWarnings("finally")
	public boolean errorMsgdisplayed() {
    	  boolean displayed = false;
    	  try {
    		  displayed= errorMsg.isDisplayed();
    		  System.out.println("Due to the following error Test case failed: "+errorMsg.getText());
              
		}finally {
			 return displayed;  
			 
		}
    	  
    	  
}*/

}
