package test;

import org.apache.poi.hslf.record.ExVideoContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import helper.ExcelOperation;

public class LoginTest
{

	@Test(dataProvider="GetData")
	public void LoginTestMethod(String Username,String Password)  //No of column in excel = no of parameters
	{
		System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
	
		WebDriver driver = new FirefoxDriver();
		driver.get("https://opensource-demo.orangehrmlive.com");
		driver.findElement(By.id("txtUsername")).sendKeys(Username);
		driver.findElement(By.id("txtUsername")).sendKeys(Password);
		driver.findElement(By.id("btnLogin")).click();
		
	}
	
	
	//this method will be used to provide test data to above test method
	@DataProvider
	public Object[][] GetData() throws Exception
	{
		
		//main objective to create a 2D object having value as of excel
		
		
		//Step 1: Find sheet name in which data is present
		ExcelOperation exceloperationObj = new ExcelOperation();
		exceloperationObj.GetExcelSheet();
		
		
		//Step 2: Find total rows in excel
		
		int rows=exceloperationObj.FindTotalRows();
		Object[][] data = new Object[rows][2];
		
		
		//Step 3: Get each excel cell data to object array
		for(int i=0; i<rows; i++)
		{
			data[i][0]=exceloperationObj.GetCellData(i, 0);
			data[i][1]=exceloperationObj.GetCellData(i, 1);
		}
		return data;
		
		
		
	}
}
