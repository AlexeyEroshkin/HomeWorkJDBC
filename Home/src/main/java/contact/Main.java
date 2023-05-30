package contact;

import contact.config.ContactConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

       var applicationContext = new AnnotationConfigApplicationContext(ContactConfiguration.class);
       var filePath = new ClassPathResource("contacts.csv").getFile().toPath();
       var contactService = applicationContext.getBean(ContactService.class);
       var namedJdbcContactDao = applicationContext.getBean(ContactDao.class);

    }
}