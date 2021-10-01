package orchowski.tomasz.ecommercev2.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class StoreUser {
    @Id
    Integer id;

    @OneToMany(mappedBy = "storeUser")
    List<DeliveryAddress> deliveryAddress;


}
