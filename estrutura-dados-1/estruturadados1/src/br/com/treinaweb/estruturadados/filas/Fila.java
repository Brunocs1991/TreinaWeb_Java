package br.com.treinaweb.estruturadados.filas;

import br.com.treinaweb.estruturadados.listasligadas.ListaLigada;

public class Fila<T> {
	private ListaLigada<T> elementos;

	public Fila() {
		this.elementos = new ListaLigada<T>();
	}

	public void enfileirar(T elemento) {
		this.elementos.inserir(elemento);

	}

	public T desenfileirar() {
		if (estaVazia()) {
			return null;
		}
		T resultado = this.elementos.recuperar(0);
		this.elementos.remover(0);
		return resultado;

	}

	public boolean estaVazia() {
		return this.elementos.estaVazia();

	}

	@Override
	public String toString() {
		return "Fila [" + elementos.toString() + "]";
	}

}
