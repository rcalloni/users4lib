package users4lib.model;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Created by luizfr on 3/21/16.
 */
public class AlephUser {

    private List<Local> localList = new ArrayList<>();
    private List<Address>  addressList = new ArrayList<>();
    private Global global = new Global();


    public Global getGlobal() {
        return global;
    }

    public void setGlobal(Global global) {
        this.global = global;
    }


    public void addGlobal(Local local){
        localList.add(local);
    }

    public void addAddress(Address address){
        addressList.add(address);
    }

    public void saveXML(Document doc, Element e)
    {
        global.saveXML(doc,e);

    }


}
