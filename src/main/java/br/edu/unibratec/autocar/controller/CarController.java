package br.edu.unibratec.autocar.controller;

import br.edu.unibratec.autocar.model.CarFiat;
import br.edu.unibratec.autocar.interfaces.ICarModel;

public class CarController {
	private ICarModel car;

	/*ALTERAR VEICULO NESSE METODO.
	METODO CONSTRUTOR DO VEICULO.
	*/
	public CarController() {
		car = new CarFiat();

	}

//METODO GET DE ACESSO AO OBJETO CARMODEL.
	public ICarModel getCarModel() {
		return this.car;
	}

}