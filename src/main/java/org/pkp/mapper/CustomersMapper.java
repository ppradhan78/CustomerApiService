package org.pkp.mapper;

import org.mapstruct.Mapper;
import org.pkp.dto.CustomersDto;
import org.pkp.entity.Customers;
import org.pkp.model.CustomersModel;

import java.util.List;


@Mapper(componentModel = "spring")
public interface CustomersMapper {
    CustomersDto modeltoDto(CustomersModel model);
    CustomersModel dtotoModel(CustomersDto dto);

    CustomersModel entityToModel(Customers entity);

    Customers modelToEntity(CustomersModel model);

    List<CustomersDto> toDtoList(List<Customers> entities);

}
