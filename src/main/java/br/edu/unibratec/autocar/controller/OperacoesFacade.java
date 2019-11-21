package br.edu.unibratec.autocar.controller;

import java.util.List;

import br.edu.unibratec.autocar.interfaces.ICarModel;
import br.edu.unibratec.autocar.model.Car;
import br.edu.unibratec.autocar.model.Place;
import br.edu.unibratec.autocar.model.Place.ROUTE_TYPE;

public class OperacoesFacade {
	private static OperacoesFacade instancia;
	private static PlaceController placeController;
	private static CarController carController;
	private static TripController tripInstance;

	private OperacoesFacade() {
	}

	public static OperacoesFacade getInstancia(int selectCar) {
		if (instancia == null) {
			instancia = new OperacoesFacade();
			placeController = PlaceController.getInstance();
			tripInstance = TripController.getInstance();
			carController = CarController.getInstance(selectCar);
		}
		return instancia;
	}

	// TRIP CONTROLLER
	public String carStatus(int selectCar) {
		return tripInstance.carStatus(selectCar);
	}

	public void setTrack(Place place, int selectCar) {
		tripInstance.setTrack(place, selectCar);

	}

	public String calcTrack(int place,int selectCar) {
//		facade.selectPlace(place).getDistance(), facade.selectPlace(place).getRoute(),
//		selectCar
		return tripInstance.calcTrack(this.selectPlace(place).getDistance(), this.selectPlace(place).getRoute(), selectCar);

	}

	public void fuel(int selectCar) {
		tripInstance.fuel(selectCar);

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
	
	public void deleteAllCar() {
		for (Car car : getAllCar()) {
			if(car.getId()>0)
			carController.delete(car.getId());
		}
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
		int idTemp = id;
		for (Place place : getPlacesList()) {
			if (place.getId() > id) {
				place.setId(id);
				updatePlace(place);
				id++;
			}
		}
		for (Car car : getAllCar()) {
			if (car.getPlace().getId() > idTemp) {
				car.setPlace(selectPlace(car.getPlace().getId() - 1));
				updateCar(car);
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
