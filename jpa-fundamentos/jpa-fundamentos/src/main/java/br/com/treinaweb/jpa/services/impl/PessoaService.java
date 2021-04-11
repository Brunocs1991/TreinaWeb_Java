package br.com.treinaweb.jpa.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.treinaweb.jpa.models.Pessoa;
import br.com.treinaweb.jpa.services.interfaces.CrudService;
import br.com.treinaweb.jpa.utils.JpaUtils;

public class PessoaService implements CrudService<Pessoa, Integer> {

	@Override
	public List<Pessoa> all() {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		EntityManager em = null;
		try {
			em = JpaUtils.getEntityManager();
			pessoas = em.createQuery("from Pessoa", Pessoa.class).getResultList();
			return pessoas;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public Pessoa byId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pessoa insert(Pessoa entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pessoa update(Pessoa entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Pessoa entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteByID(Integer id) {
		// TODO Auto-generated method stub

	}

}
