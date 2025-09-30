package produtos_naturais.model;

public class Chas extends Produtos {

	private String propriedades;

	public Chas(String nome, int id, int categoria, float valor, String propriedades) {
		super(nome, id, categoria, valor);
		this.propriedades = propriedades;

	}

	public String getPropriedades() {
		return propriedades;
	}

	public void setPropriedades(String propriedades) {
		this.propriedades = propriedades;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.printf("Beneficios do chá: %s%n", this.propriedades);
	}

}
