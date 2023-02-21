package dbconnection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MemoryManagementCommonData {
	
	Properties prop = new Properties();
	 
	String filepathECData = System.getProperty("user.dir")+"\\ECData.xlsx";
	String filepathFCData = System.getProperty("user.dir")+"\\FCData.xlsx";
	
	public String ecexcelreadData(int row, int column) throws IOException
	//public static void main(String[] args) throws IOException 
	{
		//String filepathECData = System.getProperty("user.dir")+"\\ECData.xlsx";
		
	File src = new File  (filepathECData);
	FileInputStream fis = new FileInputStream(src);
	XSSFWorkbook wb =new XSSFWorkbook(fis);
	XSSFSheet sh1 =wb.getSheet("Sheet1");
	
	DataFormatter df =new DataFormatter();
	String Nstring =df.formatCellValue(sh1.getRow(row).getCell(column));
	System.out.println("EC excel read"+Nstring);
	return Nstring;
	
//	for(int row=1; row<=totalRow; row++)
//	{
//		for(int column=0; column<=totalColumn; column++)
//	{
//		String Nstring =df.formatCellValue(sh1.getRow(row).getCell(column));
//		
//		System.out.println(Nstring);
//	}
//	}
}
	public String fcexcelreadData(int row, int column) throws IOException
	//public static void main(String[] args) throws IOException 
	{
		
	File src = new File (filepathFCData);
	FileInputStream fis = new FileInputStream(src);
	XSSFWorkbook wb =new XSSFWorkbook(fis);
	XSSFSheet sh1 =wb.getSheet("Sheet1");
	
	DataFormatter df =new DataFormatter();
	String Nstring =df.formatCellValue(sh1.getRow(row).getCell(column));
	System.out.println("FC excel read"+Nstring);
	return Nstring;
	
//	for(int row=1; row<=totalRow; row++)
//	{
//		for(int column=0; column<=totalColumn; column++)
//	{
//		String Nstring =df.formatCellValue(sh1.getRow(row).getCell(column));
//		
//		System.out.println(Nstring);
//	}
//	}
}
	public void fcexcelwriteData(String FCVal, String BillId, String CCBFC, String FCSum) throws IOException {
		
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");
        Row row0 = sheet.createRow(0);
        Row row1 = sheet.createRow(1);
        Cell cell0 = row0.createCell(0);
        Cell cell1 = row0.createCell(1);
        Cell cell2 = row0.createCell(2);
       Cell cell3 = row0.createCell(3);
        Cell cellval0 = row1.createCell(0);
        Cell cellval1 = row1.createCell(1);
        Cell cellval2 = row1.createCell(2);
      Cell cellval3 = row1.createCell(3);
        
        
        cell0.setCellValue("Bill ID");
        cell1.setCellValue("Manual FC Value");
        cell2.setCellValue("CCB FC Value");
        cell3.setCellValue("FC Summary");
        cellval0.setCellValue(BillId);
        cellval1.setCellValue(FCVal);
        cellval2.setCellValue(CCBFC);
       cellval3.setCellValue(FCSum);
        
        
        FileOutputStream fileOut = new FileOutputStream(filepathFCData);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
    }
public void ecexcelwriteData(String ECVal, String BillId, String CCBEC, String ECSum) throws IOException {
		
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");
        Row row0 = sheet.createRow(0);
        Row row1 = sheet.createRow(1);
        Cell cell0 = row0.createCell(0);
        Cell cell1 = row0.createCell(1);
        Cell cell2 = row0.createCell(2);
       Cell cell3 = row0.createCell(3);
        Cell cellval0 = row1.createCell(0);
        Cell cellval1 = row1.createCell(1);
        Cell cellval2 = row1.createCell(2);
      Cell cellval3 = row1.createCell(3);
        
        cell0.setCellValue("Bill ID");
        cell1.setCellValue("Manual EC Value");
        cell2.setCellValue("CCB EC Value");
      cell3.setCellValue("EC Summary");
        cellval0.setCellValue(BillId);
        cellval1.setCellValue(ECVal);
        cellval2.setCellValue(CCBEC);
       cellval3.setCellValue(ECSum);
        
        FileOutputStream fileOut = new FileOutputStream(filepathECData);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
    }

	//private JTable table_8;
	public static void commonDataThreeColumns(String query, JTable tableName) throws ClassNotFoundException, SQLException {
		try{ 
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.101.0.248:1817:ccbdev", "cisopr", "lQS*7E!#19yd");
		System.out.println("Connected to the database");
		Statement st=con.createStatement();
		ResultSet rs= st.executeQuery(query);
        ResultSetMetaData rsmd=rs.getMetaData();
     
        DefaultTableModel model = (DefaultTableModel) tableName.getModel();
        
        int cols=rsmd.getColumnCount();
        String[] colName= new String[cols];
        for (int i=0; i<cols;i++)
           colName[i]=rsmd.getColumnName(i+1);
        model.setColumnIdentifiers(colName);
        String COL1,COL2, COL3;
         while(rs.next()) {
      	   COL1=rs.getString(1);
           // ACCT_ID=rs.getInt(2);
      	   COL2=rs.getString(2);
      	   COL3=rs.getString(3);
            String [] row= {COL1,COL2,COL3};
           model.addRow(row);
           
           
         }
        
		} catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
      }
		
	}
	public static void commonDataTwoColumns(String query, JTable tableName) throws ClassNotFoundException, SQLException {
		try{ 
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.101.0.248:1817:ccbdev", "cisopr", "lQS*7E!#19yd");
		System.out.println("Connected to the database");
		Statement st=con.createStatement();
		ResultSet rs= st.executeQuery(query);
        ResultSetMetaData rsmd=rs.getMetaData();
     
        DefaultTableModel model = (DefaultTableModel) tableName.getModel();
        
        int cols=rsmd.getColumnCount();
        String[] colName= new String[cols];
        for (int i=0; i<cols;i++)
           colName[i]=rsmd.getColumnName(i+1);
        model.setColumnIdentifiers(colName);
        String COL1,COL2;
         while(rs.next()) {
      	   COL1=rs.getString(1);
           // ACCT_ID=rs.getInt(2);
      	   COL2=rs.getString(2);
            String [] row= {COL1,COL2};
           model.addRow(row);
         }
		} catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
      }
		
	}
	
	public void commonDataTenColumns(String query, JTable tableName) throws ClassNotFoundException {
		
		try{ 
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.101.0.248:1817:ccbdev", "cisopr", "lQS*7E!#19yd");
		System.out.println("Connected to the database");
		Statement st=con.createStatement();
		ResultSet rs= st.executeQuery(query);
        ResultSetMetaData rsmd=rs.getMetaData();
     
        DefaultTableModel model = (DefaultTableModel) tableName.getModel();
        
        int cols=rsmd.getColumnCount();
        String[] colName= new String[cols];
        for (int i=0; i<cols;i++)
           colName[i]=rsmd.getColumnName(i+1);
        model.setColumnIdentifiers(colName);
        model.addColumn("My Result");
        
        
        String COL1,COL2, COL3, COL4, COL5,COL6,COL7,COL8,COL9,COL10;
         while(rs.next()) {
        	 
        	 
      	   COL1=rs.getString(1);
           // ACCT_ID=rs.getInt(2);
      	   COL2=rs.getString(2);
      	   COL3=rs.getString(3);
      	 COL4=rs.getString(4);
      	COL5=rs.getString(5);
      	COL6=rs.getString(6);
      	COL7=rs.getString(7);
      	COL8=rs.getString(8);
      	COL9=rs.getString(9);
      	COL10=rs.getString(10);
      	
            String [] row= {COL1,COL2,COL3, COL4, COL5,COL6,COL7,COL8,COL9,COL10};
           model.addRow(row);
        	
         }
		} catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
      }
		
	}
