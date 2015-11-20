package Main;
import Handlers.RadioHandler;
import Handlers.WindowHandler;
import Handlers.AlertHandler;

import Handlers.DropDownHandler;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest; 
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class ReflectionClassNew {  
	Boolean abc;
	
	
	/*@Test
	public void callmain() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException
	{
		TestNG_Initiate TNG= new TestNG_Initiate();
		TNG.verifyBookTicketFromStartToEnd();
	}*/
	private static WebDriver driver; 
	ReflectionClassNew()
	{
	 
	 driver= new FirefoxDriver();    
	}
	
	public static void callMethods(String Action, String Property, String PropertyValue, String RealValue ) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Method methods =  ReflectionClassNew.class.getMethod(Action, String.class,String.class,String.class);
	    methods.invoke(Action,Property, PropertyValue,RealValue);
	}
	//@Test(priority=0)
	public static void getURL(String Property,String PropertyValue, String RealValue)
 	{
		driver.get(RealValue);
		 String ExpectedTitle="Welcome: Mercury Tours";
		 String ActualTitle= driver.getTitle(); 
		// Assert.assertEquals(ExpectedTitle, ActualTitle);    
		
		//System.out.println("Title on URL Page is-\t"+ActualTitle );
		
		/*if((ExpectedTitle).equalsIgnoreCase(ActualTitle))
		{
			System.out.println("Get URL Method Passed\n"); 
		}   
		else  
		{ 
			System.out.println("Get URL Method Failed\n");
		}*/
	} 
	
  
	
	public static void enterText(String Property,String PropertyValue, String RealValue)
	{
		if(Property.equalsIgnoreCase("name")) 
		{
			
			driver.findElement(By.name(PropertyValue)).sendKeys(RealValue);
		}
	}  
	//@Test(priority=1)
	public static void login(String Property,String PropertyValue, String RealValue)
	{
		//System.out.println(Property);
		if(Property.equals("name"))
		{ 
		 driver.findElement(By.name(PropertyValue)).click(); 
		 
		} 
		String ExpectedTitleLogin= "Find a Flight: Mercury Tours:";
		String ActualTitleLogin=driver.getTitle(); 
		Assert.assertEquals(ActualTitleLogin, ExpectedTitleLogin);
		/*System.out.println("Title on login page is-\t"+ ActualTitleLogin); 
		if(ExpectedTitleLogin.equalsIgnoreCase(ActualTitleLogin)) 
		{
			System.out.println("Login Method Passed\n");
		}*/ 
		 
	}   
	
	public static void selectRadio(String Property,String PropertyValue, String RealValue)
	{
		RadioHandler rdo= new RadioHandler();
		if(Property.equals("name"))
		{
			rdo.selectRadiobuttonByName(driver, PropertyValue, RealValue);
		 
		}
		else if(Property.equals("xpath"))
		{
		  
		 rdo.selectRadiobuttonByxpath(driver, PropertyValue, RealValue);
		}
		 
	}
	public static void selectDropDown(String Property,String PropertyValue, String RealValue)
	{
		DropDownHandler drp = new DropDownHandler();
		if(Property.equals("name"))
		{
			drp.selectDropDownValueByName(driver, PropertyValue, RealValue);
		}
		else if(Property.equals("xpath"))
		{
			drp.selectDropDownValueByXpath(driver, PropertyValue, RealValue);
		} 
		
	}
	
	public static void click(String Property,String PropertyValue, String RealValue)
	{
		//System.out.println("We are inside click method!");
		if(Property.equals("name"))  
		{ 
		 driver.findElement(By.name(PropertyValue)).click();
		 }
		else if(Property.equals("xpath"))  
		{ 
		 driver.findElement(By.xpath(PropertyValue)).click();
		 }
		
		
	} 
	//@Test(priority=2)
	public static void securePurchase(String Property,String PropertyValue, String RealValue)
	{
		//System.out.println("We are inside Secure Purchase method!");
		if(Property.equals("name"))
		{ 
		 driver.findElement(By.name(PropertyValue)).click();
		 }
		String ExpectedTitleFlightBook= "Flight Confirmation: Mercury Tours";
		String ActualTitleFlightBook=driver.getTitle();
		Assert.assertEquals(ActualTitleFlightBook, ExpectedTitleFlightBook);
		//System.out.println("Flight Book Title is\t"+ActualTitleFlightBook);
		/*if(ExpectedTitleFlightBook.equalsIgnoreCase(ActualTitleFlightBook))
		{
			System.out.println("securePurchase method Passed");
		}*/
		
	} 
	//@Test(priority=3) 
	public static void logOut(String Property,String PropertyValue, String RealValue)
	{
		if(Property.equals("name"))
		{ 
		 driver.findElement(By.name(PropertyValue)).click();
		 }
		if(Property.equals("xpath"))
		{
			driver.findElement(By.xpath(PropertyValue)).click();
		}
		String ExpectedTitleLogOut= "Sign-on: Mercury Tours";  
		String ActualTitleLogOut=driver.getTitle();
		Assert.assertEquals(ActualTitleLogOut, ExpectedTitleLogOut);
		//System.out.println(ActualTitleLogOut);  
		//System.out.println("Flight Book Title is\t"+ActualTitleFlightBook);
		/*if(ExpectedTitleLogOut.equalsIgnoreCase(ActualTitleLogOut))
		{
			System.out.println("LogOut method Passed");
		}*/ 
	  
	} 
	
	public static void selectSecondWindow(String Property,String PropertyValue, String RealValue) throws InterruptedException
	{
		WindowHandler wnd= new WindowHandler(); 
		wnd.selectWindow(driver, PropertyValue, RealValue);
		
	}
	
	public static void alertHandling(String Property,String PropertyValue, String RealValue)
	{
		AlertHandler alrt= new AlertHandler(); 
		alrt.alerthandle(driver, PropertyValue, RealValue);
	}
}
   

