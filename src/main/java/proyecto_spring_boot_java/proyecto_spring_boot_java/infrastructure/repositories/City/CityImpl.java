package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.repositories.City;

import java.util.List;
import java.util.Optional;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.City;
import proyecto_spring_boot_java.proyecto_spring_boot_java.application.services.ICityService;

public class CityImpl implements ICityService {
    private final CityRepository repository;

    public CityImpl(CityRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<City> findAll() {
        return (List<City>) repository.findAll();
    }

    @Override
    public Optional<City> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public City save(City city) {
        return repository.save(city);
    }

    @Override
    public Optional<City> update(Long id, City city) {
        Optional<City> cityOld = repository.findById(id);
        if(cityOld.isPresent()){
            City cityDb = cityOld.orElseThrow();
            cityDb.setName(city.getName());
            return Optional.of(repository.save(cityDb));
        }
        return Optional.empty();
    }

    @Override
    public Optional<City> delete(Long id) {
        Optional<City> cityOptional = repository.findById(id);
        cityOptional.ifPresent(cityDb -> {
            repository.delete(cityDb);
        });
        return cityOptional;        
    }
    
}
