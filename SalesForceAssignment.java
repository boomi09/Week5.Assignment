package Week5.HomeAssignment.day1;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

public class SalesForceAssignment extends ProjectSpecificMethod {

	@Test
	public void salesForce() throws InterruptedException {
		//To close browser notification
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//To scroll the page until element to visible
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement legal= driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		js.executeScript("arguments[0].scrollIntoView(true);", legal);
		legal.click();
        //Find New Legal Entity button
		driver.findElement(By.xpath("//div[text()='New']")).click();
        //Find and Entering values for companyname and description
		driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys("TestLeaf");
		driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]")).sendKeys("Salesforce");
        //Find Status dropdown by scrolling page
		WebElement status=driver.findElement(By.xpath("//button[@role='combobox']"));
		js.executeScript("arguments[0].scrollIntoView(true);", status);
		status.click();
        //Find Active value from custom drop down
		driver.findElement(By.xpath("//lightning-base-combobox-item[2]//span[@title='Active']")).click();
        //Clicking Save button
		driver.findElement(By.xpath("//button[text()='Save']")).click();
        //Find notification message and click
		driver.findElement(By.xpath("//a[text()='Legal Entity Name']")).click();
        //Find and printing Entity Name
		WebElement text=driver.findElement(By.xpath("(//div[@role='status'])[5]"));
		System.out.println("Entity Name:" + text.getText());




	}

}
