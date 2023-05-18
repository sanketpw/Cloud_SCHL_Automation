package lib;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSH {

	XSSFWorkbook wb;
	XSSFSheet sheet1;
	
	public ExcelSH(String excelpath)
	{
		try
		{
			File src= new File(excelpath);
			FileInputStream fis= new FileInputStream(src);
			
			wb=new XSSFWorkbook(fis);
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
   public String getData1 (int sheetNumber,int row,int column)
   {
	   
	   sheet1=wb.getSheetAt(sheetNumber);
	   //if (sheet1 == null) throw new IllegalArgumentException("Sheet with sheet name " + sheetNumber + " does not exist");
	   
	  /* if (sheet1 == null) {
	        throw new IllegalArgumentException("Sheet number " + sheetNumber + " does not exist.");
	    }
	    if (sheet1.getRow(row) == null) {
	        throw new IllegalArgumentException("Row " + row + " in sheet " + sheetNumber + " does not exist.");
	    }
	    if (sheet1.getRow(row).getCell(column) == null) {
	        throw new IllegalArgumentException("Cell " + column + " in sheet " + sheetNumber + " and row " + row + " does not exist.");
	        
	    } */       
	    
	   
	   String data= sheet1.getRow(row).getCell(column).getStringCellValue();  	   
	   
	   return data;
   }
   public int getRowCount1(int sheetIndex)
   {
	  int row = wb.getSheetAt(sheetIndex).getLastRowNum();
	  row= row+1;
	  return row;
	   
   }

}
