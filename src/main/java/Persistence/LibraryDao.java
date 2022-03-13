package Persistence;

import Model.Client;
import Model.Library;

import javax.persistence.EntityManager;

public interface LibraryDao {
    <T> void save(T t) ;

    <T> void merge(T t) ;

    Library getLibrary(long id);

    Library getLibraryWithDocuments(long id) ;

    Client getClient(long id);

    Client getClientWithLibrary(long clientId);

    Client getClientWithBorrowings(long clientId) ;
}
