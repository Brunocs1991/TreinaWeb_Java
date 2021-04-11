package br.com.treinaweb.javacollections.comparadores;

import java.util.Comparator;

import br.com.treinaweb.javacollections.models.Pessoa;

public class PessoaTamanhoNomeComparator implements Comparator<Pessoa> {

	@Override
	public int compare(Pessoa o1, Pessoa o2) {
//		0 : o1 == o2
		if (o1.getNome().length() == o2.getNome().length()) {
			return 0;
		}
//		-1: o1 <  o2
		if (o1.getNome().length() < o2.getNome().length()) {
			return -1;
		}
//		1 : o1  > 02
		return 1;
	}

}
