package george.tads.testlibrarybookspringwebrest.repositories;

import george.tads.testlibrarybookspringwebrest.models.Ibns;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IbnsRepository extends JpaRepository<Ibns, Long> {
}