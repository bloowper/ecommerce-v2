package orchowski.tomasz.ecommercev2.services;

import lombok.RequiredArgsConstructor;
import orchowski.tomasz.ecommercev2.entities.Item;
import orchowski.tomasz.ecommercev2.repositories.ItemRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public Page<Item> findAll(Integer page, Integer size, String sortBy, Sort.Direction direction) {

       PageRequest pageRequest;
       if (direction == Sort.Direction.ASC) {
           pageRequest = PageRequest.of(page, size, Sort.by(sortBy).ascending());
       } else {
           pageRequest = PageRequest.of(page, size, Sort.by(sortBy).descending());
       }

       return itemRepository.findAll(pageRequest);
    }

    public Item save(Item item) {
        return itemRepository.save(item);
    }

}
