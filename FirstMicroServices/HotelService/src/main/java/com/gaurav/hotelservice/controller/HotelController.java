package com.gaurav.hotelservice.controller;

import com.gaurav.hotelservice.entity.Hotel;
import com.gaurav.hotelservice.impl.HotelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelServiceImpl hotelService;


    @PostMapping("/add")
    public Hotel createHotel(@RequestBody Hotel hotel){
        return hotelService.create(hotel);
    }

    @GetMapping("/allHotel")
    public List<Hotel> getAll(){
        return hotelService.getAll();
    }

    @GetMapping("/get/{id}")
    public Hotel getById(@PathVariable String id){
        return hotelService.get(id);
    }
}
