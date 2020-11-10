package pl.coderslab.app.jpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.app.entity.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    Publisher findByNip(String nip);

    Publisher findByRegon(String regon);

}
