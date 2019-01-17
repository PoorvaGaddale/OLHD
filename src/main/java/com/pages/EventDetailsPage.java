package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.common.BaseTest;
import com.common.WebTable;
import com.common.WebTable2;
import com.common.XLUtilities;

public class EventDetailsPage {
	
	@FindBy(xpath="//strong[text()='Event Information']")
	public WebElement eventInfo;
	
	@FindBy(xpath="(//span[@id='consignment-response'])[1]")
	public WebElement consignID;
	
	@FindBy(xpath="(//span[@id='consignment-response'])[2]")
	public WebElement consignResponse;
	
	@FindBy(xpath="//span[@id='consignment-pawb-number']")
	public WebElement consignPawbNo;
	
	@FindBy(xpath="//span[@id='consignment-origin']")
	public WebElement consignOrigin;
	
	@FindBy(xpath="//span[@id='consignment-event']")
	public WebElement consignEvent;
	
	@FindBy(xpath="//span[@id='consignment-event-date']")
	public WebElement consignEventDate;
	
	@FindBy(xpath="//span[@id='partner-origin-qualifier']")
	public WebElement partnerQualifier;
	
	@FindBy(xpath="//span[@id='partner-ID-origin-code']")
	public WebElement partnerIDCode;
	
	@FindBy(xpath="//span[@id='partner-ID-origin-name']")
	public WebElement partnerIDName;
	
	@FindBy(xpath="//span[@id='handover-location-code']")
	public WebElement handoverLocCode;
	
	@FindBy(xpath="//span[@id='handover-location-name']")
	public WebElement handoverLocName;
	
	@FindBy(xpath="(//a[contains(@class,'ng-binding')])[1]")
	public WebElement eventDescriptionFirst;
	
	@FindBy(xpath="(//a[contains(@class,'ng-binding')])[2]")
	public WebElement eventDescriptionSecond;
	
public WebElement resditTransport() {
		
		return BaseTest.driver.findElement(By.xpath("//section/h3[text()='Transport Information']/../table"));
	
	}
	
	
	//9 header
	
		public void verifyWebTableValues(WebElement element, String columnText,String columnText2,String columnText3,String columnText4,String columnText5,String columnText6,String columnText7,String columnText8,String columnText9,String rowText1,String rowText2,String rowText3,String rowText4,String rowText5,String rowText6, String rowText7, String rowText8, String rowText9 ) {
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
			int headindex8 = wt2.getheaderindex(columnText8);
			int headindex9 = wt2.getheaderindex(columnText9);
		
			String row1 = wt2.getCellData(rowindex, headindex1);
			String row2 = wt2.getCellData(rowindex, headindex2);
			String row3 = wt2.getCellData(rowindex, headindex3);
			String row4 = wt2.getCellData(rowindex, headindex4);
			String row5 = wt2.getCellData(rowindex, headindex5);
			String row6 = wt2.getCellData(rowindex, headindex6);
			String row7 = wt2.getCellData(rowindex, headindex7);
			String row8 = wt2.getCellData(rowindex, headindex8);
			String row9 = wt2.getCellData(rowindex, headindex9);
	
			if(row1.equals(rowText1)) {
				System.out.println("entered first if"+rowText1);
				if((row2.equals(rowText2))&&(row3.equals(rowText3))&&(row4.equals(rowText4))&&(row5.equals(rowText5))&&(row6.equals(rowText6))&&(row7.equals(rowText7))&&(row8.equals(rowText8))&&(row9.equals(rowText9))){
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
	
	
	public EventDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	WebTable wt=new WebTable();
	XLUtilities ul=new XLUtilities();
	
	public void data() {
		//ul.getvalueFromxcell(sFileName, sSheetName, testCaseName, columnId);
	}

	
	
}
