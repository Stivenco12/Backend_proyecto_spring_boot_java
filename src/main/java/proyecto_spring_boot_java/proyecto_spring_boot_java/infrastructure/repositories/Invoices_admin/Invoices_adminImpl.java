package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.repositories.Invoices_admin;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Invoices_admin;
import proyecto_spring_boot_java.proyecto_spring_boot_java.application.services.IInvoices_adminService;

@Service
public class Invoices_adminImpl implements IInvoices_adminService {

    private final Invoices_adminRepository invoicesAdminRepository;

    public Invoices_adminImpl(Invoices_adminRepository invoicesAdminRepository) {
        this.invoicesAdminRepository = invoicesAdminRepository;
    }

    @Override
    public List<Invoices_admin> findAll() {
        return invoicesAdminRepository.findAll();
    }

    @Override
    public Optional<Invoices_admin> findById(Long id) {
        return invoicesAdminRepository.findById(id);
    }

    @Override
    public Invoices_admin save(Invoices_admin invoiceAdmin) {
        return invoicesAdminRepository.save(invoiceAdmin);
    }

    @Override
    public Optional<Invoices_admin> update(Long id, Invoices_admin invoiceAdmin) {
        if (invoicesAdminRepository.existsById(id)) {
            invoiceAdmin.setId(id);
            return Optional.of(invoicesAdminRepository.save(invoiceAdmin));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Invoices_admin> delete(Long id) {
        if (invoicesAdminRepository.existsById(id)) {
            Optional<Invoices_admin> invoiceAdmin = invoicesAdminRepository.findById(id);
            invoicesAdminRepository.deleteById(id);
            return invoiceAdmin;
        }
        return Optional.empty();
    }
}
