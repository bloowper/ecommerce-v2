package orchowski.tomasz.ecommercev2.repositories;

import orchowski.tomasz.ecommercev2.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {

}
