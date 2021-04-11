package br.com.treinaweb.estruturadados.arvorebinaria;

import br.com.treinaweb.estruturadados.modelos.Pessoa;

public class NoArvorePessoa extends NoArvore<Pessoa> {
	public NoArvorePessoa(Pessoa valor) {
		super(valor);
	}

	@Override
	public int peso() {
		return this.valor.getId();
	}

}
