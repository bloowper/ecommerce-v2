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
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/items")
    Page<Item> getItems(
            @RequestAttribute(required = true) long page,
            @RequestAttribute(required = true) long pageSize,
            @RequestAttribute(required = false) String sortBy,
            @RequestAttribute(required = false) String sortDirection
    ) {

        log.info(String.format(""));
        Page<Item> items = itemService.findAll(0, 10, "title", Sort.Direction.ASC);
        return items;
    }
}
