package mapsObjetMercadoLibre;

import base.ClaseBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MapsObjetMercadoLibre extends ClaseBase {

    public MapsObjetMercadoLibre(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    // ELEMENTOS PAGINA INICIAL
    protected By lblCrearTuCuenta = By.xpath("//a[@data-link-id='registration']");
    protected By btnEntendido = By.xpath("//body/div/div/button[contains(text(),'Entendido')]");
    protected By btnContinuar = By.xpath("//*[@role='button']");
    protected By btnValidar = By.cssSelector(".andes-button__text");
    protected By txtEmail = By.name("email");
    protected By btnEnviarEmail = By.xpath("//span[@class='andes-button__content']");
    protected By logoMercadoLibre = By.xpath("//a[@class='nav-logo']");
}

