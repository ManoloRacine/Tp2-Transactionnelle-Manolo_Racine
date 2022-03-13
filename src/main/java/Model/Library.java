package Model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Library {
    @Id
    @GeneratedValue
    private long id ;

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL)
    private List<Document> documents = new ArrayList<>();

    public List<Document> researchDocumentsByTitle(String title) {
        List<Document> documentsByTitle = new ArrayList<>() ;

        for (Document document : documents) {

            if (document.getName().contains(title)) {
                documentsByTitle.add(document) ;
            }
        }

        return documentsByTitle ;
    }

    public List<Document> researchDocumentsByAuthor(String author) {
        List<Document> documentsByAuthor = new ArrayList<>() ;

        for (Document document : documents) {

            if (document.getAuthor().equals(author)) {
                documentsByAuthor.add(document) ;
            }
        }

        return documentsByAuthor ;
    }

    public List<Document> researchDocumentsByYear(int year) {
        List<Document> documentsByYear = new ArrayList<>() ;

        for (Document document : documents) {

            if (document.getReleaseYear() == year) {
                documentsByYear.add(document) ;
            }
        }

        return documentsByYear ;
    }

    public List<Book> researchBooksByCategory(String genre) {
        List<Book> booksByCategory = new ArrayList<>() ;

        for (Document document : documents) {

            if (document instanceof Book) {

                Book book = (Book) document ;

                if (book.getCategory().equals(genre)) {
                    booksByCategory.add(book) ;
                }
            }
        }

        return booksByCategory ;
    }
}
