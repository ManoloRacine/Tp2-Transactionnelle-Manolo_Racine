package Model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Borrowing {
    @Id
    @GeneratedValue
    private long id ;
    private LocalDateTime locationDate ;
    private LocalDateTime returnDate ;

    @ManyToOne
    @PrimaryKeyJoinColumn
    private Document borrowedDocument ;

    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @ToString.Exclude
    private Client client ;
}
