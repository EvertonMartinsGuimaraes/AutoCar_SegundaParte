package br.edu.unibratec.autocar.interfaces;

//INTERFACE MODELO DOS CARROS A SEREM CRIADOS.
public interface ICarModel {

	public void setOilReduction(int kmDistance, double routeRate);

	public void setWaterReduction(int kmDistance, double routeRate);

	public void setGasReduction(int kmDistance, double routeRate);

	public void setKmReduction(int kmDistance, double routeRate);
	
	public void overhaul(int refillGas,int refillOil, int refillWatter);
	
	public void setKmForReview();

	public void setNewReview();
	
	public double getOilLevel();
	
	public double getGasLevel();
	
	public double getWaterLevel();
	
	public int getCurrentKm();
	
	public int getRemainingKm();
	
	public int getNextReview();
	
		
	}
