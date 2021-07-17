package com.webauto.tests.utils;

import java.util.ArrayList;
import java.util.List;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import com.webauto.framework.baseinfo.Application;

import java.io.File;
import org.apache.commons.lang.ArrayUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataProviderSource {

	@DataProvider(name = "TestData_Provider")
	public static Object[][] getDataFromTestData_Provider(ITestContext context) throws Exception {
		Object[][] data = new Object[][] {};
		Workbook book = new XSSFWorkbook(new File("./src/test/resources/testdata_provider.xlsx"));
		Sheet sheet = book.getSheet("Auto_TestData");
		// column headings at the first row is not required
		//
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			DataFormatter formatter = new DataFormatter();
			Row row = sheet.getRow(i);
			if (!formatter.formatCellValue(row.getCell(0)).isEmpty()) {
				List<String> app_details_list = new ArrayList<>();
				for (int j = 0; j <= row.getLastCellNum(); j++) {
					app_details_list.add(formatter.formatCellValue(row.getCell(j)));
				}
				Application application = new Application(app_details_list);
				data = (Object[][]) ArrayUtils.add(data, new Object[] { application });
			}
		}
		book.close();
		return data;
	}

	@DataProvider(name = "AutoTestData_Provider")
	public static Object[][] getDataForHotelTestData_Provider(ITestContext context) throws Exception {
		int dataSize = 2;
		Object[][] data = new Object[dataSize][1];
		Object[][] indata = getDataFromTestData_Provider(context);
		for (int i = 0; i < dataSize; i++) {
			data[i][0] = indata[i][0];
		}
		return data;
	}

}
