package br.edu.unibratec.autocar.controller;

import br.edu.unibratec.autocar.model.CarFiat;
import br.edu.unibratec.autocar.interfaces.ICarModel;

public class CarController {
	private ICarModel car;

	/*ALTERAR VEICULO NESSE METODO.
	METODO CONSTRUTOR DO VEICULO.
	*/
	// @TODO fazer a seleção para escolher qual carro inicialiar.
	// o valor deve vim como parametro no construtor.
	// pode ser string ou inteiro.
	public CarController() {
		car = new CarFiat();

	}

//METODO GET DE ACESSO AO OBJETO CARMODEL.
	public ICarModel getCarModel() {
		return this.car;
	}

}