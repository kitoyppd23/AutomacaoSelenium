import br.ce.caue.core.DriverFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TesteAjax {

    private DSL dsl;

    @Before
    public void inicializa(){

        DriverFactory.getDriver().manage().window().setSize(new Dimension(1200, 765));
        DriverFactory.getDriver().get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml?jfwid=97716");
        dsl = new DSL();

    }

    @After
    public void encerra(){
        DriverFactory.killDriver();
    }

    @Test
    public void testAjax(){
        dsl.escrever(By.id("j_id_7w:name"), "Teste");
        dsl.clickButton("j_id_7w:j_id_82");
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.textToBe(By.id("j_id_7w:display"), "Teste"));
        //*  /*  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("j_idt98")));
        //        desta forma não deu certo pois eu nao sabia exatamente qual era o elemento da imagem que sumia apos o carregamento*/
        Assert.assertEquals("Teste", dsl.obterTexto("j_id_7w:display"));

    }

}
