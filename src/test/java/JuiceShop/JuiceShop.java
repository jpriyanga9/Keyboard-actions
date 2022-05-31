package JuiceShop;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class JuiceShop {
	
	static WebDriver driver;
	
	@BeforeSuite
	public static void open() {
		System.setProperty("webdriver.chrome.driver" ,"C:\\Users\\91948\\eclipse-workspace\\KeyboardActions\\src\\test\\resources\\Drivers\\chromedriver.exe" );
		driver = new ChromeDriver();
		driver.get("https://juice-shop.herokuapp.com/#/");
		driver.manage().window().maximize();
		
	}
	
	@Test
	public static void order() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions action = new Actions(driver);
		
		JavascriptExecutor j = (JavascriptExecutor)driver;
		
		driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/app-welcome-banner/div/div[2]/button[2]/span[1]")).click();
		
		driver.findElement(By.id("navbarAccount")).click();
		//driver.findElement(By.name("Login"));
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		driver.navigate().refresh();
		Thread.sleep(1000);
		//action.click(driver.findElement(By.name("/register")));
		//driver.findElement(By.xpath("//*[@id=\"newCustomerLink\"]/a")).click();
		
		driver.findElement(By.linkText("Not yet a customer?")).click();
		
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(1000);
		String username = "username"+ randomInt +"@gmail.com";
		WebElement email = driver.findElement(By.id("emailControl"));		
		email.sendKeys(username);
		driver.findElement(By.id("passwordControl")).sendKeys("Testpwd");
		//action.sendKeys("Testpwd");
		driver.findElement(By.id("repeatPasswordControl")).sendKeys("Testpwd");
		//action.sendKeys("Testpwd");
		driver.findElement(By.name("securityQuestion")).click();
		driver.findElement(By.id("mat-option-10")).click();
		driver.findElement(By.id("securityAnswerControl")).sendKeys("book");
		driver.findElement(By.id("registerButton")).click();
		Thread.sleep(1000);
		
		//Login account
		WebElement lemail = driver.findElement(By.id("email"));		
		lemail.sendKeys(username);
		driver.findElement(By.id("password")).sendKeys("Testpwd");
		driver.findElement(By.xpath("//*[@id=\"loginButton\"]/span[1]")).click();
		
		//Add to cart
		j.executeScript("window.scrollBy(0,5000)");
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		//action.sendKeys(Keys.ARROW_DOWN).perform();
		//j.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		//action.sendKeys(Keys.END).build().perform();
		driver.findElement(By.xpath("/html/body/div[1]/div/a")).click();
		driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-search-result/div/div/div[2]/mat-grid-list/div/mat-grid-tile[10]/div/mat-card/div[2]/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-search-result/div/div/mat-paginator/div/div/div[2]/button[2]")).click();
		action.sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).build().perform();
		driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-search-result/div/div/div[2]/mat-grid-list/div/mat-grid-tile[1]/div/mat-card/div[2]/button")).click();
		driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-navbar/mat-toolbar/mat-toolbar-row/button[4]")).click();
		driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-basket/mat-card/app-purchase-basket/mat-table/mat-row[1]/mat-cell[3]/button[2]")).click();
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"checkoutButton\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"card\"]/app-address/mat-card/div/button")).click();

		driver.findElement(By.xpath("//*[@id=\"address-form\"]/mat-form-field[1]/div/div[1]/div[3]")).sendKeys("Country");
        driver.findElement(By.xpath("//*[@id=\"address-form\"]/mat-form-field[2]/div/div[1]/div[3]")).sendKeys("Name");
        driver.findElement(By.xpath("//*[@id=\"address-form\"]/mat-form-field[3]/div/div[1]/div[3]")).sendKeys("1234567890");
        driver.findElement(By.xpath("//*[@id=\"address-form\"]/mat-form-field[4]/div/div[1]/div[3]")).sendKeys("11111");
        driver.findElement(By.xpath("//*[@id=\"address-form\"]/mat-form-field[5]/div/div[1]/div[3]")).sendKeys("address");
        driver.findElement(By.xpath("//*[@id=\"address-form\"]/mat-form-field[6]/div/div[1]/div[3]")).sendKeys("city");
        driver.findElement(By.xpath("//*[@id=\"submitButton\"]")).click(); 
		
        
        
	
	}

}
