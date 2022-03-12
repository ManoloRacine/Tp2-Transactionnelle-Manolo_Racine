package Persistence;

import Model.Client;
import Model.Library;

public interface LibraryDao {
    <T> void save(T t) ;

    Library getLibrary(long id);

    Client getClient(long id);
}
