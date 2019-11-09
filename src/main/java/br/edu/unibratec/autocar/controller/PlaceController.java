package br.edu.unibratec.autocar.controller;

import java.util.ArrayList;
import java.util.List;
import br.edu.unibratec.autocar.model.Place;
import br.edu.unibratec.autocar.model.Place.ROUTE_TYPE;

public class PlaceController {
	
	List<Place> places = new ArrayList<Place>();
	
	//METODO PARA ADICIONAR LUGARES NO ARRAY
	public void addInitialPlaces() {
		Place porto = new Place("Porto de galinhas", ROUTE_TYPE.ROADWAY, 100);
		places.add(porto);
		Place trabalho = new Place("Shopping Tacaruna", ROUTE_TYPE.URBAN, 40);
		places.add(trabalho);
		Place mariaFarinha = new Place("Maria farinha", ROUTE_TYPE.URBAN, 100);
		places.add(mariaFarinha);
	}
	
	//GET PARA ACESSO AO ARRAY
	public  List<Place> getPlacesList() {
		return places;
	}
}
