package apphooks;

import java.util.Properties;

import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.utilities.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	
	private DriverFactory driverFactory;	
	private WebDriver driver;	//these are made private because these are specific to this class only.
	private ConfigReader configReader;
	Properties prop;
	//We will create public wrappers to give access to these private variables
	
	
	@Before(value="@skip", order = 0)	//This is used to skip scenarios during execution
	public void skipScenarios(Scenario scenario) {
		System.out.println("Skipped scenario is - " + scenario.getName());
		Assume.assumeTrue(false);
	}
	
	@Before(order = 1)
	public void getProperty() {
		 configReader = new ConfigReader();
		 prop = configReader.initProp();
	}
	
	@Before(order = 2)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.initDriver(browserName);		
	}
	
	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}
	
	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			//take screenshot
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte [] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
	}
	
}
