import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.junit.Assert;

public class AlertPrompt {
	
	@Test
	public void alertPrompt() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension (1200,765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
		driver.findElement(By.id("prompt")).click();
		org.openqa.selenium.Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Digite um numero", alert.getText());
		alert.sendKeys("123");
		alert.accept();
		Assert.assertEquals("Era 123?", alert.getText());
		alert.accept();
		Assert.assertEquals(":D", alert.getText());
		alert.accept();
		
		driver.findElement(By.id("prompt")).click();
		driver.switchTo().alert();
		alert.dismiss(); 
		alert.accept();
		alert.accept();
		
		
		
		
	}

}
