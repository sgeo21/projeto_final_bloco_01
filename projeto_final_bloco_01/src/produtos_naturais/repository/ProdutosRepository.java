package produtos_naturais.repository;

import produtos_naturais.model.Produtos;

public interface ProdutosRepository {
	
	public void listarTodas(); //1
	public void cadastrar(Produtos produto); //2
	public void atualizar(Produtos Produto); //4
	public void procurarPorId (int id); //4
	public void deletar(int id); //5
	
	
}
