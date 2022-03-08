package test;

import org.testng.annotations.Test;
import base.ClaseBase;
import pagObjetGuru.PagsObjetGuru;
import pagObjetMercadoLibre.pagObjetMercadoLibre;
import pagObjetToolsQA.PagsObjetAlertsFrameWindows;
import pagObjetToolsQA.PagsObjetElements;
import pagObjetToolsQA.PagsObjetHome;
import pagObjetToolsQA.PagsObjetWidgets;
import utilidades.ExcelUtilidades;
import utilidades.GenerarReportePdf;
import utilidades.MyScreenRecorder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.io.File;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class runTest {

	private WebDriver driver;

	ClaseBase claseBase;
	
	//INSTANCIAR MERCADO LIBRE
	pagObjetMercadoLibre mercadoLibre;
	//INSTANCIAR PAGS GURU
	PagsObjetGuru guru;
	//INSTANCIAR  PAGS TOOLSQA
	PagsObjetHome home;
	PagsObjetElements elements;
	PagsObjetWidgets widgets;
	PagsObjetAlertsFrameWindows alerts;
	GenerarReportePdf pdf  ;
	File rutaCarpeta;
	String valor;
	
	@BeforeClass
	@Parameters({ "urlM", "urlG", "urlT", "rutaImagenReporte" })

	public void beforeClass(@Optional("default") String urlM, @Optional("default") String urlG,
			@Optional("default") String urlT, @Optional("default") String rutaImagenReporte) {

		// DRIVER
		driver = ClaseBase.chromeDriverConnetion();
		claseBase = new ClaseBase(driver);

		pdf = new GenerarReportePdf();
		pdf.setRutaImagen(rutaImagenReporte);

		// MERCADOLIBRE
		mercadoLibre = new pagObjetMercadoLibre(driver);
		mercadoLibre.setUrlM(urlM);

		// MERCURY
		guru = new PagsObjetGuru(driver);
		guru.setUrlG(urlG);

		// TOOLSQA
		home = new PagsObjetHome(driver);
		home.setUrlT(urlT);
		elements = new PagsObjetElements(driver);
		widgets = new PagsObjetWidgets(driver);
		alerts = new PagsObjetAlertsFrameWindows(driver);

	}
	
	@Test(dataProvider = "MercadoLibre", priority = 0, description = "MercadoLibre")
	public void PruebaMercadoLibre(String Ejecutable, String Evidencia, String Email, String generarEvidencia) throws Exception {
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		
		//VALIDAR SI SE DESEA EJECUTAR EL CASO
		if(Ejecutable.contains("SI")){
			
			//ACCEDER AL METODO DE LA URL
			mercadoLibre.urlAcceso();
			
			//VALIDAR SI SE DESEA GUARDAR EVIDENCIA
			if(Evidencia.contains("SI")) 
			{
				//RUTA CARPETA PARA GUARDAR EVIDENCIA
				rutaCarpeta = claseBase.crearCarpeta(nomTest);
				
				//INICIAR GRABACION DEL VIDEO
				MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
				
				//INICIAR CREACION DEL PDF
				pdf.crearPlantilla(nomTest, rutaCarpeta);
				
				//ACCEDER A LOS METODOS DEL CASO
				mercadoLibre.register(Email, rutaCarpeta, generarEvidencia );
				
				//FINALIZAR GRABACION DEL VIDEO
				MyScreenRecorder.stopRecording();
				
				//FINALIZAR CREACION DEL REPORTE PDF
				pdf.cerrarPlantilla();
			}
			else {
				
				//ACCEDER A LOS METODOS DEL CASO
				mercadoLibre.register(Email, rutaCarpeta, generarEvidencia);
			}
				
		}
		else {
			
			System.out.println("No se ejecuto test Mercado Libre...");
		}				
		
	}

	@DataProvider(name = "MercadoLibre")
	public Object[][] datosMercadoLibre() throws Exception {
		Object[][] arreglo = ExcelUtilidades.getTableArray("./data/datos.xlsx", "MERCADOLIBRE");

		return arreglo;
	}

	
	@Test(dataProvider = "RegistroMercury", priority = 0, description = "RegistroMercury")
	public void pruebaMercury(String Ejecutable, String Evidencia, String FirstName, String LastName, String Phone,
			String Email, String Address, String City, String State, String Postal, String Country, String UserName,
			String Password, String generarEvidencia) throws Exception {

		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();

		if (Ejecutable.contains("SI")) {

			//ACCEDER AL METODO DE LA URL
			guru.urlAcceso();

			if (Evidencia.contains("SI")) {
				
				//RUTA CARPETA PARA GUARDAR EVIDENCIA
				rutaCarpeta = claseBase.crearCarpeta(nomTest);
				
				//INICIAR GRABACION DEL VIDEO
				MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
			
				//INICIAR CREACION DEL PDF
				pdf.crearPlantilla(nomTest, rutaCarpeta);
				
				//ACCEDER A LOS METODOS DEL CASO
				guru.home(rutaCarpeta, generarEvidencia);
				valor=guru.register(FirstName, LastName, Phone, Email, Address, City, State, Postal, Country, UserName,
						Password, rutaCarpeta, generarEvidencia);
				
				//FINALIZAR GRABACION DEL VIDEO
				MyScreenRecorder.stopRecording();
				
				//FINALIZAR CREACION DEL REPORTE PDF
				pdf.cerrarPlantilla();
			} else {

				//ACCEDER A LOS METODOS DEL CASO
				guru.home(rutaCarpeta, generarEvidencia);
				valor=guru.register(FirstName, LastName, Phone, Email, Address, City, State, Postal, Country, UserName,
						Password, rutaCarpeta, generarEvidencia);
			}
			assert valor.contains(FirstName);

		} else {

			System.out.println("No se ejecuto test Mercury...");
		}		
		
	}

	@DataProvider(name = "RegistroMercury")
	public Object[][] datosMercury() throws Exception {
		Object[][] arreglo = ExcelUtilidades.getTableArray("./data/datos.xlsx", "MERCURYREGISTRO");

		return arreglo;
	}


	@Test(dataProvider = "toolsQA", priority = 0, description = "toolsQA")
	public void pruebaToolsQA(String Ejecutable, String Evidencia, String FirtsName, String LastName, String Email,
			String Age, String Salary, String Departament, String Date, String generarEvidencia) throws Exception {
		
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();

		if (Ejecutable.contains("SI")) {
			
			//ACCEDER AL METODO DE LA URL
			home.urlAccesoT();
			
			if (Evidencia.contains("SI")) {
				//RUTA CARPETA PARA GUARDAR EVIDENCIA
				rutaCarpeta = claseBase.crearCarpeta(nomTest);
				//INICIAR GRABACION DEL VIDEO
				MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
				
				//INICIAR CREACION DEL PDF
				pdf.crearPlantilla(nomTest, rutaCarpeta);
				
				//ACCEDER A LOS METODOS DEL CASO
				home.Elements(rutaCarpeta, generarEvidencia);
				elements.AddWebTables(FirtsName, LastName, Email, Age, Salary, Departament, rutaCarpeta, generarEvidencia);
				elements.delete(rutaCarpeta, generarEvidencia);
				Object fechaExcel = (Date);
				widgets.datapicker(rutaCarpeta, generarEvidencia);
				widgets.date(fechaExcel, rutaCarpeta, generarEvidencia);
				alerts.alerts(rutaCarpeta, generarEvidencia);
				alerts.Optionsalerts(rutaCarpeta, FirtsName, generarEvidencia);
				
				//FINALIZAR GRABACION DEL VIDEO
				MyScreenRecorder.stopRecording();
				
				//FINALIZAR CREACION DEL REPORTE PDF
				pdf.cerrarPlantilla();
				
			} else {
				
				//ACCEDER A LOS METODOS DEL CASO
				home.Elements(rutaCarpeta, generarEvidencia);
				elements.AddWebTables(FirtsName, LastName, Email, Age, Salary, Departament, rutaCarpeta, generarEvidencia);
				elements.delete(rutaCarpeta, generarEvidencia);
				Object fechaExcel = (Date);
				widgets.datapicker(rutaCarpeta, generarEvidencia);
				widgets.date(fechaExcel, rutaCarpeta,generarEvidencia);
				alerts.alerts(rutaCarpeta, generarEvidencia);
				alerts.Optionsalerts(rutaCarpeta, FirtsName, generarEvidencia);
			}

		} else {

			System.out.println("No se ejecuto test ToolsQA...");
		}

	}

	@DataProvider(name = "toolsQA")
	public Object[][] datos() throws Exception {
		Object[][] arreglo = ExcelUtilidades.getTableArray("./data/datos.xlsx", "TOOLSQA");

		return arreglo;
	}

	@AfterClass
	public void afterClass() {
		if (driver != null) {
			driver.quit();
		}
	}
}
