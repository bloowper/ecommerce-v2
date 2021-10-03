package orchowski.tomasz.ecommercev2.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    StoreUser storeUser;

    @OneToMany(
            mappedBy = "deliveryAddress"
    )
    List<Order> orderList;

    String firstName;

    String lastName;

    String address;

    String postalCode;

    String city;

    String phoneNumber;
}
