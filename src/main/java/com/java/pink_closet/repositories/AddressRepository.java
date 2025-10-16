package com.java.pink_closet.repositories;

import com.java.pink_closet.model.Address;
import java.util.List;
import java.util.Optional;

public interface AddressRepository {

    List<Address> findAll();
    Address save(Address address);
    Optional<Address> findById(Long id);
    void delete(Address address);
    void deleteById(Long id);
    List<Address> findByCustomerId(Long customerId);
    List<Address> findByCustomerIdAndCity(Long customerId, String city);
    Optional<Address> findPrimaryByCustomerId(Long customerId);
    List<Address> findByCustomerIdAndZipCode(Long customerId, String zipCode);
}
