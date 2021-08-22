package one.digitalinnovation.customerapi.service;

import one.digitalinnovation.customerapi.dto.request.CustomerDTO;
import one.digitalinnovation.customerapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.customerapi.entity.Customer;
import one.digitalinnovation.customerapi.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static one.digitalinnovation.customerapi.utils.PersonUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    void testGivenPersonDTOThenReturnSavedMessage() {
        CustomerDTO personDTO = createFakeDTO();
        Customer expectedSavedCustomer = createFakeEntity();

        when(customerRepository.save(any(Customer.class))).thenReturn(expectedSavedCustomer);

        MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedCustomer.getId());
        MessageResponseDTO succesMessage = customerService.createCustomer(personDTO);

        assertEquals(expectedSuccessMessage, succesMessage);
    }

    private MessageResponseDTO createExpectedMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + id)
                .build();
    }
}
