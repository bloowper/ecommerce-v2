package orchowski.tomasz.ecommercev2.mapers;

import io.micrometer.core.lang.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class BindingResultToMap implements Converter<BindingResult,Map<String, String>> {

    @Override
    @Nullable
    @Synchronized
    public Map<String, String> convert(BindingResult bindingResult) {
        return bindingResult.getAllErrors().stream().collect(Collectors.toMap(ObjectError::getObjectName, ObjectError::getDefaultMessage));
    }
}
