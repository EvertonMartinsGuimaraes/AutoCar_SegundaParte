package br.edu.unibratec.autocar.model;

//import javax.persistence.DiscriminatorValue;
//import javax.persistence.Entity;

import br.edu.unibratec.autocar.interfaces.ICarModel;


/*EXEMPLO DE CARRO CRIADO.
EM CASO DE NOVO CARRO SÓ É NECESSARIO CRIAR UMA NOVA CLASSE COMO ESSA E ALTERAR SOMENTE AS VARIAVEIS CONSTANTES.*/
//@Entity
//@DiscriminatorValue("F")
public class CarFiat extends Car implements ICarModel {
		
	//CONSTANTES PARA ESSE CARRO.
//	private static final double oilReductionRate = 0.02, waterReductionRate = 0.01, gasConsumptionRate = 7;
//	private static final int eachReviewKm = 3000;
		
	//CONSTRUTOR - PADRÃO PARA TODOS OS CARROS.

	public CarFiat() {
		super.setOilLevel(1000);
		super.setCurrentKm(0);
		super.setGasLevel(100);
		super.setNextReview(3000);
		super.setRemainingKm(3000);
		super.setWaterLevel(1000);
		super.setOilReductionRate(0.02);
		super.setWaterReductionRate(0.01);
		super.setGasConsumptionRate(7);
		super.setEachReviewKm(3000);
//		super.setCarModel('F');
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
