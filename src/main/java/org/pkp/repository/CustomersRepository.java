package org.pkp.repository;

import org.pkp.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomersRepository extends JpaRepository<Customers, String> {
    //6.	 JPQL (Java Persistence Query Language)
    @Query("FROM Customers s WHERE s.postalCode  LIKE %:postalCode%")
    List<Customers> findByPostalCodeContaining(String postalCode);

    //5.	Query Methods (Derived Queries)
    List<Customers> findByCompanyNameAndCity(String companyName, String City);

    //7.	Native SQL Queries
    @Query(value = "SELECT * FROM Customers c  WHERE c.CompanyName  LIKE %:companyName%",nativeQuery = true)
    List<Customers> findByCompanyName(String companyName);

}