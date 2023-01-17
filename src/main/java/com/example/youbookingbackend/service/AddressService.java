package com.example.youbookingbackend.service;

import com.example.youbookingbackend.entity.Address;

public interface AddressService {
    Address addAddress(Address adress);
    Address updateAddress(Address adress);
    int deleteAddress(Long id);

}
