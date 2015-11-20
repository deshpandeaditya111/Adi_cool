package Handlers;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownHandler {
	
	public void selectDropDownValueByName(WebDriver driver,String PropertyValue, String RealValue)
	{
		Select fromPort = new Select(driver.findElement(By.name(PropertyValue)));
		List<WebElement> dropDwonList = new ArrayList<WebElement>();
		dropDwonList = fromPort.getOptions();	
		for(WebElement temp:dropDwonList) 
		{
			if(temp.getAttribute("value").equals(RealValue))
			{
				fromPort.selectByValue(RealValue);
			}
		}	
	}

	public void selectDropDownValueByXpath(WebDriver driver,String PropertyValue, String RealValue)
	{
		Select fromPort = new Select(driver.findElement(By.xpath(PropertyValue)));
		List<WebElement> dropDwonList = new ArrayList<WebElement>();
		dropDwonList = fromPort.getOptions();	
		for(WebElement temp:dropDwonList) 
		{
			if(temp.getAttribute("value").equals(RealValue))
			{
				fromPort.selectByValue(RealValue);
			}
		}	
	}
}
