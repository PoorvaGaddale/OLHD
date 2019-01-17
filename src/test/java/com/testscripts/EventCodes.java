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

public class EventCodes extends BaseTest {
	
	SearchConsignmentPage scp;
	ConsignmentDetailsPage cdp;
	ConsignmentSummaryPage csp;
	CommonFunctions cf;
	XLUtilities ul; 
	WebTable wt;
	EventDetailsPage edp;
	String errorMessage="errormessage";
	String TestData="TestData";
	String eventinfotable="eventinfotable";
	String EventCodes="EventCodes";
	String CommonTestData="CommonTestData";
	String Colheader1="ConsignmentNO";
	String Colheader2="ReceptacleID";
	String consignoTC01;
	String receptacleID;
	
	String EV="Event";
	String ConsignEvent="ConsignEvent";
	
	String eve;
	String conEve;
		
	String CheckIfRESCON="CheckIfRESCON";
	String checkIfRescon;
	
	String ConsignEvent2="ConsignEvent2";
	String conEve2;
	
	@BeforeClass
	public void fetchValues() throws Exception {
	openURL();
	scp= new SearchConsignmentPage(driver);
	cf= new CommonFunctions();
	ul=new XLUtilities();
	cdp=new ConsignmentDetailsPage(driver);
	csp = new ConsignmentSummaryPage(driver);
	wt=new WebTable();
	edp=new EventDetailsPage(driver);
	
	consignoTC01=ul.getvalueFromxcell(EXCEL_PATH, TestData, CommonTestData, Colheader1);
	receptacleID=ul.getvalueFromxcell(EXCEL_PATH, TestData, CommonTestData, Colheader2);
	
	eve=ul.getvalueFromxcell(EXCEL_PATH, eventinfotable, EventCodes, EV);
	conEve=ul.getvalueFromxcell(EXCEL_PATH, eventinfotable, EventCodes, ConsignEvent);
	checkIfRescon=ul.getvalueFromxcell(EXCEL_PATH, eventinfotable, EventCodes, CheckIfRESCON);
	conEve2=ul.getvalueFromxcell(EXCEL_PATH, eventinfotable, EventCodes, ConsignEvent2);
	}
	
	@Test
	public void validateFields() throws Exception {
		cf.click(scp.searchConsignment, "searchConsignment");
		cf.sendKeys(scp.consignmentNumber, consignoTC01, "consignmentNumber");
		cf.click(scp.findItem, "findItem");
		cf.verifyElement_NOTPresent(scp.errorMsg, errorMessage);
		//toSwitchTab(0);
		/*driver.get("http://npermg397:8090/CMM/#!/consignments/"+consignoTC01+"");
		Thread.sleep(2000);
		
		cf.verifyElement_text(csp.eventDescriptionFirst, eve, "eve");
		cf.click(csp.consignmentDetails, "consignmentDetails");
		Thread.sleep(2000);
		cf.click(cdp.ReceptacleID(receptacleID), "Receptacle id");
		cf.verifyElement_text(edp.eventDescriptionFirst, eve, "eve");
		
		cf.click(edp.eventDescriptionFirst, "eventDescriptionFirst");
		Thread.sleep(4000);
		toSwitchTab(0);*/
		//toSwitchTab(1);
		//cf.verifyElement_text(edp.consignEvent, conEve, "ConsignEvent");
		if (checkIfRescon.equals("RESCON")) {
			/*toSwitchTab(1);
			cf.click(edp.eventDescriptionSecond, "eventDescriptionSecond");
			toSwitchTab(0);*/
			driver.get("http://npermg397:8090/CMM/#!/consignments/"+consignoTC01+"");
			Thread.sleep(2000);
			
			cf.click(csp.consignmentDetails, "consignmentDetails");
			Thread.sleep(2000);
			cf.click(cdp.ReceptacleID(receptacleID), "Receptacle id");
			
			cf.click(edp.eventDescriptionSecond, "eventDescriptionSecond");
			Thread.sleep(4000);
			toSwitchTab(0);
			cf.verifyElement_text(edp.consignEvent, conEve2, "ConsignEvent2");
		}
		else
		{
			driver.get("http://npermg397:8090/CMM/#!/consignments/"+consignoTC01+"");
			Thread.sleep(2000);
			
			cf.verifyElement_text(csp.eventDescriptionFirst, eve, "eve");
			cf.click(csp.consignmentDetails, "consignmentDetails");
			Thread.sleep(2000);
			cf.click(cdp.ReceptacleID(receptacleID), "Receptacle id");
			cf.verifyElement_text(edp.eventDescriptionFirst, eve, "eve");
			
			cf.click(edp.eventDescriptionFirst, "eventDescriptionFirst");
			toSwitchTab(0);
			cf.verifyElement_text(edp.consignEvent, conEve, "ConsignEvent");
		}
		
	}

}
