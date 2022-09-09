package Datadriven.excelDataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvide {

	
	
	@Test(dataProvider="driveTest")
	public void testCaseData(String greeting, String communication, int id)
	{
		System.out.println(greeting+communication+id);
	}
	@DataProvider(name="driveTest")	
	
		public Object[][] getdata()	
		{
			Object[][] data = { {"hello","text",1}, {"bye","message", 143}, {"solo","call",453} };
			
			return data;
		}
		
	
}
