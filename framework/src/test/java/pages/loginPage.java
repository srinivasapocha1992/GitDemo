package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import basePackage.baseClass;
import testcases.LoginTestcase;
import utilities.Reusabilities;

public class loginPage extends baseClass {
	
	private static Logger log = LogManager.getLogger(LoginTestcase.class.getName());
	
	Reusabilities reusabilities = new Reusabilities();
	
	By userName = By.className("LM6RPg");

	public void userName() {
		if (reusabilities.isElementPresent(userName,reusabilities.timeINSeconds ));
		
		driver.findElement(userName).sendKeys("soundarya cream");
		
	
		
		
	}
	By list  = By.ClassName("_2cLu-l");
	public void 
	
	driver.findElements(By.xpath("//*[contains(@text()='soundarya cream']"));
	driver.findElement(By.className("_2cLu-l")).click();

}
