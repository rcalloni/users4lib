package users4lib.model;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Created by luizfr on 3/21/16.
 */
public class AlephUser implements User {

    private List<Local> localList = new ArrayList<>();
    private List<Address>  addressList = new ArrayList<>();
    private List<PatronID>  idList = new ArrayList<>();
    private Global global;



    public Global getGlobal() {
        return global;
    }

    public void setGlobal(Global global){
       this.global = global;
    }

    public void addPatronID(PatronID patronID) {
        idList.add(patronID);
    }

    public void addAddress(Address address){
        addressList.add(address);
    }

    public void addLocal (Local local){
        localList.add(local);

    }

    public void saveXML(Document doc, Element parent) {
        Element patronRecord=doc.createElement("patron-record");
        parent.appendChild(patronRecord);
        global.saveXML(doc,patronRecord);

        for(Address address:addressList){
            address.saveXML(doc, patronRecord);
        }

        for(Local local:localList){
            local.saveXML(doc, patronRecord);
        }

        for(PatronID id:idList){
            id.saveXML(doc, patronRecord);
        }


    }

    @Override
    public String getId() {
        return null;
    }
}
