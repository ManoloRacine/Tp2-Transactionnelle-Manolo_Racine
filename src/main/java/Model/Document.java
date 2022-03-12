package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class Document {
    @Id
    @GeneratedValue
    private long id ;
    private String name ;
    private String author ;
    private int releaseYear ;
    private boolean isBorrowed = false;

    @ManyToOne
    @JoinColumn(name = "library_id")
    @ToString.Exclude
    private Library library ;

}
