package com.common;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;


public class WebTable extends BaseTest {
	
	private WebElement _webTable;

	/*public WebTable(WebElement webTable) {
		set_webTable(webTable);
	}*/

	public WebElement get_webTable() {
		return _webTable;
	}

	public void set_webTable(WebElement _webTable) {
		this._webTable = _webTable;
	}

	public int getRowCount() {
	    List<WebElement> tableRows = _webTable.findElements(By.tagName("tr"));
	    return tableRows.size();
	}
	
	public int getColumnCount() {
		List<WebElement> tableRows = _webTable.findElements(By.tagName("tr"));
		WebElement headerRow = tableRows.get(0);
		List<WebElement> tableCols = headerRow.findElements(By.tagName("td"));
		return tableCols.size();
	}
	
	public String getCellData(int rowIdx, int colIdx) {
		List<WebElement> tableRows = _webTable.findElements(By.tagName("tr"));
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
	
	public List<WebElement> eheader() {
		List<WebElement> findElements = driver.findElements(By.xpath("//section/h3[text()='Event Information']/following-sibling::table/thead/tr/th"));
		return findElements;
	}
	
	public List<WebElement> mailheader() {
		List<WebElement> findElements = driver.findElements(By.xpath("//section[@class='fieldset-group mailclass-table']/table/thead/tr/td"));
		return findElements;
	}
	
	public int getheaderCount() {
	  // List<WebElement> tableRows = driver.findElements(By.xpath("//section/h3[text()='Event Information']/following-sibling::table/thead/tr/th"));
	   return eheader().size();
	}
	public int getheaderindex(String columnText) {
		System.out.println("entered");
		int hsize = getheaderCount();
		int i;
		String text = null;
		for (i = 0; i <hsize; i++) {
		
			 text = eheader().get(i).getText();
				System.out.println(text+"coloumn text");
					 if(text.equalsIgnoreCase(columnText)) {
						 //System.out.println(text+"columnText is");
						break;
					 }
		}
		return i+1;
}
	public List<WebElement> row(String columnText) {
		int i = getheaderindex(columnText);
		List<WebElement> findElements = driver.findElements(By.xpath("//section/h3[text()='Event Information']/following-sibling::table/tbody/tr/td["+i+"]"));
		return findElements;
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
			 System.out.println(text+": row text is");
					 if(text.equalsIgnoreCase(rowText)) {
						 //System.out.println(text+":equal rowText is");
						break;
					 }
		}
		//System.out.println("rowindex");
		//System.out.println(i+1);
		return i+1;
}
	public void getrowindex1(String columnText, String rowText) {
		int Hindex = getheaderindex(columnText);
		String text = null;
		//System.out.println("Hindex:"+Hindex);
		 List<WebElement> Rdata = driver.findElements(By.xpath("//section/h3[text()='Event Information']/following-sibling::table/tbody/tr/td["+Hindex+"]"));
		 			int i = Rdata.size();
		/*if(Rdata.get(i).getText().equalsIgnoreCase("Precon")) {
			 List<WebElement> rowvalue = driver.findElements(By.xpath("//section/h3[text()='Event Information']/following-sibling::table/tbody/tr["+i+"]/td["+Hindex+"]"));
			 int size = rowvalue.size();
			 System.out.println(size+"rowvalues");
			 for (int j = 0; j < size; j++) {
				if(rowvalue.get(j).getText().equalsIgnoreCase("Precon")||rowvalue.get(j).getText().equalsIgnoreCase("NA")) {
					System.out.println("verified");
				}
			}
		 }*/
	}
	
}


