import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

public class ValidarCadastro {
	
	private WebDriver driver;
	private DSL dsl;
	private CampoTreinamentoPage page;
	
	@Before
	public void inicializa() {
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension (1200,765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
		page = new CampoTreinamentoPage(driver);
	}
	
	@After
	public void encerra() {
		driver.quit();
	}
	
	@Test
	public void validarCadastro() {
		//TextField
		//**driver.findElement(By.id("elementosForm:nome")).sendKeys("Luana");
		//***dsl.escreve("elementosForm:nome" ,"Luana");
		page.setNome("Luana");
	//	Assert.assertEquals("Luana", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		
		//**driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Reis");
		//***dsl.escreve("elementosForm:sobrenome", "Reis");
		page.setSobrenome("Reis");
		//	Assert.assertEquals("Reis", driver.findElement(By.id("elementosForm:sobrenome")).getAttribute("value"));
	
		// Radio button
		//**driver.findElement(By.id("elementosForm:sexo:1")).click();
		page.setSexoFeminino();
		//	Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:1")).isSelected());
		
		//Check button
		//**driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		//***dsl.clicaRadio("elementosForm:comidaFavorita:2");
		page.setComidaPizza();
		//	Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
	
		
		// Combo suspenso
		//WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		//Select combo = new Select(element);
		//combo.selectByVisibleText("Mestrado");
				
		//ou
				
		//**new Select(driver.findElement(By.id("elementosForm:escolaridade"))).selectByVisibleText("Mestrado");
		//***dsl.selecionarCombo("elementosForm:escolaridade", "Mestrado");
		page.setEscolaridade("Mestrado");
		//Assert.assertEquals("Mestrado", combo.getFirstSelectedOption().getText());
	
		// Combo multipla escolha
		//element = driver.findElement(By.id("elementosForm:esportes"));
		
		// ou
		
		//**new Select(driver.findElement(By.id("elementosForm:esportes"))).selectByVisibleText("Natacao");
		//***dsl.selecionarCombo("elementosForm:esportes", "Natacao");
		page.setEsporte("Natacao");
		
		// Combo multipla escolha
		//combo.selectByVisibleText("Natacao");
		//Assert.assertEquals("Natacao", combo.getFirstSelectedOption().getText());
		
		//**driver.findElement(By.id("elementosForm:cadastrar")).click();
		//***dsl.clicarBotao("elementosForm:cadastrar");
		page.cadastrar();

		//**Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
		//***Assert.assertTrue(dsl.obterUmTexto("resultado").startsWith("Cadastrado!"));
		Assert.assertTrue(page.obterResultadoCadastro().startsWith("Cadastrado!"));
		
		//**Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("Luana"));
		//***Assert.assertTrue(dsl.obterUmTexto("descNome").endsWith("Luana"));
		Assert.assertTrue(page.obterNomeCadastro().endsWith("Luana"));
		
		//**Assert.assertEquals("Sobrenome: Reis", driver.findElement(By.id("descSobrenome")).getText());
		//***Assert.assertEquals("Sobrenome: Reis", dsl.obterUmTexto("descSobrenome"));
		Assert.assertEquals("Sobrenome: Reis", page.obterSobrenomeCadastro());
		
		//**Assert.assertEquals("Sexo: Feminino", driver.findElement(By.id("descSexo")).getText());
		//***Assert.assertEquals("Sexo: Feminino", dsl.obterUmTexto("descSexo"));
		Assert.assertEquals("Sexo: Feminino", page.obterSexoCadastro());
		
		//**Assert.assertEquals("Comida: Pizza", driver.findElement(By.id("descComida")).getText());
		//***Assert.assertEquals("Comida: Pizza", dsl.obterUmTexto("descComida"));
		Assert.assertEquals("Comida: Pizza", page.obterComidaCadastro());
		
		//**Assert.assertEquals("Escolaridade: mestrado", driver.findElement(By.id("descEscolaridade")).getText());
		//***Assert.assertEquals("Escolaridade: mestrado", dsl.obterUmTexto("descEscolaridade"));
		Assert.assertEquals("Escolaridade: mestrado", page.obterEscolaridadeCadastro());
		
		//**Assert.assertEquals("Esportes: Natacao", driver.findElement(By.id("descEsportes")).getText());
		//***Assert.assertEquals("Esportes: Natacao", dsl.obterUmTexto("descEsportes"));
		Assert.assertEquals("Esportes: Natacao", page.obterEsportesCadastro());
		
		
		//Assert.assertEquals("Cadastrado!", driver.findElement(By.id("resultado")).getText());
		//driver.quit();
	}
	
	@Test
	public void deveValidarNomeObrigatorio() {
		//***dsl.clicarBotao("elementosForm:cadastrar");
		page.cadastrar();
		Assert.assertEquals("Nome eh obrigatorio", dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void deveValidarSobrenomeObrigatorio() {
		//***dsl.escreve("elementosForm:nome", "Nome qualquer");
		page.setNome("Nome qualquer");
		//***dsl.clicarBotao("elementosForm:cadastrar");
		page.cadastrar();
		Assert.assertEquals("Sobrenome eh obrigatorio", dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void deveValidarSexoObrigatorio() {
		//***dsl.escreve("elementosForm:nome", "Nome qualquer");
		page.setNome("Nome qualquer");
		//***dsl.escreve("elementosForm:sobrenome", "Sobrenome qualquer");
		page.setSobrenome("Sobrenome qualquer");
		//***dsl.clicarBotao("elementosForm:cadastrar");
		page.cadastrar();
		Assert.assertEquals("Sexo eh obrigatorio", dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void deveValidarComidaVegetariano() {
		//***dsl.escreve("elementosForm:nome", "Nome qualquer");
		page.setNome("Nome qualquer");
		//***dsl.escreve("elementosForm:sobrenome", "Sobrenome qualquer");
		page.setSobrenome("Sobrenome qualquer");
		//***dsl.clicaRadio("elementosForm:sexo:1");
		page.setSexoFeminino();
		//***dsl.clicaRadio("elementosForm:comidaFavorita:0");
		page.setComidaCarne();
		//***dsl.clicaRadio("elementosForm:comidaFavorita:3");
		page.setComidaVegetariano();
		//***dsl.clicarBotao("elementosForm:cadastrar");
		page.cadastrar();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertaObterTextoEAceita());		
	}
	
	public void deveValidarEsportistaIndeciso() {
		//***dsl.escreve("elementosForm:nome", "Nome qualquer");
		page.setNome("Nome qualquer");
		//***dsl.escreve("elementosForm:sobrenome", "Sobrenome qualquer");
		page.setSobrenome("Sobrenome qualquer");
		//***dsl.clicaRadio("elementosForm:sexo:1");
		page.setSexoFeminino();
		//***dsl.clicaRadio("elementosForm:comidaFavorita:0");
		page.setComidaCarne();
		//***dsl.selecionarCombo("elementosForm:esportes", "Karate");
		//***dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
		page.setEsporte("Karate", "O que eh esporte?");
		//***dsl.clicarBotao("elementosForm:cadastrar");
		page.cadastrar();
		Assert.assertEquals("Voce faz esporte ou nao?", dsl.alertaObterTextoEAceita());
	
	}
	
	
}
