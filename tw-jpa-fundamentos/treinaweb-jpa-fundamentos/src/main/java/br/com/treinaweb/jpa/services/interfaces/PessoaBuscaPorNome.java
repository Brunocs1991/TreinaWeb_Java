package br.com.treinaweb.jpa.services.interfaces;

import java.util.List;

import br.com.treinaweb.jpa.models.Pessoa;

public interface PessoaBuscaPorNome extends CrudService<Pessoa, Integer> {

	List<Pessoa> searchByName(String name);

}
