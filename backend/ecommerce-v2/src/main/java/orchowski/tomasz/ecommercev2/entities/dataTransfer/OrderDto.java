package orchowski.tomasz.ecommercev2.entities.dataTransfer;

import lombok.Data;
import orchowski.tomasz.ecommercev2.entities.DeliveryAddress;
import orchowski.tomasz.ecommercev2.entities.ItemSnapshot;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.List;

@Data
public class OrderDto {

    private Integer id;

    List<ItemSnapshotDto> itemsSnapshots;

    DeliveryAddressDto deliveryAddress;

    private Timestamp create;

}
