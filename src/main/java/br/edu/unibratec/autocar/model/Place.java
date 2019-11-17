package br.edu.unibratec.autocar.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Place {
	@Id
	private int id;
	private String name;
	private ROUTE_TYPE route;
	private int distance;

	public Place() {
	}

	public Place(int id,String name, ROUTE_TYPE route, int distance) {
		this.setId(id);
		this.setName(name);
		this.setRoute(route);
		this.setDistance(distance);
	}

	public static enum ROUTE_TYPE {
		ROADWAY, URBAN
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ROUTE_TYPE getRoute() {
		return route;
	}

	public void setRoute(ROUTE_TYPE route) {
		this.route = route;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
}
