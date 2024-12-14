
package ua.nure.RegistryService.Model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import ua.nure.RegistryService.LocalDateTimeAdapter.LocalDateTimeAdapter;

import java.time.LocalDateTime;


@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Registry")
public class Registry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "service_name")
    @XmlElement
    private String servicename;

    @Column(name = "WSDLurl")
    @XmlElement
    private String wsdlurl;

    @Column(name = "description")
    @XmlElement
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "service_status")
    @XmlElement
    private Status status;

    @Column(name = "registration_date")
    @XmlElement
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime registrationDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public String getWsdlurl() {
        return wsdlurl;
    }

    public void setWsdlurl(String wsdlurl) {
        this.wsdlurl = wsdlurl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }
}