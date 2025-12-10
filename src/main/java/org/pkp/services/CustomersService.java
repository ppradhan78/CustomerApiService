package org.pkp.services;

import org.pkp.entity.Customers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CustomersService {
    List<Customers> findAll();
    Optional<Customers> findById(String id);
    Customers save(Customers dto);
    void deleteById(String id);

    List<Customers> findByPostalCodeContaining(String postalCode);
    List<Customers> findByCompanyNameAndCity(String companyName, String City);
    List<Customers> findByCompanyName(String companyName);
}
