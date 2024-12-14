package ua.nure.RegistryService.ServiceImplementation;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.RegistryService.Interface.ServiceRegistry;
import ua.nure.RegistryService.Model.Registry;
import ua.nure.RegistryService.Model.Status;
import ua.nure.RegistryService.Repository.RegistryRepository;

import java.util.List;
import java.util.Optional;
@WebService(endpointInterface = "ua.nure.RegistryService.Interface.ServiceRegistry")
@Service
public class ServiceRegistryImpl implements ServiceRegistry {
    @Autowired
    private RegistryRepository registryRepository;

    @Override
    public Registry registerService(Registry registry) {
        return registryRepository.save(registry);
    }

    @Override
    public List<Registry> getAllServices() {
        return registryRepository.findAll();
    }

    @Override
    public Registry getServiceByName(String name) {
        return registryRepository.findByServicename(name);
    }

    @Override
    public Registry updateServiceStatus(int id, Status status) {
        Optional<Registry> optionalRegistry = registryRepository.findById(id);
        if (optionalRegistry.isPresent()) {
            Registry registry = optionalRegistry.get();
            registry.setStatus(status);
            return registryRepository.save(registry);
        }
        return null;
    }

    @Override
    public void deleteService(int id) {
        registryRepository.deleteById(id);
    }
}
