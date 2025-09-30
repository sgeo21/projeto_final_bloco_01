package produtos_naturais.model;

public class Comidas extends Produtos {

	private String ingredientes;

	public Comidas(String nome, int id, int categoria, float valor, String ingredientes) {
		super(nome, id, categoria, valor);
		this.ingredientes = ingredientes;

	}

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.printf("Beneficios do chá: %s%n", this.ingredientes);
	}

}
