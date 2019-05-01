import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class excelDb {
	
	public static void main(String args[])throws SQLException
	{
				//// HashMap<Integer,String> hm=new HashMap<Integer,String>();  
		 //List<String> list=new ArrayList<String>();
		try
		{
			//step1 load the driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//step 2 create the connection object
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","rama");
			//step3 create the statement object
			Statement stmt=con.createStatement();
			//step4 execute querry
			
			ResultSet rs=stmt.executeQuery("select * from employee");
			HSSFWorkbook workbook = new HSSFWorkbook();
			String yemi = "g:/test.xls";
		    HSSFSheet sheet = workbook.createSheet("lawix10");
		    HSSFRow rowhead = sheet.createRow((short) 0);
		    rowhead.createCell((short) 0).setCellValue("ENAME");
		    rowhead.createCell((short) 1).setCellValue("NO");
		    rowhead.createCell((short) 2).setCellValue("SAL");
			//excelDb.createExcelSheet();
			
		    int i = 1;
		   while (rs.next()){
		        HSSFRow row = sheet.createRow((short) i);
		        row.createCell((short) 0).setCellValue(rs.getString(1));
		        row.createCell((short) 1).setCellValue(rs.getString(2));
		        row.createCell((short) 2).setCellValue(rs.getString(3));
		        System.out.println();
		        i++;
		    }
		    //String yemi = "g:/test.xls";
		    FileOutputStream fileOut = new FileOutputStream(yemi);
		    workbook.write(fileOut);
		    fileOut.close();
		 
		/*	while(rs.next()){
				
			String r=rs.getString(1);
			String no=rs.getString(2);
			int sal=rs.getInt(3);
			System.out.println("Name:"+r+"no:"+no+"sal:"+sal);
			
				hm.put(1, rs.getString(1));
				hm.put(2, rs.getString(2));
				hm.put(3, rs.getString(3));
			
			//list.add(rs.getString(1));
		
			}*/
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		//for(String s:list){
			//System.out.println(s);
		}
	
	
	public static void createExcelSheet(){
		HSSFWorkbook workbook = new HSSFWorkbook();
		String yemi = "g:/test.xls";
	    HSSFSheet sheet = workbook.createSheet("lawix10");
	    HSSFRow rowhead = sheet.createRow((short) 0);
	    rowhead.createCell((short) 0).setCellValue("ENAME");
	    rowhead.createCell((short) 1).setCellValue("NO");
	    rowhead.createCell((short) 2).setCellValue("SAL");
	}
	}



