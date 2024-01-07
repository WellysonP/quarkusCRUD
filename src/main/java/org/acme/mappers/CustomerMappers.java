package org.acme.mappers;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.dto.CustomerDTO;
import org.acme.entity.CustomerEntity;

@ApplicationScoped
public class CustomerMappers {

    public CustomerDTO mapCustomerEntityToDTO(CustomerEntity customerEntity){
        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setId(customerEntity.getId());
        customerDTO.setAddress(customerEntity.getAddress());
        customerDTO.setAge(customerEntity.getAge());
        customerDTO.setName(customerEntity.getName());
        customerDTO.setPhone(customerEntity.getPhone());
        customerDTO.setEmail(customerEntity.getEmail());

        return customerDTO;
    }

    public CustomerEntity mapCustomerDtoToEntity(CustomerDTO customerDTO){
        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setId(customerEntity.getId());
        customerEntity.setAddress(customerDTO.getAddress());
        customerEntity.setAge(customerDTO.getAge());
        customerEntity.setName(customerDTO.getName());
        customerEntity.setPhone(customerDTO.getPhone());
        customerEntity.setEmail(customerDTO.getEmail());

        return customerEntity;
    }
}
