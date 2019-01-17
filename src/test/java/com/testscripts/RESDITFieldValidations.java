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
import com.pages.PreconDetailsPage;
import com.pages.ReceptacleSummary;
import com.pages.SearchConsignmentPage;

public class RESDITFieldValidations extends BaseTest {
	SearchConsignmentPage scp;
	ConsignmentDetailsPage cdp;
	ConsignmentSummaryPage csp;
	CommonFunctions cf;
	XLUtilities ul; 
	WebTable wt;
	EventDetailsPage edp;
	PreconDetailsPage precon;
	ReceptacleSummary rs;
	String errorMessage="errormessage";
	
	String RESDITFieldValidations="RESDITFieldValidations";
	String eventinfotable="eventinfotable";
	String resditpartnertransinfo="resditpartnertransinfo";
	String receptacleinfotable="receptacleinfotable";
	
	String ConsignmentNo="ConsignmentNo";
	String Consignresponse="Consignresponse";
	String CPwabNo="CPwabNo";
	String CO="CO";
	String CE="CE";
	String CEDT="CEDT";
	
	String PQ="PQ";
	String PIC="PIC";
	String PIN="PIN";
	String HLC="HLC";
	String HLN="HLN";
	
	String TSQ="TSQ";
	String TCC="TCC";
	String TCN="TCN";
	String TDLC="TDLC";
	String TDLN="TDLN";
	String TALC="TALC";
	String TALN="TALN";
	String TDDT="TDDT";
	String TADT="TADT";
	
	String consignNo;
	String consignResponse;
	String cpwabno;
	String co;
	String ce;
	String cedt;
	
	String pq;
	String pic;
	String pin;
	String hlc;
	String hln;
	
	String tsq;
	String tcc;
	String tcn;
	String tdlc;
	String tdln;
	String talc;
	String taln;
	String tddt;
	String tadt;
	
	String Event="Event";
	String EDT="EDT";
	String ECS="ECS";
	String ECF="ECF";
	String EL="EL";
	
	
	String event;
	String edt;
	String ecs;
	String ecf;
	String el;
	
	String RecpID="RecpID";
	String RCJID="RCJID";
	String RecpWt="RecpWt";
	String RCID="RCID";
	String RCS="RCS";
	
	String ReceptacleID2;
	String recpid;
	String rcjid;
	String recpwt;
	String rcid;
	String rcs;
	
	
	
	
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
	precon=new PreconDetailsPage(driver);
	rs= new ReceptacleSummary(driver);
	
	consignNo=ul.getvalueFromxcell(EXCEL_PATH, resditpartnertransinfo, RESDITFieldValidations, ConsignmentNo);
	consignResponse=ul.getvalueFromxcell(EXCEL_PATH, resditpartnertransinfo, RESDITFieldValidations, Consignresponse);
	cpwabno=ul.getvalueFromxcell(EXCEL_PATH, resditpartnertransinfo, RESDITFieldValidations, CPwabNo);
	co=ul.getvalueFromxcell(EXCEL_PATH, resditpartnertransinfo, RESDITFieldValidations, CO);
	ce=ul.getvalueFromxcell(EXCEL_PATH, resditpartnertransinfo, RESDITFieldValidations, CE);
	cedt=ul.getvalueFromxcell(EXCEL_PATH, resditpartnertransinfo, RESDITFieldValidations, CEDT);
	
	pq=ul.getvalueFromxcell(EXCEL_PATH, resditpartnertransinfo, RESDITFieldValidations, PQ);
	pic=ul.getvalueFromxcell(EXCEL_PATH, resditpartnertransinfo, RESDITFieldValidations, PIC);
	pin=ul.getvalueFromxcell(EXCEL_PATH, resditpartnertransinfo, RESDITFieldValidations, PIN);
	hlc=ul.getvalueFromxcell(EXCEL_PATH, resditpartnertransinfo, RESDITFieldValidations, HLC);
	hln=ul.getvalueFromxcell(EXCEL_PATH, resditpartnertransinfo, RESDITFieldValidations, HLN);
	
	tsq=ul.getvalueFromxcell(EXCEL_PATH, resditpartnertransinfo, RESDITFieldValidations, TSQ);
	tcc=ul.getvalueFromxcell(EXCEL_PATH, resditpartnertransinfo, RESDITFieldValidations, TCC);
	tcn=ul.getvalueFromxcell(EXCEL_PATH, resditpartnertransinfo, RESDITFieldValidations, TCN);
	tdlc=ul.getvalueFromxcell(EXCEL_PATH, resditpartnertransinfo, RESDITFieldValidations, TDLC);
	tdln=ul.getvalueFromxcell(EXCEL_PATH, resditpartnertransinfo, RESDITFieldValidations, TDLN);
	talc=ul.getvalueFromxcell(EXCEL_PATH, resditpartnertransinfo, RESDITFieldValidations, TALC);
	taln=ul.getvalueFromxcell(EXCEL_PATH, resditpartnertransinfo, RESDITFieldValidations, TALN);
	tddt=ul.getvalueFromxcell(EXCEL_PATH, resditpartnertransinfo, RESDITFieldValidations, TDDT);
	tadt=ul.getvalueFromxcell(EXCEL_PATH, resditpartnertransinfo, RESDITFieldValidations, TADT);
	
