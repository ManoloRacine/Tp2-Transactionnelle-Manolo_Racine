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

    public List<Document> researchDocumentByTitle(String title) {
        List<Document> documentsByTitle = new ArrayList<>() ;

        for (Document document : documents) {

            if (document.getName().contains(title)) {
                documentsByTitle.add(document) ;
            }

        }

        return documentsByTitle ;
    }

}
