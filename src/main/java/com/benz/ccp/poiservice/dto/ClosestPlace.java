package com.benz.ccp.poiservice.dto;

import java.util.ArrayList;
import java.util.List;

public class ClosestPlace {

	private String category;
	private Integer distance;
	private String address;
	private List<Double> position = new ArrayList<Double>();
    private String title;
    private String type;
    private OpeningHours openingHours;
    
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getDistance() {
		return distance;
	}
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Double> getPosition() {
		return position;
	}
	public void setPosition(List<Double> position) {
		this.position = position;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public OpeningHours getOpeningHours() {
		return openingHours;
	}
	public void setOpeningHours(OpeningHours openingHours) {
		this.openingHours = openingHours;
	}
	
	@Override
	public String toString() {
		return "ClosestPlace [category=" + category + ", distance=" + distance + ", address=" + address + ", position="
				+ position + ", title=" + title + ", type=" + type + ", openingHours=" + openingHours + "]";
	}
  
	
}
