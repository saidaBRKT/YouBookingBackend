package com.example.youbookingbackend.service.Imp;

import com.example.youbookingbackend.repository.dto.ResponseDto;
import com.example.youbookingbackend.entity.*;
import com.example.youbookingbackend.repository.HotelRespository;
import com.example.youbookingbackend.service.AddressService;
import com.example.youbookingbackend.service.HotelService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class HotelServiceImp implements HotelService {

    @Autowired
    private HotelRespository hotelRespository;
    @Autowired
    private AddressService addressService;
    @Override
    public ResponseDto addHotel(Hotel hotel) {
        if(hotel.getNom()==null  || hotel.getTel()==null ){
            throw new IllegalStateException("Toutes les données sont obligatoires");
        }
        else {
            addressService.addAddress(hotel.getAdresse());
            //hotel.setStatus(Status.Desactive);
           // return hotelRespository.save(hotel);
            return new ResponseDto("success","message",hotelRespository.save(hotel));
        }
    }

    @Override
    public ResponseDto updateHotel(Hotel hotel) {
        Hotel hotelToUpdate=hotelRespository.findById(hotel.getId()).get();
        if(hotelToUpdate == null)
            throw new IllegalStateException("Tout les données sont obligatoire");
        else{
            hotelToUpdate=hotel;
            //return hotelRespository.save(hotelToUpdate);
            addressService.updateAddress(hotelToUpdate.getAdresse());
            return new ResponseDto("success","message",hotelRespository.save(hotelToUpdate));
        }
    }

    @Override
    public Hotel getOneHotel(Long id) {
        Hotel hotel=hotelRespository.findById(id).get();
        if(hotel == null)
            throw new IllegalStateException("l'hotel n'existe pas");
        else{
            return hotel;
        }
    }

    @Override
    public List<Hotel> findAllHotels() {
        return hotelRespository.findAll();
    }

    @Override
    public Hotel desactiveHotel(Long id) {
        Hotel hotel=hotelRespository.findById(id).get();
        if(hotel==null)
            throw new IllegalStateException("L'hotel' n'existe pas");
        else{
            hotel.setStatus(Status.Desactive);
            return hotelRespository.save(hotel);
        }
    }

    @Override
    public Hotel approveHotel(Long id) {
        Hotel hotel1=hotelRespository.findById(id).get();
        hotel1.setStatus(Status.Active);
        return hotelRespository.save(hotel1);
    }

    @Override
    public List<Hotel> getAllApprovedHotels() {
        return hotelRespository.findAllByStatus(Status.Active);
    }

    @Override
    public Hotel getHotelByName(String name) {
        return hotelRespository.findHotelByNom(name);
    }


}
