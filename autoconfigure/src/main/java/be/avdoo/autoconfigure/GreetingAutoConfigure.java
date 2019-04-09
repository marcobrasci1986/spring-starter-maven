package be.avdoo.autoconfigure;

import be.avidoo.kring.commons.GreetingService;
import be.avidoo.kring.commons.config.ObjectMapperConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ConditionalOnClass(GreetingService.class)
@Import(ObjectMapperConfiguration.class)
public class GreetingAutoConfigure {

    @Autowired
    @Qualifier("kringObjectMapper")
    private ObjectMapper objectMapper;

    @Bean
    @ConditionalOnProperty(prefix = "kring.commons", value = "true")
    public GreetingService greetingService() {
        return new GreetingService(objectMapper);
    }
}


