package produtos_naturais;

import java.util.InputMismatchException;
import java.util.Scanner;

import produtos_naturais.controller.ProdutosController;
import produtos_naturais.model.Chas;
import produtos_naturais.model.Comidas;
import produtos_naturais.model.Produtos;
import produtos_naturais.util.Cores;

public class Menu {
	private static final Scanner leia = new Scanner(System.in);
	private static final ProdutosController produtoController = new ProdutosController();

	public static void main(String[] args) {

		int opcao;

		criarProdutosTeste();

		while (true) {

			System.out.println(
					Cores.TEXT_GREEN_BOLD + Cores.ANSI_WHITE_BACKGROUND + "-----------------------------------------");
			System.out.println("                Naturebices              ");
			System.out.println("           O melhor por você!            ");
			System.out.println("-----------------------------------------");
			System.out.println("                                         ");
			System.out.println("      1- Cadastrar produto               ");
			System.out.println("      2- Listar todos os produtos        ");
			System.out.println("      3- Buscar produto por id           ");
			System.out.println("      4- Atualizar dados do produto      ");
			System.out.println("      5- Apagar produto                  ");
			System.out.println("      6- Procurar produto por nome       ");
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
				System.out.println("Cadastrar um produto\n\n");

				cadastrarProduto();

				KeyPress();
				break;
			case 2:
				System.out.println("A listagem de produtos é:\n\n");

				listarProduros();

				KeyPress();
				break;
			case 3:
				System.out.println("Buscar produto por Id:\n\n");

				procurarProdutoPorId();

				KeyPress();
				break;
			case 4:
				System.out.println("Atualizar dados do produto\n\n");
				
				atualizarProduto();

				KeyPress();
				break;
			case 5:
				System.out.println("Apagar produto\n\n");
				
				deletarProduto();

				KeyPress();
				break;
			case 6:
				System.out.println("Encontrar produto por Nome:\n\n");
				
				procurarPorNome();

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
		produtoController.cadastrar(new Comidas ("Banana chips", produtoController.gerarId(), 1, 12.8f, "Banana, açúcar e canela."));
		produtoController.cadastrar(new Chas("Carqueja", produtoController.gerarId(), 2, 10.5f, "bom para dor!"));

	}

	private static void listarProduros() {
		produtoController.listarTodas();
	}

	private static void cadastrarProduto() { // para cadastrar produtos

		System.out.println("Digite o nome do Produto: ");
		String nome = leia.nextLine();

		System.out.println("Digite o tipo de produto (1- Comidas | 2- Chás): ");
		int categoria = leia.nextInt();

		System.out.println("Digite o valor do produto: ");
		float valor = leia.nextFloat();

		switch (categoria) {
		case 1 -> {
			System.out.println("Digite os ingredientes do produto: ");
			leia.skip("\\R");
			String ingredientes = leia.nextLine();
			produtoController.cadastrar(new Comidas(nome, produtoController.gerarId(), categoria, valor, ingredientes));
		}
		case 2 -> {
			System.out.println("Digite os beneficios do produto: ");
			leia.skip("\\R");
			String propriedades = leia.nextLine();
			produtoController.cadastrar(new Chas(nome, produtoController.gerarId(), categoria, valor, propriedades));
		}
		default -> System.out.println(Cores.TEXT_RED + "Tipo de produto inválido inválido" + Cores.TEXT_RESET);
		}
	}

	private static void procurarProdutoPorId() {  // para procurar o produto pelo id
		System.out.println("Digite o Id do produto: ");
		int id = leia.nextInt();
		leia.nextLine();

		produtoController.procurarPorId(id);
	}

	private static void atualizarProduto() { // para atualizar o produto atraves do id
		System.out.println("Digite o Id do produto: "); //produrar o produto
		int id = leia.nextInt();
		leia.nextLine();
		Produtos produto = produtoController.buscarNaCollection(id);

		if (produto != null) { //criar atualizações

			String nome = produto.getNome();
			int categoria = produto.getCategoria();
			float valor = produto.getValor();

			System.out.printf("O nome  atual é: %s%nNovo nome: (Precione ENTER para manter o nome atual)", nome);
			String entrada = leia.nextLine();
			nome = entrada.isEmpty() ? nome : entrada;

			System.out.printf("Digite o preço atual é: %.2f%nNovo preço (Precione ENTER para manter o preço)", valor);
			entrada = leia.nextLine();
			valor = entrada.isEmpty() ? valor : Float.parseFloat(entrada);

			switch (categoria) {
			case 1 -> {
				String ingredientes = ((Comidas) produto).getIngredientes();
				System.out.printf(
						"Os ingredientes atuais são: %s%nDigite os novos ingredeintes: (Precione ENTER para manter os ingredientes atuais)",
						ingredientes);
				entrada = leia.nextLine();
				ingredientes = entrada.isEmpty() ? ingredientes : entrada;
				produtoController.atualizar(new Comidas(nome, id, categoria, valor, ingredientes));
			}
			case 2 -> {
				String propriedades = ((Chas) produto).getPropriedades();
				System.out.printf(
						"Os beneficios atuais são: %s%nDigite os novos beneficios: (Precione ENTER para manter os beneficios atuais)",
						propriedades);
				entrada = leia.nextLine();
				propriedades = entrada.isEmpty() ? propriedades : entrada;
				produtoController.atualizar(new Chas(nome, id, categoria, valor, propriedades));
			}
			default -> System.out.println(Cores.TEXT_RED + "Categoria inválida" + Cores.TEXT_RESET);
			}

		} else {
			System.out.printf("\nId do produto %d não encontrado!", id);
		}
	}
	private static void deletarProduto() { // para excluir o produto pelo numero de id
		System.out.println("Digite o id do produto: ");
		int id = leia.nextInt();
		leia.nextLine();
		Produtos produto = produtoController.buscarNaCollection(id);
		if (produto != null) {

			System.out.print("\nTem certeza que deseja excluir este produto? (S/N): ");
			String confirmacao = leia.nextLine();

			if (confirmacao.equalsIgnoreCase("S")) {
				produtoController.deletar(id);
			} else {
				System.out.println("\nOperação cancelada!"); 
			}
		} else { 
			System.out.printf("\nO Id do produto %d não foi encontrado!", id);
		}
	}
	private static void procurarPorNome() { // aqui pode ser fiderente do nome abaixo, importante que esse será usado no menu
		System.out.println("Digite oo nome do produto: ");
		String nome = leia.nextLine();
		produtoController.ProcurarPorNomes(nome);
	}

}
