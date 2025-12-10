package org.pkp.services.imp;

import lombok.RequiredArgsConstructor;
import org.pkp.entity.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomersServiceImpl implements org.pkp.services.CustomersService {

    @Autowired
    private org.pkp.repository.CustomersRepository repository;

    /**
     * @return
     */
    @Override
    public List<Customers> findAll() {
        return repository.findAll();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<Customers> findById(String id) {
        return repository.findById(id);
    }

    /**
     * @param dto
     * @return
     */
    @Override
    public Customers save(Customers dto) {
        return repository.save(dto);
    }


    /**
     * @param id
     * @return
     */
    @Override
    public void deleteById(String id) {
         repository.deleteById(id);
    }

    /**
     * @param companyName
     * @param City
     * @return
     */
    @Override
    public List<Customers> findByCompanyNameAndCity(String companyName, String City) {
        return repository.findByCompanyNameAndCity( companyName,  City);
    }

    @Override
    public List<Customers> findByPostalCodeContaining(String postalCode) {
        var result=repository.findByPostalCodeContaining(postalCode);
        return result;
    }

    @Override
    public List<Customers> findByCompanyName(String companyName) {
        var result=repository.findByCompanyName(companyName);
        return result;
    }
}
