package com.testscripts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.common.BaseTest;
import com.common.CommonFunctions;
import com.common.XLUtilities;
import com.pages.ConsignmentDetailsPage;
import com.pages.ConsignmentSummaryPage;
import com.pages.EventDetailsPage;
import com.pages.PreconDetailsPage;
import com.pages.ReceptacleSummary;
import com.pages.SearchConsignmentPage;
import com.pages.SearchSummaryPage;


public class NavigationOfPages extends BaseTest{
	SearchConsignmentPage scp;
	SearchSummaryPage ssp;
	ConsignmentSummaryPage csp;
	ConsignmentDetailsPage cdp;
	PreconDetailsPage pdp;
	CommonFunctions cf;
	XLUtilities ul;
	ReceptacleSummary rs;
	EventDetailsPage edp;
	String TestData="TestData";
	String CommonTestData="CommonTestData";
	String Colheader1="ConsignmentNO";
	String Colheader2="ReceptacleID";
	String consignoTC01;
	String receptacleID;
	String summarySearch="summarySearch";
	String searchConsignment="searchConsignment";
	@BeforeClass
	public void setup() throws Exception {
			
			scp = new SearchConsignmentPage(driver);
			ssp = new SearchSummaryPage(driver);
			csp = new ConsignmentSummaryPage(driver);
			cdp = new ConsignmentDetailsPage(driver);
			cf= new CommonFunctions();
			rs = new ReceptacleSummary(driver);
			ul=new XLUtilities();
			pdp=new PreconDetailsPage(driver);
			edp = new EventDetailsPage(driver);
			consignoTC01=ul.getvalueFromxcell(EXCEL_PATH, TestData, CommonTestData, Colheader1);
			receptacleID=ul.getvalueFromxcell(EXCEL_PATH, TestData, CommonTestData, Colheader2);
			//System.out.println(consignoTC01+":consignoTC01");
			//System.out.println(receptacleID+":receptacleID");
	}
	
	@Test(priority=-1, enabled=false)
	public void navigateToEventDetails2() throws Exception {
		openURL();
		cf.verifyElement_IsDisplayed(ssp.summarySearch,summarySearch );
		cf.click(scp.searchConsignment, searchConsignment);
		cf.verifyElement_IsDisplayed(scp.activeSearch, "searchConsignment");
		cf.sendKeys(scp.consignmentNumber, consignoTC01, "consigno");
		Thread.sleep(2000);
		cf.click(scp.findItem, "findItem");
		//toSwitchTab(1);
		driver.get("http://npermg397:8090/CMM/#!/consignments/"+consignoTC01+"");
		cf.verifyElement_IsDisplayed(csp.handoverInfo, "handoverInfo");
		Thread.sleep(2000);
		cf.click(csp.preconDetails, "preconDetails");
		cf.verifyElement_IsDisplayed(pdp.preconTransInfo, "preconTransInfo");
		cf.click(csp.consignmentDetails, "consignmentDetails");
		
		
		cf.verifyElement_IsDisplayed(cdp.receptacleInfo, "receptacleInfo");
		Thread.sleep(2000);
		cf.click(cdp.ReceptacleID(receptacleID), "Receptacle id");
		Thread.sleep(2000);
		
		cf.verifyElement_IsDisplayed(rs.receptacleDetails, "receptacleDetails");
		cf.click(rs.event, "event");
		toSwitchTab(2);
		cf.verifyElement_IsDisplayed(edp.eventInfo, "eventInfo");
		toSwitchTab(2);
		cf.verifyElement_IsDisplayed(rs.receptacleDetails, "receptacleDetails");
		cf.click(cdp.consignmentDetails, "consignmentDetails");
		cf.verifyElement_IsDisplayed(cdp.receptacleInfo, "receptacleInfo");
		cf.click(csp.preconDetails, "preconDetails");
		cf.verifyElement_IsDisplayed(pdp.preconTransInfo, "preconTransInfo");
		cf.click(csp.consignSummary, "consignSummary");
		cf.verifyElement_IsDisplayed(csp.handoverInfo, "handoverInfo");
		
		
	}
	
	@Test(enabled=false)
	public void searchNavigation() throws Exception {
		openURL();
		cf.verifyElement_IsDisplayed(ssp.summarySearch,summarySearch );
		cf.click(scp.searchConsignment, searchConsignment);
		cf.verifyElement_IsDisplayed(scp.activeSearch, "searchConsignment");
		cf.click(ssp.searchSummary, "searchSummary");
		cf.verifyElement_IsDisplayed(ssp.summarySearch,summarySearch );
	}
	
	@Test(enabled=false)
	public void navigateConsignSummaryToEventDetails() throws Exception {
		openURL();
		cf.verifyElement_IsDisplayed(ssp.summarySearch,summarySearch );
		cf.click(scp.searchConsignment, searchConsignment);
		cf.verifyElement_IsDisplayed(scp.activeSearch, "searchConsignment");
		cf.sendKeys(scp.consignmentNumber, consignoTC01, "consigno");
		cf.click(scp.findItem, "findItem");
		//toSwitchTab(3);
		driver.get("http://npermg397:8090/CMM/#!/consignments/"+consignoTC01+"");
		cf.verifyElement_IsDisplayed(csp.handoverInfo, "handoverInfo");
		Thread.sleep(3000);
		cf.click(csp.eventDescriptionFirst, "eventDescriptionFirst");
		toSwitchTab(2);
		cf.verifyElement_IsDisplayed(edp.eventInfo, "eventInfo");
		
	}
	
	@Test(enabled=true)
	public void navigateToSummaryInfo() throws Exception {
		openURL();
		cf.verifyElement_IsDisplayed(ssp.summarySearch,summarySearch );
		
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
		//ssp.getsearchButton();
		
		cf.click(ssp.detailedView, "detailedView");
		cf.verifyElement_IsDisplayed(ssp.summaryDetails, "summaryDetails");
		cf.click(ssp.backArrow, "backArrow");
		cf.verifyElement_IsDisplayed(ssp.summarySearch,summarySearch );
	
	
	}
	
	

}
