package com.selenium.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.google.common.io.Files;



public class BaseClass {
	
	public static WebDriver driver;
	
	public static Map<String,String> locatormap= new HashMap<String,String>();
	public static Map<String,String> inputmap= new HashMap<String,String>();
	
	
	/*
	 * public static void main(String[] args) throws IOException {
	 * 
	 * getDataFromExcelFile(); getLocatorDataFromExcelFile(); }
	 */
	 

	public static String getConfigData(String key) throws IOException
	{
		String value="";
		File f= new File("./src/data/config.properties");
		InputStream iStream= new FileInputStream(f);
		Properties prop=new Properties();
		prop.load(iStream);
		value=prop.getProperty(key);
		
		return value;
	}
	@BeforeSuite
	public static void getLocatorDataFromExcelFile() throws IOException
	{
	
		
		File f= new File("./src/data/input.xlsx");
		FileInputStream iStream= new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(iStream);
		XSSFSheet ws=wb.getSheet("Sheet1");
		int row=ws.getLastRowNum();
		
		 System.out.println(row);
		for(int i=1;i<=row;i++)
			
			  {
		String	page=ws.getRow(i).getCell(0).getStringCellValue();
		String	elementsname=ws.getRow(i).getCell(1).getStringCellValue();
		String	data=ws.getRow(i).getCell(2).getStringCellValue();
		inputmap.put(page+"$"+elementsname, data);
		
		
			  System.out.println(" xpath ="+page+" "+elementsname+" "+data);
			  
			  } 
			 		
		wb.close();
	}
	
	@BeforeSuite
	public static void getDataFromExcelFile() throws IOException
	{
	
		
		File f= new File("./src/data/locatordata.xlsx");
		FileInputStream iStream= new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(iStream);
		XSSFSheet ws=wb.getSheet("Sheet1");
		int row=ws.getLastRowNum();
		
		 System.out.println(row);
		for(int i=1;i<=row;i++)
			
			  {
		String	page=ws.getRow(i).getCell(0).getStringCellValue();
		String	elementsname=ws.getRow(i).getCell(1).getStringCellValue();
		String	data=ws.getRow(i).getCell(2).getStringCellValue();
		locatormap.put(page+"$"+elementsname, data);
		
		
			  System.out.println("Data ="+page+" "+elementsname+" "+data);
			  
			  } 
			 		
		wb.close();
	}
	
	public static void BrowserClose()
	{
		driver.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * public static String getLocatorData(String key) throws IOException { String
	 * value=""; File f= new File("./src/data/locator.prperties"); InputStream
	 * iStream= new FileInputStream(f); Properties prop=new Properties();
	 * prop.load(iStream); value=prop.getProperty(key);
	 * 
	 * return value; }
	 */
	/*
	 * public static String getInputData(String key) throws IOException { String
	 * value=""; File f= new File("./src/data/inputdata.prperties"); InputStream
	 * iStream= new FileInputStream(f); Properties prop=new Properties();
	 * prop.load(iStream); value=prop.getProperty(key);
	 * 
	 * return value; }
	 */
	@BeforeTest
	public static void LaunchBrowser() throws IOException 
	{
		System.out.println("Before suite run");
		String browser= getConfigData("browser");
		String url=getConfigData("url");
		String timeout=getConfigData("timeout");
		int tout=Integer.parseInt(timeout);
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./utilities/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
			
		{
			System.setProperty("webdriver.gecko.driver", "./utilities/geckodriver.exe");
			driver=new ChromeDriver();
		}
		else
		{
			System.out.println("Browser not supported");
		}
		
driver.manage().timeouts().implicitlyWait(tout, TimeUnit.SECONDS);
		
		driver.get(url);
	}
	
	public static void captureScreenShot(String fileName) throws IOException
	{
		

		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dest = new File("./src/results/screenshots/"+fileName+".png");
		
		Files.copy(source, dest);
	}
	
	public static void writeResultsToFile(String testcasename,String status) throws IOException
	{
		
		File f = new File("./src/results/results.txt");
		
		FileWriter fw = new FileWriter(f,true);
		
		fw.write(testcasename+"----> "+status +"\n");
		
		
		fw.flush();
		fw.close();
	}
	@AfterTest
	public static void browserClose()
	{
		System.out.println("After suite");
		BrowserClose();
	}
	 
}

