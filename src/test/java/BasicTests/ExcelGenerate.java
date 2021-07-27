package BasicTests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import org.automationtesting.excelreport.Xl;
import org.testng.TestNG;
import org.xml.sax.SAXException;


public class ExcelGenerate {
	public static void main(String[]args) throws ParserConfigurationException, IOException, SAXException
	{
		
		TestNG runner=new TestNG();

		List<String> suitefiles=new ArrayList<>();

		suitefiles.add("C:\\Users\\neha_patil5\\Documents\\workspace-spring-tool-suite-4-4.7.0.RELEASE\\ArchUnitDemo\\testng.xml");

		runner.setTestSuites(suitefiles);

		runner.run();
		
		try {
			Xl.generateReport("myxslx.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
