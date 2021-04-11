package br.com.treinaweb.estruturadados.conjuntos;

import br.com.treinaweb.estruturadados.espalhamento.TabelaEspalhamento;

public class Conjunto<T> {
	private TabelaEspalhamento<T> elementos;

	public Conjunto() {
		this.elementos = new TabelaEspalhamento<T>();
	}

	public boolean inserir(T elemento) {
		return this.elementos.inserir(elemento);
	}

	public boolean estaVazio() {
		return this.elementos.tamanho() == 0;
	}

	public int tamanho() {
		return this.elementos.tamanho();
	}

	public boolean contem(T elemento) {
		return this.elementos.contem(elemento);
	}

	public void remover(T elemento) {
		this.elementos.remover(elemento);
	}

//	private boolean contemOtimizado(T elemento) {
//		for (int i = 0; i < this.elementos.tamanho(); i++) {
//			T el = this.elementos.recuperar(i);
//			if (el.hashCode() == elemento.hashCode()) {
//				return true;
//			}
//		}
//		return false;
//	}

	@Override
	public String toString() {
		return "Conjunto [elementos=" + elementos + "]";
	}

}
