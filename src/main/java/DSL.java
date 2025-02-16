import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static br.ce.caue.core.DriverFactory.getDriver;

public class DSL {

	// estancia


	// construtor



	public void escreve(String id_campo, String texto) {
		// para o método ficar genérico ele precisa ser parametrizado então ao inves
		// disso em baixo "elementosForm:nome" ele vira uma variavel
		// driver.findElement(By.id("elementosForm:nome")).sendKeys("Caue");
		// ficara assim - troquei tmb dentro do () ao lado de escreve na linha 15 o nome
		// da variavel id_campo e texto sempre acompanhado de String
		getDriver().findElement(By.id(id_campo)).clear();
		getDriver().findElement(By.id(id_campo)).sendKeys(texto);
		
	}

	public void escrever(By by, String texto){
		getDriver().findElement(by).clear();
		getDriver().findElement(by).sendKeys(texto);
	}
	

	public String obterValorCampo(String id_campo) {

		return getDriver().findElement(By.id(id_campo)).getAttribute("value");

	}

	public void clickRadioButton(String id_campo) {
		getDriver().findElement(By.id(id_campo)).click();

	}

	public boolean isRadioMarcado(String id) {
		return getDriver().findElement(By.id(id)).isSelected();
	}

	public void selecionarCombo(String id, String valor) {

		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		// combo.selectByIndex(2);
		// combo.selectByValue();
		combo.selectByVisibleText(valor);

	}

	public String obterValorCombo(String id) {

		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		// combo.selectByIndex(2);
		// combo.selectByValue();
		return combo.getFirstSelectedOption().getText();

	}

	public void clickButton(String id) {
		getDriver().findElement(By.id(id)).click();
	}

	public void clickLink(String link) {
		getDriver().findElement(By.linkText(link)).click();
	}

	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}

	public String obterTexto(String id) {
		return obterTexto(By.id(id));
	}



	public void entrarFrame(String id) {
		getDriver().switchTo().frame(id);
	}


	

	public Object obterValueElement(String id) {
		// TODO Auto-generated method stub
		return getDriver().findElement(By.id(id)).getAttribute("value");
	}


	public Object executarJS(String cmd, Object... param) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		return js.executeScript(cmd, param);

	}

	public String alertaObterTextoEAceita(){
		Alert alert = getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;
	}

	public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela){
		//procurar coluna do registro
		WebElement tabela = getDriver().findElement(By.xpath("//*[@id='elementosForm:tableUsuarios']"));
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
		getDriver().findElement(by).click();
	}

	public  void clickBasicOption(String id) {
		clickBasicOption(By.id(id));
	}


	public void clicarRadio(String id) {
		getDriver().findElement(By.id(id)).click();
	}

/*	public void selecionarComboPrime(String radical, String valor) {
		 dsl.clickBasicOption(By.xpath("//*[@id+radical+\"]"));
        dsl.clickBasicOption(By.xpath("//*[@id=\"j_id_8y:option_2\"]"));
	}*/

}
