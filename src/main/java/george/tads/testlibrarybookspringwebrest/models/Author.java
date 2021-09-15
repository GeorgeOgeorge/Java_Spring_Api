package george.tads.testlibrarybookspringwebrest.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;


@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "author")
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "nationality", length = 30)
    private String nationality;

    @OneToMany(mappedBy = "author", cascade = CascadeType.MERGE)
    private List<Book> books;

}