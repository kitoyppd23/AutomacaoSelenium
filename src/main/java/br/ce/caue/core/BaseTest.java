package br.ce.caue.core;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static br.ce.caue.core.DriverFactory.killDriver;

public class BaseTest {

    @After
    public void finaliza() throws IOException {
        TakesScreenshot ss = (TakesScreenshot) DriverFactory.getDriver();
        File arquivo = ss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(arquivo, new File( "screenshot.jpg"));
        if(Propriedades.FECHAR_BROWSER) {
            killDriver();
        }
    }

}
