package com.lcwd.hotel.HotelService.controller;

import com.lcwd.hotel.HotelService.entites.Hotel;
import com.lcwd.hotel.HotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    @RequestMapping("/hotels")
    public class HotelController {

        @Autowired
        HotelService hotelService;

        //create

        @PostMapping()
        public ResponseEntity<Hotel> create(@RequestBody Hotel hotel)
        {
            return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
        }

        //Get Single
        @GetMapping("/{hotelId}")
        public ResponseEntity<Hotel> create(@PathVariable String hotelId)
        {
            return ResponseEntity.status(HttpStatus.OK).body(hotelService.get(hotelId));
        }


        //Get All

        @GetMapping
        public ResponseEntity<List<Hotel>> getAll()
        {
            return ResponseEntity.ok(hotelService.getAll());
        }

    }
