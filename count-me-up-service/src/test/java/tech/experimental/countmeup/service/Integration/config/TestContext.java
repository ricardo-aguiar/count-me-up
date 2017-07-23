package tech.experimental.countmeup.service.Integration.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;
import tech.experimental.countmeup.service.CountMeUpApplication;

import java.util.Collections;

/**
 * Test configuration.
 */
@Configuration
@ContextConfiguration(classes = CountMeUpApplication.class)
@ComponentScan(basePackages = "tech.experimental.countmeup.service")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestContext
{

    @Bean
    public RestTemplate restTemplate(final ObjectMapper objectMapper)
    {
        final RestTemplate restTemplate = new RestTemplate();
        final MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        messageConverter.setObjectMapper(objectMapper);
        restTemplate.setMessageConverters(Collections.singletonList(messageConverter));
        return restTemplate;
    }

    @Bean
    public ObjectMapper objectMapper()
    {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        return objectMapper;
    }

}
