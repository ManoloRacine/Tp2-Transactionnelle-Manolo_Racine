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

    @OneToOne
    @PrimaryKeyJoinColumn
    private Document borrowedDocument ;

    @ManyToOne
    @PrimaryKeyJoinColumn
    @ToString.Exclude
    private Client client ;
}
