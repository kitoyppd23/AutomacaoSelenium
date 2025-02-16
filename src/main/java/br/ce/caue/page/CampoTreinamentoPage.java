package br.ce.caue.page;

import br.ce.caue.core.BasePage;
import org.openqa.selenium.By;

public class CampoTreinamentoPage  extends BasePage {


	public String obterResultadoCadastro(){
		return dsl.obterTexto(By.xpath(".//*[@id='resultado']/span"));
	}

	public void setNome(String nome) {
		dsl.escrever(By.id("elementosForm:nome"), nome);
	}
	
	public void setSobrenome(String sobrenome) {
		dsl.escrever(By.id("elementosForm:sobrenome") ,sobrenome);
	}
	
	public void setSexoMasculino() {
		dsl.clickRadioButton("elementosForm:sexo");
	}

	public void setEscolaridade(String valor){
		dsl.selecionarCombo("elementosForm:escolaridade", valor);
	}

	public void setEsporte(String... valores) {
		for(String valor: valores)
			dsl.selecionarCombo("elementosForm:esportes", valor);
	}
	
	public void setComidaFavorita() {
		dsl.clickRadioButton("elementosForm:comidaFavorita:2");
	}

	public void cadastrar(){
		dsl.clickButton("elementosForm:cadastrar");
	}




	public String obterNomeCadastro(){
		return dsl.obterTexto(By.xpath("//*[@id='descNome']/span"));
	}

	public String obterSobrenomeCadastro(){
		return dsl.obterTexto(By.xpath("//*[@id='descSobrenome']/span"));
	}

	public String obterSexoCadastro(){
		return dsl.obterTexto(By.xpath("//*[@id='descSexo']/span"));
	}

	public String obterComidaCadastro(){
		return dsl.obterTexto(By.xpath("//*[@id='descComida']/span"));
	}

	public String obterEscolaridadeCadastro(){
		return dsl.obterTexto(By.xpath("//*[@id='descEscolaridade']/span"));
	}

	public String obterEsportesCadastro(){
		return dsl.obterTexto(By.xpath("//*[@id='descEsportes']/span"));
	}

}
