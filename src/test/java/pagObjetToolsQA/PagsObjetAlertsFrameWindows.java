package pagObjetToolsQA;

import java.io.File;
import org.openqa.selenium.WebDriver;

import mapsObjetToolsQA.MapsObjetAlertsFrameWindows;


public class PagsObjetAlertsFrameWindows extends MapsObjetAlertsFrameWindows {

	// CREAMOS EL CONSTRUCTOR DE LA CLASE
	public PagsObjetAlertsFrameWindows(WebDriver driver) {
		super(driver);
		this.driver = driver;

	}
	//METODO SELECION DE ALERTAS
	public void alerts(File rutaCarpeta, String  generarEvidencia) throws Exception {

		
		click(lblAlertsFromWindows, 10, rutaCarpeta, generarEvidencia);
		scrollelement(lblAlerts, generarEvidencia);
		waittime(2000);
		click(lblAlerts, 10, rutaCarpeta,  generarEvidencia);  

	}
	//METODO SELECION BOTONES DE ALERTAS
	public void Optionsalerts( File rutaCarpeta, String name,  String  generarEvidencia) throws Exception {
		
		click(btnToSeeAlert, 10, generarEvidencia);
		alert();
		click(btnAlertWillAppearAfter5Seconds, 10, generarEvidencia);
		alert(); 
		click(btnconfirmBoxWillAppear, 10, generarEvidencia);
		alert();
		scrollelement(btnpromptBoxWillAppear, generarEvidencia);
		click(btnpromptBoxWillAppear, 10, generarEvidencia);
		//driver.switchTo().alert().sendKeys("vivi");
		alertaTexto(name);
		alert();
		scrollelement(btnToSeeAlert, generarEvidencia);
		waittime(3000);
		capture(rutaCarpeta,btnToSeeAlert, generarEvidencia);
		waittime(1000);
	}
	

}
