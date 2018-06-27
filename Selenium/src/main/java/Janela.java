import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Janela {
	
	@Test
	public void testJanelaPopUpComTitulo() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension (1200,765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
		driver.findElement(By.id("buttonPopUpEasy")).click();
		driver.switchTo().window("Popup"); //quando a popup tiver título
		driver.findElement(By.tagName("textarea")).sendKeys("Deu certo");
		driver.close(); //fecha a janela de pop up
		driver.switchTo().window("");
		driver.findElement(By.tagName("textarea")).sendKeys("Deu certo agora?");
		
		
	}
	

}
