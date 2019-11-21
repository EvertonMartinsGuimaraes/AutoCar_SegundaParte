package br.edu.unibratec.autocar.model;

import java.util.Date;
import java.text.DecimalFormat;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private double oilLevel;
	private double waterLevel;
	private int currentKm;
	private int remainingKm;
	private int nextReview;
	private double gasLevel;
	Date data;
	@ManyToOne
	private Place place;

	public Car() {

	}

	public Car(double oilLevel, double waterLevel, int currentKm, int remainingKm, double gasLevel) {
		this.data = (Date) Calendar.getInstance().getTime();
		this.oilLevel = oilLevel;
		this.waterLevel = waterLevel;
		this.currentKm = currentKm;
		this.remainingKm = remainingKm;
		this.gasLevel = gasLevel;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getOilLevel() {
		return oilLevel;
	}

	public void setOilLevel(double oilLevel) {
		this.oilLevel = oilLevel;
	}

	public double getWaterLevel() {
		return waterLevel;
	}

	public void setWaterLevel(double waterLevel) {
		this.waterLevel = waterLevel;
	}

	public int getCurrentKm() {
		return currentKm;
	}

	public void setCurrentKm(int currentKm) {
		this.currentKm = currentKm;
	}

	public int getRemainingKm() {
		return remainingKm;
	}

	public void setRemainingKm(int remainingKm) {
		this.remainingKm = remainingKm;
	}

	public double getGasLevel() {
		return gasLevel;
	}

	public void setGasLevel(double gasLevel) {
		this.gasLevel = gasLevel;
	}

	public int getNextReview() {
		return nextReview;
	}

	public void setNextReview(int nextReview) {
		this.nextReview = nextReview;
	}

	public String carStatus() {
		DecimalFormat decimalFormat = new DecimalFormat("###,##0");
//		System.out.println("-------------------------------------------------------------------------------------------------------------------\n\nGasolina:"
//				+ decimalFormat.format(car.getGasLevel()) + " %\nKm atual: " + car.getCurrentKm()
//				+ " KM\nProxima revisao: " + car.getNextReview() + " KM\nOleo:"
//				+ decimalFormat.format(car.getOilLevel()) + " ML\nKm para proxima revisao: " + car.getRemainingKm()
//				+ " KM\nNivel da agua: " + decimalFormat.format(car.getWaterLevel()) + " ML\n\n");
		
		return "-------------------------------------------------------------------------------------------------------------------\n\nGasolina:"
		+ decimalFormat.format(this.getGasLevel()) + " %\nKm atual: " + this.getCurrentKm()
		+ " KM\nProxima revisao: " + this.getNextReview() + " KM\nOleo:"
		+ decimalFormat.format(this.getOilLevel()) + " ML\nKm para proxima revisao: " + this.getRemainingKm()
		+ " KM\nNivel da agua: " + decimalFormat.format(this.getWaterLevel()) + " ML\n\n";
		
	}
}
