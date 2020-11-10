package pl.coderslab.app.jpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.app.entity.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findByEmail(String email);

    Author findByPesel(String pesel);

    List<Author> findByLastName(String lastName);

    @Query("SELECT a FROM Author a WHERE a.email LIKE :email%")
    List<Author> findAuthorsByEmailStartsWith(@Param("email") String email);

    @Query("SELECT a FROM Author a WHERE a.pesel LIKE ?1%")
    List<Author> findAuthorsByPeselStartsWith(String pesel);
}
