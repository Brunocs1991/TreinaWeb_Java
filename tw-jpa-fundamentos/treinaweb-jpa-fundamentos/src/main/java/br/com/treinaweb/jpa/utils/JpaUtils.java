package br.com.treinaweb.jpa.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {
	
	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = null;
	
	public static EntityManager getEntityManager() {
		if (ENTITY_MANAGER_FACTORY == null) {
			ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("treinaweb-jpa-fundamentos");			
		}
		return ENTITY_MANAGER_FACTORY.createEntityManager();
	}

}
