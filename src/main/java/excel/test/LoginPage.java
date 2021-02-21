package excel.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.util.Xls_Reader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.facebook.com");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		WebElement userName = driver.findElement(By.xpath("//input[@id='email']"));
		WebElement passWord = driver.findElement(By.xpath("//input[@id='pass']"));

		Xls_Reader reader= new Xls_Reader("D:\\Swamyshiva\\swamyshiva\\ExcelUtil\\src\\main\\java\\excel\\test\\ExcelUtilTest.xlsx");
		String sheetName="login";
		
		int rowCount= reader.getRowCount(sheetName);
		System.out.println(rowCount);
		
		for(int rowNum = 2; rowNum<=rowCount; rowNum++) {
			String userId=reader.getCellData(sheetName, "username", rowNum);
			String password=reader.getCellData(sheetName, "password", rowNum);
			
			System.out.println(userId+ " " +password);
			
			userName.clear();
			userName.sendKeys(userId);
			
			passWord.clear();
			passWord.sendKeys(password);
		}
		
		
	}

}
