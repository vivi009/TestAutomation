package pagObjetToolsQA;

import java.io.File;
import org.openqa.selenium.WebDriver;

import mapsObjetToolsQA.MapsObjetHome;


public class PagsObjetHome extends MapsObjetHome{
	
	
	String urlT;

	//CREAMOS EL CONSTRUCTOR DE LA CLASE
	public PagsObjetHome(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
	}
	
	//METODO INICIAL
		public void urlAccesoT() {
			driver.get(urlT);
		}
		
	public void setUrlT(String urlT) {
		this.urlT = urlT;
	}


	
	//METODO INGRESO AL MODULO ELEMENTS
	public void Elements(File rutaCarpeta, String generarEvidencia ) throws Exception {
		
		
		scrollelement(lblElements, generarEvidencia);
		click(lblElements, 10, rutaCarpeta, generarEvidencia); 
		
	}
	

	
		
	}


