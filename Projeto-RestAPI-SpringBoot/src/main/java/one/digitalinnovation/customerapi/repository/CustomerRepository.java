package one.digitalinnovation.customerapi.repository;

import one.digitalinnovation.customerapi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
