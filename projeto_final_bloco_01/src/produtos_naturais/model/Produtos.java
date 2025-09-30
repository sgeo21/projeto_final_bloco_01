package produtos_naturais.model;

public abstract class Produtos {
	
	private String nome;
	private int id;
	private int categoria;
	private float valor;
	
	
	public Produtos(String nome, int id, int categoria, float valor) {
		super();
		this.nome = nome;
		this.id = id;
		this.categoria = categoria;
		this.valor = valor;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getCategoria() {
		return categoria;
	}


	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}


	public float getValor() {
		return valor;
	}


	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public void visualizar() {
        String categoria = " ";
			
			switch(this.categoria) {
			case 1 -> categoria = "Comidas";
			case 2 -> categoria = "Chás";
			default -> categoria = "Produto Desconhecido";
			
			}
			
			System.out.printf("\n*********************");
			System.out.printf("Dados do produto");
			System.out.printf("*********************\n");
			System.out.printf("Nome do produto: %s%n", this.nome);
			System.out.printf("Número da Agencia: %d%n", this.id);
			System.out.printf("Nome da titular: %s%n", this.categoria);
			System.out.printf("Saldo da conta: %.2f%n", this.valor);
			
		

			}
	
}
