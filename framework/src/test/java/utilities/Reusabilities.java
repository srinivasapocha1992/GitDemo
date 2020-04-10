package utilities;

import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import basePackage.baseClass;

public class Reusabilities extends baseClass {
	public static long timeINSeconds = 15;

	public boolean isElementPresent(By locator, long waitTime) {
		boolean bflag = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, waitTime);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			if (driver.findElement(locator).isDisplayed() || driver.findElement(locator).isEnabled()) {
				bflag = true;
			}
		} catch (NoSuchElementException e) {
			System.out.println("Element." + locator + " was not not found in time " + waitTime + "seconds"
					+ "-NosuchElementException");
			Assert.fail("locator is not present");
		} catch (TimeoutException e) {
			System.out.println(
					"Element." + locator + " was not not found in time " + waitTime + "seconds" + "-TimeoutException");
			Assert.fail("locator is not present");
		} catch (Exception e) {
			System.out.println("Element." + locator + " was not not found in time" + e);
			Assert.fail("locator is not present");
		}
		return bflag;
	}

	public boolean isElementVisible(By locator, long waitTime) {
		boolean bFlag = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, waitTime);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			if (driver.findElement(locator).isDisplayed())
				;
			{
				bFlag = true;
			}
		} catch (NoSuchElementException e) {
			System.out.println("Element." + locator + "was not not found in time " + waitTime + "seconds"
					+ "-NosuchElementException");
		} catch (TimeoutException e) {
			System.out.println(
					"Element." + locator + "was not not found in time " + waitTime + "seconds" + "-TimeoutException");
		} catch (Exception e) {
			System.out.println("Element." + locator + "was not not found in time" + e);
		}
		return bFlag;
	}

	public void isAlertPresent(long waitTime) {
		boolean bFlag = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, waitTime);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			bFlag = true;
		} catch (NoAlertPresentException e) {
			System.out.println("Alert is not presnt in time " + waitTime + "-NoAlertPresentException");
			Assert.fail("Alert is not present");
		} catch (TimeoutException e) {
			System.out.println("Alert is not presnt in time " + waitTime + "-TimeoutException");
			Assert.fail("Alert is not present");
		} catch (Exception e) {
			System.out.println("Alert not Present " + e);
			Assert.fail("Alert is not present");
		}
	}

	public void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			String sText = alert.getText();
			alert.accept();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert is not displayed to accept." + "-NoAlertPresentException");
			Assert.fail("Alert is not displayed to accept-NoAlertPresentException");
		} catch (Exception e) {
			System.out.println("Alert is not displayed to accept." + e);
			Assert.fail("unable to accept the alert");
		}

	}

	public void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			String sText = alert.getText();
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert is not displayed to dismiss." + "-NoAlertPresentException");
			Assert.fail("Alert is not displayed to dismiss-NoAlertPresentException");
		} catch (Exception e) {
			System.out.println("Alert is not displayed to dismiss." + e);
			Assert.fail("unable to dismiss the alert");
		}

	}

	public String getAlertMessage() {
		String sText = null;
		try {
			Alert alert = driver.switchTo().alert();
			sText = alert.getText();

		} catch (NoAlertPresentException e) {
			System.out.println("Alert is not displayed to accept." + "-NoAlertPresentException");
			Assert.fail("Alert is not displayed to accept-NoAlertPresentException");
		} catch (Exception e) {
			System.out.println("Alert is not displayed to accept." + e);
			Assert.fail("unable to accept the alert");
		}
		return sText;
	}

	public void refreshPage() {

		try {
			driver.navigate().refresh();
		}

		catch (Exception e) {
			System.out.println("unable to refresh the Page" + e);
			Assert.fail("Unable to Refresh the Page");
		}

	}

	public void forwardPage() {

		try {
			driver.navigate().forward();
		}

		catch (Exception e) {
			System.out.println("unable to forward the Page" + e);
			Assert.fail("Unable to forward the Page");
		}
	}

	public void backpage() {

		try {
			driver.navigate().back();
		}

		catch (Exception e) {
			System.out.println("unable to Go back to the previous Page" + e);
			Assert.fail("unable to Go back to the previous Page");
		}

	}

	public void switchToFrameByFrameNumber(int frameNumber, long waitTime) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, waitTime);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameNumber));

			driver.switchTo().frame(frameNumber);

		} catch (NoSuchFrameException e) {
			System.out.println("Frame" + frameNumber + " was not not found in time " + waitTime + "seconds"
					+ "-NosuchElementException");
			Assert.fail("Frame is not present");
		} catch (TimeoutException e) {
			System.out.println("Frame." + frameNumber + " was not not found in time " + waitTime + "seconds"
					+ "-TimeoutException");
			Assert.fail("Frame is not present");
		} catch (Exception e) {
			System.out.println("Frame." + frameNumber + " was not not found in time" + e);
			Assert.fail("Frame is not present");
		}

	}
	public void switchToFrameByWebElement(WebElement ele, long waitTime) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, waitTime);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ele));

			driver.switchTo().frame(ele);

		} catch (NoSuchFrameException e) {
			System.out.println("Frame" + ele + " was not not found in time " + waitTime + "seconds"
					+ "-NosuchElementException");
			Assert.fail("Frame is not present");
		} catch (TimeoutException e) {
			System.out.println("Frame." + ele + " was not not found in time " + waitTime + "seconds"
					+ "-TimeoutException");
			Assert.fail("Frame is not present");
		} catch (Exception e) {
			System.out.println("Frame." + ele + " was not not found in time" + e);
			Assert.fail("Frame is not present");
		}

	}
	public void switchToFrameByName(String frameLocator, long waitTime) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, waitTime);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));

			driver.switchTo().frame(frameLocator);

		} catch (NoSuchFrameException e) {
			System.out.println("Frame" + frameLocator + " was not not found in time " + waitTime + "seconds"
					+ "-NosuchElementException");
			Assert.fail("Frame is not present");
		} catch (TimeoutException e) {
			System.out.println("Frame." + frameLocator + " was not not found in time " + waitTime + "seconds"
					+ "-TimeoutException");
			Assert.fail("Frame is not present");
		} catch (Exception e) {
			System.out.println("Frame." + frameLocator + " was not not found in time" + e);
			Assert.fail("Frame is not present");
		}

	}
	public void switchToFrameById(String frameLocator, long waitTime) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, waitTime);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));

			driver.switchTo().frame(frameLocator);

		} catch (NoSuchFrameException e) {
			System.out.println("Frame" + frameLocator + " was not not found in time " + waitTime + "seconds"
					+ "-NosuchElementException");
			Assert.fail("Frame is not present");
		} catch (TimeoutException e) {
			System.out.println("Frame." + frameLocator + " was not not found in time " + waitTime + "seconds"
					+ "-TimeoutException");
			Assert.fail("Frame is not present");
		} catch (Exception e) {
			System.out.println("Frame." + frameLocator + " was not not found in time" + e);
			Assert.fail("Frame is not present");
		}

	}


}
