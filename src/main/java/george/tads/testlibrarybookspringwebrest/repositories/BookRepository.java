package george.tads.testlibrarybookspringwebrest.repositories;

import george.tads.testlibrarybookspringwebrest.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
