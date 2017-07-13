package users4lib.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import users4lib.model.User;
import users4lib.readers.UsersReader;
import users4lib.writers.AlephWriter;
import users4lib.writers.EZproxyWriter;

import java.io.IOException;
import java.util.List;

/**
 * Created by luizfr on 3/23/16.
 */
public class Users4Lib {


    // TODO add main options here
    public static void main(String [] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        if (args.length == 1){

            UsersReader reader = context.getBean("UsersReaderAleph", UsersReader.class);

            reader.setUserSource(args[0]);

            List<User> alephUsers = reader.getUsers();

            AlephWriter aw = new AlephWriter();
            try {
                aw.exportAlephUsers(alephUsers,"./aleph_users.xml");
            } catch (Exception e) {
                e.printStackTrace();
            }

            reader = context.getBean("UsersReaderEzproxy", UsersReader.class);

            reader.setUserSource(args[0]);

            EZproxyWriter writer = new EZproxyWriter();
            try {
                writer.openFile("./ezproxy_users");
                List<User> eZproxyUsers = reader.getUsers();

                writer.printEzproxyUsers(eZproxyUsers);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }else{
            System.out.println("You should pass the staff directory as argument!");
        }

    }


}
