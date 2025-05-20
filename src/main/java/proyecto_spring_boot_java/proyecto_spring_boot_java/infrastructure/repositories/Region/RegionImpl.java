package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.repositories.Region;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Region;
import proyecto_spring_boot_java.proyecto_spring_boot_java.application.services.IRegionService;

@Service
public class RegionImpl implements IRegionService {
    private  RegionRepository repository;

    public RegionImpl(RegionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Region> findAll() {
        return (List<Region>) repository.findAll();
    }

    @Override
    public Optional<Region> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Region save(Region region) {
        return repository.save(region);
    }

    @Override
    public Optional<Region> update(Long id, Region region) {
        Optional<Region> regionOld = repository.findById(id);
        if (regionOld.isPresent()) {
            Region regionDb = regionOld.get();
            regionDb.setName(region.getName()); 
            return Optional.of(repository.save(regionDb));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Region> delete(Long id) {
        Optional<Region> regionOptional = repository.findById(id);
        regionOptional.ifPresent(region -> {
            repository.deleteById(id);
        });
        return regionOptional;
    }
}