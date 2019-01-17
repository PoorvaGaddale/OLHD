package com.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



public class XLUtilities implements IConstantValues {

	public String getCellData(String sFileName,String sSheetName, int iRow, int iCol) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis = new FileInputStream(sFileName);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sSheetName);
		Row rw = sh.getRow(iRow);
		Cell cl = rw.getCell(iCol);
		return cl.getStringCellValue();
		
	}
	public String GetCellData(String sFileName,String sSheetName, int iRow, int iCol) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis = new FileInputStream(sFileName);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sSheetName);
		Row rw = sh.getRow(iRow);
		Cell cl = rw.getCell(iCol);
		return cl.getStringCellValue();
		
	}
	public void putCellData(String sFileName,String sSheetName, int iRow, int iCol,String sData) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis = new FileInputStream(sFileName);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sSheetName);
		try{
			Row rw = sh.getRow(iRow);
			Cell cl = rw.getCell(iCol);
			if (cl==null){
				cl=rw.createCell(iCol);
				cl.setCellValue(sData);
			}
			
			else{
				cl.setCellValue(sData);
			}
			
			FileOutputStream fileOut = new FileOutputStream(sFileName);
			 
				wb.write(fileOut);

		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	//////////////New
	public int getCellValue(String sFileName,String sSheetName, int iRow, int iCol) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis = new FileInputStream(sFileName);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sSheetName);
		Row rw = sh.getRow(iRow);
		Cell cl = rw.getCell(iCol);		
		return (int) cl.getNumericCellValue();
		
	}
	public int getRowNoinCSV(String sFileName) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis = new FileInputStream(sFileName);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheetAt(0);
		int rowCount=sh.getLastRowNum();
		return rowCount;
		
	}
	public int getCellNoinCSV(String sFileName) throws EncryptedDocumentException, InvalidFormatException, IOException{
		int cellCount=0;
		FileInputStream fis = new FileInputStream(sFileName);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheetAt(0);
		int rowCount=sh.getLastRowNum();
		for(int i=0;i<rowCount;i++){
			Row r=sh.getRow(i);
			cellCount=r.getLastCellNum();
		}
		
		return cellCount;
		
	}
	
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		/*String fname= "C:\\NotBackedUp\\Login.xlsx";
		String shName= "Login";
		int row =1;
		int col=1;*/
		XLUtilities ul = new XLUtilities();
				/*int value= ul.getRowCount(EXCEL_PATH, "consignmentnumber");
				int columnCount = ul.getColumnCount(EXCEL_PATH, "consignmentnumber", 0);*/
				/*int rowIndex=ul.getRowIndex(EXCEL_PATH, "consignmentnumber", "Reshma");
				int colIndex=ul.getColIndex(EXCEL_PATH, "consignmentnumber", 0, "Ayesha");
				//System.out.println(value);
				System.out.println(rowIndex+":rowIndex");
		System.out.println(colIndex+":colIndex");*/
	//ul.clickFromExcel(EXCEL_PATH, "consignmentnumber", "Reshma", "Ayesha");
		String result=ul.getvalueFromxcell(EXCEL_PATH, "resconinformation", "RESCONFieldValidations", "CE");
		System.out.println(result+":result");
	}

	public int getRowCount(String sFileName, String sSheetName) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis = new FileInputStream(sFileName);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sSheetName);
		
		return sh.getLastRowNum()+1;
		
	}
	public int getColumnCount(String sFileName, String sSheetName, int row) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis = new FileInputStream(sFileName);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sSheetName);
		Row rw = sh.getRow(0);
		return rw.getLastCellNum();
		}
	
	public int getRowIndex(String sFileName,String sSheetName, String testCaseName) throws EncryptedDocumentException, InvalidFormatException, IOException{
		int rowCount = getRowCount(sFileName, sSheetName);
		int i;
		//System.out.println(rowCount+": rowCount");
		FileInputStream fis = new FileInputStream(sFileName);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sSheetName);
		for (i=1; i < rowCount; i++) {
			try {
				if(testCaseName.equalsIgnoreCase(sh.getRow(i).getCell(0).toString())) {
					//System.out.println("loop entered");
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		return i;
	}
	public int getColIndex(String sFileName,String sSheetName, int row, String columnId) throws EncryptedDocumentException, InvalidFormatException, IOException{
		int colCount = getColumnCount(sFileName, sSheetName, row);
		int i;
		//System.out.println(colCount+": colCount");
		FileInputStream fis = new FileInputStream(sFileName);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sSheetName);
		for (i=1; i < colCount; i++) {
			try {
				if(columnId.equalsIgnoreCase(sh.getRow(0).getCell(i).toString())) {
					//System.out.println("loop entered");
					String string = sh.getRow(0).getCell(i).toString();
					//System.out.println(string+"text is");
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		return i;
	}
	//public void clickFromExcel(WebElement element, String sFileName,String sSheetName, String irow, String iCol) throws EncryptedDocumentException, InvalidFormatException, IOException {
		public String getvalueFromxcell(String sFileName,String sSheetName, String testCaseName, String columnId) throws EncryptedDocumentException, InvalidFormatException, IOException {
			//XLUtilities ul = new XLUtilities();
			int rowIndex = getRowIndex(sFileName, sSheetName, testCaseName);
			int colIndex = getColIndex(sFileName, sSheetName, 0, columnId);
			FileInputStream fis = new FileInputStream(sFileName);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sSheetName);
			return sh.getRow(rowIndex).getCell(colIndex).toString();		
		}


}
