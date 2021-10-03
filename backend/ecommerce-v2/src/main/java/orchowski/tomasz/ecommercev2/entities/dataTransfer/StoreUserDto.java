package orchowski.tomasz.ecommercev2.entities.dataTransfer;

import lombok.Data;
import lombok.Singular;
import orchowski.tomasz.ecommercev2.entities.DeliveryAddress;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class StoreUserDto {

    Integer id;

    String login;

    List<DeliveryAddressDto> deliveryAddress;

}