public void commonDataEightColumns(String query, JTable tableName) throws ClassNotFoundException {
		
		try{ 
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.101.0.248:1817:ccbdev", "cisopr", "lQS*7E!#19yd");
		System.out.println("Connected to the database");
		Statement st=con.createStatement();
		ResultSet rs= st.executeQuery(query);
        ResultSetMetaData rsmd=rs.getMetaData();
     
        DefaultTableModel model = (DefaultTableModel) tableName.getModel();
        
        int cols=rsmd.getColumnCount();
        String[] colName= new String[cols];
        for (int i=0; i<cols;i++)
           colName[i]=rsmd.getColumnName(i+1);
        model.setColumnIdentifiers(colName);
        model.addColumn("FC/EC SUMMARY");
        model.addColumn("BSQ_RESULT");
        model.addColumn("FC/EC_RESULT");
        
        
        String COL1,COL2, COL3, COL4, COL5,COL6,COL7,COL8;
         while(rs.next()) {
        	 
        	 
      	   COL1=rs.getString(1);
           // ACCT_ID=rs.getInt(2);
      	   COL2=rs.getString(2);
      	   COL3=rs.getString(3);
      	 COL4=rs.getString(4);
      	COL5=rs.getString(5);
      	COL6=rs.getString(6);
      	COL7=rs.getString(7);
      	COL8=rs.getString(8);
      	
      	
            String [] row= {COL1,COL2,COL3, COL4, COL5,COL6,COL7,COL8};
           model.addRow(row);
        	
         }
		} catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
      }
		
	}

