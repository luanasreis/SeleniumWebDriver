import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.WebElement;

import java.util.List;

import org.junit.Assert;

public class ComboSuspenso {
	
	@Test
	public void comboSuspenso() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		
		//combo.selectByIndex(3);
		//combo.selectByValue("2grauincomp");
		combo.selectByVisibleText("2o grau incompleto");
		
		Assert.assertEquals("2o grau incompleto", combo.getFirstSelectedOption().getText());
	//	driver.quit();
		
		
		//VERIFICA OS VALORES DISPONIVEIS NO COMBO SUSPENSO
		List<WebElement> options = combo.getOptions();
		
		Assert.assertEquals(8, options.size());
		
		//verifica se uma determinada opcao esta no combo
		boolean encontrou = false;
		for(WebElement option: options) {
			if(option.getText().equals("Mestrado")) {
				encontrou = true;
				break;
			}
			
		}
		
		Assert.assertTrue(encontrou);
		
	}

}
