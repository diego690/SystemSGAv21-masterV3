/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.SYStemSGAv21.util;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import uteq.sga.SYStemSGAv21.Entity.Docentes;
import uteq.sga.SYStemSGAv21.Entity.Notastareas;


/**
 *
 * @author capur
 */
@Component("/Representante/NotaTareaslist")
public class ListarNotasRepresentante extends AbstractPdfView{

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
         @SuppressWarnings("unchecked")
        List<Notastareas> notasT = (List<Notastareas>) model.get("notasTareas");
        
        Font fuenteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20, Color.BLUE);
        Font fuenteTituloColumnas = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, Color.BLUE);
        Font fuenteDataCeldas = FontFactory.getFont(FontFactory.COURIER, 10, Color.BLACK);

        document.setPageSize(PageSize.A4.rotate());
        document.setMargins(-20, -20, 40, 20);
        document.open();
        
        PdfPTable tablaTitulo = new PdfPTable(1);
        PdfPCell celda = null;
        
        celda = new PdfPCell(new Phrase("LISTADO DE NOTAS", fuenteTitulo));
        celda.setBorder(0);
        celda.setBackgroundColor(new Color(34, 165, 180));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(30);
        tablaTitulo.addCell(celda);
        tablaTitulo.setSpacingAfter(30);
        
        PdfPTable tablaNivel = new PdfPTable(3);
        tablaNivel.setWidths(new float[] {3f,3f,3f});
        
        celda = new PdfPCell(new Phrase("ID", fuenteTituloColumnas));
        celda.setBackgroundColor(Color.lightGray);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaNivel.addCell(celda);

        celda = new PdfPCell(new Phrase("Nombre Tarea", fuenteTituloColumnas));
        celda.setBackgroundColor(Color.lightGray);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaNivel.addCell(celda);

        celda = new PdfPCell(new Phrase("Notas", fuenteTituloColumnas));
        celda.setBackgroundColor(Color.lightGray);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaNivel.addCell(celda);
        
        for(Notastareas not:notasT){
            celda = new PdfPCell(new Phrase(String.valueOf(not.getIdentregatareas()), fuenteDataCeldas));
            celda.setPadding(5);
            tablaNivel.addCell(celda);
            
            celda = new PdfPCell(new Phrase(String.valueOf(not.getIdentregatareas().getDescripcion()), fuenteDataCeldas));
            celda.setPadding(5);
            tablaNivel.addCell(celda);
            
            celda = new PdfPCell(new Phrase(String.valueOf(not.getNota()), fuenteDataCeldas));
            celda.setPadding(5);
            tablaNivel.addCell(celda);
        }
        
        document.add(tablaTitulo);
        document.add(tablaNivel);
    }
    
}
