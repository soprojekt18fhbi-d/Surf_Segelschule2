package Steuerung;

import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import org.h2.table.Table;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import Datenbankmodels.RechnungAnzeigenModel;
import GUI.IObjektView;
import GUI.RechungsSucheGUI;


/**
 * 
 * @author Darnel
 *
 */
public class RechnungAnzeigeStrg implements IController{
	
	private RechnungAnzeigenModel model;
	private RechungsSucheGUI view;
	private String search;
	private int kundenID;
	private double summe;
	private double summeMitMwst;
	private double mwst;
	private int kundeID;
	private int buchungsID;
	private int reparaturID;
	private String art;
	private String ausleihdatum;
	private String verkaufsdatum;
	private int sportgeraetID;
	private int modellID;
	private String farbe;
	private String modellname;
	private String vorname;
	private String nachname;
	private String eMail;
	private int plz;
	private String strasse;
	private String ort;
	private String hnr;
	private String filename;
	
	private com.itextpdf.text.Font font1 = FontFactory.getFont("Arial", BaseFont.IDENTITY_H, 10, Font.PLAIN);
	private com.itextpdf.text.Font font2 = FontFactory.getFont("Arial", BaseFont.IDENTITY_H, 14, Font.BOLD);
	private com.itextpdf.text.Font font3 = FontFactory.getFont("Arial", BaseFont.IDENTITY_H, 12, Font.PLAIN);
	

	
	public RechnungAnzeigeStrg(RechnungAnzeigenModel smodel)
	{
		model = smodel;
		
	}
	
	public void getRechungDruck(int rechnungsID, int heim_urlaub)
	{
		model.holeDatenDrucken(rechnungsID, heim_urlaub);
		summe = model.getSumme();
		kundenID = model.getKundeID();
		summeMitMwst = model.getSummeMitMwst();
		mwst = model.getMwst();
		reparaturID = model.getReparaturID();
		buchungsID = model.getBuchungsID();
        art = model.getArt();
        ausleihdatum = model.getAusleihdatum();
        verkaufsdatum = model.getVerkaufsdatum();
        sportgeraetID  = model.getSportgeraetID();
        modellID=model.getModellID();
        farbe = model.getFarbe();
    	modellname = model.getModellname();
    	vorname = model.getVorname();
    	nachname = model.getNachname();
    	eMail = model.geteMail();
    	plz = model.getPlz();
    	strasse = model.getStrasse(); 
    	ort = model.getOrt();
    	hnr = model.getHnr();
    	filename = "Rechnung "+String.valueOf(rechnungsID);
    	try {
    		erstellePDF(filename, rechnungsID);
    		JOptionPane.showMessageDialog(null, "Die Rechnung wurde in Ihrem Workspace erstellt", "Rechnung erstellt", JOptionPane.PLAIN_MESSAGE);
    	}catch(DocumentException e){
    		e.printStackTrace();
    	}catch(MalformedURLException e1) {
    		e1.printStackTrace();
    	}catch(IOException e2) {
    		e2.printStackTrace();
    		JOptionPane.showMessageDialog(null, "Falls Sie noch eine Rechnung geöffnet haben, schließen Sie diese bitte", "Rechnung schließen", JOptionPane.PLAIN_MESSAGE);
    	} 
	}

	
	public void getRechnungenSuche(String search) {
		
		model.holeDatenSuche(search);
		
	}
	
	public void getRechnungen() {
		
		model.holeDaten();
		
	}
	
