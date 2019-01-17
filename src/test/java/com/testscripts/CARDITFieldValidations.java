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

public class CARDITFieldValidations extends BaseTest {
	SearchConsignmentPage scp;
	ConsignmentDetailsPage cdp;
	ConsignmentSummaryPage csp;
	CommonFunctions cf;
	XLUtilities ul; 
	WebTable wt;
	EventDetailsPage edp;
	String errorMessage="errormessage";
	//to pass excel headers
	String consignmentsummary="consignmentsummary";
	String CARDITFieldValidations="CARDITFieldValidations";
	String ConsignmentNO="ConsignmentNO";
	String Cstatus="Cstatus";
	String CCompDate="CCompDate";
	String Ccategory="Ccategory";
	String Cdest="Cdest";
	
	String Mail_Class="Mail Class";
	String Total_Count="Total Count";
	String Weight="Weight";
	String mailclassinfotable="mailclassinfotable";
	String MailClassL="MailClassL";
	String MailClassE="MailClassE";
	String TotalCountL="TotalCountL";
	String TotalCountE="TotalCountE";
	String WeightL="WeightL";
	String WeightE="WeightE";
	
	String Handover_Origin_Location_Code="Handover Origin Location Code";
	String Handover_Origin_Cut_Off="Handover Origin Cut Off";
	String Handover_Destination_Location_Code="Handover Destination Location Code";
	String Handover_Destination_Cut_Off="Handover Destination Cut Off";
	String handoverinfotable="handoverinfotable";
	String HOLC="HOLC";
	String HOCO="HOCO";
	String HDLC="HDLC";
	String HDCO="HDCO";
	
	String Transport_Qualifier="Transport Qualifier";
	String Conveyance_Reference="Conveyance Reference";
	String Departure_Location_Code="Departure Location Code";
	String Arrival_Location_Code="Arrival Location Code";
	String Transport_Departure_Date_Time="Transport Departure Date Time";
	String Transport_Arrival_Date_Time="Transport Arrival Date Time";
	String cardittransporttable="cardittransporttable";
	String TQ="TQ";
	String TCR="TCR";
	String TDLC="TDLC";
	String TALC="TALC";
	String TDDT="TDDT";
	String TADT="TADT";
	
	String colEvent="Event";
	String colEventDT="Event Date Time";
	String colConsign_Status="Consignment Status";
	String colCount_Flag="Count Flag";
	String Event_Location="Event Location";
	String eventinfotable="eventinfotable";
	String EV="Event";
	String EDT="EDT";
	String ECS="ECS";
	String ECF="ECF";
	String EL="EL";
	
	
	//to fetch values in variables
	String consignNo;
	String currentStatusExpected;
	String consignCompletiondateExpected;
	String consigncategoryExpected;
	String consignDestinationExpected;
	String mcL;
	String mcE;
	String tcL;
	String tcE;
	String wtL;
	String wtE;
	
	
	//to fetch values in handover info table
	String holc;
	String hoco;
	String hdlc;
	String hdco;
	
	//to fetch values of transport info table
	String tq;
	String tcr;
	String tdlc;
	String talc;
	String tddt;
	String tadt;
	
	//Event information 
	String eve; 
	String edt;
	String ecs;
	String ecf;
	String el;
	
	//Receptacle information
	String receptacleinfotable="receptacleinfotable";
	String RecpID="RecpID";
	String RCJID="RCJID";
	String RecpWt="RecpWt";
	String RCID="RCID";
	String RCS="RCS";
	String Receptacle_ID="Receptacle ID";
	String Container_Journey_ID="Container Journey ID";
	String Receptacle_Weight="Receptacle Weight";
	String Container_ID="Container ID";
	String Consignment_Status="Consignment Status";
	
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
	
	//Consignment Information
	consignNo=ul.getvalueFromxcell(EXCEL_PATH, consignmentsummary, CARDITFieldValidations, ConsignmentNO);
	currentStatusExpected=ul.getvalueFromxcell(EXCEL_PATH, consignmentsummary, CARDITFieldValidations, Cstatus);
	consignCompletiondateExpected=ul.getvalueFromxcell(EXCEL_PATH, consignmentsummary, CARDITFieldValidations, CCompDate);
	consigncategoryExpected=ul.getvalueFromxcell(EXCEL_PATH, consignmentsummary, CARDITFieldValidations, Ccategory);
	consignDestinationExpected=ul.getvalueFromxcell(EXCEL_PATH, consignmentsummary, CARDITFieldValidations, Cdest);
	
	//Mail Class information
	mcL=ul.getvalueFromxcell(EXCEL_PATH, mailclassinfotable, CARDITFieldValidations, MailClassL);
	mcE=ul.getvalueFromxcell(EXCEL_PATH, mailclassinfotable, CARDITFieldValidations, MailClassE);
	tcL=ul.getvalueFromxcell(EXCEL_PATH, mailclassinfotable, CARDITFieldValidations, TotalCountL);
	tcE=ul.getvalueFromxcell(EXCEL_PATH, mailclassinfotable, CARDITFieldValidations, TotalCountE);
	wtL=ul.getvalueFromxcell(EXCEL_PATH, mailclassinfotable, CARDITFieldValidations, WeightL);
	wtE=ul.getvalueFromxcell(EXCEL_PATH, mailclassinfotable, CARDITFieldValidations, WeightE);
	
