package br.edu.unibratec.autocar.controller;

import br.edu.unibratec.autocar.model.Car;
import br.edu.unibratec.autocar.model.CarFiat;

import java.util.List;

import br.edu.unibratec.autocar.DAO.CarDAO;
import br.edu.unibratec.autocar.interfaces.ICarModel;
import br.edu.unibratec.autocar.interfaces.ICarOperations;

public class CarController implements ICarOperations<Car>{
	private ICarModel car;
	private CarDAO carDao;

	/*ALTERAR VEICULO NESSE METODO.
	METODO CONSTRUTOR DO VEICULO.
	*/
	// @TODO fazer a seleção para escolher qual carro inicialiar.
	// o valor deve vim como parametro no construtor.
	// pode ser string ou inteiro.
	public CarController() {
		this.car = new CarFiat();
		this.carDao = new CarDAO();
	}

//METODO GET DE ACESSO AO OBJETO CARMODEL.
	public ICarModel getCarModel() {
		return this.car;
	}

	public void insert() {
		// TODO Auto-generated method stub
		this.carDao.insert((Car) this.car);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	public void update(Car registro) {
		// TODO Auto-generated method stub
		
	}

	public List<Car> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Car select() {
		// TODO Auto-generated method stub
		return null;
	}

}