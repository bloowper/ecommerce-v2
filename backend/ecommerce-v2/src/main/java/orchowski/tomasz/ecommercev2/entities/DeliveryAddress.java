package orchowski.tomasz.ecommercev2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    @JsonIgnore
    StoreUser storeUser;

    @OneToMany(
            mappedBy = "deliveryAddress"
    )
    @JsonIgnore
    List<Order> orderList;

    String firstName;

    String lastName;

    String address;

    String postalCode;

    String city;

    String phoneNumber;
}
