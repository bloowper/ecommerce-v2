package orchowski.tomasz.ecommercev2.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import orchowski.tomasz.ecommercev2.entities.DeliveryAddress;
import orchowski.tomasz.ecommercev2.entities.StoreUser;
import orchowski.tomasz.ecommercev2.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;

@RestController
@RequestMapping("${api.prefix}")
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200"})
public class StoreUserController {



    private final UserService userService;



    //TODO split into smaller methods/objects (such a mess)
    @GetMapping("/user")
    ResponseEntity<?> getUsers(@RequestParam List<Integer> ID) {
        List<StoreUser> users = userService.getUsersById(ID);
        Map<String, Object> responseBody = new HashMap<>();
        if (users.isEmpty()) {
            responseBody.put("error", "NOT_FOUND");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
        } else {
            responseBody.put("response", users);
            Map<String, Object> errors = new HashMap<>();
            for (Integer userId : ID) {
                if (!StoreUserControllerUtils.isIdExistInInEntities(userId, users,
                        (user, uid) -> {
                            return user.getId().equals(uid);
                        }
                )) {
                    errors.put(String.valueOf(userId), "NOT_FOUND");
                }
            }
            if (!errors.isEmpty()) {
                responseBody.put("errors", errors);
            }
        }
        return ResponseEntity.ok(responseBody);
    }



    @GetMapping("/deliveryAddress")
    ResponseEntity<?> getDeliveryAddress(@RequestParam List<Integer> ID) {
        List<DeliveryAddress> deliveryAddresses = userService.getDeliveryAddressById(ID);
        Map<String, Object> responseBody = new HashMap<>();
        if (deliveryAddresses.isEmpty()) {
            responseBody.put("error", "NOT_FOUND");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
        }else {
            responseBody.put("response", deliveryAddresses);
            Map<Integer, Object> errors = new HashMap<>();
            for (Integer id : ID) {
                if(!StoreUserControllerUtils.isIdExistInInEntities(
                        id,deliveryAddresses,
                        (deliveryAddress, integer1) -> {
                            return deliveryAddress.getId().equals(integer1);
                        }
                )){
                    errors.put(id, "NOT_FOUND");
                }
            }
            if (!errors.isEmpty()) {
                responseBody.put("errors", errors);
            }
            return ResponseEntity.ok(responseBody);
        }
    }



}



//TODO what i should to do with that type of util class
final class StoreUserControllerUtils {

    /**
     * @param predicate  have to return true when entity in entities have same id as idOfEntity
     * @return true when id exist in iterable of entities
     */
    public static <Entity, Id> boolean isIdExistInInEntities(Id idOfEntity, Iterable<Entity> entities, BiPredicate<Entity, Id> predicate) {
        for (Entity entity : entities) {
            if (predicate.test(entity, idOfEntity)) {
                return true;
            }
        }
        return false;
    }
}
