package com.Actitime.GeniricLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author Reetima
 *
 */
public class FileLibrary {
	/**
	 * THIS CLASS IS A GENERIC CLASS WHICH IS HAVEING NONSTATIC METHOD TO PERFROM DATA DRIVEN TESTING
     * @author Reetima
     *this method is a non static method which is used to read data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	//create a non static method then return in place of void go with string
	public String readDataFromPropertyfile(String key) throws IOException
	{
		//create object for read the data from property file
		FileInputStream fis=new FileInputStream("./Testdata/commondata.property.txt");
		
		
		//to call non static method from proprties class
		Properties p=new Properties();
		
		
		//to load the file
		p.load(fis);
		
		
		//to get the data from the property file
		String value = p.getProperty(key);
		
		
		//to return the value
		return value;
	}
	/**
	 * this method is a non static method to read the data from excel sheet
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
     public String readDataFromExcelFile(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException
{
     FileInputStream fis1=new FileInputStream("./Testdata/Testdata.xlsx");
     Workbook wb = WorkbookFactory.create(fis1);
     String value = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
     return value;

}
}
