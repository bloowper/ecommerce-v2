package orchowski.tomasz.ecommercev2.entities.dataTransfer;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class ItemDto {

    private Integer id;

    private Timestamp createDate;

    private Timestamp updateDate;

    private String title;

    private String subTitle;

    private String mainPhotoUrl;

    private String shortDescription;

    private String description;

    private List<String> photos;
}
