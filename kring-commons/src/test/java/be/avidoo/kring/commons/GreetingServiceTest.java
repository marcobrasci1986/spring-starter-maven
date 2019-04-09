package be.avidoo.kring.commons;

import be.avidoo.kring.commons.config.ObjectMapperConfiguration;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {GreetingService.class, ObjectMapperConfiguration.class})
public class GreetingServiceTest {

    @Autowired
    private GreetingService greetingService;

    @Before
    public void setUp() {
    }

    @Test
    public void sayHello() throws JsonProcessingException {
        String result = greetingService.sayHello("John");

        assertThat(result, is("Hello John. Json is {\"name\":\"Mike\",\"date\":\"09.04.2019\"}"));
    }
}
