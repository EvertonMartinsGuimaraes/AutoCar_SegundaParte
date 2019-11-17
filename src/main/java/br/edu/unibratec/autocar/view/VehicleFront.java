package br.edu.unibratec.autocar.view;

import java.util.Scanner;

import br.edu.unibratec.autocar.controller.*;

public class VehicleFront {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		TripView tripInstance = TripView.getInstance();
		PlaceController placeInstance = PlaceController.getInstance();

		// ADICIONANDO OS LUGARES AO ARRAY -TRIPCONTROLLER-
		placeInstance.addInitialPlaces();

		// LAÇO PARA O MENU - TRIPCONTROLLER -
		tripInstance.generalMenu();

		// CASO OPÇÃO PLACE SEJA IGUAL A 0 = SAIR.
		System.out.println("Obrigado por utilizar o computador de bordo.");
		input.close();

	}
}