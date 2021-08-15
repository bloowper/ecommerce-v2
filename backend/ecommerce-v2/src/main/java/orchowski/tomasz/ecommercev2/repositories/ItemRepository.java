package orchowski.tomasz.ecommercev2.repositories;

import orchowski.tomasz.ecommercev2.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {

}
