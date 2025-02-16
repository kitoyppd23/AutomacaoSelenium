import br.ce.caue.core.DriverFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static br.ce.caue.core.DriverFactory.getDriver;

public class TesteFrames {


    private DSL dsl;

    @Before
    public void inicializa() {

        DriverFactory.getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        dsl = new DSL();
    }

    @After
    public void finaliza() {
        DriverFactory.killDriver();
    }

    @Test
    public void deveInteragirComFrames() {


        getDriver().switchTo().frame("frame1");
        getDriver().findElement(By.id("frameButton")).click();
        Alert alert = getDriver().switchTo().alert();
        String msg = alert.getText();
        Assert.assertEquals("Frame OK!", msg);
        alert.accept();

        getDriver().switchTo().defaultContent();
        getDriver().findElement(By.id("elementosForm:nome")).sendKeys(msg);
    }

    @Test
    public void deveInteragirComFrameEscondido() {
        WebElement frame = getDriver().findElement(By.id("frame2"));
        dsl.executarJS("window.scrollBy(0, arguments[0])", frame.getLocation().y);
        dsl.entrarFrame("frame2");
        dsl.clickButton("frameButton");
        String msg = dsl.alertaObterTextoEAceita();
        Assert.assertEquals("Frame OK!", msg);
    }

}


