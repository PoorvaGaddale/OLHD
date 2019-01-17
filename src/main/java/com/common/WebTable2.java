package com.common;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;


public class WebTable2 extends BaseTest {
	
	private WebElement _webTable;

	public WebTable2(WebElement webTable) {
		set_webTable(webTable);
	}

	public WebElement get_webTable() {
		return _webTable;
	}

	public void set_webTable(WebElement _webTable) {
		this._webTable = _webTable;
	}

	public int getRowCount() {
		WebElement tablebody = _webTable.findElement(By.tagName("tbody"));
	    List<WebElement> tableRows = tablebody.findElements(By.tagName("tr"));
	    return tableRows.size();
	}
	
	public int getColumnCount() {
		List<WebElement> tableRows = _webTable.findElements(By.tagName("tr"));
		WebElement headerRow = tableRows.get(0);
		List<WebElement> tableCols = headerRow.findElements(By.tagName("td"));
		return tableCols.size();
	}
	
	public String getCellData(int rowIdx, int colIdx) {
		WebElement tablebody = _webTable.findElement(By.tagName("tbody"));
		List<WebElement> tableRows = tablebody.findElements(By.tagName("tr"));
		WebElement currentRow = tableRows.get(rowIdx-1);
		List<WebElement> tableCols = currentRow.findElements(By.tagName("td"));
		WebElement cell = tableCols.get(colIdx-1);
		return cell.getText();		
	}
	
	public WebElement getCellEditor(int rowIdx, int colIdx, int editorIdx) throws NoSuchElementException {
		try {
			List<WebElement> tableRows = _webTable.findElements(By.tagName("tr"));
			WebElement currentRow = tableRows.get(rowIdx-1);
			List<WebElement> tableCols = currentRow.findElements(By.tagName("td"));
			WebElement cell = tableCols.get(colIdx-1);
			WebElement cellEditor = cell.findElements(By.tagName("input")).get(editorIdx);
			return cellEditor;
			
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("Failed to get cell editor");
		}
	}
	
	public WebElement selectCellCalendar(int rowIdx, int colIdx) throws NoSuchElementException {
		try {
			List<WebElement> tableRows = _webTable.findElements(By.tagName("tr"));
			WebElement currentRow = tableRows.get(rowIdx-1);
			List<WebElement> tableCols = currentRow.findElements(By.tagName("td"));
			WebElement cell = tableCols.get(colIdx-1);
			//cell.click();
			//String s = cell.getText();
			//WebElement cellEditor = cell.findElements(By.cssSelector("a.ui-state-default")).get(labelIdx);
			return cell;
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("Failed to get cell editor");
		}
	}
	public List<WebElement> header() throws NoSuchElementException {
		List<WebElement> noOfheader;
		try {
			WebElement tableheader = _webTable.findElement(By.tagName("thead"));
			//WebElement currentRow = tableRows.get(rowIdx-1);
			WebElement headerRow = tableheader.findElement(By.tagName("tr"));
			System.out.println("headerRow tagname: "+headerRow.getTagName());
			 noOfheader = headerRow.findElements(By.tagName("td"));
			if(noOfheader.size()==0) {
				 noOfheader = headerRow.findElements(By.tagName("th"));
			}
			System.out.println("noOfheader: "+noOfheader.size());
			

			//cell.click();
			//String s = cell.getText();
			//WebElement cellEditor = cell.findElements(By.cssSelector("a.ui-state-default")).get(labelIdx);
			return noOfheader;
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("Failed to get headersize");
		}
	}
	
	
	
	public int getheaderCount() {
	  // List<WebElement> tableRows = driver.findElements(By.xpath("//section/h3[text()='Event Information']/following-sibling::table/thead/tr/th"));
	   return header().size();
	}
	

	public int getheaderindex(String columnText) {
		System.out.println("entered");
		int hsize = getheaderCount();
		System.out.println("hsize: "+hsize);
		int i;
		String text = null;
		for (i = 0; i <hsize; i++) {
		
			 text = header().get(i).getText();
				//System.out.println(text+"coloumn text");
					 if(text.equalsIgnoreCase(columnText)) {
						 System.out.println(text+"columnText is");
						break;
					 }
		}
		return i+1;
}
	public List<WebElement> row(String columnText) {
		int i = getheaderindex(columnText);
		System.out.println("header pointing to:"+i);
		try {
			WebElement tablerows = _webTable.findElement(By.tagName("tbody"));
			List<WebElement> Rows = tablerows.findElements(By.tagName("tr"));
			System.out.println("Rows size:"+Rows.size());
			WebElement specific_row = Rows.get(i-1);
			System.out.println("specific_row:"+specific_row);
			List<WebElement> noOfRows = specific_row.findElements(By.tagName("td"));
			System.out.println("noOfRows size:"+noOfRows.size());
			//cell.click();
			//String s = cell.getText();
			//WebElement cellEditor = cell.findElements(By.cssSelector("a.ui-state-default")).get(labelIdx);
			return noOfRows;
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("Failed to get headersize");
		}
	}
	
	public int getrowCount(String columnText) {
		int size = row(columnText).size();
		//System.out.println(size+" :rowsize is:");
		return size;
		}
	public int getrowindex(String columnText,String rowText) {
		System.out.println("entered row");
		int rsize = getrowCount(columnText);
		int i;
		String text = null;
		for (i = 0; i <rsize; i++) {
			 text = row(columnText).get(i).getText();
			 //System.out.println(text+": row text is");
					 if(text.equalsIgnoreCase(rowText)) {
						 System.out.println(text+":equal rowText is");
						break;
					 }
		}
		//System.out.println("rowindex");
		//System.out.println(i+1);
		return i+1;
}
	
	
}


