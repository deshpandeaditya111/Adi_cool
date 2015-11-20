package Handlers;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertHandler {
	
	public void alerthandle(WebDriver driver,String PropertyValue, String RealValue)
	{
		driver.findElement(By.id(PropertyValue)).click();

		Alert simpleAlert = driver.switchTo().alert();
		String alertText = simpleAlert.getText();
		System.out.println("Alert text is " + alertText+"\n");
		simpleAlert.accept();
	}

}
