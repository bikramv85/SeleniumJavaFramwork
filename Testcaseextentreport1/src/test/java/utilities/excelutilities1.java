	package utilities;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;

	import org.apache.poi.hssf.usermodel.HSSFSheet;
	import org.apache.poi.hssf.usermodel.HSSFWorkbook;


	public class excelutilities1 {
		
		public static void main (String[] args) {
			try {
				getRowcount();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
				
		public static void getRowcount() throws IOException {
						
			
			try {
				FileInputStream inputStream;
				String projectPath = System.getProperty("user.dir");
				String excelfilepath = projectPath+"Excel/Testdata2.xls";
				inputStream = new FileInputStream(new File(excelfilepath));
				HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
				HSSFSheet sheet = workbook.getSheet("Test");
				int rowCount = sheet.getPhysicalNumberOfRows();
				System.out.println("this is the rowcount"+rowCount);
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.getMessage();
				e.getCause();
				e.printStackTrace();
			}
		
			
		}

	}

