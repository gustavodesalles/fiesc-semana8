package bfinal;

import bfinal.enums.Arma;
import bfinal.enums.Motivacao;
import bfinal.inimigos.*;
import bfinal.jogadores.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BatalhaFinal {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Jogador jogador;
		Arma arma = null;
		String nome, sexo;
		int opcaoClasse = 0, opcaoArma, opcao = 0;
		boolean repetir = true;

		System.out.println("Seja bem vindo(a) à BATALHA FINAL!");

		do {
			System.out.println("Digite o nome de seu personagem: ");
			nome = input.nextLine();
		} while (nome.isBlank() || nome.isEmpty());


		do {
			System.out.println("Digite o gênero de seu personagem (m/f): ");
			sexo = input.nextLine();
		} while (!sexo.equals("m") && !sexo.equals("f"));


		do {
			try {
				System.out.println("Escolha a classe de seu personagem: ");
				System.out.println("1 - Guerreiro");
				System.out.println("2 - Paladino");
				System.out.println("3 - Arqueiro");
				System.out.println("4 - Mago");
				opcaoClasse = input.nextInt();
				if (opcaoClasse > 4 || opcaoClasse < 1) {
					System.out.println("Opção inválida.");
				} else {
					repetir = false;
				}
			} catch (InputMismatchException i) {
				System.out.println("Favor digitar um número inteiro.");
			}
		} while (repetir);


		repetir = true;
		do {
			try {
				System.out.println("Escolha a arma do personagem: ");
				switch (opcaoClasse) {
					case 1:
						System.out.println("1 - Espada");
						System.out.println("2 - Machado");
						opcaoArma = input.nextInt();
						if (opcaoArma > 2 || opcaoArma < 1) {
							System.out.println("Opção inválida.");
						}
						switch (opcaoArma) {
							case 1:
								arma = Arma.ESPADA;
								repetir = false;
								break;
							case 2:
								arma = Arma.MACHADO;
								repetir = false;
								break;
						}
						break;
					case 2:
						System.out.println("1 - Martelo");
						System.out.println("2 - Clava");
						opcaoArma = input.nextInt();
						if (opcaoArma > 2 || opcaoArma < 1) {
							System.out.println("Opção inválida.");
						}
						switch (opcaoArma) {
							case 1:
								arma = Arma.MARTELO;
								repetir = false;
								break;
							case 2:
								arma = Arma.CLAVA;
								repetir = false;
								break;
						}
						break;
					case 3:
						System.out.println("1 - Arco");
						System.out.println("2 - Besta");
						opcaoArma = input.nextInt();
						if (opcaoArma > 2 || opcaoArma < 1) {
							System.out.println("Opção inválida.");
						}
						switch (opcaoArma) {
							case 1:
								arma = Arma.ARCO;
								repetir = false;
								break;
							case 2:
								arma = Arma.BESTA;
								repetir = false;
								break;
						}
						break;
					case 4:
						System.out.println("1 - Cajado");
						System.out.println("2 - Livro de magias");
						opcaoArma = input.nextInt();
						if (opcaoArma > 2 || opcaoArma < 1) {
							System.out.println("Opção inválida.");
						}
						switch (opcaoArma) {
							case 1:
								arma = Arma.CAJADO;
								repetir = false;
								break;
							case 2:
								arma = Arma.LIVRO_DE_MAGIAS;
								repetir = false;
								break;
						}
						break;
				}
			} catch (InputMismatchException i) {
				System.out.println("Favor digitar um número inteiro.");
			}
		} while (repetir);

		switch (opcaoClasse) {
			case 1:
				jogador = new Guerreiro(nome, sexo, Motivacao.NENHUMA, arma);
				break;
			case 2:
				jogador = new Paladino(nome, sexo, Motivacao.NENHUMA, arma);
				break;
			case 3:
				jogador = new Arqueiro(nome, sexo, Motivacao.NENHUMA, arma);
				break;
			case 4:
				jogador = new Mago(nome, sexo, Motivacao.NENHUMA, arma);
				break;
			default:
				throw new IllegalStateException("Unexpected value: " + opcaoClasse);
		}
		System.out.println("A noite se aproxima, a lua já surge no céu, estrelas vão se acendendo,\n"
				+ "e sob a luz do crepúsculo você está prestes a entrar na fase final da sua missão.\n"
				+ "Você olha para o portal à sua frente, e sabe que a partir desse ponto, sua vida mudará para sempre.");
		
		System.out.println("Memórias do caminho percorrido para chegar até aqui invadem sua mente.\n"
				+ "Você se lembra de todos os inimigos já derrotados para alcançar o covil do líder maligno.\n"
				+ "Olha para seu equipamento de combate, já danificado e desgastado depois de tantas lutas.\n"
				+ "Você está a um passo de encerrar para sempre esse mal.");
		
		System.out.println("Buscando uma injeção de ânimo, você se força a lembrar o que te trouxe até aqui.");

		repetir = true;

		do {
			try {
				input.nextLine();
				System.out.println("Qual é a sua motivação? Vingança ou glória?");
				System.out.println("1 - Vingança");
				System.out.println("2 - Glória");
				opcao = input.nextInt();

				if (opcao > 2 || opcao < 1) {
					System.out.println("Opção inválida.");
				} else {
					repetir = false;
				}

				switch (opcao) {
					case 1:
						jogador.setMotivacao(Motivacao.VINGANCA);
						repetir = false;
						break;

					case 2:
						jogador.setMotivacao(Motivacao.GLORIA);
						repetir = false;
						break;
				}

			} catch (InputMismatchException i) {
				System.out.println("Fale a verdade.");
			}
		} while (repetir);

		if (jogador.getMotivacao() == Motivacao.VINGANCA) {
			System.out.println("Imagens daquela noite trágica invadem sua mente.\n"
					+ "Você nem precisa se esforçar para lembrar, pois essas memórias estão sempre presentes,\n"
					+ "mesmo que de pano de fundo, quando você tem outros pensamentos em foco, elas nunca o deixaram.\n"
					+ "Elas são o combustível que te fizeram chegar até aqui.\n"
					+ "E você sabe que não irá desistir até ter vingado a morte\n"
					+ "daqueles que foram - e pra sempre serão - sua fonte de amor e desejo de continuar vivo.\n"
					+ "O maldito líder finalmente pagará por tanto mal causado na vida de tantos\n"
					+ "(e principalmente na sua).");
		} else {
			System.out.println("Você já consegue visualizar na sua mente o povo da cidade te recebendo de braços abertos,\n"
					+ "bardos criando canções sobre seus feitos heróicos, nobres te presenteando com jóias e diversas riquezas,\n"
					+ "taberneiros se recusando a cobrar por suas bebedeiras e comilanças.\n"
					+ "Desde já, você sente o amor do público, te louvando a cada passo que dá pelas ruas,\n"
					+ "depois de destruir o vilão que tanto assombrou a paz de todos.\n"
					+ "Porém, você sabe que ainda falta o último ato dessa história.\n"
					+ "Você se concentra na missão.\n"
					+ "A glória o aguarda, mas não antes da última batalha.");
		}
		
		System.out.println("Inspirado pelo motivo que te trouxe até aqui, você sente seu coração ardendo em chamas,\n"
				+ "suas mãos formigarem em volta da sua arma. Você a segura com firmeza. Seu foco está renovado.\n"
				+ "Você avança pelo portal.");
		
		System.out.println("A escuridão te envolve. Uma iluminação muito fraca entra pelo portal às suas costas.\n"
				+ "À sua frente, só é possível perceber que você se encontra em um corredor extenso.\n"
				+ "Você só pode ir à frente, ou desistir.");

		repetir = true;
		do {
			try {
				System.out.println("O que você faz?");
				System.out.println("1 - Segue em frente");
				System.out.println("2 - Desiste");
				opcao = input.nextInt();
				if (opcao > 2 || opcao < 1) {
					System.out.println("Opção inválida.");
				} else {
					repetir = false;
				}
			} catch (InputMismatchException i) {
				System.out.println("Responda!");
			}
		} while (repetir);

		if (opcao == 2) {
			System.out.println("O medo invade o seu coração e você sente que ainda não está à altura do desafio.\n"
					+ "Você se volta para a noite lá fora, e corre em direção à segurança.");
			System.exit(0);
		}
		
		System.out.println("Você caminha, atento a todos os seus sentidos, por vários metros,\n"
					+ "até visualizar a frente uma fonte de luz, que você imagina ser a chama de uma tocha,\n"
					+ "vindo de dentro de uma porta aberta.");
		
		System.out.println("Você se pergunta se dentro dessa sala pode haver inimigos, ou alguma armadilha,\n"
				+ "e pondera sobre como passar pela porta.");
		// TODO: perguntar ao jogador se deseja passar pela porta ANDANDO CUIDADOSAMENTE, CORRENDO ou SALTANDO.
		repetir = true;

		do {
			try {
				System.out.println("Como você deseja passar pela porta?");
				System.out.println("1 - Andando cuidadosamente");
				System.out.println("2 - Correndo");
				System.out.println("3 - Saltando");

				opcao = input.nextInt();
				if (opcao > 3 || opcao < 1) {
					System.out.println("Opção inválida.");
				} else {
					repetir = false;
				}

			} catch (InputMismatchException i) {
				System.out.println("Responda!");
			}
		} while (repetir);

		switch (opcao) {
			case 3:
				System.out.println("Você se concentra e pula em direção à luz, saltando de antes da porta até o interior da sala.");
				break;
			case 2:
				System.out.println("Você respira fundo e desata a correr em direção à sala.\n"
						+ "Quando passa pela porta, sente que pisou em uma pedra solta,\n"
						+ "mas não dá muita importância e segue para dentro da sala, olhando ao redor à procura de inimigos.\n"
						+ "Não tem ninguém, mas você ouve sons de flechas batendo na pedra atrás de você,\n"
						+ "e quando se vira, vê várias flechas no chão.\n"
						+ "Espiando pela porta, você entende que pisou em uma armadilha que soltou flechas de uma escotilha aberta no teto,\n"
						+ "mas por sorte você entrou correndo e conseguiu escapar desse ataque surpresa.");
				break;
			case 1:
				System.out.println("Você toma cuidado e vai caminhando vagarosamente em direção à luz.\n"
						+ "Quando você pisa exatamente embaixo da porta, você sente o chão ceder levemente, como se tivesse pisado em uma pedra solta.\n"
						+ "Você ouve um ruído de mecanismos se movimentando, e uma escotilha se abre no teto atrás de você, no corredor.\n"
						+ "Flechas voam da escotilha em sua direção, e você salta para dentro da sala, porém uma delas te acerta na perna.");
				Armadilha armadilha = new Armadilha();
				armadilha.atacar(jogador);
		}

		System.out.println("Você se encontra sozinho em uma sala quadrada, contendo uma porta em cada parede.\n"
				+ "Uma delas foi aquela pela qual você entrou, que estava aberta, e as outras três estão fechadas.\n"
				+ "A porta à sua frente é a maior das quatro, com inscrições em seu entorno em uma língua que você não sabe ler,\n"
				+ "mas reconhece como sendo a língua antiga utilizada pelo inimigo.\n"
				+ "Você se aproxima da porta e percebe que ela está trancada por duas fechaduras douradas,\n"
				+ "e você entende que precisará primeiro derrotar o que estiver nas outras duas portas laterais,\n"
				+ "antes de conseguir enfrentar o líder.");
		
		System.out.println("Você se dirige para a porta à direita.");
		
		System.out.println("Você se aproxima, tentando ouvir o que acontece porta adentro, mas não escuta nada.\n"
				+ "Segura com mais força sua arma com uma mão, enquanto empurra a porta com a outra.\n"
				+ "Ao entrar, você se depara com uma sala espaçosa,\n"
				+ "com vários equipamentos de batalha pendurados nas paredes e dispostos em armários e mesas.\n"
				+ "Você imagina que este seja o arsenal do inimigo, onde estão guardados os equipamentos que seus soldados\n"
				+ "utilizam quando saem para espalhar o terror nas cidades e vilas da região.\n"
				+ "Enquanto seu olhar percorre a sala, você ouve a porta se fechando e gira rapidamente para olhar para trás.\n"
				+ "Ali, de pé entre você e a porta fechada, bloqueando o caminho do seu destino, está um dos capitães do inimigo.\n"
				+ "Um orque horrendo, de armadura, capacete e espada em punho, em posição de combate.\n"
				+ "Ele avança em sua direção.");

		Armeiro armeiro = new Armeiro();
		// TODO: iniciar loop de combate, inimigo ataca primeiro
		combate(jogador, armeiro, false);
		
		System.out.println("Após derrotar o Armeiro, você percebe que seus equipamentos estão muito danificados.\n"
				+ "Olha em volta, encarando todas aquelas peças de armaduras resistentes e em ótimo estado.");

		repetir = true;
		do {
			try {
				System.out.println("Você deseja pegar as armaduras novas?");
				System.out.println("1 - Sim");
				System.out.println("2 - Não");
				opcao = input.nextInt();
				if (opcao > 2 || opcao < 1) {
					System.out.println("Opção inválida.");
				} else {
					repetir = false;
				}
			} catch (InputMismatchException i) {
				System.out.println("Responda!");
			}
		} while (repetir);

		switch (opcao) {
			case 1:
				System.out.println("Você resolve usar os equipamentos do inimigo contra ele, e trocar algumas peças suas,\n"
						+ "que estavam danificadas, pelas peças de armaduras existentes na sala.\n"
						+ "De armadura nova, você se sente mais protegido para os desafios à sua frente.");
				jogador.setPontosDef(jogador.getPontosDef() + 5);
				break;

			case 2:
				System.out.println("Você decide que não precisa utilizar nada que venha das mãos do inimigo.");
				break;
		}

		System.out.println("Em uma mesa, você encontra uma chave dourada, e sabe que aquela chave abre uma das fechaduras da porta do líder inimigo.\n"
				+ "Você pega a chave e guarda numa pequena bolsa que leva presa ao cinto.");
		
		System.out.println("Você retorna à sala anterior e se dirige à porta da esquerda.\n"
				+ "Você se aproxima, tentando ouvir o que acontece porta adentro, mas não escuta nada.\n"
				+ "Segura com mais força sua arma com uma mão, enquanto empurra a porta com a outra.\n"
				+ "Ao entrar, você se depara com uma sala parecida com a do arsenal, mas em vez de armaduras,\n"
				+ "existem vários potes e garrafas de vidro com conteúdos misteriosos e de cores diversas,\n"
				+ "e você entende que o capitão que vive ali, realiza experimentos com diversos ingredientes,\n"
				+ "criando poções utilizadas pelos soldados para aterrorizar a região.");
		System.out.println("No fundo da sala, olhando em sua direção, está outro dos capitães do inimigo.\n"
				+ "Um orque horrendo, de armadura, cajado em punho, em posição de combate. Ele avança em sua direção.");

		Alquimista alquimista = new Alquimista();
		// TODO: iniciar loop de combate, inimigo ataca primeiro
		combate(jogador, alquimista, false);
		
		System.out.println("Após derrotar o Alquimista, você olha em volta, tentando reconhecer alguma poção do estoque do inimigo.\n"
				+ "Em uma mesa, você reconhece uma pequena garrafa de vidro contendo um líquido levemente rosado,\n"
				+ "pega a garrafa e pondera se deve beber um gole.");
		// TODO: perguntar ao jogador se ele quer ou não beber.
		repetir = true;
		do {
			try {
				System.out.println("Você deseja beber?");
				System.out.println("1 - Sim");
				System.out.println("2 - Não");
				opcao = input.nextInt();
				if (opcao > 2 || opcao < 1) {
					System.out.println("Opção inválida.");
				} else {
					repetir = false;
				}
			} catch (InputMismatchException i) {
				System.out.println("Responda!");
			}
		} while (repetir);

		switch (opcao) {
			case 1:
				System.out.println("Você se sente revigorado para seguir adiante!");
				jogador.setPontosSaude(jogador.getSaudeMaxima());
				break;
			case 2:
				System.out.println("Você fica receoso de beber algo produzido pelo inimigo.");
				break;
		}

		System.out.println("Ao lado da porta, você vê uma chave dourada em cima de uma mesa,\n"
				+ "e sabe que aquela chave abre a outra fechadura da porta do líder inimigo.\n"
				+ "Você pega a chave e guarda na pequena bolsa que leva presa ao cinto.");
		
		System.out.println("De volta à sala das portas, você se dirige à porta final.\n"
				+ "Coloca as chaves nas fechaduras, e a porta se abre.\n"
				+ "Seu coração acelera, memórias de toda a sua vida passam pela sua mente,\n"
				+ "e você percebe que está muito próximo do seu objetivo final.\n"
				+ "Segura sua arma com mais firmeza, foca no combate que você sabe que irá se seguir, e adentra a porta.");
		
		System.out.println("Lá dentro, você vê o líder sentado em uma poltrona dourada, com duas fogueiras de cada lado, e prisioneiros acorrentados às paredes.");
		
		System.out.println("Ele percebe sua chegada e se levanta com um salto, apanhando seu machado de guerra de lâmina dupla.");

		Lider lider = new Lider();
		repetir = true;
		do {
			try {
				System.out.println("Você ataca ou espera?");
				System.out.println("1 - Atacar");
				System.out.println("2 - Esperar");
				opcao = input.nextInt();
				if (opcao > 2 || opcao < 1) {
					System.out.println("Opção inválida.");
				} else {
					repetir = false;
				}
			} catch (InputMismatchException i) {
				System.out.println("Responda!");
			}
		} while (repetir);
		// TODO: iniciar loop de combate, dependendo da resposta do jogador, ele ataca primeiro
		switch (opcao) {
			case 1:
				combate(jogador, lider, true);
			case 2:
				combate(jogador, lider, false);
		}
		
		System.out.println("Você conseguiu!");
		// TODO: exibir mensagem de vitória de acordo com a motivação do jogador:
		if (jogador.getMotivacao() == Motivacao.VINGANCA) {
			System.out.println("Você obteve sua vingança. Você se ajoelha e cai no choro, invadido por uma sensação de alívio e felicidade.\n"
					+ "Você se vingou, tudo que sempre quis, está feito. Agora você pode seguir sua vida.");
		} else {
			System.out.println("O êxtase em que você se encontra não cabe dentro de si. Você se ajoelha e grita de alegria.\n"
					+ "A glória o aguarda, você a conquistou.");
		}
		
		System.out.println("Você se levanta, olha para os prisioneiros, vai de um em um e os liberta,\n"
				+ "e todos vocês saem em direção à noite, retornando à cidade.\n"
				+ "Seu dever está cumprido.");
	}
	
	private static void combate(Jogador jogador, Inimigo inimigo, boolean prioridadeJogador) {
		Scanner input = new Scanner(System.in);
		int opcao = 0;

		if (prioridadeJogador) {
			jogador.atacar(inimigo);
			prioridadeJogador = false;
		}
		while (inimigo.getPontosSaude() > 0) {
			inimigo.atacar(jogador);

			if (jogador.getPontosSaude() <= 0) {
				System.out.println("Você não estava preparado para a força do inimigo.");
				if (jogador.getMotivacao() == Motivacao.VINGANCA) {
					System.out.println("Não foi possível concluir sua vingança, e agora resta saber se alguém se vingará por você.");
				} else {
					if (jogador.getSexo().equals("m")) {
						System.out.println("A glória que buscavas não será sua, e a cidade aguarda por seu próximo herói.");
					} else {
						System.out.println("A glória que buscavas não será sua, e a cidade aguarda por sua próxima heroína.");
					}
				}
				System.exit(0);
			}

//			while (jogador.getPontosSaude() > 0) {
				boolean repetir = true;
				do {
					try {
						System.out.println("Você ataca ou foge?");
						System.out.println("1 - Atacar");
						System.out.println("2 - Fugir");
						opcao = input.nextInt();
						if (opcao > 2 || opcao < 1) {
							System.out.println("Opção inválida.");
						} else {
							repetir = false;
						}
					} catch (InputMismatchException i) {
						System.out.println("Favor digitar 1 ou 2.");
					}
				} while (repetir);

				switch (opcao) {
					case 1:
						jogador.atacar(inimigo);
						break;
					case 2:
						System.out.println("Você não estava preparado para a força do inimigo,\n"
								+ "e decide fugir para que possa tentar novamente em uma próxima vez.");
						break;
					default:
						throw new IllegalStateException("Unexpected value: " + opcao);
//				}

			}
		}

		System.out.println("O inimigo não é páreo para o seu heroísmo, e jaz imóvel aos seus pés.");

	}

}
