package orchowski.tomasz.ecommercev2.entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
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

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createDate;

    @UpdateTimestamp
    private Timestamp updateDate;

    @NotNull
    @Size(min = 4)
    private String title;

    @NotNull
    private String subTitle;

    @NotNull
    private String mainPhotoUrl;

    @NotNull
    @Lob
    private String shortDescription;

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
