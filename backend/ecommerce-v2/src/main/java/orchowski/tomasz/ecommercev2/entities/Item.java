package orchowski.tomasz.ecommercev2.entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createDate;

    @UpdateTimestamp
    private Timestamp updateDate;

    @NotNull
    @Size(min = 4,max = 255)
    private String title;

    @NotNull
    @Size(min = 4,max = 255)
    private String subTitle;

    @NotNull
    @Size(max = 255)
    private String mainPhotoUrl;

    @NotNull
    @Size(min = 4,max = 500)
    private String shortDescription;

    @NotNull
    @Lob
    @Size(min = 4,max = 3000)
    private String description;


    @Singular
    @ElementCollection
    @CollectionTable(
            name = "ITEM_PHOTO"
    )
    private List<String> photos;


}
