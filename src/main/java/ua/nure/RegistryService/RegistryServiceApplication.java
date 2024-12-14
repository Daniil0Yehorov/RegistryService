package ua.nure.RegistryService;

import jakarta.xml.ws.Endpoint;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ua.nure.RegistryService.ServiceImplementation.ServiceRegistryImpl;

@SpringBootApplication
public class RegistryServiceApplication {


	public static void main(String[] args) {SpringApplication.run(RegistryServiceApplication.class, args);}

	@Bean
	public CommandLineRunner startSOAPService(ServiceRegistryImpl serviceRegistryImpl) {
		return args -> {
			String address = "http://localhost:8089/ws/Registry";
			Endpoint.publish(address, serviceRegistryImpl);
			System.out.println("SOAP web service is running at: " + address);
		};
	}
}
