package softuni.andreysexam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.andreysexam.model.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {
}
