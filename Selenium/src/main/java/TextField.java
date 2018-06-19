import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Assert;
import org.junit.Test;

public class TextField {
	
	@Test
	public void textField() {
		 WebDriver driver = new FirefoxDriver();
		 driver.manage().window().setSize(new Dimension(1200, 765));
		 driver.get("file:///" +  System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		 driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita");
		 Assert.assertEquals("Teste de escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		 driver.quit();
	}

}
