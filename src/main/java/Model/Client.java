package Model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@SuperBuilder
public class Client extends Account {
    private double totalLateFees ;

    @OneToMany
    @ToString.Exclude
    private List<Borrowing> borrowings ;

    public void payLateFees() {

    }

    public void returnDocument() {

    }

    public void borrowDocument(Borrowing borrowing) {
        borrowings.add(borrowing) ;
    }
}
