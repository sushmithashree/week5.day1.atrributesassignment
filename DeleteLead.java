package week2.day2.assign2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {
	@Test(priority=3, invocationCount=9, threadPoolSize=3)
	public void main() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		
		driver.findElement(By.linkText("Phone")).click();
		driver.findElement(By.name("phoneNumber")).sendKeys("9667781424");
		driver.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(2000);
		
		WebElement leadId = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a"));
		String leadId1 = leadId.getText();
		System.out.println(leadId1);
		
		leadId.click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadId1);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		String s = driver.findElement(By.className("x-paging-info")).getText();
		System.out.println(s);
		
		if(s.equals("Records verification"))
		{
			System.out.println("No Records to display");
		}
		else {
			System.out.println("Records to display");
		}
		//driver.close();
		
		
		
		
		

}
}
