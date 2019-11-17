package br.edu.unibratec.autocar.facade;

import java.util.List;

import br.edu.unibratec.autocar.controller.CarController;
import br.edu.unibratec.autocar.controller.PlaceController;
import br.edu.unibratec.autocar.controller.TripController;
import br.edu.unibratec.autocar.interfaces.ICarModel;
import br.edu.unibratec.autocar.model.Car;
import br.edu.unibratec.autocar.model.Place;
import br.edu.unibratec.autocar.model.Place.ROUTE_TYPE;

public class AutoCarFacade {

	private static AutoCarFacade instancia;
	private static PlaceController placeController;
	private static CarController carController;
	private static TripController tripInstance;

	private AutoCarFacade() {
	}

	public static AutoCarFacade getInstancia() {
		if (instancia == null) {
			instancia = new AutoCarFacade();
			placeController = PlaceController.getInstance();
			carController = CarController.getInstance();
			tripInstance = TripController.getInstance();

		}

		return instancia;
	}

	// TRIP CONTROLLER
	public void carStatus() {
		tripInstance.carStatus();
	}

	public void setTrack(Place place) {
		tripInstance.setTrack(place);

	}

	public void calcTrack(int km, ROUTE_TYPE type) {
		tripInstance.calcTrack(km, type);

	}

	public void fuel() {
		tripInstance.fuel();

	}
	// CAR CONTROLLER
	public ICarModel getCarModel() {
		return carController.getCarModel();
	}

	public void insertCar(Car car) {
		carController.insert(car);
	}

	public void deleteCar(int id) {
		carController.delete(id);
	}
	public void updateCar(Car car) {
		carController.update(car);

	}

	public List<Car> getAllCar() {
		return carController.getAll();
	}

	public Car selectCar(int id) {
		return carController.select(id);
	}

	// PLACE CONTROLER
	public void addInitialPlaces() {
		placeController.addInitialPlaces();
	}

	public List<Place> getPlacesList() {
		return placeController.getAll();
	}

	public void insert(Place place) {
		placeController.insert(place);

	}

	public void insertNewPlace(int routeConfirm, String name) {
		int distance = 0;
		int id = 1;
		ROUTE_TYPE route = ROUTE_TYPE.URBAN;
		if (routeConfirm == 1) {
			route = ROUTE_TYPE.URBAN;
			distance = (int) (10 + (Math.random() * 60));
		} else if (routeConfirm == 2) {
			route = ROUTE_TYPE.ROADWAY;
			distance = (int) (100 + (Math.random() * 300));
		}
		for (Place place : getPlacesList()) {
			if (place.getId() > 0) {
				id++;
			}
		}
		placeController.insertNewPlace(id, name, route, distance);
	}

	public void deletePlace(int id) {
		if (id != 0) {
			placeController.delete(id);
		}
		for (Place place : getPlacesList()) {
			if (place.getId() > id) {
				place.setId(id);
				updatePlace(place);
				id++;
			}
		}
		placeController.delete(id);

	}

	public void updatePlace(Place place) {
		placeController.update(place);

	}

	public Place selectPlace(int id) {
		return placeController.select(id);
	}
}
