package users4lib.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import users4lib.readers.UsersReader;

/**
 * Created by luizfr on 3/23/16.
 */
public class Users4Lib {


    // TODO add main options here
    public static void main(String [] main){
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        UsersReader reader = context.getBean("UsersReader", UsersReader.class);



    }
}
