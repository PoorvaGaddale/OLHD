package com.common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
public class CommonFunctions extends BaseTest {
	
	//This method is to scroll down to bottom
	public void scrollDown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) BaseTest.driver();;
		int x = element.getLocation().getX();
		int y = element.getLocation().getY();
		System.out.println("X"+x+"Y"+y);
		js.executeScript("window.scrollBy("+x+","+y+")");
		System.out.println("Scroll is working");
		
	}
	
	// This method verify whether the element is present or not
	public boolean verifyElement_IsDisplayed(WebElement element, String elementTitle){
		System.out.println("Verify element -" + elementTitle + " - is displaying.");
		boolean is_displayed = element.isDisplayed();
		return is_displayed;		
	}
	
	// This method verify whether the element is enabled or not
	public boolean verifyelement_IsEnabled(WebElement element, String elementTitle){
		System.out.println("Verify element - " + elementTitle + " - is enabled.");
		boolean is_enabled = element.isEnabled();
		return is_enabled;		
	}
	
	public boolean verifyElement_IsChecked(WebElement element, String elementTitle){
		System.out.println("Verify element -" + elementTitle + " - is Checked.");
		boolean is_selected = element.isSelected();
		return is_selected;		
	}
	
	public void verifyElement_IsPresent(WebElement element, String elementTitle) throws Exception{
		
		System.out.println("Verify element - " + elementTitle + " - is Present.");		
		if(element != null){
			System.out.println(elementTitle + " - Element is Present");
		}else{
			Assert.fail(elementTitle + " - Element is NOT Present");
		}
	}
	public void verifyElement_text(WebElement element, String expectedText,String elemetTittle) throws Exception{
		String text = null;
	try {
		text = element.getText();
		
	}catch(Exception e) {
		
	}finally {
		System.out.println("Verifying elemet text: "+elemetTittle);
		Assert.assertEquals(text, expectedText);
	}
	}
	public void verifyElement_NOTPresent(WebElement element, String elementTitle) throws Exception{
		
		System.out.println("Verify element - " + elementTitle + " - is NOT Present.");		
		/*if(element.isDisplayed()){
			//System.out.println("Element is Present, but it should be Absent: "+element.getText());
			//Assert.assertFalse(element.isDisplayed());
			Assert.fail("Element is Present, but it should be Absent: "+element.getText());
		}else{
			System.out.println(elementTitle + " - Element is NOT Present As Expected.");
			}*/
		boolean displayed = false;
  	  try {
  		  displayed= element.isDisplayed();
  		  System.out.println("Due to the following element Test case failed: "+element.getText());
            
		}catch(Exception e) {
			
		}finally {
			 Assert.assertFalse(displayed);
			 
		}
	}

	// This method get all option values from Dropdown
	public List<WebElement> get_AllOptions_FrmDrpDwn(WebElement element, String elementTitle){	
		System.out.println("Get All option from - " + elementTitle + " - Dropdown");
		
		Select select = new Select(element);
		List<WebElement> allOptions = select.getOptions();
		return allOptions;			
	}
	
	// This method get single selection value from Dropdown
	public String get_Single_Select_Option_frmDrpDwn (WebElement element, String elementTitle){
		System.out.println("Element -" + elementTitle + " - is displayed and Element attribute value is -" + element);
		
		Select selectSingleOption = new Select(element);
		String singleOption = selectSingleOption.getFirstSelectedOption().getText();
		
		System.out.println("Element -" + elementTitle + " - dropdown selected option is -" + singleOption);
		return singleOption;		
	}
	
	// This method Select single value from Dropdown using 'selectByIndex'
	public void selectByIndex_SingleOption_frmDrpDwn (WebElement element, int OptionIndexNo, String elementTitle){
		System.out.println("Element -" + elementTitle + " - dropdown is selecting value using Index - " + OptionIndexNo + " - & Element attribute value is -" + element);
		
		Select selectSingleOption = new Select(element);
		selectSingleOption.selectByIndex(OptionIndexNo);
		
		System.out.println("Element -" + elementTitle + " - dropdown, selected Index value is -" + OptionIndexNo);				
	}
	
	// This method Select single value from Dropdown using 'selectByValue'
	public void selectByValue_SingleOption_frmDrpDwn (WebElement element, String OptionValue, String elementTitle){
		System.out.println("Select value from -" + elementTitle + " - dropdown, using ByValue - " + OptionValue);
		
		Select selectSingleOption = new Select(element);
		selectSingleOption.selectByValue(OptionValue);
		
		System.out.println(elementTitle + " - dropdown, selected value -" + OptionValue);					
	}
		
		
	// This method Select single value from Dropdown using 'selectByVisibleText'
	public void selectByVisibleText_SingleOption_frmDrpDwn (WebElement element, String OptionVisibleText, String elementTitle){
		System.out.println("Select value from -" + elementTitle + " - dropdown, using visibleText - " + OptionVisibleText);
		
		Select selectSingleOption = new Select(element);
		selectSingleOption.selectByVisibleText(OptionVisibleText);
		
		System.out.println(elementTitle + " - dropdown, selected value -" + OptionVisibleText);					
	}
	
	public void sendKeys(WebElement element, String fieldValue, String elementTitle){
		System.out.println("Enter - " + elementTitle + " - as -" + fieldValue);
		
		if("input".equals(element.getTagName())){
			element.sendKeys(fieldValue);
		
		} else{
			new Actions(BaseTest.driver()).moveToElement(element).click().perform();
			element.sendKeys(fieldValue);
		}
	}
	
	public void click(WebElement element, String elementTitle){
			System.out.println("Click on - "+ elementTitle );	
			element.click();
	}
	
	public void clear(WebElement element, String elementTitle){
		System.out.println("Clear value from - " + elementTitle);
		element.clear();
	}
	
	public int getTable_RowCount(List<WebElement> element, String TableInfo) {
		int tableRows = element.size();
	    System.out.println(TableInfo + " - table Rows count is - " + tableRows);
		return tableRows;
	}
	
	public int getTable_ColumnCount(List<WebElement> element, String TableInfo) {
		
		int table_HeaderColumnCount = element.size();
	    System.out.println(TableInfo + " - table cloumn count is - " + table_HeaderColumnCount);
		return table_HeaderColumnCount;
	}
	
	
	public void doubleClick(WebElement element, String TableInfo) {		
		Actions action = new Actions(BaseTest.driver());
		action.doubleClick(element).perform();
	}
	
	public void getValueFrom_UL_DropDown (WebElement element, String sValueToBeSelect, String elementInfo){
		WebElement industries = element;
		List<WebElement> links = industries.findElements(By.tagName("li"));
		System.out.println("Size values - " + links.size());
		for (int i = 0; i < links.size(); i++)
		{
			System.out.println("Actual value - " + links.get(i).getText());
			System.out.println("Expected value - " + sValueToBeSelect);
			if (sValueToBeSelect.equalsIgnoreCase(links.get(i).getText())) {
				
				try {
					links.get(i).click();
					break;
	            } catch(StaleElementReferenceException e) {
	            }
				
			}
		}
	}
	
	public void hitEnter(WebElement element, String Desc) {		
		element.sendKeys(Keys.ENTER);
	}
	
		
}
