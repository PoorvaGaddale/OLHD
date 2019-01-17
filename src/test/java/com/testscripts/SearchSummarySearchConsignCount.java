package com.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.common.BaseTest;
import com.common.CommonFunctions;
import com.common.XLUtilities;
import com.pages.ConsignmentDetailsPage;
import com.pages.ConsignmentSummaryPage;
import com.pages.PreconDetailsPage;
import com.pages.ReceptacleSummary;
import com.pages.SearchConsignmentPage;
import com.pages.SearchSummaryPage;

public class SearchSummarySearchConsignCount extends BaseTest{
	
	SearchConsignmentPage scp;
	SearchSummaryPage ssp;
	ConsignmentSummaryPage csp;
	ConsignmentDetailsPage cdp;
	PreconDetailsPage pdp;
	CommonFunctions cf;
	XLUtilities ul;
	ReceptacleSummary rs;
	String consignNo;
	
	
	@BeforeClass
	public void setup() throws Exception {
		openURL();
		scp = new SearchConsignmentPage(driver);
		ssp = new SearchSummaryPage(driver);
		csp = new ConsignmentSummaryPage(driver);
		cdp = new ConsignmentDetailsPage(driver);
		cf= new CommonFunctions();
		rs = new ReceptacleSummary(driver);
		ul=new XLUtilities();
		pdp=new PreconDetailsPage(driver);	
		
		consignNo=ul.getvalueFromxcell(EXCEL_PATH, "TestData", "SearchSummarySearchConsignCount", "ConsignmentNO");
		
			
	}
	
	@Test
	public void validateCount() throws Exception {
		
		cf.click(ssp.carrier, "carrier");
		cf.click(ssp.carrierDropDown, "carrierDropDown");
		cf.click(ssp.carrier, "carrier");
		//Thread.sleep(2000);
		cf.click(ssp.destinationDO, "destinationDO");
		cf.click(ssp.destinationDODropDown, "destinationDODropDown");
		cf.click(ssp.destinationDO, "destinationDO");
		Thread.sleep(2000);
		cf.click(ssp.searchButton, "searchButton");
		Thread.sleep(2000);
		String text = ssp.totalField.getText();
		
		
		cf.click(scp.searchConsignment, "searchConsignment");
		
		cf.click(scp.activeCarrier, "activeCarrier");
		
		cf.click(scp.activeCarrierdropdown, "activeCarrierdropdown");
		
		cf.click(scp.activeCarrier, "activeCarrier");
	
		cf.click(scp.activeStatus, "activeStatus");
		
		cf.click(scp.activeStatusdropdown, "activeStatusdropdown");
		
		cf.click(scp.activeStatus, "activeStatus");
		
		cf.click(scp.activeDO, "activeDO");
		
		cf.click(scp.activeDOdropdown, "activeDOdropdown");
		
		cf.click(scp.activeDO, "activeDO");
		cf.click(scp.activeSearchbtn, "activeSearchbtn");
		
		int activeCount = scp.getActiveCount(scp.activeSearchResults());
		//scp.getSpecificRowtext(scp.activeSearchResults(),"Consignment Status");
		
		
		int summaryTotalCount = Integer.parseInt(text);
		Assert.assertEquals(activeCount, summaryTotalCount);
		
		/*WebElement activeConsignment=driver.findElement(By.xpath("//tbody//a//span[text()='"+consignNo+"']"));
		
		cf.click(activeConsignment, "activeConsignment");
		
		toSwitchTab(0);
		
		cf.click(scp.createdStart, "createdStart");
		cf.click(scp.nov1st, "nov1st");*/
	
	
	}

}
