package com.city.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.city.service.CityConnectorService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityConnectorController {

    @Autowired
    private CityConnectorService cityConnectorService;

    @RequestMapping(value = "/connected", method = RequestMethod.GET)
    public ResponseEntity<String> isCityConnected(@RequestParam("origin") String origin, @RequestParam("destination") String destination) {
        boolean isConnected = cityConnectorService.isConnected(origin, destination);
        return (isConnected) ? ResponseEntity.ok("Yes") : ResponseEntity.ok("No");
    }

}
