package pagObjetGuru;

import java.io.File;


import org.openqa.selenium.WebDriver;

import mapsObjetGuru.MapsObjetGuru;

public class PagsObjetGuru extends MapsObjetGuru {
	
	String urlG;

	// CREAR CONSTRUCTOR DE LA CLASE
	public PagsObjetGuru(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	// METODO INICIAL
		public void urlAcceso() {
			driver.get(urlG);
		}
		
	public void setUrlG(String urlG) {
		this.urlG = urlG;
	}


	
	public void home(File rutaCarpeta, String generarEvidencia) throws Exception {
		click(lblRegister, 10, rutaCarpeta, generarEvidencia);
		time(1);
	}
	
	public String register(String firstName, String lastName, String phone, String email,
			String address, String city, String state, String postal, String country,
			String userName, String password, File rutaCarpeta, String generarEvidencia) throws Exception {
		
		sendKey(firstName, txtFirstName, 10, rutaCarpeta, generarEvidencia);
		//capture(rutaCarpeta,txtFirstName, generarEvidencia);
		sendKey(lastName, txtLastName, 10, rutaCarpeta, generarEvidencia);
		sendKey(phone, txtPhone, 10, rutaCarpeta, generarEvidencia);
		sendKey(email, txtEmail, 10, rutaCarpeta, generarEvidencia); 
		sendKey(address, txtAddress, 10, rutaCarpeta, generarEvidencia);
		sendKey(city, txtCity, 10, rutaCarpeta, generarEvidencia);
		sendKey(state, txtState, 10, rutaCarpeta, generarEvidencia);
		sendKey(postal, txtPostal, 10, rutaCarpeta, generarEvidencia);
		sendKey(country, lblCountry, 10, rutaCarpeta, generarEvidencia);
		sendKey(userName, txtUserName, 10, rutaCarpeta, generarEvidencia);
		sendKey(password, txtPassword, 10, rutaCarpeta, generarEvidencia);
		sendKey(password, txtConfirmPassword, 10, rutaCarpeta, generarEvidencia);
		click(btnEnviar, 10, rutaCarpeta, generarEvidencia);
		time(4);
		
		String valor = capturarValorSelenium(validacionResultado, rutaCarpeta, generarEvidencia);
		return valor;
	}

	
}
