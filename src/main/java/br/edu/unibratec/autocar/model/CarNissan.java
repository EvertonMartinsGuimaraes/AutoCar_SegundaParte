package br.edu.unibratec.autocar.model;

import br.edu.unibratec.autocar.interfaces.ICarModel;

public class CarNissan extends Car implements ICarModel {

//	private static final double oilReductionRate = 0.05, waterReductionRate = 0.01, gasConsumptionRate = 8;
//	private static final int eachReviewKm = 7000;

	public CarNissan() {
		super.setOilLevel(1000);
		super.setCurrentKm(0);
		super.setGasLevel(100);
		super.setNextReview(7000);
		super.setRemainingKm(7000);
		super.setWaterLevel(1000);
		super.setOilReductionRate(0.05);
		super.setWaterReductionRate(0.01);
		super.setGasConsumptionRate(8);
		super.setEachReviewKm(7000);
	}

	//routeRate É A TAXA DE VARIAÇÃO CONFORME A ROTA ESCOLHIDA. TRECHO URBAN CONSOME MAIS.
	public void setOilReduction(int kmDistance, double routeRate) {
		
		setOilLevel((super.getOilLevel() - (super.getOilReductionRate() * kmDistance))*routeRate);
	}

	public void setWaterReduction(int kmDistance, double routeRate) {
		
		setWaterLevel((super.getWaterLevel() - (super.getWaterReductionRate() * kmDistance))*routeRate);
	}

	public void setGasReduction(int kmDistance, double routeRate) {
		setGasLevel((super.getGasLevel() - (kmDistance  / super.getGasConsumptionRate()))*routeRate);
	}

	public void setKmReduction(int kmDistance, double routeRate) {
		setCurrentKm((super.getCurrentKm() + kmDistance));

	}
	
	public void overhaul(int gasRefill, int watterRefill, int oilRefill) {
			setGasLevel(gasRefill);
			setOilLevel(oilRefill);
			setWaterLevel(watterRefill);
		}

	public void setKmForReview() {

		setRemainingKm(super.getNextReview() - (super.getCurrentKm()));
	}

	public void setNewReview() {
		int km = super.getCurrentKm();
		int nextReview = super.getEachReviewKm();

		for (; km / super.getEachReviewKm() >= 1;) {
			km = km - super.getEachReviewKm();
			nextReview = nextReview + super.getEachReviewKm();
		}
		setNextReview(nextReview);
	}

	public double getOilLevel() {
		return super.getOilLevel();
	}

	public double getGasLevel() {
		return super.getGasLevel();
	}

	public double getWaterLevel() {
		return super.getWaterLevel();
	}

	public int getCurrentKm() {
		return super.getCurrentKm();
	}
	
	public int getNextReview() {
		return super.getNextReview();
	}
	
	public int getRemainingKm() {
		return super.getRemainingKm();
	}

}
