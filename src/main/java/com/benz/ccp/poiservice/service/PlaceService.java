package com.benz.ccp.poiservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.benz.ccp.poiservice.dto.ClosestPlace;
import com.benz.ccp.poiservice.dto.Item;
import com.benz.ccp.poiservice.dto.Places;
import com.benz.ccp.poiservice.model.ClosestPlaceCache;
import com.benz.ccp.poiservice.repository.ClosestPlaceCacheRepository;

@Component
public class PlaceService {
	
	private final Logger logger = LoggerFactory.getLogger(PlaceService.class);
	
	@Autowired
	ClosestPlaceCacheRepository repository;

	@Value("${here.api.uri}")
	private String apiURI;
	@Value("${here.api.key}")
	private String apiKey;
	private Map<String, String> uriVariables = new HashMap<>();
	private ClosestPlace closestPlace;
	private Places searchedPlace1;
	private Places searchedPlace2;
	private Places searchedPlace3;
	private ResponseEntity<Places> response;
	
	
	
	public ArrayList<ClosestPlace> fetchClosestPlaces(String searchLocation) {
		
		//check if results are available on redis cache using search location
		logger.info("Looking redis cache for searchLocation : "+searchLocation);
		Optional<ClosestPlaceCache> closestPlaceCache = repository.findById(searchLocation);
		
		if(closestPlaceCache.isPresent()) {
			logger.info("Closest places for searchLocation is available on redis cache. Return the same to the user");
			return (ArrayList<ClosestPlace>) closestPlaceCache.get().getClosestPlace();
		}
		
		uriVariables.put("at", searchLocation);
		uriVariables.put("query","charging");
		uriVariables.put("apiKey", apiKey);
		logger.info("calling external service to get nearby places for category charging...");
		response = new RestTemplate().getForEntity(apiURI, Places.class, uriVariables);
		
		if(null != response) {
			searchedPlace1 = response.getBody();
		} else {
			logger.info("Query to get nearby places for charing returned null. Please check with the external service provider.");
		}
		
		uriVariables.put("at", searchLocation);
		uriVariables.put("query","parking");
		uriVariables.put("apiKey", apiKey);	
		logger.info("calling external service to get nearby places for category parking...");
		response = new RestTemplate().getForEntity(apiURI, Places.class, uriVariables);
		
		if(null != response) {
			searchedPlace2 = response.getBody();
		} else {
			logger.info("Query to get nearby places for parking returned null. Please check with the external service provider.");
		}
		
		uriVariables.put("at", searchLocation);
		uriVariables.put("query","restaurant");
		uriVariables.put("apiKey", apiKey);	
		logger.info("calling external service to get nearby places for category restaurant...");
		response = new RestTemplate().getForEntity(apiURI, Places.class, uriVariables);
		
		if(null != response) {
			searchedPlace3 = response.getBody();
		} else {
			logger.info("Query to get nearby places for restaurant returned null. Please check with the external service provider.");
		}
		
		ArrayList<Item> items = new ArrayList<>();
		items.add(searchedPlace1.getResults().getItems().get(0));
		items.add(searchedPlace1.getResults().getItems().get(1));
		items.add(searchedPlace1.getResults().getItems().get(2));
		
		items.add(searchedPlace2.getResults().getItems().get(0));
		items.add(searchedPlace2.getResults().getItems().get(1));
		items.add(searchedPlace2.getResults().getItems().get(2));
		
		
		items.add(searchedPlace3.getResults().getItems().get(0));
		items.add(searchedPlace3.getResults().getItems().get(1));
		items.add(searchedPlace3.getResults().getItems().get(2));
		
		ArrayList<ClosestPlace> closestPlaceList = new ArrayList<>();
		
		for(Item item : items) {
			closestPlace = new ClosestPlace();
			closestPlace.setCategory(item.getCategory().getTitle());
			closestPlace.setDistance(item.getDistance());
			closestPlace.setAddress(item.getVicinity());
			closestPlace.setPosition(item.getPosition());
			closestPlace.setTitle(item.getTitle());
			closestPlace.setType(item.getType());
			closestPlace.setOpeningHours(item.getOpeningHours());
			
			closestPlaceList.add(closestPlace);
		}
		
		
		// add the list to ClosestPlaceCache
		addToCache(closestPlaceList, searchLocation);
		
		return closestPlaceList;
		
	}



	private void addToCache(List<ClosestPlace> closestPlaceList, String searchLocation) {
		logger.info("Saving searchLocation : "+searchLocation+" data to redis cache.");
		ClosestPlaceCache closestPlaceCache = new ClosestPlaceCache(searchLocation, closestPlaceList);
		repository.save(closestPlaceCache);
	}
}
