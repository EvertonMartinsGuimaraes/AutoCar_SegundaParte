package br.edu.unibratec.autocar.view;

import java.util.Scanner;

import br.edu.unibratec.autocar.controller.PlaceController;
import br.edu.unibratec.autocar.model.Place;
import br.edu.unibratec.autocar.model.Place.ROUTE_TYPE;

public class VehicleFront {
	public static void main(String[] args) {
		int i = 0;
		int place = -1;
		int confirm = 0;
		int confirm2 = 0;
		Scanner input = new Scanner(System.in);
		
			// LIGA O CARRO MOSTRANDO NO PAINEL O STATUS DO CARRO E ADICIONANDO OS LUGARES AO ARRAY
		VehicleController V = new VehicleController();
		V.carStatus();
		PlaceController P = new PlaceController();
		P.addInitialPlaces();
		
			// LAÇO PARA O MENU CONTINUAR ENQUANTO OPÇÃO PLACE DIFERENTE DE 0 = SAIR
		for (; place != 0;) {
			i = 0;
			
			// FOREACH PARA VISUALIZAÇÃO DOS LUGARES INSERIDOS NO ARRAYLIST
			try {

				for (Place places : P.getPlacesList()) {
					i++;
					System.out.println(i + "- " + places.getName());
				}
				
			//INICIO DO MENU
				System.out.println(
						"\n\n\nOla cara, Qual local você quer ir? Digite o numero correspondente ao local. 0- SAIR");
				place = Integer.parseInt(input.next());
				
			//APOS PEGAR O LOCAL QUE O USUARIO QUER IR ELE PEGA O NOME, DISTANCIA E TAXA DA ROTA E VERIFICA CONDICOES.
					// SE POSSUIR GASOLINA SUFICIENTE EXECUTA O CODIGO
				if (place != 0 && V.carC.getCarModel().getGasLevel() > 25) {
					int placeDistance = P.getPlacesList().get(place - 1).getDistance();
					ROUTE_TYPE typeRoute = P.getPlacesList().get(place - 1).getRoute();
					String name = P.getPlacesList().get(place - 1).getName();

					System.out.println("Deseja realmente ir a " + name + "?  1-SIM / 2-NÂO");
					confirm = Integer.parseInt(input.next());
					if (confirm == 1) {

						V.tripStatus(name, placeDistance);
						V.setTrack(placeDistance, typeRoute);
						V.carStatus();

					} else {
						System.out.println(
								"\nViagem cancelada.\n\n-------------------------------------------------------------------------");
					}
					
						// CASO NAO TENHA GASOLINA SUFICIENTE ELE PERGUNTA SE QUER ABASTECER
				} else if (V.carC.getCarModel().getGasLevel() < 25) {
					System.out.println("Carro na reserva, Deseja abastecer? 1-SIM/2-NAO.\n");
					confirm2 = Integer.parseInt(input.next());
						
						// CASO ABASTEÇA ELE ENCHE NIVEIS DE AGUA E OLEO E MOSTRA NOVAMENTE O STATUS DO CARRO.
					if (confirm2 == 1) {
						V.carC.getCarModel().overhaul(100, 1000, 1000);
						V.carStatus();
					} else {
						place = 0;
						break;
					}
				}
				
			// TRATAMENTO DE ERROS
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Opção invalida. Numero não corresponde a nenhum lugar predefinido.\n\n");
			} catch (NumberFormatException e) {
				System.out.println("Opção invalida. Somente numeros.\n\n");
			}
		}
		
		//CASO OPÇÃO PLACE SEJA IGUAL A 0 = SAIR.
		System.out.println("Obrigado por utilizar o computador de bordo.");
		input.close();
	}
}
