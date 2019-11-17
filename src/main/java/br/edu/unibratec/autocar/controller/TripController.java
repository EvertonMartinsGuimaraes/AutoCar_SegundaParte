package br.edu.unibratec.autocar.controller;

import java.util.Date;
import java.util.Calendar;
import br.edu.unibratec.autocar.model.Car;
import br.edu.unibratec.autocar.model.CarFiat;
import br.edu.unibratec.autocar.model.Place;
import br.edu.unibratec.autocar.model.Place.ROUTE_TYPE;

public class TripController {
	int id = 1;
	private static TripController tripInstance;
	
	CarController carController = CarController.getInstance();
	PlaceController placeController = PlaceController.getInstance();

	public static TripController getInstance() {
		if (tripInstance == null) {
			tripInstance = new TripController();

		}
		return tripInstance;
	}

	// MOSTRA O STATUS DO CARRO APOS UMA VIAGEM.
	public void carStatus() {
		Car car = carController.select(id);
		car.carStatus(car);
	}

	// FAZ OS CALCULOS DE UMA POSSIVEL ROTA
	public void calcTrack(int km, ROUTE_TYPE type) {
		double routeRate = 0;

		if (type == ROUTE_TYPE.URBAN) {
			routeRate = 0.95;

		} else if (type == ROUTE_TYPE.ROADWAY) {
			routeRate = 0.98;
		}

		carController.getCarModel().carTempStatus(km, routeRate);

	}

	// SETA O STATUS DO VEICULO COM OS VALORES DO CALCTRACK APOS CONFIRMAÇÃO DA ROTA
	// E INSERE NO BANCO
	public void setTrack(Place place) {

		carController.getCarModel().SetNewKm();
		carController.getCarModel().SetNewReview();
		carController.getCarModel().SetKmForReview();
		carController.getCarModel().SetGasReduction();
		carController.getCarModel().SetOilReduction();
		carController.getCarModel().SetWaterReduction();

		CarFiat carro = new CarFiat();
		Date data = (Date) Calendar.getInstance().getTime();
		carro.setOilLevel(carController.getCarModel().getOilLevel());
		carro.setCurrentKm(carController.getCarModel().getCurrentKm());
		carro.setGasLevel(carController.getCarModel().getGasLevel());
		carro.setNextReview(carController.getCarModel().getNextReview());
		carro.setRemainingKm(carController.getCarModel().getRemainingKm());
		carro.setWaterLevel(carController.getCarModel().getWaterLevel());
		carro.setPlace(place);
		carro.setData(data);

		carController.insert((Car) carro);
		id++;
	}

	public void fuel() {
		carController.getCarModel().overhaul(100, 1000, 1000);
		Car carro = (Car) carController.getCarModel();
		carro.setPlace(placeController.select(0));
		carController.insert(carro);
		id++;
	}

}
