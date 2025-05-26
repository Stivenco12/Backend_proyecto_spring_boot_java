package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import jakarta.validation.Valid;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Reservations;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.User;
import proyecto_spring_boot_java.proyecto_spring_boot_java.application.services.IReservationsService;
import proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.repositories.User.UserRepository;

@RestController
@RequestMapping("/api/Reservations")
public class ReservationsController {
    @Autowired
    private IReservationsService reservationsService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<Reservations> list() {
        return reservationsService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<Reservations> optional = reservationsService.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/{id}/pdf")
    public ResponseEntity<?> downloadReservationPdf(@PathVariable Long id) {
        Optional<Reservations> optional = reservationsService.findById(id);
        if (!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Reservations reservation = optional.get();

        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            Document document = new Document(PageSize.A4, 50, 50, 50, 50); // márgenes
            PdfWriter.getInstance(document, baos);
            document.open();

            Font titleFont = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD);
            Font subtitleFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
            Font normalFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);

            
            Paragraph title = new Paragraph("Factura de Reserva", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(20f);
            document.add(title);

            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);
            table.setWidths(new int[]{1, 2});

            addCell(table, "ID de Reserva:", normalFont);
            addCell(table, String.valueOf(reservation.getId()), normalFont);
            addCell(table, "ID de Usuario:", normalFont);
            addCell(table, String.valueOf(reservation.getUser().getId()), normalFont);

            addCell(table, "Herramienta:", normalFont);
            addCell(table, reservation.getToolsId().getName(), normalFont);

            addCell(table, "Descripción:", normalFont);
            addCell(table, reservation.getToolsId().getDescripcion(), normalFont);

            addCell(table, "Costo Diario:", normalFont);
            addCell(table, String.valueOf(reservation.getToolsId().getCostoDiario()), normalFont);

            addCell(table, "Disponibilidad:", normalFont);
            addCell(table, String.valueOf(reservation.getToolsId().getDisponibilidad()), normalFont);

            addCell(table, "ID de Pago:", normalFont);
            addCell(table, reservation.getPaymentId() != null ? String.valueOf(reservation.getPaymentId().getId()) : "Sin pago", normalFont);

            addCell(table, "Fecha de Inicio:", normalFont);
            addCell(table, String.valueOf(reservation.getFechaReserva()), normalFont);

            addCell(table, "Fecha de Devolución:", normalFont);
            addCell(table, String.valueOf(reservation.getFechaDevolucion()), normalFont);

            addCell(table, "Fecha de Creación:", normalFont);
            addCell(table, String.valueOf(reservation.getAudit().getCreatedAt()), normalFont);

            document.add(table);

            // Footer o nota
            Paragraph nota = new Paragraph("Gracias por usar nuestra plataforma de alquiler de herramientas.", subtitleFont);
            nota.setSpacingBefore(30f);
            nota.setAlignment(Element.ALIGN_CENTER);
            document.add(nota);

            document.close();

            String fileName = "Reserva_" + reservation.getId() + ".pdf";
            reservation.setFacturas(fileName);
            reservationsService.save(reservation);

            ByteArrayResource resource = new ByteArrayResource(baos.toByteArray());
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(resource.contentLength())
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(resource);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error generando PDF: " + e.getMessage());
        }
    }

    private void addCell(PdfPTable table, String text, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setBorder(Rectangle.BOX);
        cell.setPadding(8);
        table.addCell(cell);
    }


    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Reservations reservation, @RequestParam Long userId, BindingResult result) {
        if (result.hasErrors()) {
            return validation(result);
        }
        Optional<User> userOpt = userRepository.findById(userId);
        if (!userOpt.isPresent()) {
            return ResponseEntity.badRequest().body("Usuario no encontrado");
        }
        reservation.setUser(userOpt.get());
        return ResponseEntity.status(HttpStatus.CREATED).body(reservationsService.save(reservation));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Reservations reservation, @PathVariable Long id) {
        Optional<Reservations> optional = reservationsService.update(id, reservation);
        if (optional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(optional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Reservations> optional = reservationsService.delete(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, Object> response = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            String message = "Error in field '" + err.getField() + "': " + err.getDefaultMessage();
            response.put("error", message);
        });
        return ResponseEntity.badRequest().body(response);
    }
    
    @GetMapping("/user/{userId}")
    public List<Reservations> getByUser(@PathVariable Long userId) {
        return reservationsService.findByUserId(userId);
    }
}