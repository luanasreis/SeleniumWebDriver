import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
//import org.openqa.selenium.*;
//import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Alert {
	
	private WebDriver driver;
	
	@Before
	public void inicializa() {
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension (1200,765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
	}
	
	@After
	public void encerra() {
		driver.quit();
	}
	
	
	@Test
	public void testAlert() {
	//	WebDriver driver = new FirefoxDriver();
	//	driver.manage().window().setSize(new Dimension (1200,765));
	//	driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
		driver.findElement(By.id("alert")).click();
	    org.openqa.selenium.Alert alert = driver.switchTo().alert();
	    String texto = alert.getText();
	    Assert.assertEquals("Alert Simples", texto);
	    alert.accept(); //clica no botao ok pra sair do alerta
	    
	    driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
	    driver.quit();
	}

}
