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

public class RESCONFieldValidations extends BaseTest {
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
	String consignmentsummary="consignmentsummary";
	String TestData="TestData";
	String RESCONFieldValidations="RESCONFieldValidations";
	String ConsignmentNO="ConsignmentNO";
	String resconinformation="resconinformation";
	String eventinfotable="eventinfotable";
	String resditpartnertransinfo="resditpartnertransinfo";
	
	String RID="RID";
	String NOP="NOP";
	String Receptype="Receptype";
	String RecepID="RecepID";
	String RSC="RSC";
	String DDI="DDI";
	String RDGI="RDGI";
	String RFC="RFC";
	String RHC="RHC";
	String REI="REI";
	String EII="EII";
	String RAW="RAW";
	String RI="RI";
	String DID="DID";
	
	String consignNo;
	String ReceptacleID;

	String nop;
	String rt;
	String rid;
	String rsc;
	String ddi;
	String rdgi;
	String rfc;
	String rhc;
	String rei;
	String eii;
	String raw;
	String ri;
	String did;
	
	String ce;
	
	String event;
	String edt;
	String ecs;
	String ecf;
	String el;
	
	String TSQ="TSQ";
	String TCC="TCC";
	String TCN="TCN";
	String TDLC="TDLC";
	String TDLN="TDLN";
	String TALC="TALC";
	String TALN="TALN";
	String TDDT="TDDT";
	String TADT="TADT";
	
	String tsq;
	String tcc;
	String tcn;
	String tdlc;
	String tdln;
	String talc;
	String taln;
	String tddt;
	String tadt;
	
	
	
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
	consignNo=ul.getvalueFromxcell(EXCEL_PATH, resconinformation, RESCONFieldValidations, ConsignmentNO);
	
	event=ul.getvalueFromxcell(EXCEL_PATH, eventinfotable, RESCONFieldValidations, "Event");
	edt=ul.getvalueFromxcell(EXCEL_PATH, eventinfotable, RESCONFieldValidations, "EDT");
	ecs=ul.getvalueFromxcell(EXCEL_PATH, eventinfotable, RESCONFieldValidations, "ECS");
	ecf=ul.getvalueFromxcell(EXCEL_PATH, eventinfotable, RESCONFieldValidations, "ECF");
	el=ul.getvalueFromxcell(EXCEL_PATH, eventinfotable, RESCONFieldValidations, "EL");
	
	ce=ul.getvalueFromxcell(EXCEL_PATH, resconinformation, RESCONFieldValidations, "CE");
	
	ReceptacleID=ul.getvalueFromxcell(EXCEL_PATH, resconinformation, RESCONFieldValidations, RID);
	
	nop=ul.getvalueFromxcell(EXCEL_PATH, resconinformation, RESCONFieldValidations, NOP);
	rt=ul.getvalueFromxcell(EXCEL_PATH, resconinformation, RESCONFieldValidations, Receptype);
	//rid=ul.getvalueFromxcell(EXCEL_PATH, resconinformation, RESCONFieldValidations, RecepID);
	rsc=ul.getvalueFromxcell(EXCEL_PATH, resconinformation, RESCONFieldValidations, RSC);
	ddi=ul.getvalueFromxcell(EXCEL_PATH, resconinformation, RESCONFieldValidations, DDI);
	rdgi=ul.getvalueFromxcell(EXCEL_PATH, resconinformation, RESCONFieldValidations, RDGI);
	rfc=ul.getvalueFromxcell(EXCEL_PATH, resconinformation, RESCONFieldValidations, RFC);
	rhc=ul.getvalueFromxcell(EXCEL_PATH, resconinformation, RESCONFieldValidations, RHC);
	rei=ul.getvalueFromxcell(EXCEL_PATH, resconinformation, RESCONFieldValidations, REI);
	eii=ul.getvalueFromxcell(EXCEL_PATH, resconinformation, RESCONFieldValidations, EII);
	raw=ul.getvalueFromxcell(EXCEL_PATH, resconinformation, RESCONFieldValidations, RAW);
	ri=ul.getvalueFromxcell(EXCEL_PATH, resconinformation, RESCONFieldValidations, RI);
	did=ul.getvalueFromxcell(EXCEL_PATH, resconinformation, RESCONFieldValidations, DID);
	
	tsq=ul.getvalueFromxcell(EXCEL_PATH, resditpartnertransinfo, RESCONFieldValidations, TSQ);
	tcc=ul.getvalueFromxcell(EXCEL_PATH, resditpartnertransinfo, RESCONFieldValidations, TCC);
	tcn=ul.getvalueFromxcell(EXCEL_PATH, resditpartnertransinfo, RESCONFieldValidations, TCN);
	tdlc=ul.getvalueFromxcell(EXCEL_PATH, resditpartnertransinfo, RESCONFieldValidations, TDLC);
	tdln=ul.getvalueFromxcell(EXCEL_PATH, resditpartnertransinfo, RESCONFieldValidations, TDLN);
	talc=ul.getvalueFromxcell(EXCEL_PATH, resditpartnertransinfo, RESCONFieldValidations, TALC);
	taln=ul.getvalueFromxcell(EXCEL_PATH, resditpartnertransinfo, RESCONFieldValidations, TALN);
	tddt=ul.getvalueFromxcell(EXCEL_PATH, resditpartnertransinfo, RESCONFieldValidations, TDDT);
	tadt=ul.getvalueFromxcell(EXCEL_PATH, resditpartnertransinfo, RESCONFieldValidations, TADT);
	
	
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
		Thread.sleep(2000);
		cf.click(csp.EventID(event),"EventID");
		toSwitchTab(0);
		System.out.println(edp.consignEvent.getText());
		cf.verifyElement_text(edp.consignEvent, ce, "consignEvent");
		//edp.verifyWebTableValues(edp.resditTransport(), "Transport Stage Qualifier", "Conveyance Reference", "Carrier Name", "Departure Location Code", "Departure Location Name", "Arrival Location Code", "Arrival Location Name", "Transport Departure Date Time", "Transport Arrival Date Time", tsq, tcc, tcn, tdlc, tdln, talc, taln, tddt, tadt);
		
		toSwitchTab(2);
		
		Thread.sleep(2000);
		cf.click(csp.consignmentDetails, "consignmentDetails");
		Thread.sleep(2000);
		cf.click(cdp.ReceptacleID(ReceptacleID), "ReceptacleID");
		Thread.sleep(2000);
		System.out.println(rs.resconNOP+"resconNOP"+nop);
		
		cf.verifyElement_text(rs.resconNOP, nop, "resconNOP");
		
		cf.verifyElement_text(rs.resconRt, rt, "resconRt");
		//cf.verifyElement_text(rs.resconRid, rid, "resconRid");
		cf.verifyElement_text(rs.resconRsc, rsc, "resconRsc");
		cf.verifyElement_text(rs.resconDdi, ddi, "resconDdi");
		cf.verifyElement_text(rs.resconRdgi, rdgi, "resconRdgi");
		cf.verifyElement_text(rs.resconRhc, rhc, "resconRhc");
		cf.verifyElement_text(rs.resconRfc, rfc, "resconRfc");
		cf.verifyElement_text(rs.resconRei, rei, "resconRei");
		cf.verifyElement_text(rs.resconEii, eii, "resconEii");
		cf.verifyElement_text(rs.resconRaw, raw, "resconRaw");
		cf.verifyElement_text(rs.resconRi, ri, "resconRi");
		cf.verifyElement_text(rs.resconDid, did, "resconDid");
	}
	}


