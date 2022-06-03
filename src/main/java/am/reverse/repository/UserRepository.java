package am.reverse.repository;


import am.reverse.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByName(String name);
    boolean existsByEmail(String email);
}
