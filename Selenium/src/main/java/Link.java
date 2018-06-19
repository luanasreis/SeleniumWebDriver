import org.junit.Assert;
//import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Link {
	
	@Test
	// @Ignore //para nao executar um teste
	public void testLinks() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension (1200,765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
		driver.findElement(By.linkText("Voltar")).click();
		//Assert.fail(); - PARA DAR BARRA VERMELHA
		
		Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
		
		
		driver.quit();
		
	}

}
