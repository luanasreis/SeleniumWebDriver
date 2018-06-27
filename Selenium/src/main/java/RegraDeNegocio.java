import org.openqa.selenium.By;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;
import org.junit.Test;

public class RegraDeNegocio {
	
	@Test
	public void nomeObrigatorio() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension (1200,765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
			
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		Assert.assertEquals("Nome eh obrigatorio", texto);
		alert.accept();
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Luana");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert2 = driver.switchTo().alert();
		String texto2 = alert2.getText();
		Assert.assertEquals("Sobrenome eh obrigatorio", texto2);
		alert2.accept();
		
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Reis");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert3 = driver.switchTo().alert();
		String texto3 = alert3.getText();
		Assert.assertEquals("Sexo eh obrigatorio", texto3);
		alert3.accept();
		
		driver.findElement(By.id("elementosForm:sexo:1")).click();
		//driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert4 = driver.switchTo().alert();
		String texto4 = alert4.getText();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", texto4);
		alert4.accept();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		
		new Select(driver.findElement(By.id("elementosForm:esportes"))).selectByVisibleText("Natacao");
		new Select(driver.findElement(By.id("elementosForm:esportes"))).selectByVisibleText("O que eh esporte?");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert5 = driver.switchTo().alert();
		String texto5 = alert5.getText();
		Assert.assertEquals("Voce faz esporte ou nao?", texto5);
		alert5.accept();
		
		driver.quit();
		
	}

}
