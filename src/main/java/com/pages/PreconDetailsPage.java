package com.pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.common.BaseTest;
import com.common.WebTable2;

public class PreconDetailsPage extends BaseTest {

	@FindBy(xpath="//h3[text()='Transport Information']")
	public WebElement preconTransInfo;
	
	@FindBy(xpath="//span[@id='consignment-Number']")
	public WebElement preconConsignNo;
	
	@FindBy(xpath="//span[contains(@id,'ConsignmentCompletionDate')]")
	public WebElement preconConsignCompletionDate;
	
	@FindBy(xpath="//span[contains(@id,'consignment-Category')]")
	public WebElement preconConsignCategory;
	
	@FindBy(xpath="//td[contains(@ng-bind,'transportModeDesc')]")
	public WebElement transportModeDesc;
	
	@FindBy(xpath="//td[contains(@ng-bind,'conveyanceReferenceNo')]")
	public WebElement preconConveyanceReferenceNo;
	
	@FindBy(xpath="//td[contains(@ng-bind,'carrierCode')]")
	public WebElement preconCarrierCode;
	
	@FindBy(xpath="//td[contains(@ng-bind,'departureLocationCode')]")
	public WebElement preconDepartureLocationCode;
	
	@FindBy(xpath="//td[contains(@ng-bind,'arrivalLocationCode')]")
	public WebElement preconArrivalLocationCode;
	
	@FindBy(xpath="//td[contains(@ng-bind,'transportDepartureDateTime')]")
	public WebElement preconTransportDepartureDT;
	
	@FindBy(xpath="//td[contains(@ng-bind,'transportArrivalDateTime')]")
	public WebElement preconTransportArrivalDT;
	
	public WebElement preconTransInfo() {
		return BaseTest.driver.findElement(By.xpath("//section/h3[text()='Transport Information']/../table"));
	}
	
	public WebElement preconEventInfo() {
		return BaseTest.driver.findElement(By.xpath("//section/h3[text()='Event Information']/../table"));
	}
	
	 public WebElement Event(String Event2) throws EncryptedDocumentException, InvalidFormatException, IOException {
		 System.out.println("Event2:"+Event2);
		  WebElement element=driver.findElement(By.xpath("//tbody/tr/td/a[text()=' "+Event2+"']"));	
		  System.out.println("entered");
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  System.out.println("inside");
		  wait.until(ExpectedConditions.visibilityOf(element));
		  System.out.println("inside enter");
		  return element;
	 }
	//tbody/tr/td/a[text()=' PRECON(14)']
	
	//4 header
	public void verifyWebTableValues(WebElement element, String columnText,String columnText2,String columnText3,String columnText4, String rowText1,String rowText2,String rowText3,String rowText4) {
		boolean result = false;
		WebTable2 wt2=new WebTable2(element);
		
		int rowindex = wt2.getrowindex(columnText,rowText1);
		System.out.println(rowindex+"rowindex");
		int headindex1 = wt2.getheaderindex(columnText);
		//System.out.println(headindex1+"headindex1");
		int headindex2 = wt2.getheaderindex(columnText2);
		int headindex3 = wt2.getheaderindex(columnText3);
		int headindex4 = wt2.getheaderindex(columnText4);
		
		System.out.println(headindex1+" :headindex1");
		System.out.println(headindex2+" :headindex2");
		System.out.println(headindex3+" :headindex3");
		System.out.println(headindex4+" :headindex4");
		String row1 = wt2.getCellData(rowindex, headindex1);
		String row2 = wt2.getCellData(rowindex, headindex2);
		String row3 = wt2.getCellData(rowindex, headindex3);
		String row4 = wt2.getCellData(rowindex, headindex4);
		
		System.out.println(row1+" :row1");
		System.out.println(row2+" :row2");
		System.out.println(row3+" :row3");
		System.out.println(row4+" :row4");
		
		
		if(row1.equals(rowText1)) {
			System.out.println("entered first if"+rowText1);
			if((row2.equals(rowText2))&&(row3.equals(rowText3))&&(row4.equals(rowText4))){
				System.out.println(" working validated:"+rowText1);
				result=true;
			}
			else {
				System.out.println("not working properly:"+rowText1);
				//result=false;
			}
		}
		Assert.assertTrue(result);
		
	}
	
	//7 header
	
		public void verifyWebTableValues(WebElement element, String columnText,String columnText2,String columnText3,String columnText4,String columnText5,String columnText6,String columnText7, String rowText1,String rowText2,String rowText3,String rowText4,String rowText5,String rowText6,String rowText7 ) {
			boolean result = false;
			WebTable2 wt2=new WebTable2(element);
			
			int rowindex = wt2.getrowindex(columnText,rowText1);
			System.out.println(rowindex+"rowindex");
			int headindex1 = wt2.getheaderindex(columnText);
			//System.out.println(headindex1+"headindex1");
			int headindex2 = wt2.getheaderindex(columnText2);
			int headindex3 = wt2.getheaderindex(columnText3);
			int headindex4 = wt2.getheaderindex(columnText4);
			int headindex5 = wt2.getheaderindex(columnText5);
			int headindex6 = wt2.getheaderindex(columnText6);
			int headindex7 = wt2.getheaderindex(columnText7);
			System.out.println(headindex1+" :headindex1");
			System.out.println(headindex2+" :headindex2");
			System.out.println(headindex3+" :headindex3");
			System.out.println(headindex4+" :headindex4");
			String row1 = wt2.getCellData(rowindex, headindex1);
			String row2 = wt2.getCellData(rowindex, headindex2);
			String row3 = wt2.getCellData(rowindex, headindex3);
			String row4 = wt2.getCellData(rowindex, headindex4);
			String row5 = wt2.getCellData(rowindex, headindex5);
			String row6 = wt2.getCellData(rowindex, headindex6);
			String row7 = wt2.getCellData(rowindex, headindex7);
			System.out.println(row1+" :row1");
			System.out.println(row2+" :row2");
			System.out.println(row3+" :row3");
			System.out.println(row4+" :row4");
			System.out.println(row5+" :row5");
			System.out.println(row6+" :row6");
			System.out.println(row7+" :row7");
			
			if(row1.equals(rowText1)) {
				System.out.println("entered first if"+rowText1);
				if((row2.equals(rowText2))&&(row3.equals(rowText3))&&(row4.equals(rowText4))&&(row5.equals(rowText5))&&(row6.equals(rowText6))&&(row7.equals(rowText7))){
					System.out.println(" working validated:"+rowText1);
					result=true;
				}
				else {
					System.out.println("not working properly:"+rowText1);
					//result=false;
				}
			}
			Assert.assertTrue(result);
			
		}
	
	public PreconDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
}
