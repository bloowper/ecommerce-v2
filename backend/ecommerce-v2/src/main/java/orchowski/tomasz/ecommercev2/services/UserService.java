package orchowski.tomasz.ecommercev2.services;

import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import orchowski.tomasz.ecommercev2.entities.DeliveryAddress;
import orchowski.tomasz.ecommercev2.entities.StoreUser;
import orchowski.tomasz.ecommercev2.repositories.DeliveryAddressRepository;
import orchowski.tomasz.ecommercev2.repositories.StoreUserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserService {

    private final StoreUserRepository storeUserRepository;
    private final DeliveryAddressRepository deliveryAddressRepository;

    public Iterable<StoreUser> getAllUsers() {
        Iterable<StoreUser> all = storeUserRepository.findAll();
        return all;
    }

    public Page<StoreUser> getAllUsers(Integer pageNUmber, Integer pageSize, String sortBy,Sort.Direction direction) {
        PageRequest pageRequest = PageRequest.of(pageNUmber, pageSize, direction);
        return storeUserRepository.findAll(pageRequest);
    }

    public List<StoreUser> getUsersById(Iterable<Integer> ids) {
        Iterable<StoreUser> byId = storeUserRepository.findAllById(ids);
        List<StoreUser> users = Lists.newArrayList(byId);
        return users;
    }

    /**
     * save user with delivery addresses cascade
     */
    public StoreUser save(StoreUser user) {
        return storeUserRepository.save(user);
    }

    public List<DeliveryAddress> getDeliveryAddressById(Iterable<Integer> id) {
        List<DeliveryAddress> byId = deliveryAddressRepository.findAllById(id);
        return byId;
    }

}
