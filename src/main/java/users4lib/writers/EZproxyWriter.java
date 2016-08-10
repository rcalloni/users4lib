package users4lib.writers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import users4lib.config.PropertiesCSVReader;
import users4lib.model.EZproxyUser;
import users4lib.model.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Created by Luiz Claudio Santos on 7/25/16.
 */
public class EZproxyWriter {

    private BufferedWriter writer;

    public void openFile(String fileName) throws IOException {
        this.writer = new BufferedWriter( new FileWriter(fileName));
    }


    private String eZproxyHeader(){
        ApplicationContext context  = new ClassPathXmlApplicationContext("application-context.xml");
        PropertiesCSVReader ezproxyProperties = context.getBean("PropertiesEZproxyRead", PropertiesCSVReader.class);
        String head = ezproxyProperties.getValeuBypropertyName("ezproxy.head.line1") + "\n";
        head = head + ezproxyProperties.getValeuBypropertyName("ezproxy.head.line2") + "\n";
        head = head + ezproxyProperties.getValeuBypropertyName("ezproxy.head.line3") + "\n";
        head = head + ezproxyProperties.getValeuBypropertyName("ezproxy.head.line4") + "\n\n\n";
        head = head + ezproxyProperties.getValeuBypropertyName("ezproxy.head.line5") + "\n";
        head = head + ezproxyProperties.getValeuBypropertyName("ezproxy.head.line6") + "\n";
        head = head + ezproxyProperties.getValeuBypropertyName("ezproxy.head.line7") + "\n";
        head = head + ezproxyProperties.getValeuBypropertyName("ezproxy.head.line8") + "\n";
        head = head + ezproxyProperties.getValeuBypropertyName("ezproxy.head.line9") + "\n";
        head = head + ezproxyProperties.getValeuBypropertyName("ezproxy.head.line10") + "\n";
        return head;
    }

    public void printEzproxyUsers(List<User> users) throws IOException {
        this.writer.write(this.eZproxyHeader());

        Collections.sort(users, (currentUser, nextUser) ->  currentUser.getId().compareTo(nextUser.getId()));

        for(User user : users){
            EZproxyUser eZproxyUser = (EZproxyUser) user;
            this.writer.write(eZproxyUser.toEzproxy() + "\n");
        }
        this.writer.close();

    }
}
