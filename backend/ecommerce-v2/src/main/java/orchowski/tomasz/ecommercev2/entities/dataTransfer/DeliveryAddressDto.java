package orchowski.tomasz.ecommercev2.entities.dataTransfer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import orchowski.tomasz.ecommercev2.entities.Order;
import orchowski.tomasz.ecommercev2.entities.StoreUser;

import javax.persistence.*;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryAddressDto {

    Integer id;

    String firstName;

    String lastName;

    String address;

    String postalCode;

    String city;

    String phoneNumber;
}
