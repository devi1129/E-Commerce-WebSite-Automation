package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CucumberScenarioExamples;
import utils.ExcelUtils;
import utils.PropertiesFile;
import utils.TestContextSetUp;

public class Hooks {

	TestContextSetUp testContextSetUp;

	public Hooks(TestContextSetUp tu) {
		this.testContextSetUp = tu;
	}

	@After
	public void afterscenario() {
		testContextSetUp.testBase.getdriver().quit();
	}

	@AfterStep
	public void addscreenshot(Scenario scenario)

	{

		WebDriver driver = testContextSetUp.testBase.getdriver();
		if (scenario.isFailed()) {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			// by apachecommons dependency we can convert file to bytearray

			byte[] filecontent = null;
			try {
				filecontent = FileUtils.readFileToByteArray(src);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			scenario.attach(filecontent, "image/png", "failedstep");
		}
	}

	@Before("@SearchUsingExcelData")
	public void getsearchData() {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		String sheetname = PropertiesFile.getProperty("excel.search.sheet");
			list=getExcelData(sheetname);

		CucumberScenarioExamples.setExamples(list);
	}
    
	

	@Before("@OrderUsingExcelData")
	public void getorderData() {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		String sheetname = PropertiesFile.getProperty("excel.order.sheet");
			list=getExcelData(sheetname);

		CucumberScenarioExamples.setExamples(list);
	}
    
	
	public List<Map<String, String>> getExcelData(String sheetname)
	{
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		int rowcount = ExcelUtils.getRowCount(sheetname);
		int cellcount = ExcelUtils.getCellCount(sheetname);

		

		for (int i = 1; i <= rowcount; i++) {
			Map<String, String> map = new HashMap();

			for (int j = 0; j < cellcount; j++) {
				
				
				String colnameString=ExcelUtils.getCellData(sheetname, 0, j);
				String cellvalue = ExcelUtils.getCellData(sheetname, i, j);
				
				System.out.println(colnameString+""+cellvalue);
				map.put(colnameString, cellvalue.trim());

			}
			list.add(map);
		}
         return list;
	}
}
