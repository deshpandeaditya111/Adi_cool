package Handlers;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioHandler {
	public void selectRadiobuttonByName(WebDriver driver, String PropertyValue, String RealValue)
	{
		List<WebElement> radiobutton = new ArrayList<WebElement>();
		radiobutton = driver.findElements(By.name(PropertyValue));
		for(WebElement temp : radiobutton)
		{
			String str = temp.getAttribute("value");
			if(str.equals(RealValue))
			{
				temp.click();  
			} 
		}
	}
	public void selectRadiobuttonByxpath(WebDriver driver, String PropertyValue, String RealValue)
	{
		List<WebElement> radiobutton = new ArrayList<WebElement>();
		radiobutton = driver.findElements(By.xpath(PropertyValue));
		for(WebElement temp : radiobutton)
		{
			String str = temp.getAttribute("value");
			if(str.equals(RealValue))
			{
				temp.click();
			}
		}
	}

}
