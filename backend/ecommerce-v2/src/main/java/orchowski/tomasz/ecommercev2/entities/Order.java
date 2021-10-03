package orchowski.tomasz.ecommercev2.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Table(name = "order")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    private Integer id;

    @OneToMany
    List<ItemSnapshot> itemsSnapshots;

    @ManyToOne
    DeliveryAddress deliveryAddress;

    @CreatedDate
    private Timestamp create;

}