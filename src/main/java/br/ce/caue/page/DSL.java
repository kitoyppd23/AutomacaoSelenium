package br.ce.caue.page;

import br.ce.caue.core.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DSL {



	public void escrever(By by, String texto){
		DriverFactory.getDriver().findElement(by).clear();
		DriverFactory.getDriver().findElement(by).sendKeys(texto);
	}
	

	public String obterValorCampo(String id_campo) {

		return DriverFactory.getDriver().findElement(By.id(id_campo)).getAttribute("value");

	}

	public void clickRadioButton(String id_campo) {
		DriverFactory.getDriver().findElement(By.id(id_campo)).click();

	}

	public boolean isRadioMarcado(String id) {
		return DriverFactory.getDriver().findElement(By.id(id)).isSelected();
	}

	public void selecionarCombo(String id, String valor) {

		WebElement element = DriverFactory.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		// combo.selectByIndex(2);
		// combo.selectByValue();
		combo.selectByVisibleText(valor);

	}

	public String obterValorCombo(String id) {

		WebElement element = DriverFactory.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		// combo.selectByIndex(2);
		// combo.selectByValue();
		return combo.getFirstSelectedOption().getText();

	}

	public void clickButton(String id) {
		DriverFactory.getDriver().findElement(By.id(id)).click();
	}

	public void clickLink(String link) {
		DriverFactory.getDriver().findElement(By.linkText(link)).click();
	}

	public String obterTexto(By by) {
		return DriverFactory.getDriver().findElement(by).getText();
	}

	public String obterTexto(String id) {
		return obterTexto(By.id(id));
	}



	public void entrarFrame(String id) {
		DriverFactory.getDriver().switchTo().frame(id);
	}


	

	public Object obterValueElement(String id) {
		// TODO Auto-generated method stub
		return DriverFactory.getDriver().findElement(By.id(id)).getAttribute("value");
	}


	public Object executarJS(String cmd, Object... param) {
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		return js.executeScript(cmd, param);

	}

	public String alertaObterTextoEAceita(){
		Alert alert = DriverFactory.getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;
	}

	public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela){
		//procurar coluna do registro
		WebElement tabela = DriverFactory.getDriver().findElement(By.xpath("//*[@id='elementosForm:tableUsuarios']"));
		int idColuna = obterIndiceColuna(colunaBusca, tabela);
		
		//encontrar a linha do registro
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);
		
		//procurar coluna do botao
		int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);
		
		//clicar no botao da celula encontrada
		WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
		celula.findElement(By.xpath(".//input")).click();
		
	}

	protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
		int idLinha = -1;
		for(int i = 0; i < linhas.size(); i++) {
			if(linhas.get(i).getText().equals(valor)) {
				idLinha = i+1;
				break;
			}
		}
		return idLinha;
	}

	protected int obterIndiceColuna(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int idColuna = -1;
		for(int i = 0; i < colunas.size(); i++) {
			if(colunas.get(i).getText().equals(coluna)) {
				idColuna = i+1;
				break;
			}
		}
		return idColuna;
	}


	public void clickBasicOption(By by){
		DriverFactory.getDriver().findElement(by).click();
	}

	public  void clickBasicOption(String id) {
		clickBasicOption(By.id(id));
	}


	public void clicarRadio(String id) {
		DriverFactory.getDriver().findElement(By.id(id)).click();
	}

/*	public void selecionarComboPrime(String radical, String valor) {
		 dsl.clickBasicOption(By.xpath("//*[@id+radical+\"]"));
        dsl.clickBasicOption(By.xpath("//*[@id=\"j_id_8y:option_2\"]"));
	}*/

}
