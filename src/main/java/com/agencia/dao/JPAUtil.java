package com.agencia.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Classe utilitária responsável por criar e fornecer o EntityManager,
 * que é o objeto que a JPA usa para conversar com o banco de dados.
 */
public class JPAUtil {

    private static final String PERSISTENCE_UNIT = "agenciaPU";
    private static EntityManagerFactory factory;

    static {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
    }

    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    public static void close() {
        if (factory != null && factory.isOpen()) {
            factory.close();
        }
    }
}
