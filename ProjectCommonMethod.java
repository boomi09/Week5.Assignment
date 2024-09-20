package Week5.HomeAssignment.day2.staticparam;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class ProjectCommonMethod {

    RemoteWebDriver driver;
    @Parameters({"url","username","password"})
	@BeforeMethod       
	public void preCondition(String url,String uName,String Pword) {
		ChromeOptions options = new ChromeOptions();
     options.addArguments("--disable-notifications");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("username")).sendKeys(uName);
		driver.findElement(By.id("password")).sendKeys(Pword);
     driver.findElement(By.id("Login")).click();
	}
	@AfterMethod
	public void postCondtion() {
		driver.close();
	}
}
