package com.selenium.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.selenium.base.BaseClass;

public class Login extends BaseClass {
	public static int i=0;
/*static {
		
		try {
			getDataFromExcelFile(); 
			getLocatorDataFromExcelFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	*/

	//public static void main(String[] args) throws IOException {
	
		
	//}
	@Test(priority=0)
	public static void login_AT_001() throws IOException {
		
		System.out.println("Test case 1");
		 //LaunchBrowser();
		 boolean result = false;	
		  try
		  {
		  driver.findElement(By.xpath(locatormap.get("Login$UserName_Editbox"))).
		  sendKeys(inputmap.get("Login$UserName_Editbox"));
		  
		  driver.findElement(By.xpath(locatormap.get("Login$Password_Editbox"))).
		  sendKeys(inputmap.get("Login$Password_Editbox"));
		  
		  driver.findElement(By.xpath(locatormap.get("Login$Login_Button"))).click();
		//  BrowserClose();
		  
		  
		  result = driver.findElement(By.xpath(locatormap.get("Home$Logout_Link"))).isDisplayed();
			
			
			
			if (result)
			{
				System.out.println("Login_001 is passed");
				writeResultsToFile("Login_001","PASS");
			}
			else
			{
				captureScreenShot("login_AT_001");
				System.out.println("Login_001 is Failed!!");
				writeResultsToFile("Login_001","FAILED!!!");
			}
		 }
			catch(Exception e)
			{
				captureScreenShot("login_AT_001");
				System.out.println("Login_001 is Failed!!");
				writeResultsToFile("Login_001","FAILED!!!");
			}
		  finally
		  {
			  driver.findElement(By.xpath(locatormap.get("Home$Logout_Link"))).click();
		  }
	}
	@Test(priority=2)
	public static void login_AT_002() throws IOException {
		
		System.out.println("Test case 2");
	//	 LaunchBrowser();
		 boolean result = false;	
		 try {
		  
		  driver.findElement(By.xpath(locatormap.get("Login$UserName_Editbox"))).
		  sendKeys(inputmap.get("Login$UserName_Editbox"));
		  
		  driver.findElement(By.xpath(locatormap.get("Login$Password_Editbox"))).
		  sendKeys(inputmap.get("Login$Password_Editbox"));
		  
		  driver.findElement(By.xpath(locatormap.get("Login$Login_Button"))).click();
		  
		  driver.findElement(By.xpath(locatormap.get("Home$Tasks_link"))).click();
		 
		  
		  driver.findElement(By.xpath(locatormap.get("Home$Add_New_Task"))).click();
		 
		  
		  driver.findElement(By.xpath(locatormap.get("Home$Add_New_Customer"))).click();
		  
		 
		  driver.findElement(By.xpath(locatormap.get("Customer$CustomerName_Editbox"))).
		  sendKeys(inputmap.get("Customer$CustomerName_Editbox")+i++);
	  
		  driver.findElement(By.xpath(locatormap.get("Customer$CustomerDescription_TextArea"))).
		  sendKeys(inputmap.get("Customer$CustomerDescription_TextArea"));
		  
		  driver.findElement(By.xpath(locatormap.get("Customer$CreateCustomer_Button"))).click();
		  
		//  BrowserClose();
	  result = driver.findElement(By.xpath(locatormap.get("Home$Logout_Link"))).isDisplayed();
			
			
			
			if (result)
			{
				System.out.println("Login_002 is passed");
				writeResultsToFile("Login_002","PASS");
			}
			else
			{
				captureScreenShot("login_AT_002");
				System.out.println("Login_002 is Failed!!");
				writeResultsToFile("Login_002","FAILED!!!");
			}
		 }
			catch(Exception e)
			{
				captureScreenShot("login_AT_002");
				System.out.println("Login_002 is Failed!!");
				writeResultsToFile("Login_002","FAILED!!!");
			}
			
		 finally
		  {
			  driver.findElement(By.xpath(locatormap.get("Home$Logout_Link"))).click();
		  }
			
		//	BrowserClose();
	}
	@Test(priority=1)
	public static void login_AT_003() throws IOException {
		System.out.println("Test case 3");
		
		 //LaunchBrowser();
		 boolean result = false;	
		 try {
		  
		  driver.findElement(By.xpath(locatormap.get("Login$UserName_Editbox"))).
		  sendKeys(inputmap.get("Login$UserName_Editbox"));
		  
		  driver.findElement(By.xpath(locatormap.get("Login$Password_Editbox"))).
		  sendKeys(inputmap.get("Login$Password_Editbox"));
		  
		  driver.findElement(By.xpath(locatormap.get("Login$Login_Button"))).click();
		  
		  driver.findElement(By.xpath(locatormap.get("Home$Tasks_link"))).click();
		 
		  
		  driver.findElement(By.xpath(locatormap.get("Home$Add_New_Task"))).click();
		 
		  
		  driver.findElement(By.xpath(locatormap.get("Home$Add_New_Project"))).click();
		  
		  
		  driver.findElement(By.xpath(locatormap.get("Project$ProjectName_Editbox"))).
		  sendKeys(inputmap.get("Project$ProjectName_Editbox")+i++);
		  
		  
		  
		  driver.findElement(By.xpath(locatormap.get("Project$Select_Customer"))).click();
		//  sendKeys(inputmap.get("Project$Select_Customer")).click();
		  
		   
			
			/*
			 * WebElement dropdown= driver.findElement(By.xpath(
			 * "//*[@id=\"createProjectPopup_content\"]/div[2]/div[1]/div/div[1]/div[1]/div[2]/div[2]/div/div[1]/div[2]/div/div[1]/input"
			 * ));
			 * 
			 * Select selec=new Select(dropdown); selec.getOptions();
			 * selec.selectByIndex(1);
			 * 
			 * 
			 */
		    driver.findElement(By.xpath("//*[@id=\"createProjectPopup_content\"]/div[2]/div[1]/div/div[1]/div[1]/div[2]/div[2]/div/div[2]/div/div[1]/div/div[2]")).click();
		  
		  
		  
		  
		  
		  
			/*
			 * WebElement dropdown=
			 * driver.findElement(By.xpath("Customer$Select_Customer"));
			 * 
			 * 
			 * Select comboSelect= new Select(dropdown);
			 * comboSelect.deselectByVisibleText("JEC_Manage");
			 * 
			 * System.out.println(comboSelect.getOptions().size());
			 */
		  
		  
		  
		  driver.findElement(By.xpath(locatormap.get("Project$ProjectDescription_EditBox"))).
		  sendKeys(inputmap.get("Project$ProjectDescription_EditBox"));
		  
		  driver.findElement(By.xpath(locatormap.get("Project$CreateProject_Button"))).click();
		  
		//  BrowserClose();
	  result = driver.findElement(By.xpath(locatormap.get("Home$Logout_Link"))).isDisplayed();
			
			
			
			if (result)
			{
				System.out.println("Login_003 is passed");
				writeResultsToFile("Login_003","PASS");
			}
			else
			{
				captureScreenShot("login_AT_003");
				System.out.println("Login_003 is Failed!!");
				writeResultsToFile("Login_003","FAILED!!!");
			}
		 }
			catch(Exception e)
			{
				captureScreenShot("login_AT_003");
				System.out.println("Login_003 is Failed!!");
				writeResultsToFile("Login_003","FAILED!!!");
			}
			
		 finally
		  {
			  driver.findElement(By.xpath(locatormap.get("Home$Logout_Link"))).click();
		  }
			
		//	BrowserClose();
	}
	@Test
	public static void login_AT_004() throws IOException {
		System.out.println("test case 4");
		 //LaunchBrowser();
		 boolean result = false;	
		 try {
		  
		  driver.findElement(By.xpath(locatormap.get("Login$UserName_Editbox"))).
		  sendKeys(inputmap.get("Login$UserName_Editbox"));
		  
		  driver.findElement(By.xpath(locatormap.get("Login$Password_Editbox"))).
		  sendKeys(inputmap.get("Login$Password_Editbox"));
		  
		  driver.findElement(By.xpath(locatormap.get("Login$Login_Button"))).click();
		  
		  driver.findElement(By.xpath(locatormap.get("Home$Tasks_link"))).click();
		 
		  
		  driver.findElement(By.xpath(locatormap.get("Home$Add_New_Task"))).click();
		 
		  
		  driver.findElement(By.xpath(locatormap.get("Home$Add_New_Project"))).click();
		  
		  
		  driver.findElement(By.xpath(locatormap.get("Project$ProjectName_Editbox"))).
		  sendKeys(inputmap.get("Project$ProjectName_Editbox")+i++);
		  
		  
		  
		  driver.findElement(By.xpath(locatormap.get("Project$Select_Customer"))).click();
		//  sendKeys(inputmap.get("Project$Select_Customer")).click();
		  
		   
			
			/*
			 * WebElement dropdown= driver.findElement(By.xpath(
			 * "//*[@id=\"createProjectPopup_content\"]/div[2]/div[1]/div/div[1]/div[1]/div[2]/div[2]/div/div[1]/div[2]/div/div[1]/input"
			 * ));
			 * 
			 * Select selec=new Select(dropdown); selec.getOptions();
			 * selec.selectByIndex(1);
			 * 
			 * 
			 */
		    driver.findElement(By.xpath("//*[@id=\"createProjectPopup_content\"]/div[2]/div[1]/div/div[1]/div[1]/div[2]/div[2]/div/div[2]/div/div[1]/div/div[2]")).click();
		  
		  
		  
		  
		  
		  
			/*
			 * WebElement dropdown=
			 * driver.findElement(By.xpath("Customer$Select_Customer"));
			 * 
			 * 
			 * Select comboSelect= new Select(dropdown);
			 * comboSelect.deselectByVisibleText("JEC_Manage");
			 * 
			 * System.out.println(comboSelect.getOptions().size());
			 */
		  
		  
		  
		  driver.findElement(By.xpath(locatormap.get("Project$ProjectDescription_EditBox"))).
		  sendKeys(inputmap.get("Project$ProjectDescription_EditBox"));
		  
		  driver.findElement(By.xpath(locatormap.get("Project$CreateProject_Button"))).click();
		  
		//  BrowserClose();
	  result = driver.findElement(By.xpath(locatormap.get("Home$Logout_Link"))).isDisplayed();
			
			
			
			if (result)
			{
				System.out.println("Login_004 is passed");
				writeResultsToFile("Login_004","PASS");
			}
			else
			{
				captureScreenShot("login_AT_004");
				System.out.println("Login_004 is Failed!!");
				writeResultsToFile("Login_004","FAILED!!!");
			}
		 }
			catch(Exception e)
			{
				captureScreenShot("login_AT_004");
				System.out.println("Login_004 is Failed!!");
				writeResultsToFile("Login_004","FAILED!!!");
			}
			
			
		//	BrowserClose();
	}
	
	
	
}

