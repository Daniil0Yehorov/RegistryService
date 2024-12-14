package ua.nure.RegistryService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.nure.RegistryService.Model.Registry;

import java.util.Optional;

public interface RegistryRepository extends JpaRepository<Registry,Long> {
    @Query("SELECT r FROM Registry r WHERE r.servicename = :servicename")
    Registry findByServicename(@Param("servicename") String servicename);

    Optional<Registry> findById(int id);
    void deleteById(int id);
}
