package com.pages;


import java.io.IOException;
import java.util.List;

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
import com.common.XLUtilities;

public class ConsignmentDetailsPage extends BaseTest {
	
	//WebDriver driver;
	
	@FindBy(xpath="//a[text()='Consignment Details']")
	public WebElement consignmentDetails;
	
	@FindBy(xpath="//h3[text()='Receptacle Information']")
	public WebElement receptacleInfo;
	

	@FindBy(xpath="//tbody/tr")
	public WebElement receptacleTableBody;
	
	
	public WebElement receptacleInfo() {
		return BaseTest.driver.findElement(By.xpath("//section/h3[text()='Receptacle Information']/../section"));
	}
	
	
	
	 public ConsignmentDetailsPage(WebDriver driver){
         //This initElements method will create all WebElements
         PageFactory.initElements(driver, this);
     }
	 
	 public void clickConsignDetails() {
		 consignmentDetails.click();
	 }
	 
	 public String getreceptacleInfoText() {
		 return receptacleInfo.getText();
	 }
	 
	 //need to optimize webtable xpath
	 public WebElement ReceptacleID(String ReceptacleID2) throws EncryptedDocumentException, InvalidFormatException, IOException {
		 System.out.println("ReceptacleID:"+ReceptacleID2);
		  WebElement element=driver.findElement(By.xpath("//tbody/tr/td/a[text()='"+ReceptacleID2+"']"));	
		  System.out.println("entered");
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  System.out.println("inside");
		  wait.until(ExpectedConditions.visibilityOf(element));
		  System.out.println("inside enter");
		  return element;
	 }
	 
	//5 header
		public void verifyWebTableValues(WebElement element, String columnText,String columnText2,String columnText3,String columnText4,String columnText5,String rowText1,String rowText2,String rowText3,String rowText4,String rowText5 ) {
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
			System.out.println(headindex1+" :headindex1");
			System.out.println(headindex2+" :headindex2");
			System.out.println(headindex3+" :headindex3");
			System.out.println(headindex4+" :headindex4");
			String row1 = wt2.getCellData(rowindex, headindex1);
			String row2 = wt2.getCellData(rowindex, headindex2);
			String row3 = wt2.getCellData(rowindex, headindex3);
			String row4 = wt2.getCellData(rowindex, headindex4);
			String row5 = wt2.getCellData(rowindex, headindex5);
			System.out.println(row1+" :row1");
			System.out.println(row2+" :row2");
			System.out.println(row3+" :row3");
			System.out.println(row4+" :row4");
			System.out.println(row5+" :row5");
			
			if(row1.equals(rowText1)) {
				System.out.println("entered first if"+rowText1);
				if((row2.equals(rowText2))&&(row3.equals(rowText3))&&(row4.equals(rowText4))&&(row5.equals(rowText5))){
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

}
