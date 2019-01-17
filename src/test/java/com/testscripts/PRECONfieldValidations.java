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

public class PRECONfieldValidations extends BaseTest {
	
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
	//to pass excel headers
	String ConsignmentNo="ConsignmentNo";
	String PRECONfieldValidations="PRECONfieldValidations";
	String precondetails="precondetails";
	String Ccomdate="Ccomdate";
	String Ccategory="Ccategory";
	String Transport_Mode="Transport Mode";
	String Conveyance_Reference="Conveyance Reference";
	String Carrier_Code="Carrier Code";
	String Departure_Location_Code="Departure Location Code";
	String Arrival_Location_Code="Arrival Location Code";
	String Transport_Departure_Date_Time="Transport Departure Date Time";
	String Transport_Arrival_Date_Time="Transport Arrival Date Time";
	
	
	
	String TM="TM";
	String TCR="TCR";
	String TCC="TCC";
	String TDLC="TDLC";
	String TALC="TALC";
	String TDDT="TDDT";
	String TADT="TADT";
	
	
	String consignNo;
	String preccompdate;
	String precccategory;
	String pretm;
	String pretcr;
	String pretcc;
	String pretdlc;
	String pretalc;
	String pretddt;
	String pretadt;
	
	//PRECON information
	String Receptype="Receptype";
	String RecepserialNo="RecepserialNo";
	String Rsubclass="Rsubclass";
	String DDI="DDI";
	String RDGI="RDGI";
	String RFC="RFC";
	String RHC="RHC";
	String REI="REI";
	String EII="EII";
	String RWT="RWT";
	String RW="RW";
	String RI="RI";
	String DID="DID";
	String RID="RID";
	String preEvent="preEvent";
	String preEDT="preEDT";
	String preCS="preCS";
	String preEL="preEL";
	String ConsignEvent="ConsignEvent";
	
	String rt;
	String rsn;
	String rsc;
	String ddi;
	String rdgi;
	String rfc;
	String rhc;
	String rei;
	String eii;
	String rwt;
	String rw;
	String ri;
	String did;
	
	String ReceptacleID;
	
	String pe;
	String pedt;
	String pcs;
	String pel;
	
	String consignEvent;
	
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
	
	//Precon values
	consignNo=ul.getvalueFromxcell(EXCEL_PATH, precondetails, PRECONfieldValidations, ConsignmentNo);
	preccompdate=ul.getvalueFromxcell(EXCEL_PATH, precondetails, PRECONfieldValidations, Ccomdate);
	precccategory=ul.getvalueFromxcell(EXCEL_PATH, precondetails, PRECONfieldValidations, Ccategory);
	pretm=ul.getvalueFromxcell(EXCEL_PATH, precondetails, PRECONfieldValidations, TM);
	pretcr=ul.getvalueFromxcell(EXCEL_PATH, precondetails, PRECONfieldValidations, TCR);
	pretcc=ul.getvalueFromxcell(EXCEL_PATH, precondetails, PRECONfieldValidations, TCC);
	pretdlc=ul.getvalueFromxcell(EXCEL_PATH, precondetails, PRECONfieldValidations, TDLC);
	pretalc=ul.getvalueFromxcell(EXCEL_PATH, precondetails, PRECONfieldValidations, TALC);
	pretddt=ul.getvalueFromxcell(EXCEL_PATH, precondetails, PRECONfieldValidations, TDDT);
	pretadt=ul.getvalueFromxcell(EXCEL_PATH, precondetails, PRECONfieldValidations, TADT);
	
	rt=ul.getvalueFromxcell(EXCEL_PATH, precondetails, PRECONfieldValidations, Receptype);
	rsn=ul.getvalueFromxcell(EXCEL_PATH, precondetails, PRECONfieldValidations, RecepserialNo);
	rsc=ul.getvalueFromxcell(EXCEL_PATH, precondetails, PRECONfieldValidations, Rsubclass);
	ddi=ul.getvalueFromxcell(EXCEL_PATH, precondetails, PRECONfieldValidations, DDI);
	rdgi=ul.getvalueFromxcell(EXCEL_PATH, precondetails, PRECONfieldValidations, RDGI);
	rfc=ul.getvalueFromxcell(EXCEL_PATH, precondetails, PRECONfieldValidations, RFC);
	rhc=ul.getvalueFromxcell(EXCEL_PATH, precondetails, PRECONfieldValidations, RHC);
	rei=ul.getvalueFromxcell(EXCEL_PATH, precondetails, PRECONfieldValidations, REI);
	eii=ul.getvalueFromxcell(EXCEL_PATH, precondetails, PRECONfieldValidations, EII);
	rwt=ul.getvalueFromxcell(EXCEL_PATH, precondetails, PRECONfieldValidations, RWT);
	rw=ul.getvalueFromxcell(EXCEL_PATH, precondetails, PRECONfieldValidations, RW);
	ri=ul.getvalueFromxcell(EXCEL_PATH, precondetails, PRECONfieldValidations, RI);
	did=ul.getvalueFromxcell(EXCEL_PATH, precondetails, PRECONfieldValidations, DID);
	
