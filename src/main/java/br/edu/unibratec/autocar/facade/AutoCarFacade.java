package br.edu.unibratec.autocar.facade;

import java.util.List;

import br.edu.unibratec.autocar.controller.CarController;
import br.edu.unibratec.autocar.controller.PlaceController;
import br.edu.unibratec.autocar.interfaces.ICarModel;
import br.edu.unibratec.autocar.model.Place;

public class AutoCarFacade {

	private AutoCarFacade autoCarFacade;
	private CarController carControl;
	private PlaceController placeControl;
	
	public AutoCarFacade() {
		// TODO Auto-generated constructor stub
		if(this.autoCarFacade == null) {
			this.autoCarFacade = new AutoCarFacade();
			this.carControl = new CarController();
			this.placeControl = new PlaceController();
		}
	}
	
	public void addCar(ICarModel car) {
		
	}
	
	public ICarModel getCar() {
		return null;
		
	}
	
	public void deleteCar() {
		
	}
	
	public void addPlace(Place place) {
		
	}
	
	public void updatePlace(Place place) {
		
	}
	
	public void deletePlace(int idPlace) {
		
	}
	
	public List<Place> getAllPlaces(){
		return null;
	}
}
