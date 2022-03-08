package pagObjetMercadoLibre;


import org.openqa.selenium.WebDriver;

import mapsObjetMercadoLibre.MapsObjetMercadoLibre;

import java.io.File;

public class pagObjetMercadoLibre extends MapsObjetMercadoLibre {
	
	String urlM;
	public pagObjetMercadoLibre(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	
	public void urlAcceso() {
		driver.get(urlM);
	}
	
	public void setUrlM(String urlM) {
		this.urlM = urlM;
	}

	public void continuar(File rutaCarpeta, String generarEvidencia) throws Exception {
		   Boolean cookie = confirmar(btnEntendido, 10);
		   if (Boolean.TRUE.equals(cookie)) {
		      click(btnEntendido,10, rutaCarpeta, generarEvidencia);
		      desplazarseElemento(btnContinuar);
		      click(btnContinuar, 10, rutaCarpeta, generarEvidencia);
		   }
		}
	public void register(String email, File rutaCarpeta, String generarEvidencia) throws Exception {
		click(lblCrearTuCuenta, 10, rutaCarpeta, generarEvidencia);
		continuar(rutaCarpeta, generarEvidencia);
		click(btnValidar, 10, rutaCarpeta, generarEvidencia);
		sendKey(email, txtEmail, 10, rutaCarpeta, generarEvidencia);
		click(btnEnviarEmail, 10, rutaCarpeta, generarEvidencia);
		click(logoMercadoLibre, 10, rutaCarpeta, generarEvidencia);
		time(4);
	}
}

