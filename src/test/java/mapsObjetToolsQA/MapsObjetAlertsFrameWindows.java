package mapsObjetToolsQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.ClaseBase;

public class MapsObjetAlertsFrameWindows extends ClaseBase {
	
	//CREAMOS EL CONTRUCTOR DE LA CLASE
	public MapsObjetAlertsFrameWindows(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//CREAMOS LOS ELEMENTOS
	//ELEMENTOS SELECCION ALERTS
	protected By lblAlertsFromWindows = By.xpath("//*[@class='header-wrapper']/div[contains(text(),'Alerts, Frame & Windows')]");
	protected By lblAlerts = By.xpath("//*[@class='btn btn-light ']/span[contains(text(),'Alert')]");
	//ELEMENTOS BOTON ALERTAS
	protected By btnToSeeAlert = By.xpath("//button[@id='alertButton']");
	protected By btnAlertWillAppearAfter5Seconds = By.xpath("//button[@id='timerAlertButton']");
	protected By btnconfirmBoxWillAppear = By.xpath("//button[@id='confirmButton']"); 
	protected By btnpromptBoxWillAppear = By.xpath("//button[@id='promtButton']");
}
 