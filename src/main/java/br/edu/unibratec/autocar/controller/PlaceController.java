package br.edu.unibratec.autocar.controller;

import java.util.List;
import br.edu.unibratec.autocar.DAO.PlaceDAO;
import br.edu.unibratec.autocar.interfaces.IPlaceOperations;
import br.edu.unibratec.autocar.model.Place;
import br.edu.unibratec.autocar.model.Place.ROUTE_TYPE;

public class PlaceController implements IPlaceOperations<Place> {

	private static PlaceController placeInstance;
	private PlaceDAO placeDao;

	public static PlaceController getInstance() {
		if (placeInstance == null) {
			placeInstance = new PlaceController();

		}
		return placeInstance;
	}

	public PlaceController() {

		placeDao = new PlaceDAO();
	}

	// METODO PARA ADICIONAR LUGARES NO ARRAY
	public void addInitialPlaces() {
		insertNewPlace(0,"Posto Gasolina", ROUTE_TYPE.ROADWAY, 10);
		insertNewPlace(1,"Porto de galinhas", ROUTE_TYPE.ROADWAY, 100);
		insertNewPlace(2,"Shopping Tacaruna", ROUTE_TYPE.URBAN, 40);
		insertNewPlace(3,"Maria farinha", ROUTE_TYPE.URBAN, 100);
	}

	public void insert(Place place) {
		placeDao.insert(place);
	}
	
	public void insertNewPlace(int id, String name, ROUTE_TYPE route, int distance) {
		Place insertPlace = new Place(id, name, route, distance);
		if (insertPlace != null) {
			this.placeDao.insert(insertPlace);
		}
		

	}

	public void delete(int id) {
		placeDao.delete(id);

	}

	public void update(Place place) {
		placeDao.update(place);

	}

	public List<Place> getAll() {
		return this.placeDao.getAll();
	}

	public Place select(int id) {
		return placeDao.select(id);
	}
}