public void commonDataTwentyFiveColumns(String query, JTable tableName) throws ClassNotFoundException {
		
		try{ 
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.101.0.248:1817:ccbdev", "cisopr", "lQS*7E!#19yd");
		System.out.println("Connected to the database");
		Statement st=con.createStatement();
		ResultSet rs= st.executeQuery(query);
        ResultSetMetaData rsmd=rs.getMetaData();
     
        DefaultTableModel model = (DefaultTableModel) tableName.getModel();
        
        int cols=rsmd.getColumnCount();
        String[] colName= new String[cols];
        for (int i=0; i<cols;i++)
           colName[i]=rsmd.getColumnName(i+1);
        model.setColumnIdentifiers(colName);
        
        String COL1,COL2, COL3, COL4, COL5,COL6,COL7,COL8,COL9,COL10,COL11,COL12,COL13,COL14,COL15,COL16,COL17,COL18,COL19,
        COL20,COL21,COL22,COL23,COL24,COL25;
         while(rs.next()) {
      	   COL1=rs.getString(1);
           // ACCT_ID=rs.getInt(2);
      	   COL2=rs.getString(2);
      	   COL3=rs.getString(3);
      	 COL4=rs.getString(4);
      	COL5=rs.getString(5);
      	COL6=rs.getString(6);
      	COL7=rs.getString(7);
      	COL8=rs.getString(8);
      	COL9=rs.getString(9);
      	COL10=rs.getString(10);
      	COL11=rs.getString(11);
      	COL12=rs.getString(12);
      	COL13=rs.getString(13);
      	COL14=rs.getString(14);
      	COL15=rs.getString(15);
      	COL16=rs.getString(16);
      	COL17=rs.getString(17);
      	COL18=rs.getString(18);
      	COL19=rs.getString(19);
      	COL20=rs.getString(20);
      	COL21=rs.getString(21);
      	COL22=rs.getString(22);
      	COL23=rs.getString(23);
      	COL24=rs.getString(24);
      	COL25=rs.getString(25);
      	
      	
      	
      	
            String [] row= {COL1,COL2,COL3, COL4, COL5,COL6,COL7,COL8,COL9,COL10,COL11,COL12,COL13,
            		COL14,COL15,COL16,COL17,COL18,COL19,COL20,COL21,COL22,COL23,COL24,COL25};
           model.addRow(row);
         }
		} catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
      }

	}

 public void fcTableValue(int CIndex, int RIndex, JTable tableVar) throws IOException {
	 
	 int columnIndex = CIndex; 
     TableModel model2 = tableVar.getModel();
    String ManualFC= (String) model2.getValueAt(RIndex, CIndex);

	  int IntManualFC = Integer.parseInt(ManualFC);
    System.out.println("Int Manual FC = "+IntManualFC); 
    
 //   fcexcelwriteData(2, 2, ManualFC);
    
 }
 public void ecTableValue(int CIndex, int RIndex, JTable tableVar) {
	 
	 int columnIndex = CIndex; 
     TableModel model2 = tableVar.getModel();
    String ManualEC= (String) model2.getValueAt(RIndex, CIndex);

	  int IntManualEC = Integer.parseInt(ManualEC);
    System.out.println("Int Manual EC = "+IntManualEC); 
}

 public String CCBED (String query) throws SQLException {
	 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.101.0.248:1817:ccbdev", "cisopr", "lQS*7E!#19yd");
		Statement st=con.createStatement();
		ResultSet resultSet = st.executeQuery(query);
		
		    resultSet.next();
			String CCBED = resultSet.getString("CALC_AMT");

         System.out.println("calc amt: "+CCBED);

	 return CCBED;
 }
 public String FCSummary (String query) throws SQLException {
	 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.101.0.248:1817:ccbdev", "cisopr", "lQS*7E!#19yd");
		Statement st=con.createStatement();
		ResultSet resultSet = st.executeQuery(query);
		
		    resultSet.next();
			String FCSummary = resultSet.getString("FC_SUMMARY");

         System.out.println("FC Summary: "+FCSummary);

	 return FCSummary;
 }
 public String TotalSummary (String query) throws SQLException {
	 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.101.0.248:1817:ccbdev", "cisopr", "lQS*7E!#19yd");
		Statement st=con.createStatement();
		ResultSet resultSet = st.executeQuery(query);
		
		    resultSet.next();
			String TotalSummary = resultSet.getString("TOTAL_SUMMARY");

         System.out.println("Total Summary: "+TotalSummary);

	 return TotalSummary;
 }
}

