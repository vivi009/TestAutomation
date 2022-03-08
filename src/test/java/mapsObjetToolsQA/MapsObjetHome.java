package mapsObjetToolsQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.ClaseBase;

public class MapsObjetHome extends ClaseBase {
	
	//CONSTRUCTOR DE LA CLASE
	public MapsObjetHome(WebDriver driver) {
		super(driver);
		this.driver=driver;
	} 
	
	//CREAMOS LOS ELEMENTOS DEL HOME
	protected By lblElements = By.xpath("//*[@class='card-body']/h5[contains(text(),'Elements')]");
	protected By lblWidgets = By.xpath("//h5[contains(text(),'Widgets')]");
	protected By lblAlertsFrameWindows = By.xpath("//h5[contains(text(),'Alerts, Frame & Windows')]");  
	 

}
