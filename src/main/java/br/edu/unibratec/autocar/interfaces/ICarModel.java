package br.edu.unibratec.autocar.interfaces;

import br.edu.unibratec.autocar.model.Car;

//INTERFACE MODELO DOS CARROS A SEREM CRIADOS.
public interface ICarModel {

	// METODOS DE CALCULO PARA RETORNAR UM POSSIVEL STATUS DO CARRO
	public double OilReduction(int kmDistance, double routeRate);

	public double WaterReduction(int kmDistance, double routeRate);

	public double GasReduction(int kmDistance, double routeRate);

	public int NewKm(int kmDistance, double routeRate);

	public int KmForReview(int kmDistance);

	public int NewReview();
	
	//METODO PARA ENCHER O TANQUE E NIVEIS DE AGUA E OLEO
	public void overhaul(int refillGas, int refillOil, int refillWatter);

	// METODOS SET E GET DO CARRO JA SETADO APOS VIAGEM
	
	public void SetOilReduction();

	public void SetWaterReduction();

	public void SetGasReduction();

	public void SetNewKm();

	public void SetKmForReview();

	public void SetNewReview();

	public double getOilLevel();

	public double getGasLevel();

	public double getWaterLevel();

	public int getCurrentKm();

	public int getRemainingKm();

	public int getNextReview();
	
	public String carTempStatus(int km, double routeRate);
}
