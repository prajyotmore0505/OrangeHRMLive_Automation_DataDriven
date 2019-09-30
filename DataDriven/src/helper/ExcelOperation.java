package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperation 
{
	XSSFSheet sheet;
	public void GetExcelSheet() throws Exception
	{
		// Below lines to read file in java
		File File = new File("G:\\prajyot\\java\\J2EE\\mysace\\DataDriven\\TestData\\ExcelData.xlsx");
		FileInputStream fs = new FileInputStream(File);
		//HSSFWorkbook -excel format is .xls
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		sheet=wb.getSheet("Sheet1");
		
	}
	
	public int FindTotalRows()
	{
	int TotalRows=sheet.getLastRowNum()+1;
	return TotalRows;
		
	}
	
	public String GetCellData(int row, int column)
	{
		String cellvalue=sheet.getRow(row).getCell(column).getStringCellValue();
		return cellvalue;
		
	}
	
	

}
