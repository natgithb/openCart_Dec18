package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider 1
	
	@DataProvider(name="LoginData")//Unique name of dp
//String [][] the return type,getData() method name 	
	public String [][] getData() throws IOException
	{
		//the location of taking the xl file from testData
		String path=".\\testData\\Opencart_LoginData.xlsx";
	
		// creating an object for XLUtility to 
		// read the data from excel sheet		
		ExcelUtility xlutil=new ExcelUtility(path);
	
		//to get number of row we pass only sheet name
		int totalrows=xlutil.getRowCount("Sheet1");
		//to get cell/column number we have to pass sheet name
		// along with the row number.
		int totalcols=xlutil.getCellCount("Sheet1",1);
		
		//Two dimension array created with the exact total number 
		//of row and column.	
		String logindata[][]=new String[totalrows][totalcols];
		
		// Logic
	
		for(int i=1;i<=totalrows;i++)  //row   
		{		
			for(int j=0;j<totalcols;j++)  //col
			{
				logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);    
			}
		}
	return logindata;//returning two dimension array
				
	}
	
	//DataProvider 2
	
	//DataProvider 3
	
	//DataProvider 4
}
