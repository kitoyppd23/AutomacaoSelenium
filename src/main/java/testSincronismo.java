import br.ce.caue.core.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class testSincronismo {


    private DSL dsl;

    @Before
    public void inicializa() {

        DriverFactory.getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        dsl = new DSL();

    }

    @After
    public void encerra() {
        /* driver.quit(); */
    }

    @Test
    public void deveInteragirComRespostaDemorada() throws InterruptedException {
        dsl.clickButton("buttonDelay");
        Thread.sleep(5000);
        dsl.escreve("novoCampo", "Deu Certo");
    }

    @Test
    public void deveInteragirComRespostaDemoradaImplicita() throws InterruptedException {
        dsl.clickButton("buttonDelay");
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        dsl.escreve("novoCampo", "Deu Certo");
    }

  /*  @Test
    public void deveUtilizarEsperaExplicita() throws InterruptedException{
        dsl.clickButton("buttonDelay");
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("novoCampo")));
        dsl.escreve("novoCampo", "Deu certo?");
    }
*/
}
