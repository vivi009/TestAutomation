package mapsObjetToolsQA;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.ClaseBase;

public class MapsObjetElements extends ClaseBase {
	
	//CONSTRUCTOR DE LA CLASE
	public MapsObjetElements(WebDriver driver) {
		super(driver);
	}
	
	//CREAMOS LOS ELEMENTOS
	//ELEMENTOS INGRESO A WEB TABLES PARA AGREGAR UN NUEVO REGISTRO
	protected By btnWebTables = By.xpath("//span[contains(text(),'Web Tables')]");
	protected By btnAdd = By.xpath("//button[@id='addNewRecordButton']");
	//ELEMENTOS INGRESO DATOS AL FORMULARIO
	protected By txtFirtsName = By.xpath("//input[@id='firstName']");
	protected By txtLastName = By.xpath("//input[@id='lastName']");
	protected By txtEmail = By.xpath("//input[@id='userEmail']");
	protected By txtAge = By.xpath("//input[@id='age']");
	protected By txtSalary = By.xpath("//input[@id='salary']");
	protected By txtDepartament = By.xpath("//input[@id='department']"); 
	//ELEMENTOS ENVIO DE DATOS 
	protected By btnSubmit = By.xpath("//button[@id='submit']");
	//ELEMENTOS DE ELIMINAR
	protected By delete =By.xpath("//body/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/span[2]");
	
}
