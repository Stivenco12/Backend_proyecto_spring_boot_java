package proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class ReservationPdfGenerator {
    public static void generatePdf(Reservations reservation, String filePath) {
        Document document = new Document();
        try {
            OutputStream outputStream = new FileOutputStream(filePath);
            PdfWriter.getInstance(document, outputStream);
            document.open();
            Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
            Paragraph title = new Paragraph("Detalle de la Reserva", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph(" ")); 
            document.add(new Paragraph("ID de reserva: " + reservation.getId()));
            document.add(new Paragraph("Herramienta: " + reservation.getToolsId().getName())); 
            document.add(new Paragraph("Descripción: " + reservation.getToolsId().getDescripcion()));
            document.add(new Paragraph("Costo diario: " + reservation.getToolsId().getCostoDiario()));
            document.add(new Paragraph("Disponibilidad: " + reservation.getToolsId().getDisponibilidad()));
            document.add(new Paragraph("Fecha de inicio: " + reservation.getAudit().getCreatedAt()));
            document.add(new Paragraph("Fecha de creación: " + reservation.getAudit()));
            document.add(new Paragraph("ID de pago: " + (reservation.getPaymentId() != null ? reservation.getPaymentId().getId() : "Sin pago")));
            document.close();
            outputStream.close();
            System.out.println("PDF generado en: " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
