package com.common;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

//Method to fetch url from config.properties file
public class Lib implements IConstantValues{
	public static Workbook wb;
	public static String getProperty(String CONFIG_PATH, String key){
		String property="";
		Properties prop= new Properties();
		try {
			prop.load(new FileInputStream(CONFIG_PATH));
			property=prop.getProperty(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return property;
	}
	//Read data from Excel sheet
	public static String getCellValue(String EXCEL_PATH, String sheet, int row, int column){
	            String value = "";
	            try {
	                  wb = WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
	                  value = wb.getSheet(sheet).getRow(row).getCell(column).toString();
	            } catch (Exception e) {
	            }
	            return value;
	      }
	
	

}
	