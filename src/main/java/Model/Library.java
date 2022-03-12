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

}
