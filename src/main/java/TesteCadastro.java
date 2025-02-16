

import br.ce.caue.core.BaseTest;
import br.ce.caue.page.CampoTreinamentoPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static br.ce.caue.core.DriverFactory.getDriver;

public class TesteCadastro extends BaseTest {

    private CampoTreinamentoPage page;

    @Before
    public void inicializa(){
        getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        page = new CampoTreinamentoPage();
    }

    @Test
    public void deveRealizarCadastroComSucesso(){
        page.setNome("Wagner");
        page.setSobrenome("Costa");
        page.setSexoMasculino();
        page.setComidaFavorita();
        page.setEscolaridade("Mestrado");
        page.setEsporte("Natacao");
        page.cadastrar();

        Assert.assertEquals("Cadastrado!", page.obterResultadoCadastro());
        Assert.assertEquals("Wagner", page.obterNomeCadastro());
        Assert.assertEquals("Costa", page.obterSobrenomeCadastro());
        Assert.assertEquals("Masculino", page.obterSexoCadastro());
        Assert.assertEquals("Pizza", page.obterComidaCadastro());
        Assert.assertEquals("mestrado", page.obterEscolaridadeCadastro());
        Assert.assertEquals("Natacao", page.obterEsportesCadastro());
    }
}