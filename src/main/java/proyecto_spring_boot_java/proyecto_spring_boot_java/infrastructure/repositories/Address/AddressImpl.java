package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.repositories.Address;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Address;
import proyecto_spring_boot_java.proyecto_spring_boot_java.application.services.IAddresService;

@Service
public class AddressImpl implements IAddresService {
    @Autowired
    private AddressRepository addressRepository;
    
    @Transactional(readOnly = true)
    @Override
    public List<Address> findAll() {
        return (List<Address>) addressRepository.findAll();
    }
    @Override
    public Optional<Address> findById(Long id) {
        return addressRepository.findById(id);
    }
    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }
    @Override
    public Optional<Address> update(Long id, Address address) {
        Optional<Address> AddressOld = addressRepository.findById(id);
        if(AddressOld.isPresent()){
            Address AddreesDb = AddressOld.orElseThrow();
            AddreesDb.setAddress(address.getAddress());         
            return Optional.of(addressRepository.save(AddreesDb));
        }
        return Optional.empty();
    }
    @Override
    public Optional<Address> delete(Long id) {
        Optional<Address> addressOptional = addressRepository.findById(id);
        addressOptional.ifPresent(addressDb -> {
            addressRepository.delete(addressDb);
        });
        return addressOptional;        
    }
}