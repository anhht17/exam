package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testcaseSearchGoogle {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void TC_01_Search_Google() {
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Demo with selenium");
		element.submit();

	    List<WebElement> contents = driver.findElements(By.xpath("//*[@id='rso']//h3"));

	    for (int i = 0; i < contents.size(); i++)
	    {
	    	Assert.assertTrue(contents.get(i).getText().contains("Demo with selenium"));
	    }
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
