package com.AdOmega.qa.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.AdOmega.qa.base.TestBase;

public class TestUtils extends TestBase {
	
	public static long PAGE_LOAD_TIMEOUT=10;
	public static long IMPLICITLY_WAIT=20;
	
	public static String FILEPATH="E:\\AderantWorkLocation\\AderantOmegaTesting\\src\\main\\java\\com\\AdOmega\\qa\\testData\\CreateLeadData.xlsx";
	
	
	public static Object[][] getDataOfCreateLead(String sheetName) throws IOException{
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(FILEPATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		XSSFWorkbook wbook=new XSSFWorkbook(fis);
		
		XSSFSheet sheet=wbook.getSheetAt(0);
		
		int rowNum=sheet.getLastRowNum();
		int cellNum=sheet.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[rowNum][cellNum];
		
		for(int j=0;j<rowNum;j++) {
			XSSFRow row=sheet.getRow(j);
			
			for(int i=0;i<cellNum;i++) {
				XSSFCell cell=row.getCell(i);
				
				data[j][i]=sheet.getRow(j+1).getCell(i).toString();
			}
		}
		
		return data;
		
	}
	

}
