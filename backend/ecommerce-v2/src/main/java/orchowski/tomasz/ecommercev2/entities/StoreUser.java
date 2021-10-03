package orchowski.tomasz.ecommercev2.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class StoreUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotNull
    String login;//for change


    @OneToMany(
            cascade = {
                    CascadeType.PERSIST
            },
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "store_user_id")
    @Singular("deliveryAddress")
    List<DeliveryAddress> deliveryAddress;




}
