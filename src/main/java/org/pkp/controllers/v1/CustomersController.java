package org.pkp.controllers.v1;

import ch.qos.logback.classic.Level;
import lombok.RequiredArgsConstructor;
import org.pkp.client.OrderClient;
import org.pkp.dto.OrdersDto;
import org.pkp.entity.Customers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomersController {
    private static final Logger logger = LoggerFactory.getLogger(CustomersController.class);
    @Autowired
    private final org.pkp.services.CustomersService service;

    @Autowired
    private OrderClient orderClient;

    @GetMapping
    public ResponseEntity<List<Customers>> findAll() {
        logger.info("Processing CustomersController");
        logger.debug("Debug CustomersController");
        logger.error("Something went wrong in CustomersController");
        try{
            return ResponseEntity.ok(service.findAll());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Customers>> findById(@PathVariable String id) {
        Optional<Customers> customers= service.findById(id);
        if (customers.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok(customers);
        }

    }

    @PostMapping
    public Map<String, String> save(@RequestBody Customers dto) {
        Customers success= service.save( dto);
        if ( (success != null && success.getCustomerID() != null)|| !success.getCustomerID().isEmpty()) {
            return Map.of("message", "Customers created successfully");
        }
        else {
            return Map.of("message", "Faill to Create Customers.");
        }
    }

    @DeleteMapping("/{id}")
    public Map<String, String>  Delete(@PathVariable String id) {

        try{
            service.deleteById(id);
            return Map.of("message", "Customers deleted successfully");
        } catch (Exception e) {
            return Map.of("message", "Faill to deleted Customers.");
        }
    }

    @GetMapping("/by-name-city")
    public List<Customers> findByCompanyNameAndCity(
            @RequestParam String companyName,
            @RequestParam String City) {

        return service.findByCompanyNameAndCity(companyName, City);
    }

    @GetMapping("/postal")
    public ResponseEntity<List<Customers>> findByPostalCodeContaining(
            @RequestParam(required = false, defaultValue = "") String postalCode) {

        return ResponseEntity.ok(service.findByPostalCodeContaining(postalCode));
    }

    @GetMapping("/cname")
    public ResponseEntity<List<Customers>> findByCompanyName(
            @RequestParam(required = false, defaultValue = "") String companyName) {

        return ResponseEntity.ok(service.findByCompanyName(companyName));
    }

    @GetMapping("order/customerID")
    public ResponseEntity<List<OrdersDto>> getOrdersByCustomer(
            @RequestParam(required = false, defaultValue = "") String customerID) {

        List<OrdersDto> orders = orderClient.getOrdersByCustomer(customerID);
        return ResponseEntity.ok(orders);

    }
}
