import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteRegraDeNegocio {

	@Test
	public void rnLogin() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
        String msg = alert.getText();
        Assert.assertEquals("Nome eh obrigatorio", msg);
        alert.accept();
        driver.quit();
		
		
				
	}
	
	@Test
	public void rnLoginSobrenome() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Caue");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
        String msg = alert.getText();
        Assert.assertEquals("Sobrenome eh obrigatorio", msg);
        alert.accept();
        driver.quit();
		
		
				
	}
	
	@Test
	public void rnSexo() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Caue");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Lopes");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
        String msg = alert.getText();
        Assert.assertEquals("Sexo eh obrigatorio", msg);
        alert.accept();
        driver.quit();
		
		
				
	}
	
	@Test
	public void rnComida() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Caue");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Lopes");
		driver.findElement(By.id("elementosForm:sexo")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
        alert.accept();
        driver.quit();
		
		
				
	}
	
	@Test
	public void rnEsporte() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Caue");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Lopes");
		driver.findElement(By.id("elementosForm:sexo")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();

		Select combo = new Select (driver.findElement(By.id("elementosForm:esportes")));
		combo.selectByVisibleText("Karate");
		combo.selectByVisibleText("O que eh esporte?");
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
        String msg = alert.getText();
        Assert.assertEquals("Voce faz esporte ou nao?", msg);
        alert.accept();
        driver.quit();
		
		
				
	}
	
}
