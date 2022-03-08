package base;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilidades.GenerarReportePdf;

public class ClaseBase {
	protected WebDriver driver;

	// CONSTRUCTOR DE CLASE
	public ClaseBase(WebDriver driver) {
		super();
	}

	// METODO DE NAVEGADOR
	public static WebDriver chromeDriverConnetion() {

		WebDriver _driver_ = null;  
		try {
			// SETEAR LAS OPCIONES DE NAVEGADOR
			ChromeOptions chromeoptions = new ChromeOptions();
			chromeoptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
 
			// SETEAR LAS PROPIEDADES DEL NAVEGADOR
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			_driver_ = new ChromeDriver();

			// MAXIMIZAR NAVEGADOR
			_driver_.manage().window().maximize();

		} catch (Exception e) {
			System.out.println(e);
		}
		return _driver_;
	}

	// FECHA PARA CAPTURA DE PANTALLA
	public static String fechaHora() {
		// TOMAMOS LA FECHA DEL SISTEMA
		LocalDateTime fechaSistema = LocalDateTime.now();

		// DEFINIR FORMATO FECHA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

		// DAR FORMATO A LA FECHA DEL SISTEMA
		String formatFecha = fecha.format(fechaSistema);
		return formatFecha;
	}

	public static String fechaHora1() {
		// TOMAMOS LA FECHA DEL SISTEMA
		LocalDateTime fechaSistema = LocalDateTime.now();

		// DEFINIR FORMATO FECHA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		// DAR FORMATO A LA FECHA DEL SISTEMA
		String formatFecha = fecha.format(fechaSistema);
		return formatFecha;
	}
	public String horaSistema() {
		// TOMAMOS LA FECHA DEL SISTEMA
		LocalTime horaSistema = LocalTime.now();

		// DEFINIR FORMATO FECHA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("HHmmss");

		// DAR FORMATO A LA FECHA DEL SISTEMA
		String hora = fecha.format(horaSistema);
		return hora;
	}

