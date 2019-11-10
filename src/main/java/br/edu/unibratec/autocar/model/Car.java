package br.edu.unibratec.autocar.model;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)	
@DiscriminatorColumn(name="carModel", length=1, discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("C")
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
	@Column(insertable=false, updatable=false)
	private char carModel;
	
	private double oilReductionRate, waterReductionRate, gasConsumptionRate;
	private int eachReviewKm;

	public Car() {

	}
	
	public Car(double oilLevel, double waterLevel, int currentKm, int remainingKm, double gasLevel, char carModel) {
		this.oilLevel = oilLevel;
		this.waterLevel = waterLevel;
		this.currentKm = currentKm;
		this.remainingKm = remainingKm;
		this.gasLevel = gasLevel;
		this.carModel = carModel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public char getCarModel() {
		return carModel;
	}

	public void setCarModel(char carModel) {
		this.carModel = carModel;
	}

	public double getOilReductionRate() {
		return oilReductionRate;
	}

	public void setOilReductionRate(double oilReductionRate) {
		this.oilReductionRate = oilReductionRate;
	}

	public double getWaterReductionRate() {
		return waterReductionRate;
	}

	public void setWaterReductionRate(double waterReductionRate) {
		this.waterReductionRate = waterReductionRate;
	}

	public double getGasConsumptionRate() {
		return gasConsumptionRate;
	}

	public void setGasConsumptionRate(double gasConsumptionRate) {
		this.gasConsumptionRate = gasConsumptionRate;
	}

	public int getEachReviewKm() {
		return eachReviewKm;
	}

	public void setEachReviewKm(int eachReviewKm) {
		this.eachReviewKm = eachReviewKm;
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

}
