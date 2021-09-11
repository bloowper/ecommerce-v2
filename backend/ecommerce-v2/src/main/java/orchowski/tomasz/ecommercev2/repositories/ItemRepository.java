package orchowski.tomasz.ecommercev2.repositories;

import orchowski.tomasz.ecommercev2.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {

   Optional<Item>  findByUuid(String uuid);
}
