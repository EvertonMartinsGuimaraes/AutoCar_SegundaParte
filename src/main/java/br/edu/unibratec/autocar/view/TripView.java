package br.edu.unibratec.autocar.view;

import java.text.DecimalFormat;
import java.util.Scanner;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;

import br.edu.unibratec.autocar.facade.AutoCarFacade;
import br.edu.unibratec.autocar.interfaces.ICarModel;
import br.edu.unibratec.autocar.model.Car;
import br.edu.unibratec.autocar.model.Place;
import br.edu.unibratec.autocar.model.Place.ROUTE_TYPE;
import br.edu.unibratec.autocar.view.TripView;

public class TripView {
	int menu = 1;
	int i;
	private static TripView tripInstance;

	Scanner input = new Scanner(System.in);
	DecimalFormat decimalFormat = new DecimalFormat("###,##0");
	AutoCarFacade facade = AutoCarFacade.getInstancia();
	ICarModel carModel = facade.getCarModel();

	public static TripView getInstance() {
		if (tripInstance == null) {
			tripInstance = new TripView();

		}
		return tripInstance;
	}

	// MOSTRA O STATUS DA VIAGEM FEITA
	public void tripStatus(int id) {

		System.out.println("\n\nViagem feita para: " + facade.selectPlace(id).getName() + " / Distancia percorrida: "
				+ facade.selectPlace(id).getDistance()
				+ "KM\n\n--------------------------------------------------------------------------------------------------------------------");
	}