	//Handover Information
	holc=ul.getvalueFromxcell(EXCEL_PATH, handoverinfotable, CARDITFieldValidations, HOLC);
	hoco=ul.getvalueFromxcell(EXCEL_PATH, handoverinfotable, CARDITFieldValidations, HOCO);
	hdlc=ul.getvalueFromxcell(EXCEL_PATH, handoverinfotable, CARDITFieldValidations, HDLC);
	hdco=ul.getvalueFromxcell(EXCEL_PATH, handoverinfotable, CARDITFieldValidations, HDCO);
	
	//Transport information
	tq=ul.getvalueFromxcell(EXCEL_PATH, cardittransporttable, CARDITFieldValidations, TQ);
	tcr=ul.getvalueFromxcell(EXCEL_PATH, cardittransporttable, CARDITFieldValidations, TCR);
	tdlc=ul.getvalueFromxcell(EXCEL_PATH, cardittransporttable, CARDITFieldValidations, TDLC);
	talc=ul.getvalueFromxcell(EXCEL_PATH, cardittransporttable, CARDITFieldValidations, TALC);
	tddt=ul.getvalueFromxcell(EXCEL_PATH, cardittransporttable, CARDITFieldValidations, TDDT);
	tadt=ul.getvalueFromxcell(EXCEL_PATH, cardittransporttable, CARDITFieldValidations, TADT);
	
	//Event information
	eve=ul.getvalueFromxcell(EXCEL_PATH, eventinfotable, CARDITFieldValidations, EV);
	edt=ul.getvalueFromxcell(EXCEL_PATH, eventinfotable, CARDITFieldValidations, EDT);
	ecs=ul.getvalueFromxcell(EXCEL_PATH, eventinfotable, CARDITFieldValidations, ECS);
	ecf=ul.getvalueFromxcell(EXCEL_PATH, eventinfotable, CARDITFieldValidations, ECF);
	el=ul.getvalueFromxcell(EXCEL_PATH, eventinfotable, CARDITFieldValidations, EL);
	
	//Receptacle information
	recpid=ul.getvalueFromxcell(EXCEL_PATH, receptacleinfotable, CARDITFieldValidations, RecpID);
	rcjid=ul.getvalueFromxcell(EXCEL_PATH, receptacleinfotable, CARDITFieldValidations, RCJID);
	recpwt=ul.getvalueFromxcell(EXCEL_PATH, receptacleinfotable, CARDITFieldValidations, RecpWt);
	rcid=ul.getvalueFromxcell(EXCEL_PATH, receptacleinfotable, CARDITFieldValidations, RCID);
	rcs=ul.getvalueFromxcell(EXCEL_PATH, receptacleinfotable, CARDITFieldValidations, RCS);
	
	}
	
	@Test
	public void validateFields() throws Exception {
		cf.click(scp.searchConsignment, "searchConsignment");
		cf.sendKeys(scp.consignmentNumber, consignNo, "consignmentNumber");
		cf.click(scp.findItem, "findItem");
		cf.verifyElement_NOTPresent(scp.errorMsg, errorMessage);
		toSwitchTab(0);
		//driver.get("http://npermg397:8090/CTS/#!/consignments/"+consignNo+"");
		Thread.sleep(2000);
		//Validate Consignment information
		cf.verifyElement_text(csp.currentStatus, currentStatusExpected, "CREATED");
		cf.verifyElement_text(csp.consignNumber, consignNo, "consignNo");
		cf.verifyElement_text(csp.consignCompletionDate, consignCompletiondateExpected, "consignCompletiondate");
		cf.verifyElement_text(csp.consignCategory, consigncategoryExpected, "consigncategory");
		cf.verifyElement_text(csp.consignDest, consignDestinationExpected, "consignDestination");
		
		//wt2.row();
		//System.out.println(wt2.getrowindex("Transport Qualifier","Main-Carriage (20)")+"wt2.getrowCount;");
		//Validate mail class information
		csp.verifyWebTableValues(csp.mailClass(),Mail_Class, Total_Count, Weight, mcL, tcL, wtL);
		
		csp.verifyWebTableValues(csp.handover(),Handover_Origin_Location_Code, Handover_Origin_Cut_Off, Handover_Destination_Location_Code, Handover_Destination_Cut_Off, holc, hoco, hdlc, hdco);
		//csp.verifyWebTableValues(csp.transportInfo(), Transport_Qualifier, Conveyance_Reference, Departure_Location_Code, Arrival_Location_Code, Transport_Departure_Date_Time, Transport_Arrival_Date_Time, tq, tcr, tdlc, talc, tddt, tadt);
		csp.verifyWebTableValues(csp.eventInfo(), colEvent, colEventDT, colConsign_Status, colCount_Flag, Event_Location, eve, edt, ecs, ecf, el);
		cf.click(csp.consignmentDetails, "consignmentDetails");
		Thread.sleep(2000);
		cdp.verifyWebTableValues(cdp.receptacleInfo(), Receptacle_ID, Container_Journey_ID, Receptacle_Weight, Container_ID, Consignment_Status, recpid, rcjid, recpwt, rcid, rcs);
	
	}
	
	
	
}
