package progressive_test.ProgressiveInsurance_maven;


import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class ProgressiveInsurance_run {

	@Test 
	public void homepage() throws Exception{
		 WebDriver proges;
		 String nodeurl="http://192.168.1.152:5555/wd/hub";
			String applicationurl = "https://www.progressive.com/";
			String sheetpath="C:\\Users\\prk_m\\Desktop\\Book1.xlsx";
			String sheetname="Sheet1";
			
			DesiredCapabilities cap=DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WIN10);
			
			proges = new RemoteWebDriver(new URL(nodeurl), cap);
			
			
			String[][] xldata1=readxlsheet(sheetpath,sheetname);
	
			for(int k=1;k<xldata1.length;k++) {
				String zipcode=xldata1[k][0];
				String firstname=xldata1[k][1];
				
				proges.navigate().to(applicationurl);
	            
	            Auto_pom a=new Auto_pom(proges);
	            a.auto_button().click();
	            a.zipcodetxtbx().sendKeys(zipcode);
	            a.quoteautobtn().click();
	            proges.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	            a.firstnametxtbx().sendKeys(firstname);
	            String MainWindow=proges.getWindowHandle();		
        					
	            Set<String> s1=proges.getWindowHandles();		
	            Iterator<String> i1=s1.iterator();
	            while(i1.hasNext())			
	            {		
	                String ChildWindow=i1.next();		
	                		
	                if(!MainWindow.equalsIgnoreCase(ChildWindow))			
	                {    		
	                	proges.switchTo().window(ChildWindow).close();
	                	proges.close();
	                }
	            }   
	           }
	}
			
           
	
	public static String[][]  readxlsheet(String sheetlocation, String sheetname) throws Exception{
		String[][] xldata;
		File xlfile=new File(sheetlocation);
		FileInputStream xlstream=new FileInputStream(xlfile);
		XSSFWorkbook xlwb=new XSSFWorkbook(xlstream);
		XSSFSheet xlsheet=xlwb.getSheet(sheetname);
		int x=xlsheet.getLastRowNum()+1;
		int y=xlsheet.getRow(0).getLastCellNum();
		xldata=new String[x][y];
		
		for (int i=0;i<x;i++) {
			   
			for (int j=0;j<y;j++) {
				
				DataFormatter objDefaultFormat = new DataFormatter();
				FormulaEvaluator objFormulaEvaluator = new XSSFFormulaEvaluator((XSSFWorkbook) xlwb);
				XSSFRow row=xlsheet.getRow(i);
				XSSFCell celltype=row.getCell(j);
				objFormulaEvaluator.evaluate(celltype); 
			    String cellValueStr = objDefaultFormat.formatCellValue(celltype,objFormulaEvaluator);		
			    xldata[i][j]= cellValueStr;
			}
			
		}
		
		return xldata;
		
		
	}

}
