package users4lib.model;

import org.apache.commons.csv.CSVRecord;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import users4lib.config.PropertiesCSVReader;

import java.util.List;

/**
 * Created by luizfr on 3/29/16.
 */
public class UserFactory {

    public static User createAnUser(CSVRecord record){
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        PropertiesCSVReader csvProperties = context.getBean("PropertiesCSVReader", PropertiesCSVReader.class);
        List<String> csvColumns  = csvProperties.getCSVColumns();
        User user = new User();
        for(String columnName : csvColumns){
            //record.get(columnName)
        }

        return user;
    }
}