	// CLICK
	public void click(By locator, int t, File rutaCarpeta, String Evidencia) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, t);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			time(1);
			driver.findElement(locator).click();
			capture(rutaCarpeta, locator, Evidencia);

			}catch(Exception e) {
			captureScreenError(rutaCarpeta, locator, Evidencia, e.toString());
			throw new InterruptedException();
			}
			}
	// CLICK
		public void click(By locator, int t, String generarEvidencia) throws Exception {
			
			
			WebDriverWait wait = new WebDriverWait(driver, t);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			time(1);
			driver.findElement(locator).click();
			
			
		}

	// ESCRIBIR
	public void sendKey(String dato, By locator, int t, File rutaCarpeta, String generarEvidencia) throws Exception {
		try
		{
		WebDriverWait wait = new WebDriverWait(driver, t);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		time(1);
		driver.findElement(locator).sendKeys(dato);
		capture(rutaCarpeta, locator,  generarEvidencia);
		}
		catch (Exception e) 
		{
			captureScreenError(rutaCarpeta,locator,generarEvidencia,e.toString());
			throw new InterruptedException();
		}
	}

	// METODO BORRAR
	public void clear(By locator, File rutaCarpeta, String generarEvidencia) throws Exception {
		driver.findElement(locator).clear();
		capture(rutaCarpeta, locator, generarEvidencia);
	}

	// METODO ENTER SUBMIN
	public void submit(By locator, File rutaCarpeta, String generarEvidencia) throws Exception {
		driver.findElement(locator).submit();
		capture(rutaCarpeta, locator, generarEvidencia);
	}

	// METODO TIEMPO DE ESPERA
	public void time(long tiempo) throws InterruptedException {
		Thread.sleep(tiempo * 1000);
	}

	// SCROLL
	public void desplazarseVertical(int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");
	}

	public void desplazarseElemento(By locator) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(locator);
		executor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	
	//METODO INTERACTUAR  ALERTA
		public void alert() {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.alertIsPresent());
				Alert alert = driver.switchTo().alert();
				alert.accept();
				waittime(3000);
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		public void alertaTexto(String texto) {
		    try {
		        WebDriverWait wait = new WebDriverWait(driver, 20);
		        wait.until(ExpectedConditions.alertIsPresent());
		        Alert alert = driver.switchTo().alert();
		        alert.sendKeys(texto);
		        time(2);
		    } catch (Exception e) {
		        System.out.println(e);
		    }
		}
	// TECLAS
	public void enter(By locator, File rutaCarpeta, String generarEvidencia ) throws Exception {
		driver.findElement(locator).sendKeys(Keys.ENTER);
		capture(rutaCarpeta, locator, generarEvidencia);
	}

	public void control(By locator, File rutaCarpeta, String letra, String generarEvidencia) throws Exception {
		driver.findElement(locator).sendKeys(Keys.CONTROL, letra);
		capture(rutaCarpeta,locator, generarEvidencia);
	}

	public void space(By locator, File rutaCarpeta, String generarEvidencia) throws Exception {
		driver.findElement(locator).sendKeys(Keys.SPACE);
		capture(rutaCarpeta, locator, generarEvidencia);
	}

	// METODO CAPTURA
	public void captureScreen(File rutaCarpeta, String generarEvidencia) throws Exception {
		
		
		String hora = horaSistema();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle screenRectangle = new Rectangle(screenSize);
		Robot robot = new Robot();
		BufferedImage image = robot.createScreenCapture(screenRectangle);
		ImageIO.write(image, "png", new File(rutaCarpeta + "/" + hora + ".jpg"));
		}
	

	// CAPTURA DE PANTALLA
	public void capture(File rutaCarpeta, By locator, String generarEvidencia) throws Exception {
		
		if (generarEvidencia.equals("SI")) 
		{
			
		String hora = horaSistema();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(rutaCarpeta + "\\" + hora + ".png"));
		String rutaImagen = new File(rutaCarpeta+"\\" +hora+ ".png").toString();
		
		//INSTANCIAR LA CLASE GENERAR PDF
		GenerarReportePdf informePdf = new GenerarReportePdf();
		//SE INSTANCIA LOCALIZADOR HE IMAGEN EN EL PDF
		informePdf.crearbody(locator, rutaImagen);
		
		//ELIMINAR IMAGEN CREADA
		eliminarArchivo(rutaImagen);
		}
	}
	
	public void eliminarArchivo(String rutaImagen) {
		
		File fichero = new File(rutaImagen);
		fichero.delete();
	}	
	
	public void captureScreenError(File rutaCarpeta, By locator, String generarEvidencia, String msnError) throws Exception 
	{
		if (generarEvidencia.equals("SI"))
		{
			String hora = horaSistema();
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(rutaCarpeta+"\\"+hora+".png"));
			String rutaImagen =new File(rutaCarpeta+"\\"+hora+".png").toString();
			
			//INSTACIAMOS LA CLASE GENERAR PDF
			GenerarReportePdf informePdf = new GenerarReportePdf();
			//SE PROCEDE A INSERTAR LOCALIZADOR HE IMAGEN EN EL PDF
			informePdf.crearbodyError(locator,rutaImagen,msnError);
			//ELIMINAR IMAGEN CREADA
			
			eliminarArchivo(rutaImagen);
		}
	}	

	public String capturarValorSelenium(By locator, File rutaCarpeta, String generarEvidencia) throws Exception {
		try {
		String valor = driver.findElement(locator).getText();
		return valor;

		}catch (Exception e) {
			captureScreenError(rutaCarpeta, locator,generarEvidencia, e.toString());
		throw new InterruptedException();
		}
		}
	public File crearCarpeta(String nomTest) {
		// ALMACENAMOS LA FECHA DEL SISTEMA
		String fecha = fechaHora();

		// CREAMOS EL NOMBRE DE LA CARPETA
		String nomCarpeta = nomTest + "-" + fecha;

		// OBTENEMOS LA RUTA DE ALOJAMIENTO DE SALIDA Y EL NOMBRE DEL TEST A EJECUTAR
		File directorio = new File("./output/" + nomTest + "/" + nomCarpeta);
		//File directorio = new File("./output/" + nomCarpeta);

		// CREAMOS LA CARPETA
		directorio.mkdir();
		return directorio;
	}
	
	// METODO SCROLL
		public void scrollelement(By locator, String generarEvidencia ) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			WebElement element = driver.findElement(locator);
			executor.executeScript("arguments[0].scrollIntoView(true);", element);
		}
		
		// METODO TIEMPO DE ESPERA
		public void waittime(long tiempo) throws InterruptedException {
			Thread.sleep(tiempo);
		}
		
		//METODO SELECCIONAR FECHA Y HORA
		public void dateAndTime(String xpathHh, Object fechaExcel, String xpathDd, By DateAndTime, By month, By year, By locator, File rutaCarpeta, String generarEvidencia)
				throws Exception {
			String fecha = fechaExcel.toString();
			String dd = fecha.split("/")[0];
			String mm = fecha.split("/")[1];
			String aa = fecha.split("/")[2];
			String hh = fecha.split("/")[3];

			String xpathdd = xpathDd + dd + "']";
			String xpathmm = xpathDd + mm + "']";
			String xpathaa = xpathDd + aa + "']";
			String xpathhh = xpathHh + hh + "']";

			driver.findElement(DateAndTime).click();
			driver.findElement(month).click();
			driver.findElement(By.xpath(xpathmm)).click();
			driver.findElement(year).click();
			driver.findElement(By.xpath(xpathaa)).click();
			driver.findElement(By.xpath(xpathdd)).click();
			driver.findElement(By.xpath(xpathhh)).click();

			time(2);
			capture(rutaCarpeta, locator, generarEvidencia);
		}
			//METODO SELECCIONAR 
		public void selectDate(String xpathDd, Object fechaExcel, String xpathMm, String xpathAa, By locator, File rutaCarpeta, String generarEvidencia) throws Exception {
			String fecha = fechaExcel.toString();
			String dd = fecha.split("/")[0];
			String mm = fecha.split("/")[1];
			String aa = fecha.split("/")[2];

			String xpathMonth = xpathMm + mm + "']";
			String xpatYear = xpathAa + aa + "']";
			String xpatDay = xpathDd + dd + "']";

			driver.findElement(By.xpath(xpathMonth)).click(); 
			driver.findElement(By.xpath(xpatYear)).click();
			driver.findElement(By.xpath(xpatDay)).click();

			time(2);
			capture(rutaCarpeta, locator, generarEvidencia);
		}
		
		// CONFIRMAR EXISTENCIA DE ELEMENTOS
		public boolean confirmar(By locator, int t) {
		    try {
		        WebDriverWait wait = new WebDriverWait(driver, t);
		        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		        return true;
		    } catch (Exception ex) {
		        return false;
		    }
		}
}
