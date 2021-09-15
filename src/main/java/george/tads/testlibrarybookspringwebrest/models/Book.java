package george.tads.testlibrarybookspringwebrest.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "year_of_publishing", nullable = false)
    private Short yearOfPublishing;

    @Column(name = "number_of_pages", nullable = false)
    private Short numberOfPages;

    @Column(name = "rating")
    private Short rating = null;

    @Column(name = "read", nullable = false)
    private Boolean read = false;

    @Column(name = "read_data")
    private Date readData = null;

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "ibns_id")
    private Ibns ibns;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "author_id")
    private Author author;

}


