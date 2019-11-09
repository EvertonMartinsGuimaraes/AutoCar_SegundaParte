package br.edu.unibratec.autocar.model;

public class Place {
	private String name;
	private ROUTE_TYPE route;
	private int distance;

	public Place(String name, ROUTE_TYPE route, int distance) {
		this.name = name;
		this.route = route;
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
