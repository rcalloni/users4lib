package users4lib.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

/**
 * @Author luizsan
 * This class read the file that cointain the users to be imported and give back the
 * name of the columns to be readed from the pdf.
 */
public class PropertiesCSVReader {

    private Properties properties;

    public PropertiesCSVReader(String propertiesFile) throws IOException {
        properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFile);
        properties.load(inputStream);

    }

    public List<String> getCSVColumns(){
        List<String> listCSVProperties = new ArrayList<String>();
        Enumeration <String> csvColumns = (Enumeration<String>) properties.propertyNames();
        while (csvColumns.hasMoreElements() ){
            String propertieName = csvColumns.nextElement();
            listCSVProperties.add(properties.getProperty(propertieName));
        }
        return listCSVProperties;
    }

    public List<String> getCSVColumnsID(){
        List<String> listCSVProperties = new ArrayList<String>();
        Enumeration <String> csvColumns = (Enumeration<String>) properties.propertyNames();
        while (csvColumns.hasMoreElements() ){
            listCSVProperties.add(csvColumns.nextElement());
        }
        return listCSVProperties;

    }

    public String getValeuBypropertyName(String name){
        return properties.getProperty(name);
    }



}
