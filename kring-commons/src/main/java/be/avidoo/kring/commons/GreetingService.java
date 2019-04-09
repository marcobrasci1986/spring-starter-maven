package be.avidoo.kring.commons;

import be.avidoo.kring.commons.model.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GreetingService {

    private final ObjectMapper objectMapper;

    public GreetingService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String sayHello(String name) throws JsonProcessingException {
        Person person = new Person("Mike", LocalDateTime.now());


        String objectAsJson = objectMapper.writeValueAsString(person);


        return String.format("Hello %s. Json is %s", name, objectAsJson);
    }
}
