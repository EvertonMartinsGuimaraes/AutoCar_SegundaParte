package br.edu.unibratec.autocar.controller;

import java.util.Date;
import java.util.Calendar;
import br.edu.unibratec.autocar.model.Car;
import br.edu.unibratec.autocar.model.Place;
import br.edu.unibratec.autocar.model.Place.ROUTE_TYPE;

public class TripController {
	int id = 1;
	private static TripController tripInstance;
	
	PlaceController placeController = PlaceController.getInstance();

	public static TripController getInstance() {
		if (tripInstance == null) {
			tripInstance = new TripController();

		}
		return tripInstance;
	}

	// MOSTRA O STATUS DO CARRO APOS UMA VIAGEM.
	public void carStatus(int selectCar) {
		Car car = CarController.getInstance(selectCar).select(id);
		car.carStatus(car);
	}

	// FAZ OS CALCULOS DE UMA POSSIVEL ROTA
	public void calcTrack(int km, ROUTE_TYPE type, int selectCar) {
		double routeRate = 0;

		if (type == ROUTE_TYPE.URBAN) {
			routeRate = 0.95;

		} else if (type == ROUTE_TYPE.ROADWAY) {
			routeRate = 0.98;
		}

		CarController.getInstance(selectCar).getCarModel().carTempStatus(km, routeRate);

	}

	// SETA O STATUS DO VEICULO COM OS VALORES DO CALCTRACK APOS CONFIRMAÇÃO DA ROTA
	// E INSERE NO BANCO
	public void setTrack(Place place, int selectCar) {

		CarController.getInstance(selectCar).getCarModel().SetNewKm();
		CarController.getInstance(selectCar).getCarModel().SetNewReview();
		CarController.getInstance(selectCar).getCarModel().SetKmForReview();
		CarController.getInstance(selectCar).getCarModel().SetGasReduction();
		CarController.getInstance(selectCar).getCarModel().SetOilReduction();
		CarController.getInstance(selectCar).getCarModel().SetWaterReduction();

		Car carro = new Car();
		Date data = (Date) Calendar.getInstance().getTime();
		carro.setOilLevel(CarController.getInstance(selectCar).getCarModel().getOilLevel());
		carro.setCurrentKm(CarController.getInstance(selectCar).getCarModel().getCurrentKm());
		carro.setGasLevel(CarController.getInstance(selectCar).getCarModel().getGasLevel());
		carro.setNextReview(CarController.getInstance(selectCar).getCarModel().getNextReview());
		carro.setRemainingKm(CarController.getInstance(selectCar).getCarModel().getRemainingKm());
		carro.setWaterLevel(CarController.getInstance(selectCar).getCarModel().getWaterLevel());
		carro.setPlace(place);
		carro.setData(data);

		CarController.getInstance(selectCar).insert(carro);
		id++;
	}

	public void fuel(int selectCar) {
		CarController.getInstance(selectCar).getCarModel().overhaul(100, 1000, 1000);
		Car carro = (Car) CarController.getInstance(selectCar).getCarModel();
		Date data = (Date) Calendar.getInstance().getTime();
		carro.setPlace(placeController.select(0));
		carro.setData(data);
		carro.setCurrentKm(carro.getCurrentKm()+10);
		CarController.getInstance(selectCar).insert(carro);
		id++;
	}

}
