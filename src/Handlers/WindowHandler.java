package Handlers;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowHandler {
	
	public void selectWindow(WebDriver driver,String PropertyValue, String RealValue)
	{
		//System.out.println("Xpath is "+PropertyValue +"\n Real Value is "+ RealValue ); 
		String mainWindowid=driver.getWindowHandle();
		//System.out.println(mainWindowid);
		//2.collecting different window id*/
		//System.out.println(driver.getWindowHandles());// it will print all the set of ids of windows.
		Set<String> mywindows = driver.getWindowHandles();
		// if i want to switch to frst window
	// 3.Logic to filter out window id
		for(String temp : mywindows)
		{ 
			// here u'll get main window first, so need to skip it
			
			if(!(temp.equalsIgnoreCase(mainWindowid)))
			{
				driver.switchTo().window(temp);
				driver.manage().window().maximize();
				driver.findElement(By.xpath(PropertyValue)).click();
				//driver.quit();// close will close tabs, quit close browser.
			}
			 
		} 				
		//4.Switching to desired window(main window)
		driver.switchTo().window(mainWindowid);
		
	}
}
