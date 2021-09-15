package george.tads.testlibrarybookspringwebrest.repositories;

import george.tads.testlibrarybookspringwebrest.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}