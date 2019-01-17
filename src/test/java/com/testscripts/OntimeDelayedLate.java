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

public class OntimeDelayedLate extends BaseTest {
	SearchConsignmentPage scp;
	ConsignmentDetailsPage cdp;
	ConsignmentSummaryPage csp;
	CommonFunctions cf;
	XLUtilities ul; 
	WebTable wt;
	EventDetailsPage edp;
	String errorMessage="errormessage";
	String TestData="TestData";
	String OntimeDelayedLate="OntimeDelayedLate";
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
	String count_Flag_D;
	String colEvent="Event";
	String colConsign_Status="Consignment Status";
	String colCount_Flag="Count Flag";
	String currentStatus_RD="RECEIVED LATE";
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
	consignNo=ul.getvalueFromxcell(EXCEL_PATH, TestData, OntimeDelayedLate, Colheader1);
	event_Precon = ul.getvalueFromxcell(EXCEL_PATH, TestData, OntimeDelayedLate, "Event_Precon");
	event_Cardit = ul.getvalueFromxcell(EXCEL_PATH, TestData, OntimeDelayedLate, "Event_Cardit");
	event_Received = ul.getvalueFromxcell(EXCEL_PATH, TestData, OntimeDelayedLate, "Event_Received");
	event_Enroute = ul.getvalueFromxcell(EXCEL_PATH, TestData, OntimeDelayedLate, "Event_Enroute");
	event_Delivered = ul.getvalueFromxcell(EXCEL_PATH, TestData, OntimeDelayedLate, "Event_Delivered");
	event_NA = ul.getvalueFromxcell(EXCEL_PATH, TestData, OntimeDelayedLate, "Event_NA");
	consignment_Status_Precon = ul.getvalueFromxcell(EXCEL_PATH, TestData, OntimeDelayedLate, "Consignment_Status_Precon");
	consignment_Status_Cardit = ul.getvalueFromxcell(EXCEL_PATH, TestData, OntimeDelayedLate, "Consignment_Status_Cardit");
	consignment_Status_Received = ul.getvalueFromxcell(EXCEL_PATH, TestData, OntimeDelayedLate, "Consignment_Status_Received");
	consignment_Status_Enroute = ul.getvalueFromxcell(EXCEL_PATH, TestData, OntimeDelayedLate, "Consignment_Status_Enroute");
	consignment_Status_Delivered = ul.getvalueFromxcell(EXCEL_PATH, TestData, OntimeDelayedLate, "Consignment_Status_Delivered");
	consignment_Status_NA = ul.getvalueFromxcell(EXCEL_PATH, TestData, OntimeDelayedLate, "Consignment_Status_NA");
	count_Flag_N = ul.getvalueFromxcell(EXCEL_PATH, TestData, OntimeDelayedLate, "Count_Flag_N");
	count_Flag_F = ul.getvalueFromxcell(EXCEL_PATH, TestData, OntimeDelayedLate, "Count_Flag_F");
	}
	@Test
	public void validateConsignmentStatuses() throws Exception {
		cf.click(scp.searchConsignment, "searchConsignment");
		cf.sendKeys(scp.consignmentNumber, consignNo, "consignmentNumber");
		cf.click(scp.findItem, "findItem");
		cf.verifyElement_NOTPresent(scp.errorMsg, errorMessage);
		toSwitchTab(0);
		//driver.get("http://npermg397:8090/CTS/#!/consignments/"+consignNo+"");
		Thread.sleep(2000);
		cf.verifyElement_text(csp.currentStatus, currentStatus_RD, "Received Late");
		cf.scrollDown(csp.eventInfoText);
		
		//csp.getspecificrow(colEvent,colConsign_Status,colCount_Flag,event_Precon,consignment_Status_Precon,count_Flag_N);
		csp.getspecificrow(colEvent,colConsign_Status,colCount_Flag,event_Cardit,consignment_Status_Cardit,count_Flag_N);
		csp.getspecificrow(colEvent,colConsign_Status,colCount_Flag,event_Enroute,consignment_Status_Enroute,count_Flag_F);
		csp.getspecificrow(colEvent,colConsign_Status,colCount_Flag,event_Received,consignment_Status_Received,count_Flag_N);
		//csp.getspecificrow(colEvent,colConsign_Status,colCount_Flag,event_Delivered,consignment_Status_Delivered,count_Flag_N);
		csp.getspecificrow(colEvent,colConsign_Status,colCount_Flag,event_NA,consignment_Status_NA,count_Flag_F);
	}
	
	
	
}
