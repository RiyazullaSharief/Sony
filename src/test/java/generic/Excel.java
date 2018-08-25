package generic;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.Reporter;
public class Excel
{
	public static String getCellValue(String PATH,String Sheet,int row,int cell)
	{
		String v=" ";
		try
		{
			FileInputStream fis=new FileInputStream(PATH);
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sh=wb.getSheet(Sheet);
			Row r=sh.getRow(row);
			Cell c=r.getCell(cell);
			v=c.getStringCellValue();
			//v=c.toString();
		}
		catch(Exception e)
		{
			Reporter.log("Path is invalid",true);
			Assert.fail();
		}
		return v;
	}
}
