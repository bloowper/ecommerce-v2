package orchowski.tomasz.ecommercev2.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import orchowski.tomasz.ecommercev2.entities.DeliveryAddress;
import orchowski.tomasz.ecommercev2.entities.StoreUser;
import orchowski.tomasz.ecommercev2.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
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
    ResponseEntity<?> getUsers(@RequestParam List<Integer> id) {
        List<StoreUser> users = userService.getUsersById(id);
        Map<String, Object> responseBody = new HashMap<>();
        if (users.isEmpty()) {
            responseBody.put("error", "NOT_FOUND");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
        }else {
            responseBody.put("response", users);
            Map<String, Object> errors = new HashMap<>();
            for (Integer userId : id) {
                if (! StoreUserControllerUtils.isUserIdExistInIterable(userId, users)) {
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
    ResponseEntity<?> getDeliveryAddress(@RequestParam List<Integer> id) {
        List<DeliveryAddress> deliveryAddressById = userService.getDeliveryAddressById(id);
        Map<String, Object> responseBody = new HashMap<>();
        if (deliveryAddressById.isEmpty()) {
            responseBody.put("error", "NOT_FOUND");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
        }
        return null;
    }
}

//TODO what i should to do with that type of util class
final class StoreUserControllerUtils{
    public static boolean isUserIdExistInIterable(Integer userId, Iterable<StoreUser> users) {
        for (StoreUser storeUser : users) {
            if (storeUser.getId().equals(userId)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param idOfEntity
     * @param entities
     * @param predicate have to return true when entity in entities have same id as idOfEntity
     * @param <Entity>
     * @param <Id>
     * @return
     */
    public static <Entity, Id> boolean isIdExistInInEntities(Id idOfEntity,Iterable<Entity> entities, BiPredicate<Entity, Id> predicate) {
        for (Entity entity : entities) {
            if (predicate.test(entity, idOfEntity)) {
                return true;
            }
        }
        return false;
    }
}