	event=ul.getvalueFromxcell(EXCEL_PATH, eventinfotable, RESDITFieldValidations, Event);
	edt=ul.getvalueFromxcell(EXCEL_PATH, eventinfotable, RESDITFieldValidations, EDT);
	ecs=ul.getvalueFromxcell(EXCEL_PATH, eventinfotable, RESDITFieldValidations, ECS);
	ecf=ul.getvalueFromxcell(EXCEL_PATH, eventinfotable, RESDITFieldValidations, ECF);
	el=ul.getvalueFromxcell(EXCEL_PATH, eventinfotable, RESDITFieldValidations, EL);
	
	//ReceptacleID2=ul.getvalueFromxcell(EXCEL_PATH, resditpartnertransinfo, RESDITFieldValidations, "ReceptacleID");
	recpid=ul.getvalueFromxcell(EXCEL_PATH, receptacleinfotable, RESDITFieldValidations, RecpID);	
	rcjid=ul.getvalueFromxcell(EXCEL_PATH, receptacleinfotable, RESDITFieldValidations, RCJID);	
	recpwt=ul.getvalueFromxcell(EXCEL_PATH, receptacleinfotable, RESDITFieldValidations, RecpWt);	
	rcid=ul.getvalueFromxcell(EXCEL_PATH, receptacleinfotable, RESDITFieldValidations, RCID);	
	rcs=ul.getvalueFromxcell(EXCEL_PATH, receptacleinfotable, RESDITFieldValidations, RCS);	
			
	
	}
	
	
	@Test
	public void validateFields() throws Exception {
		cf.click(scp.searchConsignment, "searchConsignment");
		cf.sendKeys(scp.consignmentNumber, consignNo, "consignmentNumber");
		cf.click(scp.findItem, "findItem");
		cf.verifyElement_NOTPresent(scp.errorMsg, errorMessage);
		//toSwitchTab(2);
		driver.get("http://npermg397:8090/CMM/#!/consignments/"+consignNo+"");
		
		csp.verifyWebTableValues(csp.eventInfo(), "Event", "Event Date Time", "Consignment Status", "Count Flag", "Event Location", event, edt, ecs, ecf, el);
		
		cf.click(csp.EventID(event),"EventID");
		toSwitchTab(0);
		
		cf.verifyElement_text(edp.consignID, consignNo, "consignID");
		cf.verifyElement_text(edp.consignResponse, consignResponse, "consignResponse");
		cf.verifyElement_text(edp.consignPawbNo, cpwabno, "consignPawbNo");
		cf.verifyElement_text(edp.consignOrigin, co, "consignOrigin");
		cf.verifyElement_text(edp.consignEvent, ce, "consignEvent");
		cf.verifyElement_text(edp.consignEventDate, cedt, "consignEventDate");
		
		cf.verifyElement_text(edp.partnerQualifier, pq, "partnerQualifier");
		cf.verifyElement_text(edp.partnerIDCode, pic, "partnerIDCode");
		cf.verifyElement_text(edp.partnerIDName, pin, "partnerIDName");
		cf.verifyElement_text(edp.handoverLocCode, hlc, "handoverLocCode");
		cf.verifyElement_text(edp.handoverLocName, hln, "handoverLocName");
		
		edp.verifyWebTableValues(edp.resditTransport(), "Transport Stage Qualifier", "Conveyance Reference", "Carrier Name", "Departure Location Code", "Departure Location Name", "Arrival Location Code", "Arrival Location Name", "Transport Departure Date Time", "Transport Arrival Date Time", tsq, tcc, tcn, tdlc, tdln, talc, taln, tddt, tadt);
		
		driver.get("http://npermg397:8090/CMM/#!/consignments/"+consignNo+"");
		Thread.sleep(2000);
		cf.click(csp.consignmentDetails, "consignmentDetails");
		Thread.sleep(4000);
		
		cdp.verifyWebTableValues(cdp.receptacleInfo(), "Receptacle ID", "Container Journey ID", "Receptacle Weight", "Container ID", "Consignment Status", recpid, rcjid, recpwt, rcid, rcs);
		
	
		
		
		
		
	}
	
	

}
