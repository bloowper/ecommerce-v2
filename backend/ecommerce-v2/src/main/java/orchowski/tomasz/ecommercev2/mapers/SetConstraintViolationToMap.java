package orchowski.tomasz.ecommercev2.mapers;

import io.micrometer.core.lang.Nullable;
import lombok.Synchronized;
import orchowski.tomasz.ecommercev2.entities.Item;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Path;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Component
public class SetConstraintViolationToMap<T extends Object> implements Converter<Set<ConstraintViolation<T>>, Map<String, String>> {

    @Override
    @Nullable
    @Synchronized
    public Map<String, String> convert(Set<ConstraintViolation<T>> constraintViolations) {
        Map<String, String> collect = constraintViolations.
                stream().
                collect(
                        Collectors.toMap(
                                constraintViolation -> constraintViolation.getPropertyPath().toString(),
                                ConstraintViolation::getMessage
                        )
                );

        return collect;
    }

}
