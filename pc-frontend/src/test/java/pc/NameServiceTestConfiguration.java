package pc;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import pc.service.MainService;

	
@Profile("test")
@Configuration
public class NameServiceTestConfiguration {
    @Bean
    @Primary
    public MainService nameService() {
        return Mockito.mock(MainService.class);
    }
}