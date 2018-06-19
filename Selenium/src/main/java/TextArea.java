import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.junit.Assert;
import org.junit.Test;

public class TextArea {

	@Test
	public void textArea() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Exemplo de texto\n exemplo de texto \n exemplo de texto");
		Assert.assertEquals("Exemplo de texto\n exemplo de texto \n exemplo de texto", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
	
		driver.quit();
	}
}
