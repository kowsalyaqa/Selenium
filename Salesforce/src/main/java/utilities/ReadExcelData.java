package utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ProjectSpecificMethods.BaseClass;

public class ReadExcelData{
	
	public static String[][] readExcelData() throws Exception {
	File file=new File("C:\\Users\\ELCOT\\git\\Selenium\\Salesforce\\data\\testdata.xlsx");
	FileInputStream fis = new FileInputStream(file);
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	XSSFSheet sheet = workbook.getSheetAt(0);
	int rowCount=sheet.getLastRowNum();
	int cellCount=sheet.getRow(1).getLastCellNum();
	String data[][]=new String[rowCount][cellCount];
	for(int i=1;i<=rowCount;i++)
	{
	for(int j=0;j<cellCount;j++)
	{
	String string = sheet.getRow(i).getCell(j).toString();
	System.out.println(string);
	data[i-1][j]=string;

	}
	}
	return data;
	}
	}

