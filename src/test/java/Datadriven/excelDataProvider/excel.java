package Datadriven.excelDataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class excel {

	
	@Test
	public void getexcel() throws IOException
	{
FileInputStream fis = new FileInputStream("C:\\Users\\suhas.tupake\\Desktop\\path\\excelDriven.xlsx");
		
		XSSFWorkbook wb = new  XSSFWorkbook(fis);
		
		XSSFSheet sheet = wb.getSheetAt(0);
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		
		XSSFRow row = sheet.getRow(0);
		
	int colcount = row.getLastCellNum();
	
	Object data[][]= new Object[rowCount-1][colcount];
	
	for(int i=0; i<rowCount-1; i++)
	{
		System.out.println("Outer loop is started");
		row = sheet.getRow(i+1);
		for(int j=0; j<colcount; j++)
		{
		System.out.print(row.getCell(j)+" ");
		}
		
		System.out.println();
		System.out.println("Outer loop is ended");
	}
	}
}
