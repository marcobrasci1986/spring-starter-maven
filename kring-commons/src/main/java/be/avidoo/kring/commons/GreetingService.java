package be.avidoo.kring.commons;

import be.avidoo.kring.commons.config.ObjectMapperConfiguration;
import be.avidoo.kring.commons.model.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Month;

@Service
@Import(ObjectMapperConfiguration.class)
public class GreetingService {

    @Qualifier("kringObjectMapper")
    private final ObjectMapper objectMapper;

    public GreetingService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String sayHello(String name) throws JsonProcessingException {
        Person person = new Person("Mike", LocalDateTime.of(2019, Month.APRIL, 9, 0, 0));


        String objectAsJson = objectMapper.writeValueAsString(person);


        return String.format("Hello %s. Json is %s", name, objectAsJson);
    }
}
