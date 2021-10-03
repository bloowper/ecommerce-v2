package orchowski.tomasz.ecommercev2.entities.dataTransfer;

import lombok.Data;
import orchowski.tomasz.ecommercev2.entities.Item;
import orchowski.tomasz.ecommercev2.entities.Order;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
public class ItemSnapshotDto {

    private Integer id;

    private ItemDto item;

    private OrderDto order;

    private Integer numberOfItems;

    private Double price;
}
