package orchowski.tomasz.ecommercev2.bootstrap.developmentBeans;

import lombok.RequiredArgsConstructor;
import lombok.Singular;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Profile("development")
@Slf4j
@Component
@RequiredArgsConstructor
public class ItemLoremIpsum {

    String[] title = {
            "dolorum rerum totam",
            "cum eligendi magni",
            "nihil vitae",
            "Doloremque nesciunt",
            "exercitationem assumenda",
            "Ex nobis non consequatur est sint",
            "eos atque",
    };

    String[] subTitle = {
            "corrupti exercitationem assumenda cum qui. ",
            " temporibus provident nemo.",
            "Soluta minima in quia ex autem quia.",
            "nemo nostrum adipisci",
    };

    String[] mainPhotoUrl = {
            "https://dummyimage.com/432x345.6/000/ffffff",
            "https://dummyimage.com/432x345.6/000/ffffff",
            "https://dummyimage.com/432x345.6/362e36/ffffff",
            "https://dummyimage.com/432x345.6/730073/ffffff",
            "https://dummyimage.com/432x345.6/4ea100/ffffff",
    };

    String[] shortDescription = {
            "At quia iure aut itaque modi quas esse. Ut magnam fugiat at quia possimus amet atque necessitatibus. Accusamus non in pariatur omnis dolores. Qui provident quae sunt. Aut dolor nobis temporibus eum. Molestiae cupiditate facere ut magni.",
            "Omnis ut libero aliquam velit. Quas est accusantium esse ut occaecati atque natus aut. Nobis facere nam et dignissimos. Atque voluptas cumque consequatur at error deserunt ut. Tempore vero ut et fugit molestias consectetur. Et quia vero voluptatibus asperiores deserunt officia aperiam.",
            "Suscipit assumenda id illo qui amet eum. Fuga vel enim mollitia nisi facere eligendi in. Nostrum ratione omnis aut ut sed voluptatem. Dicta est non et expedita.",
            "Quod fugiat vero dolorem. Et sequi ipsa nemo fuga. Autem sunt et possimus sint. Omnis nulla animi illo voluptas.",
            "Nobis et molestias provident nobis sit deserunt ipsum voluptate. Quis voluptas esse illum. Incidunt est earum tenetur sed odio ipsum. Consequatur est qui fuga perferendis sed illum eum occaecati.",
    };

    String[] description = {
            "Qui rerum voluptatibus commodi dicta beatae. Error expedita porro ex sunt dolorem. Similique quis et amet voluptas quia excepturi temporibus eos. Atque et saepe non ea asperiores quam.\n" +
                    "\n" +
                    "Blanditiis temporibus voluptas doloribus aperiam sed aspernatur. Vel ut officiis provident vel corrupti. Quibusdam dolore ab consequatur deleniti sunt velit. Quidem aliquam non voluptates earum corporis unde. Omnis eaque sit sint est.\n" +
                    "\n" +
                    "Voluptates sunt delectus tempora. Ea quod labore voluptatem. Perspiciatis et impedit dolorem. Est hic quia eos nam reiciendis itaque. Impedit sit et recusandae expedita.",
            "ndis itaque. Impedit sit et recusandae expedita.tomek@tomek-Lenovo-Yoga-720-15IKB:~$ lorem -p 3\n" +
                    "Omnis autem asperiores fugit ad est aliquid nisi autem. Ut ab qui qui adipisci eum cum in. Voluptatibus doloribus magni non fugit. Saepe fugit sunt omnis. Possimus in doloribus voluptatem voluptas et. Quo ducimus sint eligendi aliquam corrupti voluptas minus fugit.\n" +
                    "\n" +
                    "Corporis inventore neque cum ut occaecati alias qui. Praesentium a tempora id delectus. Deserunt enim voluptatibus quia est. Perferendis impedit nostrum saepe atque natus sint voluptatum aspernatur. Modi quae est ipsum.\n" +
                    "\n" +
                    "Natus repellendus quo quibusdam possimus odit ullam autem. Eos sed incidunt hic expedita id architecto ex velit. Itaque fugiat ducimus dolores recusandae ipsa quis. Reiciendis pariatur iusto eveniet quos rerum qui porro. Non commodi dolor dolores illo officia quia. Unde reprehenderit modi perspiciatis quis assumenda dolorum.",
            "Provident eius aut nostrum quis. Incidunt at quam possimus earum. Consectetur qui inventore id ea et nemo. Aut et recusandae aut. Voluptas placeat qui vitae iure inventore ut dicta. Error enim est qui magni quia.\n" +
                    "\n" +
                    "Ullam dolorem sapiente exercitationem libero a. Eum sapiente laboriosam hic odio omnis animi impedit. Saepe quo alias mollitia laudantium ad odit. Culpa accusamus non nihil aperiam sed molestias eligendi. Facere fugiat atque et totam esse ratione laboriosam. Fuga quaerat occaecati eaque minima quia exercitationem corporis recusandae.\n" +
                    "\n" +
                    "Ad sapiente sequi fugiat quas tenetur. Odio vel autem aliquid. Voluptatem a tempore et molestiae exercitationem explicabo maxime. Iure fugit quis nam eum debitis dolores. Quis quia dolorum rerum dolor alias consequuntur fugiat occaecati. Voluptas odit voluptas nihil nostrum reiciendis quasi et.",
            "Praesentium doloribus magni ut. Architecto sunt sed sed dolore iure voluptas. Dicta qui aut labore ducimus aliquid sint. Labore modi quae voluptas voluptatem ut voluptas exercitationem ut. Excepturi qui enim quis est est quos. Ea necessitatibus rem dolorum.\n" +
                    "\n" +
                    "Fugiat ab voluptatem sunt nobis et vel in quia. Rem deserunt assumenda neque voluptas perspiciatis quis ipsam a. Voluptates alias dolorem molestias.\n" +
                    "\n" +
                    "Et dolores minus odio perspiciatis illo voluptas consequuntur sit. Nihil itaque odit sequi repellendus repudiandae. Et rerum vel sed aut. Amet et itaque illum. Accusamus sunt deserunt repudiandae qui est qui modi. Ullam et tempora maxime illo",
            "Porro pariatur est ad excepturi sed. Modi omnis a voluptatem. Aut impedit aut doloremque magnam.\n" +
                    "\n" +
                    "Facilis voluptatibus molestias odio alias. Corrupti sit iure sint ipsam enim sed ipsa. A porro molestias labore temporibus assumenda. Id eius hic dolore qui et quas. Deserunt at natus sapiente.\n" +
                    "\n" +
                    "Saepe aliquam quidem inventore aut. Ut vel odit eaque aut non nemo eveniet ut. Ab nulla voluptatibus repellat aperiam voluptatem laborum delectus. Sed aspernatur quibusdam nesciunt suscipit aut eaque quia qui. Deleniti qui minima perferendis culpa amet nobis modi.",
    };

    String[] photos = {
            "",
            "",
            "",
            "",
            "",
    };

}



    //@Id
    //@GeneratedValue(generator = "UUID")
    //private UUID uuid;
    //
    //
    //@NotNull
    //private String title;
    //
    //@NotNull
    //private String subTitle;
    //
    //@NotNull
    //private String mainPhotoUrl;
    //
    //@NotNull
    //@Lob
    //private String shortDescription;
    //
    //@NotNull
    //@Lob
    //private String description;
    //
    //@Singular
    //@ElementCollection
    //@CollectionTable(
    //        name = "ITEM_PHOTO"
    //)
    //private List<String> photos;