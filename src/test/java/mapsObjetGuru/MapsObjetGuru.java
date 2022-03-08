package mapsObjetGuru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.ClaseBase;

public class MapsObjetGuru extends ClaseBase {

	// CONSTRUCTOR DE LA CLASE
	public MapsObjetGuru(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	// ELEMENTOS PAGINA INICIAL
	protected By lblRegister = By.xpath("//a[contains(text(),'REGISTER')]");

	// INFORMACIÓN DEL CONTACTO
	protected By txtFirstName = By.name("firstName");
	protected By txtLastName = By.name("lastName"); 
	protected By txtPhone = By.name("phone"); 
	protected By txtEmail = By.id("userName");

	// INFORMACIÓN DEL ENVÍO
	protected By txtAddress = By.name("address1");
	protected By txtCity = By.name("city");
	protected By txtState = By.name("state");
	protected By txtPostal = By.name("postalCode");
	protected By lblCountry = By.xpath("//*[@name='country']");

	// INFORMACIÓN DEL USUARIO
	protected By txtUserName = By.id("email");
	protected By txtPassword = By.name("password");
	protected By txtConfirmPassword = By.name("confirmPassword");

	// ENVIAR INFORMACIÓN
	protected By btnEnviar = By.name("submitt");
	
	protected By validacionResultado = By.xpath("//*/tr/td/p/font/b");
}
