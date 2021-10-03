package orchowski.tomasz.ecommercev2.bootstrap;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import orchowski.tomasz.ecommercev2.bootstrap.developmentBeans.ItemLoremIpsum;
import orchowski.tomasz.ecommercev2.entities.DeliveryAddress;
import orchowski.tomasz.ecommercev2.entities.Item;
import orchowski.tomasz.ecommercev2.entities.StoreUser;
import orchowski.tomasz.ecommercev2.mapers.BindingResultToMap;
import orchowski.tomasz.ecommercev2.mapers.SetConstraintViolationToMap;
import orchowski.tomasz.ecommercev2.services.ItemService;
import orchowski.tomasz.ecommercev2.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;



// For bootstrapping db
@Profile("development")
@Slf4j
@Component
@RequiredArgsConstructor
public class BootstrapDb implements CommandLineRunner {

    private final ItemService itemService;
    private final UserService userService;


    private final ItemLoremIpsum itemLoremIpsum;
    private final Validator validator;
    private final BindingResultToMap bindingResultToMap;
    private final SetConstraintViolationToMap setConstraintViolationToMap;

    //variables for random behaviour
    // Items
    private final int nOfRandomItems = 46;
    public List<Item> items = new ArrayList<>(nOfRandomItems);

    // Users
    public List<StoreUser> storeUserList = new ArrayList<>();

    @Override
    public void run(String... args) throws Exception {
        log.info("Bootstrap data");
        loadRandomItems();
        loadUsers();
    }



    private void loadRandomItems() {
        for (int i = 0; i < nOfRandomItems; i++) {
            Item item = itemLoremIpsum.generateRandomItem();
            Set<ConstraintViolation<Item>> validate = validator.validate(item);
            Map mapConstraints = setConstraintViolationToMap.convert(validate);
            if (mapConstraints.isEmpty()) {
                Item save = itemService.save(item);
                items.add(save);
            }else {
                log.info("Fail {} {}", i, mapConstraints);
            }

        }
    }

    //TODO write validators for StoreUser
    private void loadUsers() {
        //user 0
        StoreUser user0 = StoreUser.builder()
                .login("customer1")
                .deliveryAddress(
                        DeliveryAddress
                                .builder()
                                .firstName("Jan")
                                .lastName("Kowalski")
                                .address("Bugczynow 321")
                                .postalCode("24-234")
                                .city("Hacz")
                                .phoneNumber("123123123")
                                .build()
                )
                .deliveryAddress(
                        DeliveryAddress
                                .builder()
                                .firstName("Jan")
                                .lastName("Kowalski")
                                .address("Panorama 123")
                                .postalCode("24-123")
                                .city("Zbyszkowo")
                                .phoneNumber("123123123")
                                .build()
                )
                .build();
        user0 = userService.save(user0);
        storeUserList.add(user0);

        //user1
        StoreUser user1 = StoreUser.builder()
                .login("customer2")
                .deliveryAddress(
                        DeliveryAddress
                                .builder()
                                .firstName("Zbigniew")
                                .lastName("Stonoga")
                                .address("Bycorow 321")
                                .postalCode("12-321")
                                .city("Krowirow")
                                .phoneNumber("321123321")
                                .build()
                )
                .build();
        user1 = userService.save(user1);
        storeUserList.add(user1);

    }
}
