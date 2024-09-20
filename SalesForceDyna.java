package Week5.HomeAssignment.day2.dynamicparameter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SalesForceDyna extends CommonMethods {
	
	@Test(dataProvider="passInput")
	public void salesForce(String name,String CName,String addr) throws InterruptedException {
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
		
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys(CName);
		driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]")).sendKeys(addr);
		
		WebElement submit=driver.findElement(By.xpath("//button[text()='Save']"));
		js.executeScript("arguments[0].scrollIntoView(true);", submit);
		submit.click();
		
	WebElement legalEntity=	driver.findElement(By.xpath("//span[@class='test-id__field-value slds-form-element__static slds-grow word-break-ie11']"));
		System.out.println("Legal Entity Name:"+legalEntity.getText());
		Thread.sleep(10000);
		
}
	    @DataProvider(name="passInput",indices= {0})
	    public String[][] inputData() {
	    	String[][] data=new String[1][3];
	    	data[0][0]="Salesforce Automation by Boomiraja";
	    	data[0][1]="TestLeaf";
	    	data[0][2]="Practice";
	    	return data;
	    	
	    }
}
