package pagObjetToolsQA;

import java.io.File;

import org.openqa.selenium.WebDriver;

import mapsObjetToolsQA.MapsObjetElements;

public class PagsObjetElements extends MapsObjetElements{
	
	//CREAMOS EL CONSTRUCTOR DE LA CLASE
	
		
	public PagsObjetElements(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
	}
	
	// CREAMOS LOS METODOS
	public void AddWebTables(String FirtsName, String LastName, String Email, String Age, String Salary,
			String Departament, File rutaCarpeta, String generarEvidencia) throws Exception {

		// INGRESO A WEB TABLES PARA AGREGAR UN NUEVO REGISTRO
		scrollelement(btnWebTables,generarEvidencia);
		click(btnWebTables, 10, rutaCarpeta, generarEvidencia);
		click(btnAdd, 10, rutaCarpeta, generarEvidencia);
		// INGRESO DE DATOS AL FORMULARIO
		sendKey(FirtsName, txtFirtsName, 10, rutaCarpeta, generarEvidencia);
		sendKey(LastName, txtLastName, 10, rutaCarpeta, generarEvidencia);
		sendKey(Email,txtEmail, 10, rutaCarpeta, generarEvidencia);
		sendKey(Age, txtAge, 10, rutaCarpeta, generarEvidencia);
		sendKey(Salary, txtSalary, 10, rutaCarpeta, generarEvidencia);
		sendKey(Departament, txtDepartament, 10, rutaCarpeta, generarEvidencia);
		// ENVIO DE DATOS
		click(btnSubmit, 10, rutaCarpeta, generarEvidencia);
			
		}
	//ELIMINAR UN REGISTRO ALEATORIO
		public void delete( File rutaCarpeta, String generarEvidencia) throws Exception {
		
			for(int i=1; i<=4; i++) {
				
				click(delete, 10, rutaCarpeta, generarEvidencia);
				waittime(2000);
			}
			
			}
	
}