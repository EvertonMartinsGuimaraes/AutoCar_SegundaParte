package br.edu.unibratec.autocar.model;

import br.edu.unibratec.autocar.interfaces.ICarModel;

public class CarNissan extends Car implements ICarModel {

	private static final double oilReductionRate = 0.05, waterReductionRate = 0.01, gasConsumptionRate = 8;
	private static final int eachReviewKm = 7000;

	public CarNissan() {
		super.setOilLevel(1000);
		super.setCurrentKm(0);
		super.setGasLevel(100);
		super.setNextReview(eachReviewKm);
		super.setRemainingKm(eachReviewKm);
		super.setWaterLevel(1000);
	}

	public static double getWaterreductionrate() {
		return waterReductionRate;
	}

	public static double gasConsumptionRate() {
		return gasConsumptionRate;
	}

	public static double getOilreductionrate() {
		return oilReductionRate;
	}

	public static int getEachreviewkm() {
		return eachReviewKm;
	}

	//routeRate é a taxa de variação conforme a rota escolhida. Urbano consome mais.
	
	public void setOilReduction(int kmDistance, double routeRate) {
		
		setOilLevel((super.getOilLevel() - (getOilreductionrate() * kmDistance))*routeRate);
	}

	public void setWaterReduction(int kmDistance, double routeRate) {
		
		setWaterLevel((super.getWaterLevel() - (getWaterreductionrate() * kmDistance))*routeRate);
	}

	public void setGasReduction(int kmDistance, double routeRate) {
		setGasLevel((super.getGasLevel() - (kmDistance  / gasConsumptionRate()))*routeRate);
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
		int nextReview = getEachreviewkm();

		for (; km / getEachreviewkm() >= 1;) {
			km = km - getEachreviewkm();
			nextReview = nextReview + getEachreviewkm();
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
