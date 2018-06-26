import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertConfirm {
	
	@Test
	public void alertConfirm() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension (1200,765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
		driver.findElement(By.id("confirm")).click();
		org.openqa.selenium.Alert alert = driver.switchTo().alert();
	    //String texto = alert.getText();
	    Assert.assertEquals("Confirm Simples", alert.getText());
	    alert.accept(); //clica no OK
	    Assert.assertEquals("Confirmado", alert.getText());
	    alert.accept(); //clica no ok
	    
	    driver.findElement(By.id("confirm")).click();
		//org.openqa.selenium.Alert alert = driver.switchTo().alert();
	    //String texto = alert.getText();
	    Assert.assertEquals("Confirm Simples", alert.getText());
	    alert.dismiss(); //clica em cancelar alerta
	    Assert.assertEquals("Negado", alert.getText());
	    alert.dismiss(); //clica em cancelar alerta
	    
	    driver.quit();
	}
}
