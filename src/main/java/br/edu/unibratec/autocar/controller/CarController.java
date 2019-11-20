package br.edu.unibratec.autocar.controller;


import java.util.List;
import br.edu.unibratec.autocar.DAO.CarDAO;
import br.edu.unibratec.autocar.interfaces.ICarModel;
import br.edu.unibratec.autocar.interfaces.ICarOperations;
import br.edu.unibratec.autocar.model.Car;
import br.edu.unibratec.autocar.model.CarFiat;
import br.edu.unibratec.autocar.model.CarNissan;
import br.edu.unibratec.autocar.model.CarVolkswagem;

public class CarController implements ICarOperations<Car> {
	private ICarModel car;
	private CarDAO carDao;
	private static CarController carInstance;
	int id = 1;

	public static CarController getInstance(int selectCar) {
		if (carInstance == null) {
			carInstance = new CarController(selectCar);

		}
		return carInstance;
	}

	public CarController(int selectCar) {
		switch (selectCar) {
		case 1:
			this.car = new CarFiat();
			this.carDao = new CarDAO();
			break;
		case 2:
			this.car = new CarVolkswagem();
			this.carDao = new CarDAO();
			break;
		case 3:
			this.car = new CarNissan();
			this.carDao = new CarDAO();
			break;
		default:
			System.out.println("Digite um valor correto para o menu.");
		}
	}

	// METODO GET DE ACESSO AO OBJETO CARMODEL.
	public ICarModel getCarModel() {
		return this.car;
	}

	public void insert(Car car) {
		if (car != null) {
			this.carDao.insert(car);
		}

	}

	public void delete(int id) {
		this.carDao.delete(id);

	}

	public void update(Car car) {
		this.carDao.update(car);

	}

	public List<Car> getAll() {
		return this.carDao.getAll();
	}

	public Car select(int id) {
		return carDao.getWithId(id);
	}

}