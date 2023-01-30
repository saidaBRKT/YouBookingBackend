package com.example.youbookingbackend.service.Imp;

import com.example.youbookingbackend.entity.Address;
import com.example.youbookingbackend.entity.Reservation;
import com.example.youbookingbackend.entity.StatusReservation;
import com.example.youbookingbackend.repository.AddressRespository;
import com.example.youbookingbackend.repository.ReservationRespository;
import com.example.youbookingbackend.service.AddressService;
import com.example.youbookingbackend.service.ReservationService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class AdressServiceImp implements AddressService {
    @Autowired
    private AddressRespository addressRespository;

    @Override
    public Address addAddress(Address address) {
        if(address.getAddress()==null || address.getCodePostal()==null || address.getPays()==null || address.getVille()==null){
            throw new IllegalStateException("Toutes les données sont obligatoires");
        }
        else {
            return addressRespository.save(address);
        }
    }

    @Override
    public Address updateAddress(Address address) {
        Address addressToUpdate=addressRespository.findById(address.getId()).get();
        if(addressToUpdate == null)
            throw new IllegalStateException("Tout les données sont obligatoire");
        else{
            addressToUpdate=address;
            return addressRespository.save(addressToUpdate);
        }
    }

    @Override
    public int deleteAddress(Long id) {
        Address address=addressRespository.findById(id).get();
        if(address==null)
            throw new IllegalStateException("L'addresse n'existe pas");
        else
            return addressRespository.deleteAddressById(id);
    }
}
