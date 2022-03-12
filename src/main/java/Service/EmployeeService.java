package Service;

import Model.Book;
import Model.Library;
import Persistence.LibraryDao;

public class EmployeeService {
    LibraryDao libraryDao ;

    public EmployeeService(LibraryDao libraryDao) {
        this.libraryDao = libraryDao ;
    }

    public void addBookToLibrary(String name, String author, int releaseYear, int nbOfPages, String genre, long libraryId) {
        Book book = Book.builder().
                name(name).
                author(author).
                releaseYear(releaseYear).
                nbOfPages(nbOfPages).
                genre(genre).
                library(libraryDao.getLibraryWithDocuments(libraryId)).
                build() ;

        book.getLibrary().getDocuments().add(book) ;
        libraryDao.merge(book.getLibrary());
    }
}
