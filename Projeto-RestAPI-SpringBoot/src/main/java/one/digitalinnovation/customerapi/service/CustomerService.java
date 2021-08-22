package one.digitalinnovation.customerapi.service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.customerapi.dto.request.CustomerDTO;
import one.digitalinnovation.customerapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.customerapi.entity.Customer;
import one.digitalinnovation.customerapi.exception.CustomerNotFoundException;
import one.digitalinnovation.customerapi.mapper.CustomerMapper;
import one.digitalinnovation.customerapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerService {

    private CustomerRepository customerRepository;

    private final CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    public MessageResponseDTO createCustomer(CustomerDTO customerDTO) {
        Customer customerToSave = customerMapper.toModel(customerDTO);

        Customer savedCustomer = customerRepository.save(customerToSave);
        return createMessageResponse(savedCustomer.getId(), "Created customer with ID ");
    }

    public List<CustomerDTO> listAll() {
        List<Customer> allPeople = customerRepository.findAll();
        return allPeople.stream()
                .map(customerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CustomerDTO findById(Long id) throws CustomerNotFoundException {
        Customer customer = verifyIfExists(id);

        return customerMapper.toDTO(customer);
    }

    public void delete(Long id) throws CustomerNotFoundException {
        verifyIfExists(id);
        customerRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, CustomerDTO customerDTO) throws CustomerNotFoundException {
        verifyIfExists(id);

        Customer personToUpdate = customerMapper.toModel(customerDTO);

        Customer updatedCustomer = customerRepository.save(personToUpdate);
        return createMessageResponse(updatedCustomer.getId(), "Updated customer with ID ");
    }

    private Customer verifyIfExists(Long id) throws CustomerNotFoundException {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
