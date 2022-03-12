package Service;

import Model.Client;
import Model.Library;
import Persistence.LibraryDao;

public class AdminService {
    LibraryDao libraryDao ;

    public AdminService(LibraryDao libraryDao) {
        this.libraryDao = libraryDao ;
    }

    public long createClient(String firstName, String lastName, String password, long libraryId) {
        Client client = Client.builder().
                myLibrary(getLibrary(libraryId)).
                firstName(firstName).
                lastName(lastName)
                .password(password).build() ;
        libraryDao.save(client);
        return client.getId() ;
    }

    public long createLibrary() {
        Library library = new Library() ;
        libraryDao.save(library) ;
        return library.getId() ;
    }

    public Library getLibrary(long id) {
        return libraryDao.getLibrary(id) ;
    }

    public Library getLibraryWithDocuments(long id) {
        return libraryDao.getLibraryWithDocuments(id) ;
    }

    public Client getClient(long id) {
        return libraryDao.getClient(id) ;
    }
}
