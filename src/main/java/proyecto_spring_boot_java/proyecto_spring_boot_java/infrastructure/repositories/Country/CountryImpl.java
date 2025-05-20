package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.repositories.Country;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Country;
import proyecto_spring_boot_java.proyecto_spring_boot_java.application.services.ICountryService;

@Service
public class CountryImpl implements ICountryService {
    @Autowired
    private CountryRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Country> findAll() {
        return (List<Country>) repository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Country save(Country country) {
        return repository.save(country);
    }

    @Override
    public Optional<Country> update(Long id, Country country) {
        Optional<Country> countryOld = repository.findById(id);
        if(countryOld.isPresent()){
            Country countryDb = countryOld.orElseThrow();
            countryDb.setName(country.getName());
            return Optional.of(repository.save(countryDb));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Country> delete(Long id) {
        Optional<Country> countryOptional = repository.findById(id);
        countryOptional.ifPresent(countrytDb -> {
            repository.delete(countrytDb);
        });
        return countryOptional;        
    }
}