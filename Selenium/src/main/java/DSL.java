import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {
	
	private WebDriver driver;
	
	public DSL(WebDriver driver) {
		this.driver = driver;
	}
	
	public void escreve( String id_campo, String texto) {
		driver.findElement(By.id(id_campo)).clear();
		driver.findElement(By.id(id_campo)).sendKeys(texto);
		
	}
	
	public String obterValorCampo(String id_campo) {
		return driver.findElement(By.id(id_campo)).getAttribute("value");
	}
	
	public void clicaRadio(String id_campo) {
		driver.findElement(By.id(id_campo)).click();
	}

	public boolean checaRadioIsSelected(String id_campo) {
		return driver.findElement(By.id(id_campo)).isSelected();
	}
	
	public void selecionarCombo(String id_campo, String valor) {
		WebElement element = driver.findElement(By.id(id_campo));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
		
	}
	
	
	public String obterValorCombo(String id_campo) {
		WebElement element = driver.findElement(By.id(id_campo));
		Select combo = new Select(element);
				
		return combo.getFirstSelectedOption().getText();
		
	}
	
	public void clicarBotao(String id_campo) {
		driver.findElement(By.id(id_campo)).click();
	}
		
	public String obterAtributoBotao(String id_campo) {
		return driver.findElement(By.id(id_campo)).getAttribute("value");
	}

	
	public void clicarLink(String link) {
		driver.findElement(By.linkText(link)).click();
		
	}
	
	public String obterUmTexto(By by) {
	 return	driver.findElement(by).getText();
	}
	
	public String obterUmTexto(String id) {
		 return	obterUmTexto(By.id(id));
		}

}
