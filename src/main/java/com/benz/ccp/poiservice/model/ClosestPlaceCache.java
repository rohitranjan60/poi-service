package com.benz.ccp.poiservice.model;

import java.util.List;

import org.springframework.data.redis.core.RedisHash;

import com.benz.ccp.poiservice.dto.ClosestPlace;

@RedisHash("ClosestPlaceCache")
public class ClosestPlaceCache {

	private String id;
	private List<ClosestPlace> closestPlace;
	
	public ClosestPlaceCache(String id, List<ClosestPlace> closestPlace) {
		super();
		this.id = id;
		this.closestPlace = closestPlace;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<ClosestPlace> getClosestPlace() {
		return closestPlace;
	}
	public void setClosestPlace(List<ClosestPlace> closestPlace) {
		this.closestPlace = closestPlace;
	}
	
	
	
	
}
