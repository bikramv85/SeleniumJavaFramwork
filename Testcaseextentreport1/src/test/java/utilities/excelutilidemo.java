package utilities;

import java.io.IOException;

public class excelutilidemo {
	
	public static void main(String[] args) throws IOException {
		
		String projectPath = System.getProperty("user.dir");
		excelutils excel = new excelutils(projectPath+"/Excel/Testdata3.xls", "Test");
		excel.getRowcount();
		excel.getcelldatastring(0, 0);
		excel.getcelldatanum(1,1);
	}

}
