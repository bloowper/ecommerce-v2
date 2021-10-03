package orchowski.tomasz.ecommercev2.entities;

import lombok.Data;

import javax.persistence.*;

@Table(name = "item_snapshot")
@Entity
@Data
public class ItemSnapshot {

    @Id
    private Integer id;

    @ManyToOne
    private Item item;

    @ManyToOne
    private Order order;

    private Integer numberOfItems;

    private Double price;


}