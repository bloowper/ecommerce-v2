package orchowski.tomasz.ecommercev2.bootstrap;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import orchowski.tomasz.ecommercev2.bootstrap.developmentBeans.ItemLoremIpsum;
import orchowski.tomasz.ecommercev2.entities.Item;
import orchowski.tomasz.ecommercev2.mapers.BindingResultToMap;
import orchowski.tomasz.ecommercev2.mapers.SetConstraintViolationToMap;
import orchowski.tomasz.ecommercev2.services.ItemService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.Set;



// For bootstrapping db
@Profile("development")
@Slf4j
@Component
@RequiredArgsConstructor
public class BootstrapDb implements CommandLineRunner {

    private final ItemService itemService;
    private final ItemLoremIpsum itemLoremIpsum;
    private final Validator validator;
    private final BindingResultToMap bindingResultToMap;
    private final SetConstraintViolationToMap setConstraintViolationToMap;

    //variables for random behaviour
    // Items
    public int nOfRandomItems = 46;
    public ArrayList<Item> items = new ArrayList<>(nOfRandomItems);

    // Users

    @Override
    public void run(String... args) throws Exception {
        log.info("Bootstrap data");
        loadRandomItems();
    }

    private void loadRandomItems() {

        for (int i = 0; i < nOfRandomItems; i++) {
            Item item = itemLoremIpsum.generateRandomItem();
            Set<ConstraintViolation<Item>> validate = validator.validate(item);
            Map mapConstraints = setConstraintViolationToMap.convert(validate);
            if (mapConstraints.isEmpty()) {
                Item save = itemService.save(item);
                items.add(save);
            }else {
                log.info("Fail {} {}", i, mapConstraints);
            }

        }

    }


}
