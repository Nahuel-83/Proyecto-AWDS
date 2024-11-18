package bbbt05e03.bbbt05e03.config;

import bbbt05e03.bbbt05e03.FormInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public FormInfo formInfo() {
        return new FormInfo();
    }
}
