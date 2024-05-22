package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class TestBase 
{
	public static WebDriver dr;
	public static Properties prop;
	public static String ExpectedHomePageTitle;
	public static String searhProduct;
	public static String mainWindowHandle;
	public static void loadProperties()
	{
		try
		{
			prop = new Properties();
			FileInputStream ip = new FileInputStream("./config.properties");
			prop.load(ip);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	public static void OpenBrowser()
	{
		loadProperties();
		String browserName = prop.getProperty("browser");
		ExpectedHomePageTitle=prop.getProperty("homepagetitle");
		searhProduct=prop.getProperty("product");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			ChromeOptions co=new ChromeOptions();
			co.addArguments("--start-maximized","--incognito");
			dr=new ChromeDriver(co);
			//dr = new ChromeDriver(); 
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			EdgeOptions eo=new EdgeOptions();
			eo.addArguments("--start-maximized","--incognito");
			dr = new EdgeDriver(eo); 
		}
		else
		{
			System.out.println("Please enter correct browser name ");
		}
		
		dr.get(prop.getProperty("url"));
		
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
		mainWindowHandle=dr.getWindowHandle();
		//System.out.println("mainWindowHandle = "+mainWindowHandle);
	}
	
	public static void getSS(String path) throws IOException
	{
		File scrsh=((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrsh,new File(path));
	}
	
	public static void teardown()
	{
		dr.quit();
	}
	
}