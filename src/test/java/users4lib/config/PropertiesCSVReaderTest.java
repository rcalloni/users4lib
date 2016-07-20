package users4lib.config;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import users4lib.readers.UsersReader;

import java.io.IOException;
import java.util.List;

/**
 * Created by luizfr on 3/24/16.
 */
public class PropertiesCSVReaderTest {

    private static PropertiesCSVReader csvProperties;
    private static PropertiesCSVReader alephProperties;
    private static PropertiesCSVReader configProperties;

    @BeforeClass
    public static void startUp(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        csvProperties = context.getBean("PropertiesCSVReader", PropertiesCSVReader.class);
        alephProperties = context.getBean("PropertiesUserRead", PropertiesCSVReader.class);
        configProperties = context.getBean("PropertiesConfig", PropertiesCSVReader.class);
    }

    @Test
    public void propertiesReaderCSV() throws IOException {
        List<String> list = csvProperties.getCSVColumns();
        assertEquals(13, list.size());
    }


    @Test
    public void propertiesReaderCSVID() throws IOException {
        List<String> list = csvProperties.getCSVColumns();
        assertEquals(13, list.size());
    }

    @Test
    public void getPropertyCSVByName(){
        String  value = csvProperties.getValeuBypropertyName("user.department");
        assertEquals("Department", value);
    }

    @Test
    public void getPropertyAlephByName(){
        String  value = alephProperties.getValeuBypropertyName("z303-id");
        assertEquals("{Email Address}", value);
    }

}
