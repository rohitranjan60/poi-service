package com.benz.ccp.poiservice.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.benz.ccp.poiservice.dto.ClosestPlace;
import com.benz.ccp.poiservice.service.PlaceService;

@RestController
public class PlaceController {
	
	private final Logger logger = LoggerFactory.getLogger(PlaceController.class);

	@Autowired
	PlaceService service;
	
	/**
	 * API: Get the closest place/nearby places as per user input location
	 * @param searchLocation
	 * @return ClosestPlace
	 */
	@GetMapping("/nearby-places/{searchLocation}")
	public ArrayList<ClosestPlace> getClosestPlaces(@PathVariable String searchLocation) {
		
		logger.info("User is searching from location : "+searchLocation);
		logger.info("Callng fetch closest places service");
		return service.fetchClosestPlaces(searchLocation);
		
	}
}
