package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.dto.CustomerDTO;
import org.acme.entity.CustomerEntity;
import org.acme.mappers.CustomerMappers;
import org.acme.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CustomerService {

    @Inject
    private CustomerRepository customerRepository;

    @Inject
    private CustomerMappers customerMappers;

    public List<CustomerDTO> findAllCustomers(){
        List<CustomerDTO> customers = new ArrayList<>();

        customerRepository.findAll().stream().forEach(item ->{
            customers.add(customerMappers.mapCustomerEntityToDTO(item));
        });

        return  customers;
    }

    public void createCustomer(CustomerDTO customerDTO){
        customerRepository.persist(customerMappers.mapCustomerDtoToEntity(customerDTO));
    }

    public void changeCustomer(Long id, CustomerDTO customerDTO){
        CustomerEntity customer = customerRepository.findById(id);

        customer.setEmail(customerDTO.getEmail());
        customer.setName(customer.getName());
        customer.setPhone(customer.getPhone());
        customer.setAge(customer.getAge());
        customer.setAddress(customer.getAddress());

        customerRepository.persist(customer);
    }

    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }
}
