package users4lib.readers;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import users4lib.config.PropertiesCSVReader;
import users4lib.model.Address;
import users4lib.model.Global;
import users4lib.model.Local;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by luizfr on 3/22/16.
 */
public class UsersReaderCSV implements UsersReader {

    private Reader reader;
    private CSVParser parser;
    private Iterator<CSVRecord> iterator;
    private String userSource;
    private ApplicationContext context;


    @Override
    public void setUserSource(String userSource) {

        this.userSource = userSource;

        context  = new ClassPathXmlApplicationContext("application-context.xml");
        PropertiesCSVReader csvUserFeilds = context.getBean("PropertiesCSVReader", PropertiesCSVReader.class);

        try {
            reader = new InputStreamReader(new FileInputStream(this.userSource), "UTF-8");
            parser = new CSVParser(reader, CSVFormat.EXCEL.withHeader());
            iterator = parser.iterator();



        } catch (IOException e) {
            throw new RuntimeException("It was not possible read from the csv file, caused by: " + e.getMessage());
        }
        if (iterator.hasNext()){
            CSVRecord record = iterator.next();
            String lastName = csvUserFeilds.getValeuBypropertyName("Last Name");
            String firstName = csvUserFeilds.getValeuBypropertyName("First Name");
            String userType = csvUserFeilds.getValeuBypropertyName("User Type");
            String emailAddress = csvUserFeilds.getValeuBypropertyName("Email Address");
            String jobTitle = csvUserFeilds.getValeuBypropertyName("Job Title");
            String nacioanlity = csvUserFeilds.getValeuBypropertyName("Nacionality");
            String phone = csvUserFeilds.getValeuBypropertyName("Business Phone");
            String fax = csvUserFeilds.getValeuBypropertyName("Fax Phone");
            String extensionNumber = csvUserFeilds.getValeuBypropertyName("ExtensionNumber");
            String office = csvUserFeilds.getValeuBypropertyName("office");
            String department = csvUserFeilds.getValeuBypropertyName("Department");
            String unit = csvUserFeilds.getValeuBypropertyName("Unit");
            String officeLocation = csvUserFeilds.getValeuBypropertyName("Office Location");

            String userId = getIdFromEmail(emailAddress);
            Global global = new Global();

            global.setZ303Id(userId);
            global.setZ303UserType("REG");
            global.setZ303ConLng("ENG");
            global.setZ303Name(firstName + lastName);
            global.setZ303Title("+");
            global.setZ303Delinq1("+");
            global.setZ303DelinqN1("+");
            global.setZ303Delinq3("+");
            global.setZ303DelinqN3("+");
            global.setZ303Buget("");
            global.setZ303ProfileId("+");
            global.setZ303IllLibrary("+");
            global.setZ303HomeLibrary("FHL");
            global.setZ303Field1(unit);
            global.setZ303Field2("+");
            global.setZ303Field3("+");
            global.setZ303IllTotalLimit("");
            global.setZ303IllActiveLmit("");
            global.setZ303BirthDate("");
            global.setZ303ExportConsent("Y");
            global.setZ303ProfileId("00");
            global.setZ303SendAllLetters("Y");
            global.setZ303PlainHtml("B");
            global.setZ303WantSMS("N");
            global.setZ303TitleRegLimit("9999");
            global.setZ303Gender("+");
            global.setZ303BirthDate(nacioanlity);







        }

    }


    public Address makeAddress(String userId){
        Address address = new Address();



        return address;
    }

    private Local makeLocal(String userId, String subLibrary, String userType ){
        Local local = new Local();
        local.setRecrodAction("A");
        local.setZ305Id(userId);
        local.setZ305SubLibrary(subLibrary);
        local.setZ305BorType("");
        local.setZ305BorStatus(getBorStatus(userType));
        local.setZ305RegistrationDate("+");
        local.setZ305ExpiryDate(getEndOfTheYear());
        local.setZ305Delinq1("+");
        local.setZ305DelinqN1("+");
        return local;
    }

    private String getEndOfTheYear(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        Date date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String year = sdf.format(date);
        return year + "1231";
    }


    private String getBorStatus(String userType){
        if(userType.equals("STAFF")){
            return "01";
        }
        return "02";
    }


    private String getIdFromEmail(String email){
        String [] values = email.split("@");
        return values[0];
    }



    @Override
    public List<String> getFieldsName() {
        return null;
    }

    @Override
    public String getFieldValue() {
        return null;
    }
}
