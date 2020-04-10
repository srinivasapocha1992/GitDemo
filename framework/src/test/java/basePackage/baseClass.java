package basePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testcases.LoginTestcase;

public class baseClass {
	public static Properties pro;
	FileInputStream fis;
	public static WebDriver driver;
	private static Logger log = LogManager.getLogger(LoginTestcase.class.getName());
	public baseClass() {
		pro = new Properties();
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "//config.properties");
			pro.load(fis);

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

	}

	public void initialization() {
		String browser = pro.getProperty("browser");
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\804401\\eclipse-workspace\\framework\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			log.info("Chrome Browser launched");
			manageIt();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir") + "");
			driver = new FirefoxDriver();
			manageIt();
		}

	}

	public void launch() {
		driver.get(pro.getProperty("baseUrl"));
		log.info("url is loaded");
	}

	public void manageIt() {
		driver.manage().window().maximize();
		log.info("Browser maximized");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		log.info("Deleted all Cookies");

	}

	@AfterMethod
	public void extentReports() {

	}

}
