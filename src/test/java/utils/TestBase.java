package utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class TestBase {

	public WebDriver driver;
	
	
	public WebDriver getdriver()  {
		
		
	
		
		if (driver == null) {
					
			if(PropertiesFile.getProperty("browser").equalsIgnoreCase("chrome"))
			{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			driver = new ChromeDriver(options);
			
			}
			else if(PropertiesFile.getProperty("browser").equalsIgnoreCase("edge"))
			{
				driver=new EdgeDriver();
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
			driver.get(PropertiesFile.getProperty("url"));
		
		}
		return driver;
	}

	public void SwitchWindowToChild() {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> wh = new ArrayList<String>(windowHandles);

		driver.switchTo().window(wh.get(1));
	}
	
	public void SwitchWindowToParent() {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> wh = new ArrayList<String>(windowHandles);

		driver.switchTo().window(wh.get(0));
	}
	
	
	

}
