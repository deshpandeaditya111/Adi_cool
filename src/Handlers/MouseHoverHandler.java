package Handlers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseHoverHandler {
	
	public void mouseHandling(WebDriver driver,String PropertyValue, String RealValue)
	{
		 Actions actions = new Actions(driver);
		  WebElement moveonmenu = driver.findElement(By.xpath(PropertyValue));
		  actions.moveToElement(moveonmenu).moveToElement(driver.findElement(By.xpath(RealValue))).click().perform();
		  
		  WebDriverWait wait = new WebDriverWait(driver, 15);
		  wait.until(ExpectedConditions.titleContains("Google"));
	}

}
