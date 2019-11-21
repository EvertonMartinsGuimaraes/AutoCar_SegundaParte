package br.edu.unibratec.autocar.model;

import java.text.DecimalFormat;

import javax.persistence.Entity;

//import javax.persistence.DiscriminatorValue;
//import javax.persistence.Entity;

import br.edu.unibratec.autocar.interfaces.ICarModel;

@Entity
//@DiscriminatorValue("V")
public class CarVolkswagem extends Car implements ICarModel {

	// CONSTANTES PARA ESSE CARRO.
	private static final double oilReductionRate = 0.04, waterReductionRate = 0.02, gasConsumptionRate = 6;
	private static final int eachReviewKm = 6000;
	int newKm = 0;
	private double newOilLevel = 1000;
	private double newGasLevel = 100;
	private double newWaterLevel = 1000;
	private int newNextReview = eachReviewKm;
	private int newRemainingKm = eachReviewKm;

	public CarVolkswagem() {

		super.setOilLevel(newOilLevel);
		super.setCurrentKm(newKm);
		super.setGasLevel(newGasLevel);
		super.setNextReview(eachReviewKm);
		super.setRemainingKm(eachReviewKm);
		super.setWaterLevel(newWaterLevel);
		super.setPlace(null);
	}

	// ABAIXO OS METODOS PARA ALTERAÇÃO DE NIVEIS E KM RETORNANDO O FUTURO VALOR
	// APOS VIAGEM

	// routeRate É A TAXA DE VARIAÇÃO CONFORME A ROTA ESCOLHIDA. TRECHO URBAN
	// CONSOME MAIS.

	public double OilReduction(int kmDistance, double routeRate) {

		return newOilLevel = ((super.getOilLevel() - (getOilreductionrate() * kmDistance)) * routeRate);
	}

	public double WaterReduction(int kmDistance, double routeRate) {

		return newWaterLevel = ((super.getWaterLevel() - (getWaterreductionrate() * kmDistance)) * routeRate);
	}

	public double GasReduction(int kmDistance, double routeRate) {
		return newGasLevel = ((super.getGasLevel() - (kmDistance / gasConsumptionRate())) * routeRate);
	}

	public int NewKm(int kmDistance, double routeRate) {
		return newKm = ((super.getCurrentKm() + kmDistance));

	}

	public int KmForReview(int kmDistance) {

		return newRemainingKm = (NewReview() - ((super.getCurrentKm() + kmDistance)));
	}

	public int NewReview() {
		int km = super.getCurrentKm();
		int nextReview = getEachreviewkm();

		for (; km / getEachreviewkm() >= 1;) {
			km = km - getEachreviewkm();
			nextReview = nextReview + getEachreviewkm();
		}
		return newNextReview = nextReview;
	}

	// METODO PARA ENCHER O TANQUE E NIVEIS DE AGUA E OLEO
	public void overhaul(int gasRefill, int watterRefill, int oilRefill) {
		setGasLevel(gasRefill);
		setOilLevel(oilRefill);
		setWaterLevel(watterRefill);
		System.out.println("Carro Abastecido.");
	}

	// METODOS GET E SET DOS VALORES JA ALTERADOS CORRESPONDENTE A CORRIDA.
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

	public void SetOilReduction() {
		super.setOilLevel(newOilLevel);

	}

	public void SetWaterReduction() {
		super.setWaterLevel(newWaterLevel);

	}

	public void SetGasReduction() {
		super.setGasLevel(newGasLevel);

	}

	public void SetNewKm() {
		super.setCurrentKm(newKm);

	}

	public void SetKmForReview() {
		super.setRemainingKm(newRemainingKm);

	}

	public void SetNewReview() {
		super.setNextReview(newNextReview);
	}

	public String carStatus(Car car) {

		DecimalFormat decimalFormat = new DecimalFormat("###,##0");
//		System.out.println(
//				"-------------------------------------------------------------------------------------------------------------------\n\nGasolina:"
//						+ decimalFormat.format(car.getGasLevel()) + " %\nKm atual: " + car.getCurrentKm()
//						+ " KM\nProxima revisao: " + car.getNextReview() + " KM\nOleo:"
//						+ decimalFormat.format(car.getOilLevel()) + " ML\nKm para proxima revisao: "
//						+ car.getRemainingKm() + " KM\nNivel da agua: " + decimalFormat.format(car.getWaterLevel())
//						+ " ML\n\n");
		return "-------------------------------------------------------------------------------------------------------------------\n\nGasolina:"
		+ decimalFormat.format(car.getGasLevel()) + " %\nKm atual: " + car.getCurrentKm()
		+ " KM\nProxima revisao: " + car.getNextReview() + " KM\nOleo:"
		+ decimalFormat.format(car.getOilLevel()) + " ML\nKm para proxima revisao: "
		+ car.getRemainingKm() + " KM\nNivel da agua: " + decimalFormat.format(car.getWaterLevel())
		+ " ML\n\n";

	}

	public String carTempStatus(int km, double routeRate) {

		DecimalFormat decimalFormat = new DecimalFormat("###,##0");
//		System.out.println("\nGastos Previstos:\n\n\nGasolina:" + decimalFormat.format(GasReduction(km, routeRate))
//				+ " %\nQuilometragem: " + NewKm(km, routeRate) + " KM\nProxima revisao: " + NewReview() + " KM\nOleo:"
//				+ decimalFormat.format(OilReduction(km, routeRate)) + " ML\nKm para proxima revisao: " + KmForReview(km)
//				+ " KM\nNivel da agua: " + decimalFormat.format(WaterReduction(km, routeRate)) + " ML\n\n");
		
		return "\nGastos Previstos:\n\n\nGasolina:" + decimalFormat.format(GasReduction(km, routeRate))
		+ " %\nQuilometragem: " + NewKm(km, routeRate) + " KM\nProxima revisao: " + NewReview() + " KM\nOleo:"
		+ decimalFormat.format(OilReduction(km, routeRate)) + " ML\nKm para proxima revisao: " + KmForReview(km)
		+ " KM\nNivel da agua: " + decimalFormat.format(WaterReduction(km, routeRate)) + " ML\n\n";

	}

}
