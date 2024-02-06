package guru.springframework.api.v1.mapper;

import guru.springframework.api.v1.model.CustomerDTO;
import guru.springframework.domain.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerMapperTest {
    CustomerMapper customerMapper = CustomerMapper.INSTANCE;
    @Test
    public void customerToCustomerDTO() throws Exception {
        Customer customer = new Customer();
        customer.setFirstName("Sam");
        customer.setLastName("Licea");
        customer.setId(1L);

        CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);

        assertEquals(Long.valueOf(1L),customerDTO.getId());
        assertEquals("Sam",customerDTO.getFirstName());
    }
}