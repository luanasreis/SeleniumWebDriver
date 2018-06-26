import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;

public class ValidarCadastro {
	
	@Test
	public void validarCadastro() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension (1200,765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
		//TextField
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Luana");
	//	Assert.assertEquals("Luana", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Reis");
	//	Assert.assertEquals("Reis", driver.findElement(By.id("elementosForm:sobrenome")).getAttribute("value"));
	
		// Radio button
		driver.findElement(By.id("elementosForm:sexo:1")).click();
	//	Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:1")).isSelected());
		
		//Check button
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
	//	Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
	
		
		// Combo suspenso
		//WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		//Select combo = new Select(element);
		//combo.selectByVisibleText("Mestrado");
		//ou
		new Select(driver.findElement(By.id("elementosForm:escolaridade"))).selectByVisibleText("Mestrado");
		//Assert.assertEquals("Mestrado", combo.getFirstSelectedOption().getText());
	
		// Combo multipla escolha
		//element = driver.findElement(By.id("elementosForm:esportes"));
		// ou
		new Select(driver.findElement(By.id("elementosForm:esportes"))).selectByVisibleText("Natacao");
		
		// Combo multipla escolha
		//combo.selectByVisibleText("Natacao");
		//Assert.assertEquals("Natacao", combo.getFirstSelectedOption().getText());
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();

		Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
		Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("Luana"));
		Assert.assertEquals("Sobrenome: Reis", driver.findElement(By.id("descSobrenome")).getText());
		Assert.assertEquals("Sexo: Feminino", driver.findElement(By.id("descSexo")).getText());
		Assert.assertEquals("Comida: Pizza", driver.findElement(By.id("descComida")).getText());
		Assert.assertEquals("Escolaridade: mestrado", driver.findElement(By.id("descEscolaridade")).getText());
		Assert.assertEquals("Esportes: Natacao", driver.findElement(By.id("descEsportes")).getText());
		//Assert.assertEquals("Cadastrado!", driver.findElement(By.id("resultado")).getText());
	

		driver.quit();
	}

}
