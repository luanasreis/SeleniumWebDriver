import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {

	private WebDriver driver;
	private DSL dsl;
	
	
	@Before
	public void incializa() {
		//WebDriver driver = new FirefoxDriver();
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 750));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html"); //abre o arquivo que coloquei na pasta de resources do projeto, para ficar um endereço generico
		dsl = new DSL(driver);
		
	}


	@After
	public void finaliza() {
		driver.quit();
	}


	@Test
	public void testTextField() { //campo de texto de uma linha em um formulário 
		//WebDriver driver = new FirefoxDriver();
		//driver.manage().window().setSize(new Dimension(1200, 750));
		//driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		// Escrever algo em um campo de texto
		//driver.findElement(By.id("elementosForm:nome")) digo ao selenium qual é o campo que eu quero interagir
		//*driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita"); //encontro o id desse elemento inspecionando a página com o botão direito>inspecionar e procuro o id ou encontro o id do elemento pelo SeleniumIDE, fazendo a gravação escrevendo algo no campo e pegando o id desse campo, neste caso o id obtido lá foi "id=elementosForm:nome", então uso a função do selenium webdriver para setar o ID do campo obtido no selenium ide
		dsl.escrever("elementosForm:nome", "Teste de escrita" ); //USANDO O METODO DSL PARA REUSO											// sendKeys é o que vai testear de a frase "Teste de escrita" vai ser escrito no elemento do forms correto, no caso elementosForm:nome, ou seja, se aquele campo está recebendo uma entrada de texto			
		
		
		//Verifica se o que eu escrevi em um campo realmente foi escrito
		// driver.findElement(By.id("elementosForm:nome")).getAttribute("value"); pego o que está escrito no campo elementosForm:nome do formulario
		//Assert.assertEquals("Teste de escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value")); //comparo o que eu digitei com o que está escrito no campo que estou testando
		Assert.assertEquals("Teste de escrita", dsl.obterValorCampo("elementosForm:nome")); //USANDO MÉTODO DSL PARA REÚSO
	
		//driver.quit(); //fecha as janelas e o que estiver rodando por baixo
	}
	
	@Test
	public void testeTextFielDuplo() {
		dsl.escrever("elementosForm:nome", "Nome1");
		Assert.assertEquals("Nome1", dsl.obterValorCampo("elementosForm:nome"));
		
		dsl.escrever("elementosForm:nome", "Nome2");
		Assert.assertEquals("Nome2", dsl.obterValorCampo("elementosForm:nome"));

				
	}
	
	@Test
	public void testTextArea() { //caixa de texto com mais de uma linha
		//WebDriver driver = new FirefoxDriver();
		//driver.manage().window().setSize(new Dimension(1200, 750));
		//driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		//DIGITA NA CAIXA DE TEXTO
		//driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste na caixa de texto\n\nteste em outra linha");
		dsl.escrever("elementosForm:sugestoes", "Teste na caixa de texto\n\nteste em outra linha" ); //USANDO O METODO DSL PARA REUSO											// sendKeys é o que vai testear de a frase "Teste de escrita" vai ser escrito no elemento do forms correto, no caso elementosForm:nome, ou seja, se aquele campo está recebendo uma entrada de texto			
		
		
		// VERIFICA SE O TEXTO DIGITADO REALMENTE FOI PARA A CAIXA DE TEXTO
		//Assert.assertEquals("Teste na caixa de texto\n\nteste em outra linha", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		Assert.assertEquals("Teste na caixa de texto\n\nteste em outra linha", dsl.obterValorCampo("elementosForm:sugestoes"));
		
		
		//driver.quit();
	}
	

	@Test
	public void testRadioButton() { //caixa de texto com mais de uma linha
		//WebDriver driver = new FirefoxDriver();
		//driver.manage().window().setSize(new Dimension(1200, 750));
		//driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
		//VERIFICAR SE PODE CLICAR O ELEMENTO RADIO BOTTON
		//driver.findElement(By.id("elementosForm:sexo:0")).click();
		dsl.clicarRadio("elementosForm:sexo:0"); //USANDO DSL PARA REUSO
		
		// VERIFICAR SE O ELEMENTO REALMENTE FOI CLICADO
		//Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		Assert.assertTrue(dsl.isRadioMarcado("elementosForm:sexo:0"));
		
		
		
		//driver.quit();
	}
	
	@Test
	public void testCheckButton() { //caixa de texto com mais de uma linha
		//WebDriver driver = new FirefoxDriver();
		//driver.manage().window().setSize(new Dimension(1200, 750));
		//driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		// CLICA NO BOTÃO CHECK BOX
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		
		// VERIFICA SE O BOTÃO REALMENTE FOI CLICADO
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());
		
		//driver.quit();

	}
	
		@Test
		public void testeCombo() {
			//WebDriver driver = new FirefoxDriver();
			//driver.manage().window().setSize(new Dimension(1200, 765));
			//driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
			// Conseguir capturar o campo do combo (menu suspenso)
			//**WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
			//**Select combo = new Select(element);
	
			// selecionar um elemento do combo
			//combo.selectByIndex(3); ///seleciona pela posicao da opcao no combo combo
			//combo.selectByValue("superior"); //seleciona pelo nome da opçao no value
			//**combo.selectByVisibleText("2o grau completo");
			dsl.selecionarCombo("elementosForm:escolaridade", "2o grau completo");
			
			//**Assert.assertEquals("2o grau completo", combo.getFirstSelectedOption().getText()); //pega o texto do primeiro valor selecionado
			Assert.assertEquals("2o grau completo", dsl.obterValorCombo("elementosForm:escolaridade"));
			
			
			//driver.quit();
	}
		
	@Test
	public void comboMultiplaEscolha() {
		//WebDriver driver = new FirefoxDriver();
		//driver.manage().window().setSize(new Dimension (1200, 765));
		//driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		//combo.selectByVisibleText("Natacao");
		//combo.selectByVisibleText("Corrida");
		//combo.selectByVisibleText("O que eh esporte?");
		dsl.selecionarCombo("elementosForm:esportes", "Natacao");
		dsl.selecionarCombo("elementosForm:esportes", "Corrida");
		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");

		List<String> opcoesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
		Assert.assertEquals(3, opcoesMarcadas.size());
		
		dsl.deselecionarCombo("elementosForm:esportes", "Corrida");
		opcoesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
		Assert.assertEquals(2, opcoesMarcadas.size());
		Assert.assertTrue(opcoesMarcadas.containsAll(Arrays.asList("Natacao", "O que eh esporte?")));
		
		//driver.quit();
		
	}
	
	@Test
	public void testBotao() {
		//WebDriver driver = new FirefoxDriver();
		//driver.manage().window().setSize(new Dimension (1200,765));
		//driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
		//driver.findElement(By.id("buttonSimple")).click();
		dsl.clicarBotao("buttonSimple");
		//Assert.assertEquals("Obrigado!", driver.findElement(By.id("buttonSimple")).getAttribute("value"));
		Assert.assertEquals("Obrigado!", dsl.obterValueElemento("buttonSimple"));
		
		
		//ou
		// WebElement botao = driver.findElement(By.id("buttonSimple"));
		//botao.click();
		//Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
	
		//driver.quit();
	}
	
	@Test
	// @Ignore //para nao executar um teste
	public void testLinks() {
		//WebDriver driver = new FirefoxDriver();
		//driver.manage().window().setSize(new Dimension (1200,765));
		//driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
		//driver.findElement(By.linkText("Voltar")).click();
		dsl.clicarLink("Voltar");
		
		//Assert.fail(); - PARA DAR BARRA VERMELHA
		
		Assert.assertEquals("Voltou!", dsl.obterTexto("resultado"));
		
		
		//driver.quit();
		
	}
	
	@Test
	public void testTextosNaPagina() {
		//WebDriver driver = new FirefoxDriver();
		//driver.manage().window().setSize(new Dimension (1200,765));
		//driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
		//verifica se um determinado texto está dentro do <body> da pagina
		//Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
	
		//verifica um texto em uma determinada posicao da pagina
		//Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("body")).getText());
		
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", dsl.obterTexto(By.className("facilAchar")));
		
		//driver.quit();
	}


	
}
