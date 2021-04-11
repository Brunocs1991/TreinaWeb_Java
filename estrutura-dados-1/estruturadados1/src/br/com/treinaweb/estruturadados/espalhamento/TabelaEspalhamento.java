package br.com.treinaweb.estruturadados.espalhamento;

import br.com.treinaweb.estruturadados.listasligadas.ListaLigada;

public class TabelaEspalhamento<T> {
	private ListaLigada<ListaLigada<T>> elementos;
	private int numeroCategorias = 16;
	private int tamanho;

	public TabelaEspalhamento() {
		this.elementos = new ListaLigada<ListaLigada<T>>();
		for (int i = 0; i < this.numeroCategorias; i++) {
			this.elementos.inserir(new ListaLigada<T>());
		}
		this.tamanho = 0;
	}

	public boolean inserir(T elemento) {
		if (elemento == null && this.contem(elemento)) {
			return false;
		}
		int numeroEspalhamento = this.gerarNumeroEspalhamento(elemento);
		ListaLigada<T> categoria = this.elementos.recuperar(numeroEspalhamento);
		categoria.inserir(elemento);
		this.tamanho++;
		return true;

	}

	public void remover(T elemento) {
		int numeroEspalhamento = this.gerarNumeroEspalhamento(elemento);
		ListaLigada<T> categoria = this.elementos.recuperar(numeroEspalhamento);
		categoria.remover(elemento);
		this.tamanho--;

	}

	public int tamanho() {
		return this.tamanho;
	}

	public boolean contem(T elemento) {
		int nummeroEspalhamenoto = this.gerarNumeroEspalhamento(elemento);
		ListaLigada<T> categoria = this.elementos.recuperar(nummeroEspalhamenoto);
		return categoria.contem(elemento);
	}

	private int gerarNumeroEspalhamento(T elemento) {
		return Math.abs(elemento.hashCode() % this.numeroCategorias);
	}

	@Override
	public String toString() {
		return "TabelaEspalhamento [elementos=" + elementos + "]";
	}

}
