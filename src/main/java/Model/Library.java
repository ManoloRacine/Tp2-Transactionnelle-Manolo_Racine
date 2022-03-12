package Model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

    @OneToMany(mappedBy = "library")
    private List<Document> documents = new ArrayList<>();

}
