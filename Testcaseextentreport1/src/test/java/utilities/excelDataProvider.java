package utilities;

import java.io.IOException;

public class excelDataProvider {

	public void testdata(String excelpath, String sheetname) {

		excelutils excel = new excelutils(excelpath, sheetname);
		int rowcount = excel.getRowcount();
		int colcount = excel.getColcount();
		
		for (int i=1; )

	}

}
