package Service;

import Model.*;
import Persistence.LibraryDao;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class ClientService {

    LibraryDao libraryDao ;

    public ClientService(LibraryDao libraryDao) {
        this.libraryDao = libraryDao ;
    }

    public List<Document> researchDocumentByTitle(String title, long libraryId) {
        Library library = libraryDao.getLibraryWithDocuments(libraryId) ;
        List<Document> documentsWithTitle = library.researchDocumentsByTitle(title) ;
        return documentsWithTitle ;
    }

    public List<Document> researchDocumentByAuthor(String author, long libraryId) {
        Library library = libraryDao.getLibraryWithDocuments(libraryId) ;
        List<Document> documentsWithAuthor = library.researchDocumentsByAuthor(author) ;
        return documentsWithAuthor ;
    }

    public List<Document> researchDocumentByYear(int year, long libraryId) {
        Library library = libraryDao.getLibraryWithDocuments(libraryId) ;
        List<Document> documentsByYear = library.researchDocumentsByYear(year) ;
        return documentsByYear ;
    }

    public List<Book> researchBooksByCategory(String genre, long libraryId) {
        Library library = libraryDao.getLibraryWithDocuments(libraryId) ;
        List<Book> documentsByGenre = library.researchBooksByCategory(genre) ;
        return documentsByGenre ;
    }

    public void borrowDocument(long clientId, long documentId) {
        Client client = libraryDao.getClientWithLibrary(clientId) ;
        Document documentToBorrow = client.getMyLibrary().getDocumentById(documentId);

        if (documentToBorrow == null) {
            throw new IllegalArgumentException() ;
        }

        Borrowing borrowing = Borrowing.builder().borrowedDocument(documentToBorrow).
                locationDate(LocalDateTime.now()).
                returnDate(LocalDateTime.now().plus(getAmountOfWeeks(documentToBorrow), ChronoUnit.WEEKS))
                .borrowedDocument(documentToBorrow).build() ;

        client = libraryDao.getClientWithBorrowings(clientId) ;
        client.getBorrowings().add(borrowing) ;
        documentToBorrow.setBorrowed(true);
        borrowing.setClient(client);

        libraryDao.merge(documentToBorrow);
        libraryDao.merge(client);
        libraryDao.save(borrowing);
    }

    private int getAmountOfWeeks(Document document) {
        int nbOfWeeksForRental ;

        if (document instanceof Book) {
            nbOfWeeksForRental = 3 ;
        }
        else if (document instanceof CD) {
            nbOfWeeksForRental = 2 ;
        }
        else {
            nbOfWeeksForRental = 1 ;
        }

        return nbOfWeeksForRental ;
    }

    public List<Borrowing> getListOfBorrowings(long clientId) {
        Client client = libraryDao.getClientWithBorrowings(clientId) ;
        return client.getBorrowings() ;
    }
}
