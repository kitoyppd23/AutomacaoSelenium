import br.ce.caue.core.DriverFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class testPrimeFaces {


    private DSL dsl;

    @Before
    public void inicializa() {

        DriverFactory.getDriver().get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml?jfwid=f594c");
        dsl = new DSL();

    }

    @After
    public void encerra() {
        /* driver.quit(); */
    }


    @Test
    public void deveInteragirComBasic(){
        dsl.clickBasicOption(By.xpath("//*[@id=\"j_id_8y:option\"]"));
        dsl.clickBasicOption(By.xpath("//*[@id=\"j_id_8y:option_2\"]"));
       /* driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));*/

        Assert.assertEquals("Option2", dsl.obterTexto("j_id_8y:option_label"));
    }

}
