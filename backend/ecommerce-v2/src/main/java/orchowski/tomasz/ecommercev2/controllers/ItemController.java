package orchowski.tomasz.ecommercev2.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import orchowski.tomasz.ecommercev2.entities.Item;
import orchowski.tomasz.ecommercev2.services.ItemService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.prefix}")
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200"})
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/items")
    Page<Item> getItems(
            @RequestParam(required = true) int page,
            @RequestParam(required = false, defaultValue = "16") int pageSize,
            @RequestParam(required = false,defaultValue = "title") String sortBy,
            @RequestParam(required = false,defaultValue = "ASC") String sortDirection
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
}
