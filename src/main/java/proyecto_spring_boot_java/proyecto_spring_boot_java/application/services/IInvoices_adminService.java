package proyecto_spring_boot_java.proyecto_spring_boot_java.application.services;

import java.util.List;
import java.util.Optional;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Invoices_admin;

public interface IInvoices_adminService {
    List<Invoices_admin> findAll();
    Optional<Invoices_admin> findById(Long id);
    Invoices_admin save(Invoices_admin invoices_adminces_admin);
    Optional<Invoices_admin> update(Long id, Invoices_admin invoices_adminces_admin);
    Optional<Invoices_admin> delete(Long id);
}
