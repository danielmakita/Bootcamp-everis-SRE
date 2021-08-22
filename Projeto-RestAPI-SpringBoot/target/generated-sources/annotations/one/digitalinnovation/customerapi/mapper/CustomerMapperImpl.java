package one.digitalinnovation.customerapi.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import one.digitalinnovation.customerapi.dto.request.CustomerDTO;
import one.digitalinnovation.customerapi.dto.request.CustomerDTO.CustomerDTOBuilder;
import one.digitalinnovation.customerapi.dto.request.PhoneDTO;
import one.digitalinnovation.customerapi.dto.request.PhoneDTO.PhoneDTOBuilder;
import one.digitalinnovation.customerapi.entity.Customer;
import one.digitalinnovation.customerapi.entity.Customer.CustomerBuilder;
import one.digitalinnovation.customerapi.entity.Phone;
import one.digitalinnovation.customerapi.entity.Phone.PhoneBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-22T17:20:17-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer toModel(CustomerDTO customerDTO) {
        if ( customerDTO == null ) {
            return null;
        }

        CustomerBuilder customer = Customer.builder();

        if ( customerDTO.getBirthDate() != null ) {
            customer.birthDate( LocalDate.parse( customerDTO.getBirthDate(), DateTimeFormatter.ofPattern( "dd-MM-yyyy" ) ) );
        }
        customer.rua( customerDTO.getRua() );
        customer.id( customerDTO.getId() );
        customer.firstName( customerDTO.getFirstName() );
        customer.lastName( customerDTO.getLastName() );
        customer.cpf( customerDTO.getCpf() );
        customer.phones( phoneDTOListToPhoneList( customerDTO.getPhones() ) );

        return customer.build();
    }

    @Override
    public CustomerDTO toDTO(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDTOBuilder customerDTO = CustomerDTO.builder();

        customerDTO.id( customer.getId() );
        customerDTO.firstName( customer.getFirstName() );
        customerDTO.lastName( customer.getLastName() );
        customerDTO.cpf( customer.getCpf() );
        customerDTO.rua( customer.getRua() );
        if ( customer.getBirthDate() != null ) {
            customerDTO.birthDate( DateTimeFormatter.ISO_LOCAL_DATE.format( customer.getBirthDate() ) );
        }
        customerDTO.phones( phoneListToPhoneDTOList( customer.getPhones() ) );

        return customerDTO.build();
    }

    protected Phone phoneDTOToPhone(PhoneDTO phoneDTO) {
        if ( phoneDTO == null ) {
            return null;
        }

        PhoneBuilder phone = Phone.builder();

        phone.id( phoneDTO.getId() );
        phone.type( phoneDTO.getType() );
        phone.number( phoneDTO.getNumber() );

        return phone.build();
    }

    protected List<Phone> phoneDTOListToPhoneList(List<PhoneDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Phone> list1 = new ArrayList<Phone>( list.size() );
        for ( PhoneDTO phoneDTO : list ) {
            list1.add( phoneDTOToPhone( phoneDTO ) );
        }

        return list1;
    }

    protected PhoneDTO phoneToPhoneDTO(Phone phone) {
        if ( phone == null ) {
            return null;
        }

        PhoneDTOBuilder phoneDTO = PhoneDTO.builder();

        phoneDTO.id( phone.getId() );
        phoneDTO.type( phone.getType() );
        phoneDTO.number( phone.getNumber() );

        return phoneDTO.build();
    }

    protected List<PhoneDTO> phoneListToPhoneDTOList(List<Phone> list) {
        if ( list == null ) {
            return null;
        }

        List<PhoneDTO> list1 = new ArrayList<PhoneDTO>( list.size() );
        for ( Phone phone : list ) {
            list1.add( phoneToPhoneDTO( phone ) );
        }

        return list1;
    }
}
