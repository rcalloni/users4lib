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
public class UsersReaderAlephCSV implements UsersReader {

    private Reader reader;
    private CSVParser parser;
    private Iterator<CSVRecord> iterator;
    private String userSource;
    private List<User> alephUsers;


    @Override
    public void setUserSource(String userSource) {

        this.userSource = userSource;
        this.alephUsers = new ArrayList<User>();

        try {
            reader = new InputStreamReader(new FileInputStream(this.userSource), "UTF-8");
            parser = new CSVParser(reader, CSVFormat.EXCEL.withHeader());
            for (CSVRecord record : parser){
                alephUsers.add(UserFactory.createAnAlephUser(record));
            }

        } catch (IOException e) {
            throw new RuntimeException("It was not possible read from the csv file, caused by: " + e.getMessage());
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
    public List<User> getUsers() {
        return alephUsers;
    }


}
