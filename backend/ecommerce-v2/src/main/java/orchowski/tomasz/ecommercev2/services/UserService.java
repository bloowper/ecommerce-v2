package orchowski.tomasz.ecommercev2.services;

import lombok.RequiredArgsConstructor;
import orchowski.tomasz.ecommercev2.entities.StoreUser;
import orchowski.tomasz.ecommercev2.repositories.DeliveryAddressRepository;
import orchowski.tomasz.ecommercev2.repositories.StoreUserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserService {

    private final StoreUserRepository storeUserRepository;
    private final DeliveryAddressRepository deliveryAddressRepository;

    Iterable<StoreUser> getAllUsers() {
        Iterable<StoreUser> all = storeUserRepository.findAll();
        return all;
    }

    Page<StoreUser> getAllUsers(Integer pageNUmber, Integer pageSize, String sortBy,Sort.Direction direction) {
        PageRequest pageRequest = PageRequest.of(pageNUmber, pageSize, direction);
        return storeUserRepository.findAll(pageRequest);
    }

    StoreUser save(StoreUser user) {
        return storeUserRepository.save(user);
    }


}
