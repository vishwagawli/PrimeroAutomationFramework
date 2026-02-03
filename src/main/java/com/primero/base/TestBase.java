package com.primero.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
//import org.openqa.selenium.devtools.v120.network.model.ConnectionType;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import com.primero.util.TestUtil;
import com.primero.util.WebEventListener;

//import io.github.bonigarcia.wdm.WebDriverManager;
import io.opencensus.common.Duration;
import java.util.Optional;
//import org.openqa.selenium.devtools.NetworkInterceptor;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.DevTools;

import org.openqa.selenium.edge.EdgeDriver;
//import static org.openqa.selenium.devtools.network.Network.loadingFailed;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static String downloadpath = System.getProperty("user.dir")+ "/PDF";
	public static DevTools devtools;
	
	public static String chromepath = System.getProperty("user.dir")+ "//src//main//resources//chromedriver.exe";
			
	
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "//src//main//java//com//primero//config//config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	@SuppressWarnings("deprecation")
	public static void initialization(){
		
		String browserName = prop.getProperty("browser");
		
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", downloadpath);
		options.setExperimentalOption("prefs", prefs);
	//	options.setBinary(chromepath);
		
		if(browserName.equals("chrome")){
		//	System.setProperty("webdriver.chrome.driver", chromepath);	
			//	WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options); 
		}
		else if(browserName.equals("FF")){
			//System.setProperty("webdriver.gecko.driver", "/Users/naveenkhunteta/Documents/SeleniumServer/geckodriver");	
			driver = new FirefoxDriver(); 
		}
		else if(browserName.equals("CC"))
		{
			driver = new EdgeDriver(); 
	

		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		driver.get(prop.getProperty("qaurl"));
	
	}


}
