import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.junit.Assert;
import org.junit.Test;

public class Botao {
	
	@Test
	public void testBotao() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension (1200,765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
		driver.findElement(By.id("buttonSimple")).click();
		Assert.assertEquals("Obrigado!", driver.findElement(By.id("buttonSimple")).getAttribute("value"));
	
		//ou
		// WebElement botao = driver.findElement(By.id("buttonSimple"));
		//botao.click();
		//Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
	
		driver.quit();
	}

}
