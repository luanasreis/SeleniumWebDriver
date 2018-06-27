import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowHandler {
	
	@Test
	public void testJanelaPopUpSemTitulo() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension (1200,765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
		driver.findElement(By.id("buttonPopUpHard")).click();
		System.out.println(driver.getWindowHandle()); // encontra a referencia da janela princial
		System.out.println(driver.getWindowHandles()); // encontra a referencia de todas as janelas correntes
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]); //pega a referencia da segunda janela
		driver.findElement(By.tagName("textarea")).sendKeys("deu certo?");
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]); //pega a referencia da primeira janela e volta para ela
		driver.findElement(By.tagName("textarea")).sendKeys("deu certo tb?");
		
		driver.quit();
	
	}

}
