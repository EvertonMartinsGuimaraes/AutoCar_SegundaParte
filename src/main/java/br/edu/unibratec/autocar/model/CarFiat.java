package br.edu.unibratec.autocar.model;

import br.edu.unibratec.autocar.interfaces.ICarModel;


/*EXEMPLO DE CARRO CRIADO.
EM CASO DE NOVO CARRO SÓ É NECESSARIO CRIAR UMA NOVA CLASSE COMO ESSA E ALTERAR SOMENTE AS VARIAVEIS CONSTANTES.*/
public class CarFiat extends Car implements ICarModel {
		
	//CONSTANTES PARA ESSE CARRO.
	private static final double oilReductionRate = 0.02, waterReductionRate = 0.01, gasConsumptionRate = 7;
	private static final int eachReviewKm = 3000;
		
	//CONSTRUTOR - PADRÃO PARA TODOS OS CARROS.
	public CarFiat() {
		super.setOilLevel(1000);
		super.setCurrentKm(0);
		super.setGasLevel(100);
		super.setNextReview(eachReviewKm);
		super.setRemainingKm(eachReviewKm);
		super.setWaterLevel(1000);
	}

	
	//ABAIXO OS METODOS SET - PARA ALTERAÇÃO DE NIVEIS E KM E GET - PARA ACESSO A ESSES DADOS 
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
	
	//routeRate É A TAXA DE VARIAÇÃO CONFORME A ROTA ESCOLHIDA. TRECHO URBAN CONSOME MAIS.
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
