package george.tads.testlibrarybookspringwebrest.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @Column(name = "publisher")
    private String publisher;

}