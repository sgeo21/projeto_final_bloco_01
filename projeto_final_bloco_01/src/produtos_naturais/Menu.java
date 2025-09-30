package produtos_naturais;

import java.util.InputMismatchException;
import java.util.Scanner;

import produtos_naturais.model.Chas;
import produtos_naturais.model.Comidas;
import produtos_naturais.model.Produtos;
import produtos_naturais.util.Cores;

public class Menu {
	private static final Scanner leia = new Scanner(System.in);
    //private static final ProdutoController produtoController = new ProdutoController();
	public static void main(String[] args) {
		
		int opcao;
		
		criarProdutosTeste();
		
		
		while (true) {

			System.out.println(Cores.TEXT_GREEN_BOLD + Cores.ANSI_WHITE_BACKGROUND + 
					           "-----------------------------------------");
			System.out.println("                Naturebices              ");
			System.out.println("           O melhor por você!            ");
			System.out.println("-----------------------------------------");
			System.out.println("                                         ");
			System.out.println("      1- Cadastrar produto               ");
			System.out.println("      2- Listar todos os produtos        ");
			System.out.println("      3- Buscar produto por id           ");
			System.out.println("      4- Atualizar dados do produto      ");
			System.out.println("      5- Apagar produto                  ");
			System.out.println("      0- Sair                            ");
			System.out.println("-----------------------------------------");
			System.out.println(" Selecione a opção desejada:             ");

			try {
				opcao = leia.nextInt();
				leia.nextLine();
			} catch (InputMismatchException e) {
				opcao = -1;
				System.out.println("Digite um número entre 0 e 5");
				leia.nextLine();
			}

			if (opcao == 0) {
				System.out.println("A naturebices agradece a preferencia! ");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Cadastrar um prduto\n\n");
			
				KeyPress();
				break;
			case 2:
				System.out.println("A listagem de produtos é:\n\n");
				

				KeyPress();
				break;
			case 3:
				System.out.println("Buscar conta por Id:\n\n");


				KeyPress();
				break;
			case 4:
				System.out.println("Atualizar dados do produto\n\n");
				
				
				KeyPress();
				break;
			case 5:
				System.out.println("Apagar produto\n\n");


				KeyPress();
				break;
			default:
				System.out.println("Opção invalida!");
				KeyPress();
				break;
			}
		}
	}


	public static void sobre() {
		System.out.println(Cores.TEXT_GREEN_BOLD + Cores.ANSI_WHITE_BACKGROUND + "*********************************");
		System.out.println("Projeto desenvolvido por:        ");
		System.out.println("Geovana Cazali da Silva          ");
		System.out.println("*********************************");
	}

	public static void KeyPress() {
		System.out.println(Cores.TEXT_RESET + "\n Pressione enter para continuar...");
		leia.nextLine();
	}
	private static void criarProdutosTeste() {
		Produtos c1 = new Comidas("Banana chips", 1, 1, 12.8f , "Banana, açúcar e canela.");
		c1.visualizar();
		Produtos C1 = new Chas("Carqueja", 1, 2, 10.5f , "bom para dor!");
		C1.visualizar();
		
	}
	
	
}
	