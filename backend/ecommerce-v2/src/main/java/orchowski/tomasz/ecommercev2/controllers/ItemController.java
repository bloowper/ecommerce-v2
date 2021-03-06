package orchowski.tomasz.ecommercev2.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import orchowski.tomasz.ecommercev2.entities.Item;
import orchowski.tomasz.ecommercev2.mapers.BindingResultToMap;
import orchowski.tomasz.ecommercev2.services.ItemService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("${api.prefix}")
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200"})
public class ItemController {

    private final ItemService itemService;
    private final BindingResultToMap bindingResultToMap;

    @GetMapping("/items")
    Page<Item> getItems(
            @RequestParam(required = true) int page,
            @RequestParam(required = false, defaultValue = "16") int pageSize,
            @RequestParam(required = false, defaultValue = "title") String sortBy,
            @RequestParam(required = false, defaultValue = "ASC") String sortDirection
    ) {
        log.debug(String.format("pageSize %s sortBy %s sortDirection %s", pageSize, sortBy, sortDirection));
        Sort.Direction direction;
        if (sortDirection.equalsIgnoreCase("DESC")) {
            direction = Sort.Direction.DESC;
        } else {
            direction = Sort.Direction.ASC;
        }

        Page<Item> items = itemService.findAll(page, pageSize, sortBy, direction);
        return items;
    }


    @GetMapping("/item/{id}")
    ResponseEntity<?> getItem(
            @PathVariable(required = true) int id
    ) {
        Optional<Item> byUuid = itemService.findById(id);
        if (byUuid.isEmpty()) {
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("error", "resource not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(byUuid.get());
        }
    }


    @PostMapping("/item")
    ResponseEntity<?> postItem(@Valid @RequestBody Item item, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResultToMap.convert(bindingResult));
        }
        Item save = itemService.save(item);
        ResponseEntity<Item> response = ResponseEntity.status(HttpStatus.OK).body(save);
        return response;
    }

    @DeleteMapping("/item")
    ResponseEntity<?> deleteItem(@RequestParam(required = true) List<Integer> id) {
        log.info("Removing Item with id"+ id);
        itemService.deleteAllById(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }



}
