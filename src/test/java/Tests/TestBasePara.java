package Tests;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class TestBasePara {
	
	
	public static String BaseURL = "http://demo.nopcommerce.com" ;
			
			
	public ThreadLocal<RemoteWebDriver> driver = null ;
	
	
	@BeforeClass
	@Parameters(value= {"browser"}) 
	public void setUP(String browser) throws MalformedURLException {
		
		driver = new ThreadLocal<>() ;
		DesiredCapabilities caps = new DesiredCapabilities(); 
		caps.setCapability("browserName", browser);
		driver.set(new RemoteWebDriver(new URL("http://192.168.1.8:4444"),caps));
		getDriver().navigate().to(BaseURL) ;
	
	}
	
	public WebDriver getDriver () {
		
		return driver.get() ;
	}

	
	
}
