import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteJanelas {

@Test
public void deveInteragirComJanelaPopupTitulo() {
	WebDriver driver = new ChromeDriver();
	driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
	driver.findElement(By.id("buttonPopUpEasy")).click();
	driver.switchTo().window("Popup");
	driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
	driver.close();
	driver.switchTo().window("");
	driver.findElement(By.tagName("textarea")).sendKeys("E agora?");
}


@Test
public void deveInteragirComJanelaSemTitulo() {
	WebDriver driver = new ChromeDriver();
	driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
	driver.findElement(By.id("buttonPopUpHard")).click();
	System.out.println(driver.getWindowHandle());
	System.out.println(driver.getWindowHandle());
	driver.switchTo().window(driver.getWindowHandle());
	driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
	//secao 39 do selenium webdriver
	
	
	
	
}
	
}