	ReceptacleID=ul.getvalueFromxcell(EXCEL_PATH, precondetails, PRECONfieldValidations, RID);
	
	pe=ul.getvalueFromxcell(EXCEL_PATH, precondetails, PRECONfieldValidations, preEvent);
	pedt=ul.getvalueFromxcell(EXCEL_PATH, precondetails, PRECONfieldValidations, preEDT);
	pcs=ul.getvalueFromxcell(EXCEL_PATH, precondetails, PRECONfieldValidations, preCS);
	pel=ul.getvalueFromxcell(EXCEL_PATH, precondetails, PRECONfieldValidations, preEL);
	
	consignEvent=ul.getvalueFromxcell(EXCEL_PATH, precondetails, PRECONfieldValidations, ConsignEvent);
	
	}
	
	@Test
	public void validateFields() throws Exception {
		cf.click(scp.searchConsignment, "searchConsignment");
		cf.sendKeys(scp.consignmentNumber, consignNo, "consignmentNumber");
		cf.click(scp.findItem, "findItem");
		cf.verifyElement_NOTPresent(scp.errorMsg, errorMessage);
		//toSwitchTab(0);
		driver.get("http://npermg397:8090/CMM/#!/consignments/"+consignNo+"");
		Thread.sleep(2000);
		
		cf.click(csp.preconDetails, "preconDetails");
		Thread.sleep(4000);
		cf.verifyElement_text(precon.preconConsignNo, consignNo, "Consignment Number");
		cf.verifyElement_text(precon.preconConsignCompletionDate, preccompdate, "Consignment Completion Date");
		cf.verifyElement_text(precon.preconConsignCategory, precccategory, "Consignment Category");
		
		precon.verifyWebTableValues(precon.preconTransInfo(), Transport_Mode, Conveyance_Reference, Carrier_Code, Departure_Location_Code, Arrival_Location_Code, Transport_Departure_Date_Time, Transport_Arrival_Date_Time, pretm, pretcr, pretcc, pretdlc, pretalc, pretddt, pretadt);
		cf.click(csp.consignmentDetails, "consignmentDetails");
		Thread.sleep(2000);
		cf.click(cdp.ReceptacleID(ReceptacleID), "ReceptacleID");
		Thread.sleep(2000);
		cf.verifyElement_text(rs.preconReceptacleType, rt, "preconReceptacleType");
		cf.verifyElement_text(rs.preconReceptacleSerialNo, rsn, "preconReceptacleSerialNo");
		cf.verifyElement_text(rs.preconReceptacleSubClass, rsc, "preconReceptacleSubClass");
		cf.verifyElement_text(rs.preconDespatchDocIndi, ddi, "preconDespatchDocIndi");
		cf.verifyElement_text(rs.preconRecepDangerGoodsIndi, rdgi, "preconRecepDangerGoodsIndi");
		cf.verifyElement_text(rs.preconRecepFormatOfContents, rfc, "preconRecepFormatOfContents");
		cf.verifyElement_text(rs.preconRecepHandlingClass, rhc, "preconRecepHandlingClass");
		cf.verifyElement_text(rs.preconRecepExpressIndi, rei, "preconRecepExpressIndi");
		cf.verifyElement_text(rs.preconExemptItemsIndi, eii, "preconExemptItemsIndi");
		cf.verifyElement_text(rs.preconRecepWeightType, rwt, "preconRecepWeightType");
		cf.verifyElement_text(rs.preconRecepWeight, rw, "preconRecepWeight");
		cf.verifyElement_text(rs.preconRecepItems, ri, "preconRecepItems");
		cf.verifyElement_text(rs.preconDespatchID, did, "preconDespatchID");
		
		precon.verifyWebTableValues(precon.preconEventInfo(), "Event", "Event Date Time", "Consignment Status", "Event Location", pe, pedt, pcs, pel);
		cf.click(precon.Event(pe), "PRECON event");
		Thread.sleep(2000);
		toSwitchTab(0);
		cf.verifyElement_text(edp.consignEvent, consignEvent, "consignEvent");
		
	}
	
	

}
