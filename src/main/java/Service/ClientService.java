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
        List<Document> documentsWithTitle = library.researchDocumentByTitle(title) ;
        return documentsWithTitle ;
    }

    public List<Document> researchDocumentByAuthor(String author, long libraryId) {
        Library library = libraryDao.getLibraryWithDocuments(libraryId) ;
        List<Document> documentsWithAuthor = library.researchDocumentByAuthor(author) ;
        return documentsWithAuthor ;
    }
}
