package week2.day2.assign2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {
	@Test(priority=1, enabled=true)
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
		driver.findElement(By.partialLinkText("Contacts")).click();
		driver.findElement(By.partialLinkText("Create Contact")).click();
		
		driver.findElement(By.id("firstNameField")).sendKeys("Sushmitha");
		driver.findElement(By.id("lastNameField")).sendKeys("T");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Sushmitha");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Thangavel");
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("Automation Testing");
		driver.findElement(By.id("createContactForm_description")).sendKeys("My First Project");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("babu@testleaf.com");
		WebElement state = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select ss = new Select(state);
		ss.selectByVisibleText("New York");
		driver.findElement(By.className("smallSubmit")).click();
		
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.xpath("(//textarea[@class ='inputBox'])[1]")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("The Contact has been Edited");
		driver.findElement(By.xpath("//input[@type = 'submit']")).click();
		System.out.println("Title is \t"+driver.getTitle());
		//driver.close();
		


}
}
