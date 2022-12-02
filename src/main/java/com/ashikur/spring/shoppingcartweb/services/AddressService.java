package com.ashikur.spring.shoppingcartweb.services;

import com.ashikur.spring.shoppingcartweb.repository.AddressesRepository;
import com.ashikur.spring.shoppingcartweb.errors.exceptions.ResourceNotFoundException;
import com.ashikur.spring.shoppingcartweb.models.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    AddressesRepository addressRepository;

    public Address save(Address address) {
        return addressRepository.save(address);
    }

    public Address getById(Long addressId) {
        return getById(addressId, true);
    }

    private Address getById(Long addressId, boolean throwIfDoesnotExist) {
        Optional<Address> address = addressRepository.findById(addressId);
        if (!address.isPresent() && throwIfDoesnotExist)
            throw new ResourceNotFoundException();

        return address.orElse(null);
    }
}
