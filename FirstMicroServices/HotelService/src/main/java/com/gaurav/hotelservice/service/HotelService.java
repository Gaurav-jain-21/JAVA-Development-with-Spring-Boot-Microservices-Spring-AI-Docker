package com.gaurav.hotelservice.service;

import com.gaurav.hotelservice.entity.Hotel;

import java.util.List;

public interface HotelService  {

    Hotel create(Hotel hotel);
    List<Hotel> getAll();

    Hotel get(String id);
}
