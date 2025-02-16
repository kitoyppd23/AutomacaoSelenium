import br.ce.caue.page.CampoTreinamentoPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import static br.ce.caue.core.DriverFactory.getDriver;


public class TesteAlert {


private CampoTreinamentoPage page;
	
	@Before
	public void inicializa() {
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage();
		
	}
	
	@After
	/*public void encerra() {
		driver.quit();
	}*/
	

	@Test
	public void deveInteragirComAlertSimple() {


		getDriver().findElement(By.id("alert")).click();
		Alert alert = getDriver().switchTo().alert();
		String texto = alert.getText();
		Assert.assertEquals("Alert Simples", texto);
		alert.accept();

		getDriver().findElement(By.id("elementosForm:nome")).sendKeys(texto);
	}
	
	@Test
		public void deveInteragirComConfirmNegado() {


		getDriver().findElement(By.id("confirm")).click();
		Alert alert = getDriver().switchTo().alert();
		alert.dismiss();
		String textoConfirm = alert.getText();
		Assert.assertEquals("Negado", textoConfirm);
		alert.accept();
		
	}
	
	@Test
		public void deveInteragirComComfirmCofirm() {


		getDriver().findElement(By.id("confirm")).click();
		Alert alert = getDriver().switchTo().alert();
		String texto = alert.getText();
		Assert.assertEquals("Confirm Simples", texto);
		alert.accept();
		String textoConfirm = alert.getText();
		Assert.assertEquals("Confirmado", textoConfirm);
		alert.accept();
	}
	
	@Test
		public void deveInteragirComPrompt() {


		getDriver().findElement(By.id("prompt")).click();
		Alert alert = getDriver().switchTo().alert();
		Assert.assertEquals("Digite um numero", alert.getText());
		alert.sendKeys("12");
		alert.accept();
		Assert.assertEquals("Era 12?", alert.getText());
		alert.accept();
		Assert.assertEquals(":D", alert.getText());
		alert.accept();
		
		
	}
	
	
/*	@Test
		public void realizandoCadastro() {

		page.setNome("wagner");
		page.setSobrenome("Lopes");
		page.setSexoMasculino();
		page.setComidaFavorita();
		//dsl.escreve("elementosForm:nome", "Caue");
		//dsl.escreve("elementosForm:sobrenome", "Lopes");
		//dsl.clickRadioButton("elementosForm:sexo");
		//dsl.clickRadioButton("elementosForm:comidaFavorita:2")
		
		
		WebElement element1 = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo1 = new Select (element1);
		combo1.selectByVisibleText("Superior");
		Assert.assertEquals("Superior", combo1.getFirstSelectedOption().getText());
		
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select (element);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");

		 
		driver.findElement(By.id("elementosForm:cadastrar")).click();

		Assert.assertEquals("Cadastrado!", page.obterResultadoCadastro());
		Assert.assertEquals("Caue", dsl.obterValueElement("elementosForm:nome"));
		Assert.assertTrue(dsl.obterTexto("resultado").startsWith("Cadastrado!"));
		Assert.assertEquals("Sobrenome: Lopes", dsl.obterTexto("descSobrenome"));
		Assert.assertEquals("Sexo: Masculino", dsl.obterTexto(By.id("descSexo")));
		Assert.assertEquals("Comida: Pizza", dsl.obterTexto("descComida"));
		Assert.assertEquals("Escolaridade: superior", dsl.obterTexto("descEscolaridade"));
		Assert.assertEquals("Esportes: Natacao Corrida", dsl.obterTexto("descEsportes"));


	}*/
	
	
	
}
