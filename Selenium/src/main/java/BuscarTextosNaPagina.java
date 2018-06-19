import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.junit.Assert;
import org.junit.Test;

public class BuscarTextosNaPagina {
	
	@Test
	public void testTextosNaPagina() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension (1200,765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
		//verifica se um determinado texto está dentro do <body> da pagina
		//Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
	
		//verifica um texto em uma determinada posicao da pagina
		//Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("body")).getText());
		
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", driver.findElement(By.className("facilAchar")).getText());
		
		driver.quit();
	}

}
