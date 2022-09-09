package Datadriven.excelDataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;




public class DataProvidee {
	
	DataFormatter formatter = new DataFormatter();

	@Test(dataProvider="driveTest")
	public void testCaseData(String greeting, String communication, String id)
	{
		System.out.println(greeting+communication+id);
	}
	@DataProvider(name="driveTest")	
	
		public Object[][] getdata() throws IOException	
		{
		//	Object[][] data = { {"hello","text","1"}, {"bye","message", "143"}, {"solo","call","453"} };
			
			//return data;
		
		FileInputStream fis = new FileInputStream("C:\\Users\\suhas.tupake\\Desktop\\path\\excelDriven.xlsx");
		
		XSSFWorkbook wb = new  XSSFWorkbook(fis);
		
		XSSFSheet sheet = wb.getSheetAt(0);
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		
		XSSFRow row = sheet.getRow(0);
		
	int colcount = row.getLastCellNum();
	
	Object data[][]= new Object[rowCount-1][colcount];
	
	for(int i=0; i<rowCount-1; i++)
	{
		row = sheet.getRow(i+1);
		for(int j=0; j<colcount; j++)
		{
			
			XSSFCell cell = row.getCell(j);
			
			
		data[i][j]=formatter.formatCellValue(cell);
		}
	}
	return data;
	
		
		}
	
}

