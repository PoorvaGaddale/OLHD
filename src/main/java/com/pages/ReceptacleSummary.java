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

import com.common.BaseTest;

public class ReceptacleSummary extends BaseTest{
	
	@FindBy(xpath="//strong[text()='Receptacle Details']")
	public WebElement receptacleDetails;
	
	@FindBy(xpath="//tbody/tr[1]/td/a")
	public WebElement event;
	
	//PRECON Information fields
	@FindBy(xpath="//span[contains(@id,'Receptacle-type')]")
	public WebElement preconReceptacleType;
	
	@FindBy(xpath="//span[contains(@id,'Receptacle-ID')]")
	public WebElement preconReceptacleID;
	
	@FindBy(xpath="//span[contains(@id,'receptacle-serial-no')]")
	public WebElement preconReceptacleSerialNo;
	
	@FindBy(xpath="(//span[contains(@id,'receptacle-sub-class')])[1]")
	public WebElement preconReceptacleSubClass;
	
	@FindBy(xpath="(//span[contains(@id,'despatch-document-indicator')])[1]")
	public WebElement preconDespatchDocIndi;
	
	@FindBy(xpath="(//span[contains(@id,'receptacle-dangerous-goods-indicator')])[1]")
	public WebElement preconRecepDangerGoodsIndi;
	
	@FindBy(xpath="(//span[contains(@id,'receptacle-format-of-contents')])[1]")
	public WebElement preconRecepFormatOfContents;
	
	
	@FindBy(xpath="(//span[contains(@id,'receptacle-handling-class')])[1]")
	public WebElement preconRecepHandlingClass;
	
	
	@FindBy(xpath="(//span[contains(@id,'receptacle-express-indicator')])[1]")
	public WebElement preconRecepExpressIndi;
	
	@FindBy(xpath="(//span[contains(@id,'exempt-items-indicator')])[1]")
	public WebElement preconExemptItemsIndi;
	
	@FindBy(xpath="(//span[contains(@id,'receptacle-weight-type')])[1]")
	public WebElement preconRecepWeightType;
	
	@FindBy(xpath="//span[@id='receptacle-weight']")
	public WebElement preconRecepWeight;
	
	@FindBy(xpath="(//span[@id='receptacle-items'])[1]")
	public WebElement preconRecepItems;
	
	@FindBy(xpath="(//span[@id='Despatch-ID'])[1]")
	public WebElement preconDespatchID;
	
	//RESCON information fields
	@FindBy(xpath="//span[contains(@id,'number-of-packages')]")
	public WebElement resconNOP;
	
	@FindBy(xpath="//span[contains(@id,'receptacle-type')]")
	public WebElement resconRt;
	
	@FindBy(xpath="//span[contains(@id,'receptacle-ID')]")
	public WebElement resconRid;
	
	@FindBy(xpath="(//span[contains(@id,'receptacle-sub-class')])[2]")
	public WebElement resconRsc;
	
	@FindBy(xpath="(//span[contains(@id,'despatch-document-indicator')])[2]")
	public WebElement resconDdi;
	
	@FindBy(xpath="(//span[contains(@id,'receptacle-dangerous-goods-indicator')])[2]")
	public WebElement resconRdgi;
	
	@FindBy(xpath="(//span[contains(@id,'receptacle-format-of-contents')])[2]")
	public WebElement resconRfc;
	
	@FindBy(xpath="(//span[contains(@id,'receptacle-handling-class')])[2]")
	public WebElement resconRhc;
	
	@FindBy(xpath="(//span[contains(@id,'receptacle-express-indicator')])[2]")
	public WebElement resconRei;
	
	@FindBy(xpath="(//span[contains(@id,'exempt-items-indicator')])[2]")
	public WebElement resconEii;
	
	@FindBy(xpath="//span[contains(@id,'receptacle-actual-weight')]")
	public WebElement resconRaw;
	
	@FindBy(xpath="(//span[@id='receptacle-items'])[2]")
	public WebElement resconRi;
	
	@FindBy(xpath="(//span[@id='Despatch-ID'])[2]")
	public WebElement resconDid;
	
	 public WebElement Event() throws EncryptedDocumentException, InvalidFormatException, IOException {
		  WebElement element=driver.findElement(By.xpath("//tbody/tr/td/a[contains(.,'RESCON RECEIVED')]"));	
		  System.out.println("entered");
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  System.out.println("inside");
		  wait.until(ExpectedConditions.visibilityOf(element));
		  System.out.println("inside enter");
		  return element;
	 }
	
	public ReceptacleSummary(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