	public void erstellePDF (String filename, int rechnungsID) throws DocumentException, MalformedURLException, IOException{
        Document document = new Document(PageSize.A4, 40, 20, 0, 0);
        PdfWriter.getInstance(document, new FileOutputStream(filename+".pdf"));
        document.open();
        

        
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        table.setSpacingBefore(150f);
        table.setWidths(new int[]{2, 1, 2});
        PdfPCell cell = new PdfPCell(new Phrase("Firma\nSurf- und Segelcenter\nStrandstraße 14\nD 24235 Laboe\n", font1));
            cell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
            cell.setBorder(0);
        table.addCell(cell);
        

        PdfPCell cellrg = new PdfPCell(new Phrase("Rechnung", font2));
            cellrg.setBorder(0);
            cellrg.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
            cellrg.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        table.addCell(cellrg);
        
        PdfPCell cell2 = new PdfPCell();
        cell2.setBorder(0);
        cell2.setHorizontalAlignment(PdfPCell.RIGHT);
        table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
            
        table.addCell(cell2);
        document.add(table);
        
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            StringBuilder dateBuilder = new StringBuilder(dateFormat.format(date));
        Paragraph rightDate = new Paragraph();
            rightDate.setAlignment(Element.ALIGN_RIGHT);
            rightDate.setFont(font1);
            rightDate.add("" + dateBuilder);
        
        document.add(new LineSeparator());  
            
        document.add(rightDate);
        document.add(new Paragraph(""));
        
        //adress
        PdfPTable adressTable = new PdfPTable(2);
        adressTable.setHorizontalAlignment(PdfPTable.ALIGN_RIGHT);
        adressTable.setSpacingBefore(40f);
        adressTable.setWidthPercentage(96f);
        cell = new PdfPCell(new Phrase(vorname +"\n"+ nachname + "\n" + strasse + " " + hnr + "\n" + plz + " "  + ort +"\n", font2));
        cell.setBorder(0);
        adressTable.addCell(cell);
        Chunk chunk = new Chunk("Rechnungsnummer: " + rechnungsID + "\n" + "Kundennummer: " + kundenID + "\n" + "Rechnungsdatum: " + dateBuilder, font1);
        cell = new PdfPCell(new Phrase(chunk));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        cell.setBorder(0);
        adressTable.addCell(cell);
        document.add(adressTable);
        
        // form of adress
        PdfPTable textTable = new PdfPTable(1);
        textTable.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
        textTable.setSpacingBefore(40f);
        textTable.setWidthPercentage(96f);
        cell = new PdfPCell(new Phrase("Rechnung " + rechnungsID, font2));
        cell.setBorder(0);
        textTable.addCell(cell);
        cell2 = new PdfPCell(new Phrase("Sehr geehrter Damen und Herren, \nwir bedanken uns für Ihren Auftrag " + buchungsID + ". Bitte zahlen Sie die Rechungssumme innerhalb der nächsten 14 Tage auf unser Bankkonto. ", font3));
        cell2.setBorder(0);
        textTable.addCell(cell2); 
        document.add(textTable);
        
        // content
        PdfPTable contentTable = new PdfPTable(2);
        contentTable.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
        contentTable.setSpacingBefore(40f);
        contentTable.setWidthPercentage(96f);
        contentTable.addCell(new Phrase("Gerätenummer", font3));
        contentTable.addCell(new Phrase(modellID+"", font3));
        contentTable.addCell(new Phrase("Modell", font3));
        contentTable.addCell(new Phrase(modellname + " ( Farbe: " + farbe + ")" , font3));
        System.out.println(art);
        
        // Hier wird bei einem Verkauf das Verkaufsdatum ausgegeben und bei einer Ausleihe das Ausleihdatum.
        if (art.equals("Verkauf")) {
        	contentTable.addCell(new Phrase("Verkaufsdatum", font3));
            contentTable.addCell(new Phrase(verkaufsdatum , font3));
        }else {
        	contentTable.addCell(new Phrase("Ausleihdatum", font3));
            contentTable.addCell(new Phrase(ausleihdatum , font3));
        }
        contentTable.addCell(new Phrase("Summe (netto)", font3));
        contentTable.addCell(new Phrase(String.valueOf(summe) + " €", font3));
        contentTable.addCell(new Phrase("Mehrwertsteuer", font3));
        contentTable.addCell(new Phrase(String.valueOf(mwst) + " €", font3));
        contentTable.addCell(new Phrase("Summe (brutto)", font3));
        contentTable.addCell(new Phrase(String.valueOf(summeMitMwst) + " €", font3));
        document.add(contentTable);
        
        document.close();
    }



	@Override
	public void anfrage() {
		// TODO Auto-generated method stub
		
	}
	
}
