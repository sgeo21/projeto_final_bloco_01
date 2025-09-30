package produtos_naturais.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import produtos_naturais.model.Produtos;
import produtos_naturais.repository.ProdutosRepository;

public class ProdutosController implements ProdutosRepository {
	private List<Produtos> listaProdutos = new ArrayList<Produtos>();
	int id = 0;

	@Override
	public void listarTodas() {
		for (var produtos : listaProdutos) {
			produtos.visualizar();
		}

	}

	@Override
	public void cadastrar(Produtos produto) {
		listaProdutos.add(produto);
		System.out.println("\n🎉Produto cadastrado com sucesso!");

	}

	@Override
	public void atualizar(Produtos Produto) { // metodo atualizar dados produto
		var buscarProduto = buscarNaCollection(Produto.getId());
		if (buscarProduto != null) {
			listaProdutos.set(listaProdutos.indexOf(buscarProduto), Produto);
			System.out.printf("\nO produto com Id  %d foi atualizado com sucesso!%n", Produto.getId());
		} else {
			System.out.printf("\nO produto com Id %d não foi encontrado!%n", Produto.getId());
		}
	}

	@Override
	public void procurarPorId(int id) { // metodo para procurar Id em uso
		var produto = buscarNaCollection(id);
		if (produto != null) {
			produto.visualizar();
		} else {
			System.out.printf("\nO produto com Id: %d não foi encontrado!%n", id);
		}

	}

	@Override
	public void deletar(int id) { // método para deletar o produto através do id
		var produto = buscarNaCollection(id); 
		if(produto!= null) {
			   if(listaProdutos.remove(produto)  == true) {
				   System.out.printf("\nO produto com id %d foi deletado com sucesso!%n", id);
			   }
		}else {
			System.out.printf("\nO id do produto: %d não foi encontrado!%n", id);
			}
	}
	@Override
	public void ProcurarPorNomes (String nome) {
		List<Produtos> listaNomes =listaProdutos.stream()
				.filter(c -> c.getNome().toUpperCase().contains(nome.toUpperCase()))
				.collect(Collectors.toList());
		if (listaNomes.isEmpty()) {
			System.out.printf("\nNenhum produto foi encontrado com este nome: %s\n", nome);
		}
		for(var produto : listaNomes) {
			produto.visualizar();
		}
		
	}
	
	// Métodos auxiliares

	public int gerarId() { //metodo para gerar a Id automaticamente
		return ++id;
	}

	public Produtos buscarNaCollection(int id) { // método para procurar produto por dados (ID)
		for (var produtos : listaProdutos) {
			if (produtos.getId() == id) {
				return produtos;
			}
		}
		return null;
	}

	
}
