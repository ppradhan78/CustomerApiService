package org.pkp.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Customers")
public class Customers {
    @Id
    @NotBlank
    @Column(nullable = false, name="CustomerID")
    private String customerID;

    @NotBlank
    @Column(nullable = false, name = "CompanyName")
    private String companyName;

    @Column(nullable = true, name="ContactName")
    private String contactName;

    @Column(nullable = true, name="ContactTitle")
    private String contactTitle	;

    @Column(nullable = true, name="Address")
    private String address;

    @Column(nullable = true, name="City")
    private String city;

    @Column(nullable = true, name="Region")
    private String region;

    @Column(nullable = true,name="PostalCode")
    private String postalCode;

    @Column(nullable = true, name="Country")
    private String country;

    @Column(nullable = true, name="Phone")
    private String phone;

    @Column(nullable = true, name="Fax")
    private String fax;
    
}
