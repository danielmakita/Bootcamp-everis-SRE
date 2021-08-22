package one.digitalinnovation.customerapi.controller;

import lombok.AllArgsConstructor;
import one.digitalinnovation.customerapi.dto.request.CustomerDTO;
import one.digitalinnovation.customerapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.customerapi.exception.CustomerNotFoundException;
import one.digitalinnovation.customerapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController //Controlador que é acessado pela API Rest
@RequestMapping("/api/v1/people") //Caminho de acesso principal da API
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerController {

    private CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
        return customerService.createCustomer(customerDTO);
    }

    @GetMapping
    public List<CustomerDTO> listAll() {
        return customerService.listAll();
    }

    @GetMapping("/{id}")
    public CustomerDTO findById(@PathVariable Long id) throws CustomerNotFoundException {
        return customerService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid CustomerDTO personDTO) throws CustomerNotFoundException {
        return customerService.updateById(id, personDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws CustomerNotFoundException {
        customerService.delete(id);
    }
}
