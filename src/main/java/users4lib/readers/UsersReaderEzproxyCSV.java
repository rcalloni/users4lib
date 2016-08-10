package users4lib.readers;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import users4lib.model.EZproxyUser;
import users4lib.model.User;
import users4lib.model.UserFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Luiz Claudio Santos on 8/10/16.
 */
public class UsersReaderEzproxyCSV implements UsersReader {

    private Reader reader;
    private CSVParser parser;
    private Iterator<CSVRecord> iterator;
    private String userSource;
    private List<User> eZProxyUsers;

    @Override
    public void setUserSource(String userSource) {

        this.userSource = userSource;
        this.eZProxyUsers = new ArrayList<User>();

        try {
            reader = new InputStreamReader(new FileInputStream(this.userSource), "UTF-8");
            parser = new CSVParser(reader, CSVFormat.EXCEL.withHeader());
            for (CSVRecord record : parser){
                eZProxyUsers.add(UserFactory.createAnEzproxyUser(record));
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
    public String getFieldValue() {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return eZProxyUsers;
    }


}
