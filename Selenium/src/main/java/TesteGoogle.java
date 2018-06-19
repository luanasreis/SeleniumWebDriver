import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteGoogle {
	
	@Test
	public void test(){
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		
		System.out.println(driver.getTitle());
		Assert.assertEquals("Google", driver.getTitle());
	}

}
