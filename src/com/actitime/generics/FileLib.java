package com.actitime.generics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	/**
	 * used to read the data from Property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getPropertyData(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./data/CommonData.Properties");
		Properties p=new Properties();
		p.load(fis);
		String value=p.getProperty(key);
		return value;	
	}
/**
 * used to read the data from excel file
 * @param sheetname
 * @param row
 * @param cell
 * @return value
 * @throws Exception
 */
public String getExceldata(String sheetname,int row,int cell) throws Exception {
	FileInputStream fis=new FileInputStream("./data/testscriptdata.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	String value=wb.getSheet(sheetname).getRow(row).getCell(cell).toString();
	return value;
}
/**
 * writing the data back to excel
 * @param sheetname
 * @param row
 * @param cell
 * @param Setvalue
 * @throws EncryptedDocumentException
 * @throws IoException
 */ 
public void setExceldata(String sheetname,int row,int cell,String setvalue) throws EncryptedDocumentException,IOException {
	FileInputStream fis=new FileInputStream("./data/testscriptdata.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	wb.getSheet(sheetname).getRow(row).getCell(cell).setCellValue(setvalue);;
	FileOutputStream fos=new FileOutputStream("./data/testscriptdata.xlsx");
	wb.write(fos);
	wb.close();
}
}
