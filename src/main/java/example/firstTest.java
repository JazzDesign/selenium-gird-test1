package example;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class firstTest {
	
	
	private WebDriver driver;
	
  @Test
  public void f() {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://www.google.com");
	  
	  String search_text = "Recherche Google";
	  WebElement search_button = driver.findElement(By.name("btnK"));
	  
	  String text = search_button.getAttribute("value");
	  
	  Assert.assertEquals(text, search_text, "Text not found!");
	  
  }
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
//	  System.setProperty("webdriver.gecko.driver","/home/jseaman/eclipse-workspace/demotest/webdriver/linux/geckodriver");
	  DesiredCapabilities cap = new DesiredCapabilities();
	  cap.setBrowserName(BrowserType.FIREFOX);
	  driver = new RemoteWebDriver(new URL("http://172.17.0.2:31251/wd/hub"), cap);
//	  driver = new FirefoxDriver();
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
