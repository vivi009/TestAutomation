package pagObjetToolsQA;

import java.io.File;

import org.openqa.selenium.WebDriver;

import mapsObjetToolsQA.MapsObjetWidgets;

public class PagsObjetWidgets extends MapsObjetWidgets {

	// CREAMOS EL CONTRUCTOR DE LA CLASE
	public PagsObjetWidgets(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}
	
	//CREAMOS METODO PARA SELECCIONAR DATAPICKER
		public void datapicker( File rutaCarpeta, String generarEvidencia) throws Exception {
			
			//SCROLL
			scrollelement(lblWidgets, generarEvidencia);
			click(lblWidgets, 10, rutaCarpeta, generarEvidencia); 
			waittime(2000);
			scrollelement(lblDataPicker, generarEvidencia);
			click(lblDataPicker, 10, rutaCarpeta, generarEvidencia);
			
		}
		
		//CREAMOS METODO PARA SELECCIONAR FECHA EN EL CALENDARIO
		public void date( Object fechaExcel,  File rutaCarpeta, String generarEvidencia) throws Exception {
			click(txtSelectDate, 10, rutaCarpeta, generarEvidencia);
			selectDate(xpathDd, fechaExcel, xpathMm, xpathAa, lblDataPicker, rutaCarpeta, generarEvidencia);
			dateAndTime(xpathHh, fechaExcel, xpathDd, txtDateAndTime, lblMonth, lblYear, lblDataPicker, rutaCarpeta, generarEvidencia);
			}
		
}