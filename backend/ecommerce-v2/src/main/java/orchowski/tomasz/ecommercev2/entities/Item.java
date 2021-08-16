package orchowski.tomasz.ecommercev2.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID uuid;


    @NotNull
    private String title;

    @NotNull
    private String subTitle;

    @NotNull
    private String mainPhotoUrl;

    @NotNull
    @Lob
    private String description;

    @Singular
    @ElementCollection
    @CollectionTable(
            name = "ITEM_PHOTO"
    )
    private List<String> photos;


}