	// LAÇO PARA O MENU CONTINUAR ENQUANTO OPÇÃO PLACE DIFERENTE DE 0 = SAIR
	public void generalMenu() {
		int place = -1;

		// INSERINDO O PRIMEIRO CARRO PADRAO NO BANCO.
		Car carro = (Car) carModel;
		carro.setPlace(facade.selectPlace(0));
		facade.insertCar(carro);
		// MOSTRANDO NO PAINEL O STATUS DO CARRO
		facade.carStatus();

		for (; place != 0;) {
			try {
				System.out.println("\n\n\n\n\n\nO que deseja fazer? 1 - Rota / 2 - Destinos / 3- Historico ");
				menu = Integer.parseInt(input.next());
				switch (menu) {
				case 1:
					routeMenu(place);
					break;
				case 2:
					destinationsMenu();
					break;
				case 3:
					historyMenu();
					break;
				default:
					System.out.println("Digite um valor correspondente ao menu.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Opção invalida. Somente numeros.\n\n");
			} catch (EntityNotFoundException e) {
				System.out.println("Digite um ID valido.");
			}
		}

	}

	// METODO PARA MENU DE ROTA
	public void routeMenu(int place) {
		i = 0;
		int rota = -1;

		for (; rota != 0;) {
			System.out.println("\n\n\n--------------------------MENU DE ROTAS ------------------------------\n\n\n");
			try {
				// FOREACH PARA VISUALIZAÇÃO DOS LUGARES INSERIDOS NO BANCO
				System.out.println("\n\nLISTA DE LUGARES:\n\n");
				for (Place places : facade.getPlacesList()) {
					if (places.getId() != 0) {
						if (places.getRoute() == ROUTE_TYPE.ROADWAY) {
							System.out.println(places.getId() + "- " + places.getName()
									+ " -  Trecho: Rodovia  -  Distancia: " + places.getDistance() + "KM");
						} else {
							System.out.println(places.getId() + "- " + places.getName()
									+ " -  Trecho: Urbano  -  Distancia: " + places.getDistance() + "KM");
						}
					}
				}
				// INICIO DO MENU DE ROTAS
				System.out.println(
						"\n\n\nOlá, como está hoje? Qual local você quer ir? Digite o numero correspondente ao local. 0 - SAIR");
				rota = Integer.parseInt(input.next());

				// METODO DE CONFIRMAÇÃO DE ROTA - TRIPCONTROLLER -
				if (rota != 0)
					routeConfirmation(rota);

				// TRATAMENTO DE ERROS
			} catch (NullPointerException e) {
				System.out.println("Opção invalida. Numero não corresponde a nenhum lugar predefinido.\n\n");
			} catch (NumberFormatException e) {
				System.out.println("Opção invalida. Somente numeros.\n\n");
			} catch (EntityNotFoundException e) {
				System.out.println("Digite um ID valido.");
			}
		}
	}

	// METODO PARA MENU DE HISTORICO
	public void historyMenu() {
		int history = -1;
		for (; history != 0;) {
			try {
				System.out.println(
						"\n\n\n--------------------------MENU DE HISTORICO ------------------------------\n\n\n");
				System.out.println(
						"O que deseja fazer? \n1- Listar todo historico de rotas feitas.\n2- Excluir um historico pelo ID.\n0 - SAIR");
				history = Integer.parseInt(input.next());
				switch (history) {
				case 0:
					break;
				case 1:

					// FOR EACH COM TODAS AS ROTAS FEITAS
					System.out.println("\n\nHistorico de rotas:\n");
					System.out.println(
							"     ID      |   GASOLINA   |  KM APOS VIAGEM  | NIVEL DE OLEO |  NIVEL DE AGUA  |        DATA E HORA            | LOCAL DA ROTA   ");
					for (Car car : facade.getAllCar()) {
						if (car.getId() != 1) {
							System.out.println("      " + (car.getId() - 1) + "      |     "
									+ decimalFormat.format(car.getGasLevel()) + "%      |       " + car.getCurrentKm()
									+ "KM      |    " + decimalFormat.format(car.getOilLevel()) + "ML      |      "
									+ decimalFormat.format(car.getWaterLevel()) + "ML      |   "
									+car.getData()+"     |"+ car.getPlace().getName());
						}
					}
					break;
				case 2:
					System.out.println("Qual ID da rota que deseja excluir do sistema?");
					int id = Integer.parseInt(input.next());
					facade.deleteCar(id + 1);
					break;
				default:
					System.out.println("Digite um valor corrrespondente ao menu.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Digite um valor correspondente ao menu.");
			} catch (EntityNotFoundException e) {
				System.out.println("Digite um ID valido.");
			}
		}
	}

	// METODO PARA MENU DE DESTINOS
	public void destinationsMenu() {
		int destination = -1;

		for (; destination != 0;) {
			try {
				System.out.println(
						"\n\n\n--------------------------MENU DE DESTINOS ------------------------------\n\n\n");
				System.out.println(
						"O que deseja fazer? \n1- Adicionar um novo destino.\n2- Excluir um destino pelo numero de ID.\n3- Lista de destinos. \n0 - SAIR");
				destination = Integer.parseInt(input.next());
				switch (destination) {
				case 0:
					break;
				case 1:
					System.out.println("Digite um nome para o destino.");
					String name = input.next();
					int routeConfirm = (int) (1 + (Math.random() * 2));
					facade.insertNewPlace(routeConfirm, name);
					break;
				// TODO
				case 2:
					System.out.println("Qual lugar pelo id você deseja excluir?");
					int id = Integer.parseInt(input.next());
					if (id != 0) {
						facade.deletePlace(id);
						System.out.println("Lugar deletado com sucesso.");
					} else
						System.out.println("Digite um ID valido.");
					break;
				case 3:
					// FOREACH PARA VISUALIZAÇÃO DOS LUGARES INSERIDOS NO BANCO
					System.out.println("\n\nLISTA DE LUGARES:\n\n");
					for (Place places : facade.getPlacesList()) {
						if (places.getId() != 0) {
							if (places.getRoute() == ROUTE_TYPE.ROADWAY) {
								System.out.println(places.getId() + "- " + places.getName()
										+ "-  Trecho: Rodovia  -  Distancia: " + places.getDistance() + "KM");
							} else {
								System.out.println(places.getId() + "- " + places.getName()
										+ "-  Trecho: Urbano  -  Distancia: " + places.getDistance() + "KM");
							}
						}
					}
					break;

				default:
					System.out.println("Digite um valor corrrespondente ao menu.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Digite um valor correspondente ao menu.");
			} catch (EntityNotFoundException e) {
				System.out.println("Digite um ID valido.");
			}catch (PersistenceException e) {
				System.out.println("Nao é possivel deletar um lugar ja visitado antes de deleta-lo em seu historico.");
			}
		}
	}

	// APOS PEGAR O LOCAL QUE O USUARIO QUER IR ELE PEGA O NOME, DISTANCIA E TAXA DA
	// ROTA E VERIFICA CONDICOES.
	// SE POSSUIR GASOLINA SUFICIENTE EXECUTA O CODIGO
	public void routeConfirmation(int place) {
		int confirm = 0;
		int confirm2 = 0;
		try {
			if (place != 0 && carModel.getGasLevel() > 25) {

				System.out
						.println("Deseja realmente ir a " + facade.selectPlace(place).getName() + "?  1-SIM / 2-NÂO\n");

				// CHAMA METODO DE CALCULO E STATUS DE UMA POSSIVEL CORRIDA
				facade.calcTrack(facade.selectPlace(place).getDistance(), facade.selectPlace(place).getRoute());

				confirm = Integer.parseInt(input.next());
				if (confirm == 1) {
					// CASO CONFIRMADO ELE SETA OS VALORES E EXIBE O STATUS DO CARRO ALTERADO.
					tripStatus(place);
					facade.setTrack(facade.selectPlace(place));
					facade.carStatus();
				} else {
					System.out.println(
							"\nViagem cancelada.\n\n-------------------------------------------------------------------------");

				}

				// CASO NAO TENHA GASOLINA SUFICIENTE ELE PERGUNTA SE QUER ABASTECER
			} else if (carModel.getGasLevel() < 25) {
				System.out.println("Carro na reserva, Deseja abastecer? 1-SIM/2-NAO.\n");
				confirm2 = Integer.parseInt(input.next());

				// CASO ABASTEÇA ELE ENCHE NIVEIS DE AGUA E OLEO E MOSTRA NOVAMENTE O STATUS DO
				// CARRO.
				if (confirm2 == 1) {
					facade.fuel();
					facade.carStatus();
				} else {
					place = 0;
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("Digite um valor correspondente ao menu.");
		} catch (EntityNotFoundException e) {
			System.out.println("Digite um ID valido.");
		}
	}
}
