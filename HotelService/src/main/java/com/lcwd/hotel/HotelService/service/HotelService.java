package com.lcwd.hotel.HotelService.service;

import com.lcwd.hotel.HotelService.entites.Hotel;

import java.util.List;

public interface HotelService {

    //create
    Hotel create(Hotel hotel);

    //get All
    List<Hotel> getAll();

    //get Single
    Hotel get(String id);
}
