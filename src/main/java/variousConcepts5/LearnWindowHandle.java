package variousConcepts5;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindowHandle {
	
	WebDriver driver;
	// method short::  form init = initialization 
		@Before
		public void init() {

			System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
			driver = new ChromeDriver();

			driver.get("https://www.yahoo.com/");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		}

		
		@Test
		public void alertTest() throws InterruptedException {
			
			/*System.out.println(driver.getTitle());

			String handle= driver.getWindowHandle();
			
			System.out.println(handle);*/
			
			driver.findElement(By.id("ybar-sbq")).sendKeys("xpath");
			driver.findElement(By.id("ybar-search")).click();
			Thread.sleep(3000);
			
			System.out.println(driver.getTitle());
			
			String handle1= driver.getWindowHandle();
			
			System.out.println(handle1);
			
			driver.findElement(By.xpath("//*[@id=\"web\"]/ol/li[1]/div/div[1]/h3/a")).click();
			System.out.println(driver.getTitle());
			
			//String handle2= driver.getWindowHandle();
			
			Set<String> handle2=driver.getWindowHandles();
			//System.out.println(handle2);
			
			
			for(String i: handle2) {
				
				System.out.println(i);
				
				driver.switchTo().window(i);
				
			}
			
			System.out.println(driver.getTitle());
			
			Thread.sleep(3000);
			
			driver.switchTo().window(handle1);
		}

}
