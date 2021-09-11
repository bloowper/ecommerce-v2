package orchowski.tomasz.ecommercev2.bootstrap;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import orchowski.tomasz.ecommercev2.bootstrap.developmentBeans.ItemLoremIpsum;
import orchowski.tomasz.ecommercev2.entities.Item;
import orchowski.tomasz.ecommercev2.services.ItemService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Profile("development")
@Slf4j
@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final ItemService itemService;
    private final ItemLoremIpsum itemLoremIpsum;

    //variables for random behaviour
    int nOfRandomItems = 46;
    ArrayList<Item> items = new ArrayList<>(nOfRandomItems);


    @Override

    public void run(String... args) throws Exception {
        log.info("Bootstrap data");
        loadRandomItems();
    }

    private void loadRandomItems() {

        for (int i = 0; i < nOfRandomItems; i++) {
            Item save = itemService.save(itemLoremIpsum.generateRandomItem());
            items.add(save);
        }

    }

}
