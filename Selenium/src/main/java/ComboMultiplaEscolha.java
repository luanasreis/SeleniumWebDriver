import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import org.junit.Assert;

public class ComboMultiplaEscolha {
	
	@Test
	public void comboMultiplaEscolha() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension (1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("O que eh esporte?");
		
		
		//Verifica se o número de elementos selecionados no combo de Multipla escolha foi 3
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectedOptions.size());
		
		//Deseleciona um opçao do combo
		combo.deselectByVisibleText("Corrida");
		allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectedOptions.size());
		
		
		driver.quit();
		
		
	}

}
