package com.lcwd.user.service.external.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="HOTEL-SERVICE")
public interface HotelService {


}
