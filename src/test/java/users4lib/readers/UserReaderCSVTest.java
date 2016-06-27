package users4lib.readers;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by luizfr on 3/24/16.
 */
public class UserReaderCSVTest {

    @Test
    public void getAInstanceTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        UsersReader reader = context.getBean("UsersReader", UsersReader.class);
        reader.setUserSource("/Users/luizfr/Development/ideaprojects/users4lib/src/main/resources/source/ePortal_Telephone_Directory.csv");
    }
}
