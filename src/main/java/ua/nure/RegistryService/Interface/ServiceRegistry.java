package ua.nure.RegistryService.Interface;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import ua.nure.RegistryService.Model.Registry;
import ua.nure.RegistryService.Model.Status;

import java.util.List;
@WebService(targetNamespace = "http://ServiceImplementation.RegistryService.nure.ua/")
public interface ServiceRegistry {
    @WebMethod
    Registry registerService(Registry registry);
    @WebMethod
    List<Registry> getAllServices();
    @WebMethod
    Registry getServiceByName(String name);
    @WebMethod
    Registry updateServiceStatus(int id, Status status);
    @WebMethod
    void deleteService(int id);
}