package ExcelCommunication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ReadExcel {
	
	static HashMap<String , List<String>> mymap= new HashMap<String , List<String>>();
	public HashMap<String , List<String>> readExcel() throws IOException 
	{
		//1. gain access to file
		
		File myfile = new File("D:/Selenium/Reflection Class/Pics/ExcelExample_1.xls");
		
		int count=0;
		
		//2.now open and read file 
		  
		try 
		{
			FileInputStream streamobject = new FileInputStream(myfile);
									
			HSSFWorkbook myworkbook = new HSSFWorkbook (streamobject);
			
			Row myrow;   
		    Sheet mysheet = myworkbook.getSheet("Sheet1");
		    for(int i=0; i<=(mysheet.getLastRowNum()-mysheet.getFirstRowNum());i++)
		    {
		    	myrow = mysheet.getRow(i);
		    	List<String> mylist= new ArrayList<String>();// always new list is created 
		    	for(int j=0; j<(myrow.getLastCellNum()-myrow.getFirstCellNum());j++)
		    	{ 
		    		
		    	 //System.out.println(myrow.getCell(j));
		    	 mylist.add(myrow.getCell(j).getStringCellValue()); 
		    	//myrow.getCell(i).getNumericCellValue(); if u want to read number from excel.
		    	
		    	}
		    	
		    	mymap.put("STEP_0" +i, mylist);
		    	
		    }    
		    
		}
		catch(FileNotFoundException e)  
		{
			e.printStackTrace();
		}
			
		return mymap;

	}


}
