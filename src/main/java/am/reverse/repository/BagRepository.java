package am.reverse.repository;

import am.reverse.entities.Bag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BagRepository extends JpaRepository<Bag,Long> {
}
