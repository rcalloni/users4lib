package users4lib.readers;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import users4lib.config.PropertiesCSVReader;
import users4lib.model.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by luizfr on 3/22/16.
 */
public class UsersReaderCSV implements UsersReader {

    private Reader reader;
    private CSVParser parser;
    private Iterator<CSVRecord> iterator;
    private String userSource;
    private ApplicationContext context;
    private List<AlephUser> users;


    @Override
    public void setUserSource(String userSource) {

        this.userSource = userSource;
        this.users= new ArrayList<AlephUser>();

        context  = new ClassPathXmlApplicationContext("application-context.xml");


        try {
            reader = new InputStreamReader(new FileInputStream(this.userSource), "UTF-8");
            parser = new CSVParser(reader, CSVFormat.EXCEL.withHeader());
            iterator = parser.iterator();

        } catch (IOException e) {
            throw new RuntimeException("It was not possible read from the csv file, caused by: " + e.getMessage());
        }
        while(iterator.hasNext()){
            CSVRecord record = iterator.next();
            users.add(UserFactory.createAnAlephUser(record));
        }
    }


    @Override
    public List<String> getFieldsName() {
        return null;
    }

    @Override
    public String getFieldValue()
    {
        return null;
    }

    @Override
    public List<AlephUser> getUsers() {
        return users;
    }

}
