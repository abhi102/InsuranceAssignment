package com.lemonade.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass  {
	public File file = new File(System.getProperty("user.dir")+ "/testdata/userdata.xlsx");
		
	public WebDriver driver;
	public void initialize() throws IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("--incognito");
	    options.addArguments("--ignore-certificate-errors");
	    options.addArguments("--remote-allow-origins=*");
	    options.addArguments("--disable-blink-features=AutomationControlled");
	    options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
	    options.setExperimentalOption("useAutomationExtension", false);
	    driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.lemonade.com");
 
		
	}
	
	public static String randomEmail() {
        return "user" + UUID.randomUUID().toString() + "@example.com";
    }
}
