package week2.day2.assign2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {
	@Test(priority=4, enabled=false)
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
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("rr@gmail.com");
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		Thread.sleep(2000);
		WebElement leadFirstName = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])[1]/a"));
		String capturedLeadName = leadFirstName.getText();
		System.out.println(capturedLeadName);
		leadFirstName.click();
		
		driver.findElement(By.linkText("Duplicate Lead")).click();
		if(driver.getTitle().contains("Duplicate Lead")) {
			System.out.println("The title contains the word Duplicate Lead");
		}
			else {
				System.out.println("The title does not contain the word Duplicate Lead");
			}

		driver.findElement(By.name("submitButton")).click();
		String duplicatedLeadName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println("duplicatedLeadName");
		
		if(capturedLeadName.equals(duplicatedLeadName)) {
			System.out.println("Duplicated Lead name is same as Captured name");
		}
		else {
			System.out.println("Duplicated Lead name is not as same as Captured name");
		}
		//driver.close();
		
		
		

}
}
