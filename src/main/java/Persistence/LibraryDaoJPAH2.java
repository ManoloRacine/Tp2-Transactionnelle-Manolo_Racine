package Persistence;

import Model.Client;
import Model.Library;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LibraryDaoJPAH2 implements LibraryDao{
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Manolo_tp2.ex1") ;

    @Override
    public <T> void save(T t) {
        EntityManager em = emf.createEntityManager() ;
        em.getTransaction().begin();

        em.persist(t);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Library getLibrary(long id) {
        return getObjectFromDatabase(id, Library.class) ;
    }

    @Override
    public Client getClient(long id) {
        return getObjectFromDatabase(id, Client.class) ;
    }

    private <T> T getObjectFromDatabase(long id, Class<T> objectClass) {
        EntityManager em = emf.createEntityManager() ;
        em.getTransaction().begin();

        T object = em.find(objectClass, id) ;

        em.getTransaction().commit();
        em.close();

        return object ;
    }
}
