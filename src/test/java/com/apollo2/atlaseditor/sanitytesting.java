package com.apollo2.atlaseditor;



import org.testng.annotations.Test;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.Set;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;


public class sanitytesting {
	 
   private RemoteWebDriver driver;
	
	@BeforeTest
	
	public void setup() throws Exception
	{
		ScreenRecorderUtil.startRecording("setup");
		  DesiredCapabilities dc = DesiredCapabilities.chrome();
	        URL url = new URL("http://172.12.20.118:5555/wd/hub");
	        driver = new RemoteWebDriver(url, dc);
	
	       
	}
	@Test(priority=1)
	public void login() throws InterruptedException
	{
		driver.get("https://apollo2.humanbrain.in/viewer/annotation/portal");
		 driver.manage().window().maximize();
		 driver.findElement(By.xpath("//a[@title='Viewer']")).click();
		 
		 String parentWindow = driver.getWindowHandle();
		 driver.findElement(By.xpath("//button[text()=' Log In ']")).click();
		 Thread.sleep(4000);
		 Set<String> allWindows = driver.getWindowHandles();
		 for (String window : allWindows) {
			    if (!window.equals(parentWindow)) {
			        driver.switchTo().window(window);
			        break;
			    }
			}
		 Thread.sleep(4000);	
	            driver.findElement(By.xpath("//input[@type='email']")).sendKeys("teamsoftware457@gmail.com");
	            driver.findElement(By.xpath("//span[text()='Next']")).click();
	            Thread.sleep(3000);
	            driver.findElement(By.xpath("//input[@aria-label='Enter your password']")).sendKeys("Health#123");
	            driver.findElement(By.xpath("//span[text()='Next']")).click();
	            Thread.sleep(5000);
	            driver.switchTo().window(parentWindow);
	            Thread.sleep(5000);
	            System.out.println("Login successfully");
	        
	}
	
	@Test(priority=2)
	public void sectionselect() throws InterruptedException
	{
	     WebElement tableElement = driver.findElement(By.xpath("//table[@class='cdk-table nb-tree-grid']//tr[7]"));
	     tableElement.click();
	     Thread.sleep(3000);
	     WebElement tableElement1=driver.findElement(By.xpath("//table[@class='cdk-table nb-tree-grid']//tr[8]//td[2]"));
	     tableElement1.click();
	     Thread.sleep(3000);
	     driver.findElement(By.xpath("//table[@class='cdk-table nb-tree-grid']//tr[9]//td[3]")).click();
	     Thread.sleep(3000);
	     driver.findElement(By.xpath("(//span[text()='382'])[1]")).click();
	}
	
	@Test(priority=3)
	
	public void atlaseditor() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[@title='Atlas Editor']")).click();
		Thread.sleep(5000);
		System.out.println("Atlas editor opened");
	}
	@Test(priority=4)
	public void oldmenu() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[@title='Edit Menu']")).click();
		Thread.sleep(3000);
	}
	@Test(priority=5)
	public void contributor() throws InterruptedException
	{
		driver.findElement(By.xpath("(//nb-icon[@pack='nebular-essentials'])[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
		Thread.sleep(4000);
		System.out.println("Contributor selected");
	}
	@Test(priority=6)
	public void draw() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[@title='Draw']")).click();
		Thread.sleep(3000);
		System.out.println("Edit mode opened");
	}
	
	@Test(priority=7)
	public void annotation() throws InterruptedException
	{
		driver.findElement(By.xpath("(//nb-icon[@pack='nebular-essentials'])[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//i[@role='presentation'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//i[@role='presentation'])[4]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//i[@role='presentation'])[17]")).click();
		Thread.sleep(3000);
		
		
		 WebElement canvas = driver.findElement(By.xpath("//canvas"));
	        Actions actions = new Actions(driver);

	        driver.findElement(By.xpath("//a[@title='Add']")).click();
	        actions.moveToElement(canvas)
            .click()
            .moveByOffset(200, 0)
            .click()
            .moveByOffset(0, 200)
            .click()
            .moveByOffset(-200, 0)
            .click()
            .moveByOffset(0, -200)
            .click()
            .release()
            .perform();
	        Thread.sleep(5000);
	        System.out.println("Annotation completed");
		
	}
	@Test(priority=8)
	public void save() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[@title='Save']")).click();
		WebDriverWait deleteWait = new WebDriverWait(driver, 100);
		By toasterLocator = By.xpath("//div[text()='Sucessfully saved the regions']");
		WebElement toasterElement = deleteWait.until(ExpectedConditions.presenceOfElementLocated(toasterLocator));
		String toasterMessage = toasterElement.getText();
		AssertJUnit.assertEquals("Sucessfully saved the regions", toasterMessage);
		System.out.println("Saved the regions successfully");
		Thread.sleep(2000);
		

	}
	@Test(priority=9)
	public void back() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[@title='Close']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Back']")).click();
		Thread.sleep(4000);
	}
	@Test(priority=10)
	public void retrive() throws InterruptedException
	{
		 driver.findElement(By.xpath("(//span[text()='382'])[1]")).click();
		 driver.findElement(By.xpath("//a[@title='Atlas Editor']")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//a[@title='Edit Menu']")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("(//nb-icon[@pack='nebular-essentials'])[3]")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
		 Thread.sleep(4000);
		 String nonenode=driver.findElement(By.xpath("(//div[@class='paragraph'])[2] ")).getText();
		 System.out.println("None node="+nonenode);
		 driver.findElement(By.xpath("(//nb-icon[@pack='nebular-essentials'])[4]")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("(//i[@role='presentation'])[1]")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("(//i[@role='presentation'])[4]")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("(//i[@role='presentation'])[17]")).click();
		 Thread.sleep(3000);
		 String selectednode=driver.findElement(By.xpath("(//div[@class='paragraph'])[2] ")).getText();
		 System.out.println("Selected node="+selectednode);
		 Assert.assertNotEquals(nonenode, selectednode);
		 System.out.println("saved node retrived successfully");
		 Thread.sleep(4000);
		 
	}
	@Test(priority=11)
	public void delete() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[@title='Draw']")).click();
		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//i[@role='presentation'])[17]")).click();
//		Thread.sleep(3000);
		WebElement canvas = driver.findElement(By.xpath("//canvas"));
		Actions actions = new Actions(driver);
		int centerX = 0; 
		int centerY = 0; 

		
		actions.moveToElement(canvas, centerX, centerY)
		        .click()
		        .perform();

		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Save']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Close']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Back']")).click();
		Thread.sleep(4000);
		System.out.println("annotated data deleted successfully");
	}
	@AfterTest
	public void close() throws Exception
	{
		ScreenRecorderUtil.stopRecording();
		driver.quit();

}

}