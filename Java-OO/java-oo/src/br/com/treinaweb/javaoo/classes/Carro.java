package br.com.treinaweb.javaoo.classes;

public class Carro extends VeiculoBase {

	private int quantidadedePortas;

	public int getQuantidadedePortas() {
		return quantidadedePortas;
	}

	public void setQuantidadedePortas(int quantidadedePortas) {
		this.quantidadedePortas = quantidadedePortas;
	}

	public Carro() {
		this.quantidadeRodas = 4;
	}

	public Carro(String nome, String marca) {
		this.quantidadeRodas = 4;
		this.setNome(nome);
		this.setMarca(marca);
	}

	@Override
	public void preparar() {
		System.out.println("Colocar o cinto de segurança");
		
	}

}
