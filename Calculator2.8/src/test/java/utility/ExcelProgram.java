package utility;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelProgram {

	public void excelreadData(int totalRow, int totalColumn) throws IOException
	//public static void main(String[] args) throws IOException 
	{
		
	File src = new File ("C:\\Users\\301584\\Desktop\\ExcelProgram.xlsx");
	FileInputStream fis = new FileInputStream(src);
	XSSFWorkbook wb =new XSSFWorkbook(fis);
	XSSFSheet sh1 =wb.getSheet("Sheet1");
	
	DataFormatter df =new DataFormatter();
	
	for(int row=1; row<=totalRow; row++)
	{
		for(int column=0; column<=totalColumn; column++)
	{
		String Nstring =df.formatCellValue(sh1.getRow(row).getCell(column));
		
		System.out.println(Nstring);
	}
	}
}
	public void excelwriteData(int rowNum, int columnNum, String data) throws IOException {
		
		File src = new File ("C:\\Users\\301584\\Desktop\\WriteData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb =new XSSFWorkbook(fis);
	    XSSFSheet sh1 =wb.getSheet("Sheet1");
		
		File fout = new File("C:\\Users\\301584\\Desktop\\WriteData.xlsx");
		FileOutputStream fos =new FileOutputStream(fout);
		sh1.getRow(rowNum).createCell(columnNum).setCellValue(data);
		//sh1.createRow(5).createCell(4).setCellValue("Data2");
		wb.write(fos);
		
	}
	public static void main(String[] args) throws IOException {
		ExcelProgram ep = new ExcelProgram();
		//ep.readData(4, 4);
       // ep.writeData();
		
		ep.excelwriteData(2, 2, "excel");
	}
}
