package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class excelutils {

	static String projectPath;
	static String excelfilepath;
	static HSSFWorkbook workbook;
	static HSSFSheet sheet ;
	static FileInputStream inputStream;

	public excelutils(String excelpath, String sheetname) throws IOException {

		//projectPath = System.getProperty("user.dir");
		//excelfilepath = projectPath+"/Excel/Testdata3.xls";
		//String excelfilepath = "C:\\Users\\Nivedita\\Desktop\\Testdata3.xls";
		excelfilepath = excelpath;

		inputStream = new FileInputStream(new File(excelfilepath));
		workbook = new HSSFWorkbook(inputStream);
		//sheet = workbook.getSheet("Test");
		sheet = workbook.getSheet(sheetname);

	}


	public static void main (String[] args) {
		try {
			getRowcount();
			getcelldatastring(0, 0);
			getcelldatanum(1, 1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static int getRowcount() {
		int rowCount = 0;

		//projectPath = System.getProperty("user.dir");
		//excelfilepath = projectPath+"/Excel/Testdata3.xls";
		//String excelfilepath = "C:\\Users\\Nivedita\\Desktop\\Testdata3.xls";

		//inputStream = new FileInputStream(new File(excelfilepath));
		//workbook = new HSSFWorkbook(inputStream);
		//sheet = workbook.getSheet("Test");
		try {
			rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("The rowcount is : " + rowCount);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.getCause());

		}
		return rowCount;

	}

	public static int getColcount()  {
		int colCount = 0;

		//projectPath = System.getProperty("user.dir");
		//excelfilepath = projectPath+"/Excel/Testdata3.xls";
		//String excelfilepath = "C:\\Users\\Nivedita\\Desktop\\Testdata3.xls";

		//inputStream = new FileInputStream(new File(excelfilepath));
		//workbook = new HSSFWorkbook(inputStream);
		//sheet = workbook.getSheet("Test");

		try {

			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("The rowcount is : " + colCount);
		}		
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.getCause());

		}
		return colCount;

	}


	public static void getcelldatastring(int rowNum, int colNum) throws IOException {

		String celldata = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		System.out.println(celldata);


	}


	public static void getcelldatanum(int rowNum, int colNum) throws IOException {

		double celldata = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		System.out.println(celldata);


	}

}
