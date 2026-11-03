package ma.ebank.customerservice.web;

import lombok.AllArgsConstructor;
import ma.ebank.customerservice.entities.Customer;
import ma.ebank.customerservice.repositories.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerRestController {
    private CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> customerList() {
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Customer customerById(@PathVariable Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }
}