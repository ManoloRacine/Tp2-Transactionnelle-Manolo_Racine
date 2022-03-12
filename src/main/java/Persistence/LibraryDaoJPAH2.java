package Persistence;

import Model.Client;
import Model.Library;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
    public <T> void merge(T t) {
        EntityManager em = emf.createEntityManager() ;
        em.getTransaction().begin();

        em.merge(t);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Library getLibrary(long id) {
        return getObjectFromDatabase(id, Library.class) ;
    }

    @Override
    public Library getLibraryWithDocuments(long id) {
        EntityManager em = emf.createEntityManager() ;
        em.getTransaction().begin();

        Library library = queryFetchLibraryWithDocuments(id, em) ;

        em.getTransaction().commit();
        em.close();

        return library ;
    }

    private Library queryFetchLibraryWithDocuments(long id, EntityManager em) {
        final TypedQuery<Library> query = em.createQuery(
                "select l from Library l left join fetch l.documents ld where l.id = :libraryId",
                Library.class
        ) ;

        query.setParameter("libraryId", id) ;

        return query.getSingleResult() ;
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
