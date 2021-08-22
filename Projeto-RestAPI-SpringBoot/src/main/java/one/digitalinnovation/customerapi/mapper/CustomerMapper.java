package one.digitalinnovation.customerapi.mapper;

import one.digitalinnovation.customerapi.dto.request.CustomerDTO;
import one.digitalinnovation.customerapi.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    @Mapping(target = "rua", source = "rua")
    Customer toModel(CustomerDTO customerDTO);

    CustomerDTO toDTO(Customer customer);
}
