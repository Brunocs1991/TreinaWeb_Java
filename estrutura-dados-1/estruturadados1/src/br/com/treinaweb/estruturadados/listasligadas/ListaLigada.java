package br.com.treinaweb.estruturadados.listasligadas;

public class ListaLigada<T> {

	private No<T> primeiroNo;
	private No<T> ultimoNo;
	private int tamanho;

	public ListaLigada() {
		this.primeiroNo = null;
		this.ultimoNo = null;
		this.tamanho = 0;
	}

	public void inserir(T elemento) {
		No<T> novoNo = new No<T>(elemento);
		if (estaVazia()) {
			this.primeiroNo = novoNo;
			this.ultimoNo = novoNo;
		} else {
			this.ultimoNo.setProximo(novoNo);
			this.ultimoNo = novoNo;
		}
		this.tamanho++;
	}

	public void inserirEm(int posicao, T elemento) {
		if (posicao >= tamanho()) {
			throw new IllegalArgumentException(String.format("Posição Inválida [%d]", posicao));
		}
		if (posicao == 0) {
			No<T> novoNo = new No<>(elemento);
			novoNo.setProximo(this.primeiroNo);
			this.primeiroNo = novoNo;

		} else if (posicao == this.tamanho() - 1) {
			No<T> novoNo = new No<>(elemento);
			this.ultimoNo.setProximo(novoNo);
			this.ultimoNo = novoNo;
		} else {

			No<T> noAnterior = recuperarNo(posicao - 1);
			No<T> noAtual = recuperarNo(posicao);
			No<T> novoNo = new No<>(elemento);
			noAnterior.setProximo(novoNo);
			novoNo.setProximo(noAtual);
		}
		this.tamanho++;
	}

	public void inserirPrimeiro(T elemento) {
		inserirEm(0, elemento);
	}

	public void inserirUltimo(T elemento) {
		inserirEm(tamanho - 1, elemento);
	}

	public T recuperar(int posicao) {
		No<T> no = recuperarNo(posicao);
		if (no != null) {
			return no.getElemento();
		}
		return null;

	}

	public boolean estaVazia() {
		return this.tamanho == 0;
	}

	public int tamanho() {
		return this.tamanho;
	}

	public boolean contem(T elemento) {
		for (int i = 0; i < tamanho(); i++) {
			No<T> noAtual = recuperarNo(i);
			if (noAtual.getElemento() != null && noAtual.getElemento().equals(elemento)) {
				return true;
			}
		}
		return false;

	}

	public int indice(T elemento) {
		for (int i = 0; i < tamanho(); i++) {
			No<T> noAtual = recuperarNo(i);
			if (noAtual.getElemento() != null && noAtual.getElemento().equals(elemento)) {
				return i;
			}

		}
		return -1;
	}

	public void remover(int posicao) {
		if (posicao >= tamanho()) {
			throw new IllegalArgumentException(String.format("Posição Inválida [%d]", posicao));
		}
		if (posicao == 0) {
			No<T> proximoNo = this.primeiroNo.getProximo();
			this.primeiroNo.setProximo(null);
			this.primeiroNo = proximoNo;

		} else if (posicao == tamanho() - 1) {
			No<T> penultimoNo = recuperarNo(tamanho() - 2);
			penultimoNo.setProximo(null);
			this.ultimoNo = penultimoNo;
		} else {
			No<T> noAnterior = recuperarNo(posicao - 1);
			No<T> proximoNo = recuperarNo(posicao + 1);
			No<T> noAtual = recuperarNo(posicao);
			noAnterior.setProximo(proximoNo);
			noAtual.setProximo(null);
		}
		tamanho--;
	}

	public void remover(T elemento) {
		int indice = indice(elemento);
		if (indice == -1) {
			throw new IllegalArgumentException("Elemento Inválido - " + elemento.toString());
		}
		remover(indice);
	}

	private No<T> recuperarNo(int posicao) {
		if (posicao >= tamanho()) {
			throw new IllegalArgumentException(String.format("Posição Inválida [%d]", posicao));
		}
		No<T> resultado = null;
		for (int i = 0; i <= posicao; i++) {
			if (i == 0) {
				resultado = this.primeiroNo;
			} else {
				resultado = resultado.getProximo();
			}
		}
		return resultado;

	}

	@Override
	public String toString() {
		if (estaVazia()) {
			return "lista[]";
		} else {
			No<T> noAtual = this.primeiroNo;
			StringBuilder sb = new StringBuilder();
			sb.append("Lista[");
			sb.append(noAtual.getElemento() != null ? noAtual.getElemento().toString() : "<NULO>");
			sb.append(",");
			while (noAtual.getProximo() != null) {
				sb.append(noAtual.getProximo().getElemento() != null ? noAtual.getProximo().getElemento().toString()
						: "<NULO>");
				sb.append(",");
				noAtual = noAtual.getProximo();
			}
			sb.append("]");
			return sb.toString();
		}
	}

}
