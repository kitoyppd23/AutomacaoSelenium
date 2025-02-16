import br.ce.caue.core.DriverFactory;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	TesteFrames.class,
	TesteAlert.class,
	TesteCampoTreinamento.class,
})


public class SuiteTeste {
	@AfterClass
	public static void finalizaTudo(){

		DriverFactory.killDriver();
	}

}
