package BasicTests;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.automationtesting.excelreport.Xl;
import org.xml.sax.SAXException;


public class ExcelGenerate {
	public static void main(String[]args) throws ParserConfigurationException, IOException, SAXException
	{
		try {
			Xl.generateReport("myxslx.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
