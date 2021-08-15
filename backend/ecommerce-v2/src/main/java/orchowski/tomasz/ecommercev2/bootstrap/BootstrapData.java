package orchowski.tomasz.ecommercev2.bootstrap;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    }

}
