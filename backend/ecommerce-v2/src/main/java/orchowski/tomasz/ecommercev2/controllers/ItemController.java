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
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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


    @GetMapping("/item")
    ResponseEntity<Item> getItem(
            @RequestParam(required = true) String uuid
    ) {
        Optional<Item> byUuid = itemService.findByUuid(uuid);
        if (byUuid.isEmpty()) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(byUuid.get());
    }


    @PostMapping("/item")
    ResponseEntity<?> newItem(@Valid @RequestBody Item item, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResultToMap.convert(bindingResult));
        }
        Item save = itemService.save(item);
        ResponseEntity<Item> response = ResponseEntity.status(HttpStatus.OK).body(save);
        return response;
    }



}
