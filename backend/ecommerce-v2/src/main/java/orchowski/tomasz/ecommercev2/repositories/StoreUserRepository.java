package orchowski.tomasz.ecommercev2.repositories;

import orchowski.tomasz.ecommercev2.entities.StoreUser;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface StoreUserRepository extends PagingAndSortingRepository<StoreUser, Integer> {


}