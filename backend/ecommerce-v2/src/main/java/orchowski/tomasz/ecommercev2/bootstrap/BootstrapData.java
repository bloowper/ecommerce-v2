package orchowski.tomasz.ecommercev2.bootstrap;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import orchowski.tomasz.ecommercev2.entities.Item;
import orchowski.tomasz.ecommercev2.services.ItemService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Profile("development")
@Slf4j
@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final ItemService itemService;


    @Override
    public void run(String... args) throws Exception {
        log.info("Bootstrap data");
        loadItems();
    }

    private void loadItems() {
        Item item0 = itemService.save(
                Item.builder().
                        title("consectetur porro assumenda").
                        subTitle("sed accusamus nihil molestiae quia et").
                        mainPhotoUrl("https://dummyimage.com/600x400/a8a8a8/000000").
                        description("Id accusamus a sed vel neque quia unde. Eos et ut hic consequatur molestiae. Non quia ut eius non commodi. Neque sunt vel in nemo et eveniet. Dolorem et sed atque officia. Delectus voluptates magnam odit neque minus.\n" +
                                "\n" +
                                "Eum consequatur dolor omnis nisi quis animi libero repudiandae. Odit ipsam delectus est possimus iste excepturi mollitia. Rem aut ratione sed vel. Qui a cum quibusdam qui in at labore.\n" +
                                "\n" +
                                "Est suscipit possimus quasi velit alias reprehenderit eum aut. Nostrum in maxime necessitatibus ut aut eos aliquid sunt. Debitis non voluptas ratione. Accusantium autem in quis. Recusandae veniam tempore sit quasi sed magnam. Enim autem ut ut culpa.").
                        photo("https://dummyimage.com/600x400/a8a8a8/000000").
                        photo("https://dummyimage.com/600x400/a8a8a8/000000")
                        .build()
        );

        for (int i = 0; i < 30; i++) {
            itemService.save(
                    Item.builder().
                            title("consectetur porro assumenda").
                            subTitle("sed accusamus nihil molestiae quia et").
                            mainPhotoUrl("https://dummyimage.com/600x400/a8a8a8/000000").
                            description("Id accusamus a sed vel neque quia unde. Eos et ut hic consequatur molestiae. Non quia ut eius non commodi. Neque sunt vel in nemo et eveniet. Dolorem et sed atque officia. Delectus voluptates magnam odit neque minus.\n" +
                                    "\n" +
                                    "Eum consequatur dolor omnis nisi quis animi libero repudiandae. Odit ipsam delectus est possimus iste excepturi mollitia. Rem aut ratione sed vel. Qui a cum quibusdam qui in at labore.\n" +
                                    "\n" +
                                    "Est suscipit possimus quasi velit alias reprehenderit eum aut. Nostrum in maxime necessitatibus ut aut eos aliquid sunt. Debitis non voluptas ratione. Accusantium autem in quis. Recusandae veniam tempore sit quasi sed magnam. Enim autem ut ut culpa.").
                            photo("https://dummyimage.com/600x400/a8a8a8/000000").
                            photo("https://dummyimage.com/600x400/a8a8a8/000000")
                            .build()
            );
        }


    }

}
