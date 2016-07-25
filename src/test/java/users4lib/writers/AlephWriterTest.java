package users4lib.writers;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import users4lib.model.AlephUser;
import users4lib.model.Global;
import users4lib.readers.UsersReader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alejandrorodriguez on 7/8/16.
 */
public class AlephWriterTest {

    @Test
    public void getAInstanceTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        UsersReader reader = context.getBean("UsersReader", UsersReader.class);
        reader.setUserSource("/Users/luizfr/Development/ideaprojects/users4lib/src/main/resources/source/ePortal_Telephone_Directory.csv");

        List<AlephUser>alephUsers = reader.getUsers();

        AlephWriter aw = new AlephWriter();
        try {
            aw.exportAlephUsers(alephUsers,"./aleph_users.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
