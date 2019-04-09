package be.avdoo.autoconfigure;

import be.avidoo.kring.commons.GreetingService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(GreetingService.class)
public class GreetingAutoConfigure {


    @Bean
    @ConditionalOnProperty(prefix = "kring.commons", value = "true")
    public GreetingService greetingService() {

        return new GreetingService();
    }
}


