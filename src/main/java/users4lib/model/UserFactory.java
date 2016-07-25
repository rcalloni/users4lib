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

        user.setGlobal(global);

        for(String subLibrary : subLibraryList){
            Local local = new Local();
            local.setRecrodAction(alephProperties.getValeuBypropertyName("z305-record-action"));
            local.setZ305Id(userId);
            local.setZ305SubLibrary(subLibrary);
            local.setZ305BorType("");
            local.setZ305BorStatus(getZ305BorType(userType));
            local.setZ305RegistrationDate("20090101");
            local.setZ305ExpiryDate(getLastDayOfTheYear());
            local.setZ305Delinq1("+");
            local.setZ305DelinqN1("+");
            local.setZ305Note("+");
            user.addLocal(local);
        }

        Address address = new Address();
        address.setRecordAction(alephProperties.getValeuBypropertyName("z304-record-action"));
        address.setZ304Id(userId);
        user.addAddress(address);
        /*
        address.setZ304address1();
        address.setZ304address2();
        address.setZ304address3();
        address.setZ304address4();
        address.setZ304zip();
        address.setZ304EmailAddres();
        address.set304
        */



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
        return email.substring(0, email.indexOf("@"));
    }

}
