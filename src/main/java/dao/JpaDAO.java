package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class JpaDAO<E> {
    private static final EntityManagerFactory entityManagerFactory;
    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            entityManagerFactory = Persistence.createEntityManagerFactory("StorePhone");
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public JpaDAO() {

    }

    public E create(E entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(entity);
        entityManager.flush();
        entityManager.refresh(entity);

        entityManager.getTransaction().commit();
        entityManager.close();

        return entity;
    }

    public E update(E entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entity = entityManager.merge(entity);

        entityManager.getTransaction().commit();
        entityManager.close();

        return entity;
    }

    public E find(Class<E> type, Object id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        E entity = entityManager.find(type, id);

        if (entity != null) {
            entityManager.refresh(entity);
        }
        entityManager.close();

        return entity;
    }

    public void delete(Class<E> type, Object id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Object reference = entityManager.getReference(type, id);
        entityManager.remove(reference);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<E> findWithNamedQuery(String queryName) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createNamedQuery(queryName);
        List<E> result = query.getResultList();

        entityManager.close();

        return result;
    }
    public long countWithNamedQuery(String queryName) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery(queryName);

        long result = (long) query.getSingleResult();
        entityManager.close();

        return result;
    }
}