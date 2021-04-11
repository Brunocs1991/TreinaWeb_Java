package br.com.treinaweb.estruturadados.mapas;

import br.com.treinaweb.estruturadados.listasligadas.ListaLigada;

public class Mapa<K, V> {
	private ListaLigada<ListaLigada<Associacao<K, V>>> elementos;
	private int quantidadeDeCategorias = 16;

	public Mapa() {
		this.elementos = new ListaLigada<ListaLigada<Associacao<K, V>>>();
		for (int i = 0; i < this.quantidadeDeCategorias; i++) {
			this.elementos.inserir(new ListaLigada<Associacao<K, V>>());

		}
	}

	public boolean contemChave(K chave) {
		int numeroEspalhamento = this.gerarNumeroEspalhamento(chave);
		ListaLigada<Associacao<K, V>> categoria = this.elementos.recuperar(numeroEspalhamento);
		for (int i = 0; i < categoria.tamanho(); i++) {
			Associacao<K, V> associacao = categoria.recuperar(i);
			if (associacao.getChave().equals(chave)) {
				return true;
			}

		}
		return false;
	}

	public void remover(K chave) {
		int numeroEspalhamento = this.gerarNumeroEspalhamento(chave);
		ListaLigada<Associacao<K, V>> categoria = this.elementos.recuperar(numeroEspalhamento);
		for (int i = 0; i < categoria.tamanho(); i++) {
			Associacao<K, V> associacao = categoria.recuperar(i);
			if (associacao.getChave().equals(chave)) {
				categoria.remover(associacao);
				return;
			}
		}
		throw new IllegalArgumentException(String.format("A chave a ser removida %s não existe", chave));
	}

	public void adicionar(K chave, V valor) {
		if (this.contemChave(chave)) {
			this.remover(chave);
		}
		int numeroEspalhamento = this.gerarNumeroEspalhamento(chave);
		ListaLigada<Associacao<K, V>> categoria = this.elementos.recuperar(numeroEspalhamento);
		categoria.inserir(new Associacao<K, V>(chave, valor));
	}

	public V recuperar(K chave) {
		int numeroEspalhamento = this.gerarNumeroEspalhamento(chave);
		ListaLigada<Associacao<K, V>> categoria = this.elementos.recuperar(numeroEspalhamento);
		for (int i = 0; i < categoria.tamanho(); i++) {
			Associacao<K, V> associacao = categoria.recuperar(i);
			if (associacao.getChave().equals(chave)) {
				return associacao.getValor();
			}
		}
		throw new IllegalArgumentException(String.format("A chave a ser recuperada %s não existe", chave));
	}

	@Override
	public String toString() {
		return "Mapa [elementos=" + elementos + "]";
	}

	private int gerarNumeroEspalhamento(K chave) {
		return Math.abs(chave.hashCode() % this.quantidadeDeCategorias);
	}

}
