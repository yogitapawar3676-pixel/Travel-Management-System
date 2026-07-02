package travel.management.system1;

import java.io.File;
import java.io.FileOutputStream;
import java.awt.Desktop;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;

import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class InvoiceGenerator {

    public static void generateInvoice(
            String username,
            String amount,
            String method,
            String txnId) {

        try {

            String fileName = "Invoice_" + txnId + ".pdf";

            Document document = new Document(PageSize.A4, 40, 40, 40, 40);

            PdfWriter.getInstance(document, new FileOutputStream(fileName));

            document.open();

            Font titleFont = new Font(Font.FontFamily.HELVETICA, 22, Font.BOLD, BaseColor.BLUE);
            Font headingFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
            Font normalFont = new Font(Font.FontFamily.HELVETICA, 12);

            Paragraph title = new Paragraph("TRAVEL MANAGEMENT SYSTEM", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            Paragraph invoice = new Paragraph("PAYMENT INVOICE", headingFont);
            invoice.setAlignment(Element.ALIGN_CENTER);
            document.add(invoice);

            document.add(new Paragraph(" "));
            document.add(new Paragraph("------------------------------------------------------------"));
            document.add(new Paragraph(" "));

            String date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());

            document.add(new Paragraph("Transaction ID : " + txnId, normalFont));
            document.add(new Paragraph("Customer Name : " + username, normalFont));
            document.add(new Paragraph("Payment Method : " + method, normalFont));
            document.add(new Paragraph("Amount Paid : ₹" + amount, normalFont));
            document.add(new Paragraph("Payment Status : SUCCESS", normalFont));
            document.add(new Paragraph("Date : " + date, normalFont));

            document.add(new Paragraph(" "));

            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100);

            PdfPCell c1 = new PdfPCell(new Phrase("Description", headingFont));
            c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(c1);

            PdfPCell c2 = new PdfPCell(new Phrase("Details", headingFont));
            c2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(c2);

            table.addCell("Customer");
            table.addCell(username);

            table.addCell("Payment Method");
            table.addCell(method);

            table.addCell("Transaction ID");
            table.addCell(txnId);

            table.addCell("Amount");
            table.addCell("₹ " + amount);

            table.addCell("Status");
            table.addCell("SUCCESS");

            document.add(table);

            document.add(new Paragraph(" "));
            document.add(new Paragraph("------------------------------------------------------------"));
            document.add(new Paragraph(" "));

            Paragraph footer = new Paragraph(
                    "Thank You For Choosing Travel Management System",
                    headingFont);

            footer.setAlignment(Element.ALIGN_CENTER);

            document.add(footer);

            document.close();

            JOptionPane.showMessageDialog(
                    null,
                    "Invoice Generated Successfully\n" + fileName);

            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(new File(fileName));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}