package com.actitime.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
public String readPropertyData(String key) throws IOException {
	FileInputStream fis=new FileInputStream("./data/commondata.property");
	Properties pobj = new Properties();
	pobj.load(fis);
	String value = pobj.getProperty(key);
	return value;
}
public String readExcelData(String sheetName, int row, int cell) throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream("./data/testscript.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	String value = wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
	return value;
}
}










