package utilidades;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import base.ClaseBase;

public class GenerarReportePdf {
	static String nombre = "prueba";
	static String fecha;
	static Document documento;
	static FileOutputStream archivo;
	static Paragraph titulo;
	String rutaImagen;
	static String hora;
	static String  horaInicio, horaFin;

	public GenerarReportePdf(){
		super();
	}
	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	public void crearPlantilla(String nomTest, File rutaCarpeta) {
		// INSTANCIAR DOCUMENTO
		documento = new Document();
		// TOMAR LA HORA DEL SISTEMA
		hora = ClaseBase.fechaHora();
		horaInicio = ClaseBase.fechaHora1();



		try {
		// COLOR FUENTE
		Font font = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD, BaseColor.DARK_GRAY);



		// RUTA/IMAGEN DEL PDF
		archivo = new FileOutputStream(rutaCarpeta + "\\" + "Reporte-" + nomTest + "-" + hora + ".pdf");
		PdfWriter.getInstance(documento, archivo);

		// IMAGEN
		Image header = Image.getInstance(rutaImagen);
		header.scaleToFit(100, 100);
		header.setWidthPercentage(100);



		// TITULO PDF
		titulo = new Paragraph(nomTest.toUpperCase() + "\n\n" + "Fecha Inicio: " + horaInicio, font);
		titulo.setAlignment(1);



		// TABLA ENCABEZADO
		PdfPTable table = new PdfPTable(2);
		table.setWidthPercentage(100);



		PdfPCell p1 = new PdfPCell(header);
		p1.setHorizontalAlignment(1);
		p1.setVerticalAlignment(2);



		PdfPCell p2 = new PdfPCell(titulo);
		p2.setHorizontalAlignment(1);
		p2.setVerticalAlignment(2);



		table.addCell(p2);
		table.addCell(p1);



		// MARGEN
		documento.setMargins(60, 40, 40, 30);



		documento.open();
		documento.add(table);



		documento.add(Chunk.NEWLINE);



		} catch (FileNotFoundException e) {
		System.err.println(e.getMessage());
		} catch (DocumentException e) {
		System.err.println(e.getMessage());
		} catch (IOException e) {
		System.err.println("Error al logo periferia: " + e.getMessage());
		}
		}

	public void crearbody(By locator, String rutaImagen) throws DocumentException, MalformedURLException, IOException {
// OBTENER EL NOMBRE DEL LOCALIZADOR
		String locator1 = locator.toString();
// DAR FORMATO A LA FUENTE
		Paragraph parrafo = new Paragraph();
		parrafo.setAlignment(Chunk.ALIGN_LEFT);
		parrafo.setFont(FontFactory.getFont("Arial", 10, Font.NORMAL));
		parrafo.add("Se realiza accion sobre el elemento: " + locator1);
// ADICIONAR MENSAJE AL PDF
		documento.add(parrafo);
// INSERT IMAGEN
// UBICACION DE LA IMAGEN
		Image imagen = Image.getInstance(rutaImagen);
// TAMAÑO DE LA IMAGEN
		imagen.scaleToFit(500, 500);
		imagen.setAlignment(Chunk.ALIGN_LEFT);
		documento.add(imagen);
	}
	
	public void crearbodyError(By locator, String rutaImagen, String msnError) throws DocumentException, MalformedURLException, IOException
	{
		// OBTENER EL NOMBRE DEL LOCALIZADOR
		String locator1 = locator.toString();
		Paragraph parrafo = new Paragraph();
		parrafo.setAlignment(Chunk.ALIGN_LEFT);



		// LETRA Y COLOR
		parrafo.setFont(FontFactory.getFont("Times", 8, Font.NORMAL, BaseColor.GRAY));
		parrafo.add("Se realiza accion sobre el elemento: " + locator1);



		documento.add(parrafo);
		Image imagen = Image.getInstance(rutaImagen);



		// imagen.scalePercent(25, 35);
		imagen.scaleToFit(500, 500);
		imagen.setAlignment(Chunk.ALIGN_CENTER);
		documento.add(imagen);



		// MENSAJE ERROR
		// FORMATO A LA FUENTE
		Paragraph elementoError = new Paragraph();
		elementoError.setAlignment(Chunk.ALIGN_LEFT);
		elementoError.setFont(FontFactory.getFont("Times", 10, Font.NORMAL, BaseColor.RED));
		elementoError.add("\nElemento con error: " + locator);

		Paragraph parrafoError = new Paragraph();
		parrafoError.setAlignment(Chunk.ALIGN_LEFT);
		parrafoError.setFont(FontFactory.getFont("Times", 6, Font.NORMAL, BaseColor.RED));
		parrafoError.add("\nMensaje de error:\n" + msnError);

		documento.add(elementoError);
		documento.add(parrafoError);

		documento.close();
	}
	

	public void cerrarPlantilla() throws DocumentException {
		documento.add(Chunk.NEWLINE);
		Paragraph parrafo = new Paragraph();
		parrafo.setAlignment(Chunk.ALIGN_RIGHT);
		parrafo.setFont(FontFactory.getFont("Times", 10, Font.BOLD, BaseColor.LIGHT_GRAY));
		parrafo.add("Fecha Inicio: " + horaInicio + "\n");



		horaFin = ClaseBase.fechaHora1();
		parrafo.add("Fecha Fin: " + horaFin);
		documento.add(parrafo);
		documento.close();
		}
}
