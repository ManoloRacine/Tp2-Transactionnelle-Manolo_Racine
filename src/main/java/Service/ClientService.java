package Service;

import Model.Document;
import Model.Library;
import Persistence.LibraryDao;

import java.util.List;

public class ClientService {

    LibraryDao libraryDao ;

    public ClientService(LibraryDao libraryDao) {
        this.libraryDao = libraryDao ;
    }

    public List<Document> researchDocumentByTitle(String title, long libraryId) {
        Library library = libraryDao.getLibraryWithDocuments(libraryId) ;
        return library.researchDocumentByTitle(title) ;
    }
}
