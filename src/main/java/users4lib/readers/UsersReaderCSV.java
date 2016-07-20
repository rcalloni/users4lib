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
    private List<Global> users;


    @Override
    public void setUserSource(String userSource) {

        this.userSource = userSource;
        this.users= new ArrayList<Global>();

        context  = new ClassPathXmlApplicationContext("application-context.xml");
        PropertiesCSVReader csvUserFeilds = context.getBean("PropertiesCSVReader", PropertiesCSVReader.class);

        try {
            reader = new InputStreamReader(new FileInputStream(this.userSource), "UTF-8");
            parser = new CSVParser(reader, CSVFormat.EXCEL.withHeader());
            iterator = parser.iterator();

        } catch (IOException e) {
            throw new RuntimeException("It was not possible read from the csv file, caused by: " + e.getMessage());
        }
        while(iterator.hasNext()){
            CSVRecord record = iterator.next();


            String lastName =record.get(csvUserFeilds.getValeuBypropertyName("user.last.name"));
            String firstName = record.get(csvUserFeilds.getValeuBypropertyName("user.first.name"));
            String userType =record.get( csvUserFeilds.getValeuBypropertyName("user.type"));
            String emailAddress = record.get(csvUserFeilds.getValeuBypropertyName("user.email"));
            String jobTitle = record.get(csvUserFeilds.getValeuBypropertyName("user.job.title"));
            String nationanlity = record.get(csvUserFeilds.getValeuBypropertyName("user.nationality"));
            String phone = record.get(csvUserFeilds.getValeuBypropertyName("user.phone"));
            String fax = record.get(csvUserFeilds.getValeuBypropertyName("user.fax"));
            String extensionNumber = record.get(csvUserFeilds.getValeuBypropertyName("user.extensionNumber"));
            String office = record.get(csvUserFeilds.getValeuBypropertyName("user.office"));
            String department = record.get(csvUserFeilds.getValeuBypropertyName("user.department"));
            String unit = record.get(csvUserFeilds.getValeuBypropertyName("user.unit"));
            String officeLocation = record.get(csvUserFeilds.getValeuBypropertyName("user.OfficeLocation"));


            String userId = getIdFromEmail(emailAddress);
            Global global = new Global();

            global.setZ303Id(userId);
            global.setZ303UserType("REG");
            global.setZ303ConLng("ENG");
            global.setZ303Name(firstName==null?"":firstName + lastName==null?"":lastName);
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

            global.setZ303BirthPlace(nationanlity==null?"":nationanlity);
            users.add(global);

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
    public String getFieldValue()
    {
        return null;
    }
    public List<Global> getGlobalUsers()
    {
        return users;
    }


}
