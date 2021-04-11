package br.com.treinaweb.javaoo.interfaces;

import br.com.treinaweb.javaoo.excecoes.AbastecimentoVeiculoLigadoException;

public interface Veiculo {

	void abastecer(float litros) throws AbastecimentoVeiculoLigadoException;

	void preparar();
}
