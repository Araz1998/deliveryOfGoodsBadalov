package com.araz.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GeneratePDF {


    public static ByteArrayOutputStream getPdfFile(List<String> listInfo) {

        Document document = new Document();
        ByteArrayOutputStream bout = new ByteArrayOutputStream();

        try {

            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(80);
            table.setSpacingBefore(15);
            table.setWidths(new int[]{1, 2, 2, 2});

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

            String[] titleNames = new String[]{"New", "Confirmed", "Paid", "AVG road"};

            for (int i = 0; i < titleNames.length; i++){
                PdfPCell hcell;

                hcell = new PdfPCell(new Phrase(titleNames[i], headFont));
                hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
                hcell.setBackgroundColor(new BaseColor(0, 255, 255));
                table.addCell(hcell);
            }

            for(int i = 1; i<5; i++) {
                PdfPCell cell;

                cell = new PdfPCell(new Phrase(listInfo.get(i)));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

            }

            PdfWriter.getInstance(document, bout);
            document.open();
            Font f = new Font();
            f.setStyle(Font.BOLD);
            f.setSize(20);
            f.setColor(new BaseColor(70, 130, 180));
            document.add(new Paragraph("Report for day: " + listInfo.get(0), f));
            document.add(table);

            document.close();

        } catch (DocumentException ex) {

            Logger.getLogger(GeneratePDF.class.getName()).log(Level.SEVERE, null, ex);
        }

        return bout;
    }
}
