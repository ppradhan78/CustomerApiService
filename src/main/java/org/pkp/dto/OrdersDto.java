package org.pkp.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OrdersDto {

    private int OrderID;
    private String CustomerID;
    private int EmployeeID;
    private LocalDate OrderDate;
    private LocalDate  RequiredDate;
    private LocalDate  ShippedDate;
    private int ShipVia;
    private int Freight;
    private String ShipName;

    private String ShipAddress;

    private String ShipCity	;

    private String ShipRegion;

    private String ShipPostalCode;

    private String ShipCountry;

}
