package george.tads.testlibrarybookspringwebrest.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Accessors(chain = true)
@Table(name = "ibns")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ibns {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    //adicionar edição do livro

    @Column(name = "publisher")
    private String publisher;

}