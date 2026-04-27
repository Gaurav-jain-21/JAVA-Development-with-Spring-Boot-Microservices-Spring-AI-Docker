package com.gaurav.hotelservice.impl;

import com.gaurav.hotelservice.entity.Hotel;
import com.gaurav.hotelservice.repository.HotelRepo;
import com.gaurav.hotelservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService{
    @Autowired
    private HotelRepo hotelRepo;

    @Override
    public Hotel create(Hotel hotel){
        String hotelId=UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepo.save(hotel);
    }

    @Override
    public List<Hotel> getAll(){
        return hotelRepo.findAll();
    }
    @Override
    public Hotel get(String id){
        return hotelRepo.findById(id).orElse(null);
    }
}
