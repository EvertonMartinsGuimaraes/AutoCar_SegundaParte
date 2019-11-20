package br.edu.unibratec.autocar.view;

import java.util.Scanner;

public class VehicleFront {
	public static void main(String[] args) throws InterruptedException {

		Scanner input = new Scanner(System.in);
		TripView tripInstance = TripView.getInstance();
		Imagens.getInstance().firstImage();
		Thread.sleep(4000);
		for (int i = 0; i < 200; ++i)
			System.out.println();
		Imagens.getInstance().secondImage();
		Thread.sleep(4000);
		for (int i = 0; i < 200; ++i)
			System.out.println();
		// LAÇO PARA O MENU - TRIPCONTROLLER -
		tripInstance.generalMenu();

		// CASO OPÇÃO PLACE SEJA IGUAL A 0 = SAIR.
		System.out.println("Obrigado por utilizar o computador de bordo.");
		input.close();

	}
}