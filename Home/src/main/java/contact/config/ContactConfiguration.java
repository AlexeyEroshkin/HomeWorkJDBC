package contact.config;

import contact.ContactDao;
import contact.ContactReader;
import contact.ContactService;
import contact.config.JdbcConfig;
import contact.config.PropertiesConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
@Import({JdbcConfig.class, PropertiesConfiguration.class})
public class ContactConfiguration {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public ContactConfiguration(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Bean
    public ContactDao contactDao() {
        return new ContactDao(namedParameterJdbcTemplate);
    }

    @Bean
    public ContactReader contactParser() {
        return new ContactReader();
    }

    @Bean
    public ContactService contactService() {
        return new ContactService(
                contactDao(),
                contactParser()
        );
    }
}