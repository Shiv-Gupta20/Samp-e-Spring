package com.lcwd.hotel.HotelService.repositories;

import com.lcwd.hotel.HotelService.entites.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,String> {

}
