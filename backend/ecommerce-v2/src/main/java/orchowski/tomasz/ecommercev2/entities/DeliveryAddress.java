package orchowski.tomasz.ecommercev2.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DeliveryAddress {
    @Id
    Integer id;

    @ManyToOne
    //@JoinColumn()
    StoreUser storeUser;

}
