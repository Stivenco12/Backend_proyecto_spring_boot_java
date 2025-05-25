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
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
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
            Document document = new Document();
            PdfWriter.getInstance(document, baos);
            document.open();
            Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
            Font normalFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);
            document.add(new Paragraph("Factura de Reserva", titleFont));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("ID de Reserva: " + reservation.getId(), normalFont));
            document.add(new Paragraph("Herramienta: " + reservation.getToolsId().getName(), normalFont));
            document.add(new Paragraph("Fecha de creación: " + reservation.getAudit().getCreatedAt(), normalFont));
            document.add(new Paragraph("Descripción: " + reservation.getToolsId().getDescripcion(), normalFont));
            document.add(new Paragraph("Costo diario: " + reservation.getToolsId().getCostoDiario(), normalFont));
            document.add(new Paragraph("Disponibilidad: " + reservation.getToolsId().getDisponibilidad(), normalFont));
            document.add(new Paragraph("ID de pago: " + (reservation.getPaymentId() != null ? reservation.getPaymentId().getId() : "Sin pago"), normalFont));
            document.add(new Paragraph("Fecha de inicio: " + reservation.getAudit().getCreatedAt(), normalFont));
            document.add(new Paragraph("Fecha de creación: " + reservation.getAudit().getCreatedAt(), normalFont));
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