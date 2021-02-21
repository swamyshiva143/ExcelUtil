package excel.test;

import com.excel.util.Xls_Reader;

public class ExcelUtilTest {

	public static void main(String[] args) {
	
		Xls_Reader reader= new Xls_Reader("D:\\Swamyshiva\\swamyshiva\\ExcelUtil\\src\\main\\java\\excel\\test\\ExcelUtilTest.xlsx");
		String sheetName="login";
		
		System.out.println(reader.getCellData(sheetName, "username", 3));
		String data= reader.getCellData(sheetName, 0, 2);
		System.out.println(data);
		 
		int rowCount= reader.getRowCount(sheetName);
		System.out.println("Total no. of rows:--"+ rowCount);
		
	//	reader.addColumn(sheetName, "Status");
		
		if(!reader.isSheetExist("Registration")) {
			reader.addSheet("Registration");
		}
	
		reader.setCellData(sheetName, "Status", 2, "Pass");
		
		System.out.println(reader.getColumnCount(sheetName));
		
		//reader.removeColumn("Registration", 0);
		
		System.out.println(reader.getCellData("Registration", "phonenumber", 2));
		System.out.println(reader.getCellData("Registration", "age", 2));
		
		

	}

}
