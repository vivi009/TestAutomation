package mapsObjetToolsQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.ClaseBase;

public class MapsObjetWidgets extends ClaseBase{
	
	//CONSTRUCTOR DE LA CLASE
	public MapsObjetWidgets(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
		//CREAMOS LOS ELEMENTOS
		//ELEMENTOS DATAPICKER
		protected By lblWidgets = By.xpath("//*[@class=\"header-wrapper\"]/div[contains(text(),'Widgets')]");
		protected By lblDataPicker = By.xpath("//*[@class='btn btn-light ']/span[contains(text(),'Date Picker')]");
		//ELEMENTOS SELECCION DE FECHAS
		protected By txtSelectDate = By.id("datePickerMonthYearInput");
		protected By txtDateAndTime = By.xpath("//input[@id='dateAndTimePickerInput']");
		protected By lblMonth = By.xpath("//*[@class='react-datepicker__header__dropdown react-datepicker__header__dropdown--scroll']/div[1]");
		protected By lblYear = By.xpath("//*[@class='react-datepicker__header__dropdown react-datepicker__header__dropdown--scroll']/div[2]");

		protected String xpathDd = "//div[text()='";
		protected String xpathMm = "//option[text()='";
		protected String xpathAa = "//option[text()='";
		protected String xpathHh = "//li[text()='"; 
		 
		
}
