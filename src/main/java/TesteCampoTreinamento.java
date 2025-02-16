import br.ce.caue.core.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.rules.TestName;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static br.ce.caue.core.DriverFactory.getDriver;

public class TesteCampoTreinamento {
	
	

	private DSL dsl;



	@Before
	public void inicializa() {

		DriverFactory.getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();

	}

	@Rule
	public TestName testName = new TestName();
	
	@After
	public void encerra() throws IOException {
		/* driver.quit(); */
		TakesScreenshot screenshot = (TakesScreenshot) DriverFactory.getDriver();
		File arquivo = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo,  new File(testName.getMethodName() + ".jpg"));
	}


	
	@Test
	public void testTextField() {	
		
		dsl.escreve("elementosForm:nome", "Caue");
		//driver.findElement(By.id("elementosForm:nome")).sendKeys("Caue");
		Assert.assertEquals("Caue", dsl.obterValorCampo("elementosForm:nome"));
		
		
		
	}
	
	@Test
	public void deveInteragirComTextArea() {

		dsl.escreve("elementosForm:sugestoes", "Lopes\n\nsegunda linha" );
		//driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Lopes\n\nsegunda linha");
		Assert.assertEquals("Lopes\n\nsegunda linha", dsl.obterValorCampo("elementosForm:sugestoes"));
		
		
	}
	
	@Test
	public void radioBox() {
			
			dsl.clickRadioButton("elementosForm:sexo:0");
			Assert.assertTrue(dsl.isRadioMarcado("elementosForm:sexo:0"));
			
			
	}

	@Test
	public void checkBox() {

		DriverFactory.getDriver().findElement(By.id("elementosForm:comidaFavorita:2")).click();
		Assert.assertTrue(dsl.isRadioMarcado("elementosForm:comidaFavorita:2"));
		
	
	}
	
	@Test
	public void testCombo() {
		
			
			
			dsl.selecionarCombo("elementosForm:escolaridade", "Superior");
			Assert.assertEquals("Superior", dsl.obterValorCombo("elementosForm:escolaridade"));
			
		
	}
	
	
	@Test
	public void deveVerificarValoresCombo () {

		WebElement element = DriverFactory.getDriver().findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select (element);
		List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());
		
		
		boolean encontrou = false;
		for(WebElement option: options) {
			if(option.getText().equals("Mestrado")) {
				encontrou = true;
				break;
			}
		}
		Assert.assertTrue(encontrou);
		
	}
	
	@Test
	public void verificarMultiplaEscolhaCombo () {
	
		dsl.selecionarCombo("elementosForm:esportes", "Natacao");
		dsl.selecionarCombo("elementosForm:esportes", "Corrida");
		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
		
		WebElement element = DriverFactory.getDriver().findElement(By.id("elementosForm:esportes"));
		Select combo = new Select (element);
		
		
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectedOptions.size());
		
		combo.deselectByVisibleText("Corrida");
		allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectedOptions.size());
		
		
		
	}
	
	@Test
	public void deveInteragirComBotoes() {

		dsl.clickButton("buttonSimple");
		WebElement botao = DriverFactory.getDriver().findElement(By.id("buttonSimple"));
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
		
	}
	
	@Test
	@Ignore
	public void deveInteragirComLinks() {

		dsl.clickLink("Voltar");
		//Assert.fail();
		Assert.assertEquals("Voltou!", dsl.obterTexto("resultado"));
		
		
	}
	
	@Test
	public void deveBuscarTextosNaPagina() {

		Assert.assertEquals("Campo de Treinamento", dsl.obterTexto(By.tagName("h3")));
			
		
	}
	
	@Test
	public void escreveNomesDiferentes() {
		dsl.escreve("elementosForm:nome", "Caue");
		Assert.assertEquals("Caue", dsl.obterValorCampo("elementosForm:nome"));
		
		
		
		dsl.escreve("elementosForm:nome", "Lopes");
		Assert.assertEquals("Lopes", dsl.obterValorCampo("elementosForm:nome"));
		
		
	}
	

	  @Test public void testJavascript() {
		  JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		  //js.executeAsyncScript("alert('Testando js via selenium')");
		  js.executeScript("document.getElementById('elementosForm:nome').value = 'Escrito via js' ");
		  js.executeScript("document.getElementById('elementosForm:sobrenome').type = 'radio' ");

		  WebElement element = DriverFactory.getDriver().findElement(By.id(("elementosForm:nome")));
		  js.executeScript("arguments[0].style.border = arguments[1]", element, "solid 4px red");

	  }

	  @Test
	public void deveClicarCampoTabela() {

		dsl.clicarBotaoTabela("Nome", "Maria", "Botao", "elementosForm:tabelaeUsuarios");
		  Alert alert = getDriver().switchTo().alert();
		  Assert.assertEquals("Maria", alert.getText());
		  alert.accept();
	}
	
}
