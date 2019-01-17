package com.testscripts;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.common.BaseTest;
import com.common.CommonFunctions;
import com.common.WebTable;
import com.common.XLUtilities;
import com.pages.ConsignmentDetailsPage;
import com.pages.ConsignmentSummaryPage;
import com.pages.EventDetailsPage;
import com.pages.SearchConsignmentPage;

public class AllOntimeFull extends BaseTest {
	SearchConsignmentPage scp;
	ConsignmentDetailsPage cdp;
	ConsignmentSummaryPage csp;
	CommonFunctions cf;
	XLUtilities ul; 
	WebTable wt;
	EventDetailsPage edp;
	String errorMessage="errormessage";
	String TestData="TestData";
	String AllOntime="AllOntime";
	String Colheader1="ConsignmentNO";
	String Colheader3="Status";
	String consignNo;
	String status1;
	String ReceptacleID2;
	String event_Precon;
	String event_Cardit; 
	String event_Enroute;
	String event_Received;
	String event_Delivered;
	String event_NA;
	String consignment_Status_Precon;
	String consignment_Status_Cardit;
	String consignment_Status_Enroute;
	String consignment_Status_Received;
	String consignment_Status_Delivered;
	String consignment_Status_NA;
	String count_Flag_N;
	String count_Flag_F;
	String colEvent="Event";
	String colConsign_Status="Consignment Status";
	String colCount_Flag="Count Flag";
	String currentStatus_RO="RECEIVED ON TIME";
	@BeforeClass
	public void login() throws Exception {
	openURL();
	scp= new SearchConsignmentPage(driver);
	cf= new CommonFunctions();
	ul=new XLUtilities();
	cdp=new ConsignmentDetailsPage(driver);
	csp = new ConsignmentSummaryPage(driver);
	wt=new WebTable();
	edp=new EventDetailsPage(driver);
	consignNo=ul.getvalueFromxcell(EXCEL_PATH, TestData, AllOntime, Colheader1);
	event_Precon = ul.getvalueFromxcell(EXCEL_PATH, TestData, AllOntime, "Event_Precon");
	event_Cardit = ul.getvalueFromxcell(EXCEL_PATH, TestData, AllOntime, "Event_Cardit");
	event_Enroute = ul.getvalueFromxcell(EXCEL_PATH, TestData, AllOntime, "Event_Enroute");
	event_Received = ul.getvalueFromxcell(EXCEL_PATH, TestData, AllOntime, "Event_Received");
	event_Delivered = ul.getvalueFromxcell(EXCEL_PATH, TestData, AllOntime, "Event_Delivered");
	event_NA = ul.getvalueFromxcell(EXCEL_PATH, TestData, AllOntime, "Event_NA");
	consignment_Status_Precon = ul.getvalueFromxcell(EXCEL_PATH, TestData, AllOntime, "Consignment_Status_Precon");
	consignment_Status_Cardit = ul.getvalueFromxcell(EXCEL_PATH, TestData, AllOntime, "Consignment_Status_Cardit");
	consignment_Status_Enroute = ul.getvalueFromxcell(EXCEL_PATH, TestData, AllOntime, "Consignment_Status_Enroute");
	consignment_Status_Received = ul.getvalueFromxcell(EXCEL_PATH, TestData, AllOntime, "Consignment_Status_Received");
	consignment_Status_Delivered = ul.getvalueFromxcell(EXCEL_PATH, TestData, AllOntime, "Consignment_Status_Delivered");
	consignment_Status_NA = ul.getvalueFromxcell(EXCEL_PATH, TestData, AllOntime, "Consignment_Status_NA");
	count_Flag_N = ul.getvalueFromxcell(EXCEL_PATH, TestData, AllOntime, "Count_Flag_N");
	count_Flag_F = ul.getvalueFromxcell(EXCEL_PATH, TestData, AllOntime, "Count_Flag_F");
	//status1=ul.getvalueFromxcell(EXCEL_PATH, TestData, AllOntime, Colheader3);
	//ReceptacleID2=ul.getvalueFromxcell(EXCEL_PATH, SheetName, "Reshma", "Heena");
	}
	@Test(enabled=false)
	public void validateCurrentStatus() throws Exception {
	//cf.click(cdp.ReceptacleID(ReceptacleID2), "working");
		/*scp.navigateToSearchConsignment();
		//scp.enterConsignmentNumber(1,0);
		cf.sendKeys(scp.consignmentNumber, ReceptacleID, "enteredvalue");
		//ul.sendKeysfromXcell(scp.consignmentNumber, EXCEL_PATH, SheetName, "Reshma", "Ayesha", "textentered");
		scp.clickFindItem();*/
		/*cf.verifyElement_NOTPresent(scp.errorMsg, errorMessage);
		
		toSwitchTab(2);
        ConsignmentSummaryPage csp = new ConsignmentSummaryPage(driver);
        String actualcurrentStatus = csp.currentStatus.getText();
        System.out.println(actualcurrentStatus);
        //String expectedCurrentStatus = "HANDOVER LATE";
        String expectedCurrentStatus = csp.getCurrentStatus(1, 0);
        Assert.assertEquals(actualcurrentStatus, expectedCurrentStatus);
		System.out.println("completed");	*/
		//cf.click(element, "");
		
	}
	@Test
	public void validateConsignmentStatuses() throws Exception {
		cf.click(scp.searchConsignment, "searchConsignment");
		cf.sendKeys(scp.consignmentNumber, consignNo, "consignmentNumber");
		cf.click(scp.findItem, "findItem");
		cf.verifyElement_NOTPresent(scp.errorMsg, errorMessage);
		toSwitchTab(0);
		//driver.get("http://npermg397:8090/CTS/#!/consignments/PREC01050308");
		Thread.sleep(4000);
		cf.verifyElement_text(csp.currentStatus, currentStatus_RO, "Received On time");
		cf.scrollDown(csp.eventInfoText);
		csp.getspecificrow(colEvent,colConsign_Status,colCount_Flag,event_Precon,consignment_Status_Precon,count_Flag_N);
		csp.getspecificrow(colEvent,colConsign_Status,colCount_Flag,event_Cardit,consignment_Status_Cardit,count_Flag_N);
		csp.getspecificrow(colEvent,colConsign_Status,colCount_Flag,event_Enroute,consignment_Status_Enroute,count_Flag_N);
		csp.getspecificrow(colEvent,colConsign_Status,colCount_Flag,event_Received,consignment_Status_Received,count_Flag_F);
		csp.getspecificrow(colEvent,colConsign_Status,colCount_Flag,event_Delivered,consignment_Status_Delivered,count_Flag_F);
		csp.getspecificrow(colEvent,colConsign_Status,colCount_Flag,event_NA,consignment_Status_NA,count_Flag_F);
	}
	
	
}
