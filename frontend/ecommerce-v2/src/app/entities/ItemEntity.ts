
export class ItemEntity {

    constructor(public uuid: string,
                public title: string,
                public mainPhotoUrl: string,
                public  description: string,
                public photos: string[]
    ) {
    }

}

// Java related class
// public class Item {
//
//     @Id
//     @GeneratedValue(generator = "UUID")
//     private UUID uuid;
//
//
//     @NotNull
//     private String title;
//
//     @NotNull
//     private String subTitle;
//
//     @NotNull
//     private String mainPhotoUrl;
//
//     @NotNull
//     @Lob
//     private String description;
//
//     @Singular
//     @ElementCollection
//     @CollectionTable(
//         name = "ITEM_PHOTO"
//     )
//     private List<String> photos;
//
//
// }
