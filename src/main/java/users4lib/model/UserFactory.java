package users4lib.model;

import org.apache.commons.csv.CSVRecord;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import users4lib.config.PropertiesCSVReader;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by luizfr on 3/29/16.
 */
public class UserFactory {

    private static ApplicationContext context  = new ClassPathXmlApplicationContext("application-context.xml");
    private static PropertiesCSVReader csvUserFeilds = context.getBean("PropertiesCSVReader", PropertiesCSVReader.class);
    private static PropertiesCSVReader alephProperties = context.getBean("PropertiesAlephRead", PropertiesCSVReader.class);
    private static PropertiesCSVReader ezproxyProperties = context.getBean("PropertiesEZproxyRead", PropertiesCSVReader.class);

    public static EZproxyUser createAnEzproxyUser(CSVRecord record){
        String emailAddress = record.get(csvUserFeilds.getValeuBypropertyName("user.email"));
        String ezproxyLine = ezproxyProperties.getValeuBypropertyName("ezproxy.line");
        String userId = getIdFromEmail(emailAddress);
        EZproxyUser user = new EZproxyUser(ezproxyLine);
        user.setId(userId);
        return user;
    }

    public static AlephUser createAnAlephUser(CSVRecord record){

        List <String> subLibraryList = new ArrayList<String>(Arrays.asList(alephProperties.getValeuBypropertyName("z305-subLibraries").split(",")));

        AlephUser user = new AlephUser();

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

        String stopNumber = record.get("StopNumber");

        String userId = getIdFromEmail(emailAddress);
        Global global = new Global();

        global.setZ303Id(userId);
        global.setZ303UserType("REG");
        global.setZ303ConLng("ENG");
        String nameFull = lastName + ", " + firstName;
        global.setZ303Name(nameFull);
        global.setZ303Title("+");
        global.setZ303Delinq1("+");
        global.setZ303DelinqN1("+");
        global.setZ303Delinq3("+");
        global.setZ303DelinqN3("+");
        global.setZ303Buget("+");
        global.setZ303ProfileId("+");
        global.setZ303IllLibrary("+");
        global.setZ303HomeLibrary("FHL");
        global.setZ303Field1(unit);
        global.setZ303Field2("+");
        global.setZ303Field3("+");
        global.setZ303IllTotalLimit("+");
        global.setZ303IllActiveLmit("+");
        global.setZ303BirthDate("+");
        global.setZ303ExportConsent("Y");
        global.setZ303ProfileId("+");
        global.setZ303SendAllLetters("Y");
        global.setZ303PlainHtml("B");
        global.setZ303WantSMS("N");
        global.setZ303TitleRegLimit("9999");
        global.setZ303Gender("+");
        global.setZ303BirthPlace(nationanlity==null?"+":nationanlity);

        user.setGlobal(global);

        for(String subLibrary : subLibraryList){
            Local local = new Local();
            local.setRecrodAction(alephProperties.getValeuBypropertyName("z305-record-action"));
            local.setZ305Id(userId);
            local.setZ305SubLibrary(subLibrary);
            local.setZ305BorType("+");
            local.setZ305BorStatus(getZ305BorType(userType));
            local.setZ305RegistrationDate("20090101");
            local.setZ305ExpiryDate(getLastDayOfTheYear());
            local.setZ305Delinq1("+");
            local.setZ305DelinqN1("+");
            local.setZ305Note("+");
            user.addLocal(local);
        }

        for (int i = 0; i < 2; i++){
            PatronID id = new PatronID();
            id.setRecordAction("A");
            id.setZ308KeyType("00");
            id.setZ308KeyData(userId);
            if(i == 0){
                id.setZ308Verification("FHL-" + userId + "-10");
            }else{
                id.setZ308Verification("10" + userId);
            }
            id.setZ308VerificationType("00");
            id.setz308Status("AC");
            id.setZ308Encryption("H");
            user.addPatronID(id);
        }

        Address address = new Address();
        address.setRecordAction(alephProperties.getValeuBypropertyName("z304-record-action"));
        address.setZ304Id(userId);
        address.setZ304sequence("01");
        address.setZ304address1("+");
        address.setZ304address2("+");
        address.setZ304address3(office==null?"+":office);
        address.setZ304address4(stopNumber==null?"+":stopNumber);
        address.setZ304zip("+");
        address.setZ304EmailAddres(emailAddress==null?"+":emailAddress);
        address.setZ304Telephone(phone==null || phone.equals("")?"+":phone);
        address.setZ304Telephone2(fax==null || fax.equals("")?"+":fax);
        address.setZ304DateFrom("20090101");
        address.setZ304DateTo("20161231");
        address.setZ304AddressType("01");
        address.setZ304address3("+");
        address.setZ304address4("+");
        user.addAddress(address);

        return user;
    }




    private static String getLastDayOfTheYear(){
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        return format.format(now) + "1231";
    }

    private static String getZ305BorType(String userType){
        if(userType.equals("Staff")){
            return "01";
        }else if(userType.equals("Contractual")){
            return "02";
        }else if(userType.equals("Contractor")){
            return "02";
        }else if(userType.equals("Pensioners")){
            return "07";
        }else if(userType.equals("Staff")){
            return "01";
        }else if(userType.equals("Unknown")){
            return "02";
        }
        return "02";
    }

    private static String getIdFromEmail(String email){
        return email.substring(0, email.indexOf("@")).toUpperCase();
    }

}
