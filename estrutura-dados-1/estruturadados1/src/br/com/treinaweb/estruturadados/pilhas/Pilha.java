package br.com.treinaweb.estruturadados.pilhas;

import br.com.treinaweb.estruturadados.listasligadas.ListaDuplamenteLigada;

public class Pilha<T> {
	private ListaDuplamenteLigada<T> elementos;

	public Pilha() {
		this.elementos = new ListaDuplamenteLigada<T>();
	}

	public boolean estaVazia() {
		return this.elementos.estaVazia();
	}

	public void empilhar(T elemento) {
		this.elementos.inserir(elemento);

	}

	public T desempilhar() {
		if (estaVazia()) {
			return null;
		}
		T resultado = this.elementos.recuperar(this.elementos.tamanho() - 1);
		this.elementos.remover(this.elementos.tamanho() - 1);
		return resultado;
	}

}
