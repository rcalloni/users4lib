package users4lib.model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Created by luizfr on 3/21/16.
 */
public class Address {

    private String recordAction;
    private String z304Id;
    private String getZ304sequence;
    private String z304address1;
    private String z304address2;
    private String z304address3;
    private String z304address4;
    private String z304zip;
    private String z304EmailAddres;
    private String z304Telephone;
    private String getZ304Telephone2;
    private String z304DateFrom;
    private String z304DateTo;
    private String z304AddressType;

    public String getZ304Id() {
        return z304Id;
    }

    public void setZ304Id(String z304Id) {
        this.z304Id = z304Id;
    }

    public String getGetZ304sequence() {
        return getZ304sequence;
    }

    public void setGetZ304sequence(String getZ304sequence) {
        this.getZ304sequence = getZ304sequence;
    }

    public String getZ304address1() {
        return z304address1;
    }

    public void setZ304address1(String z304address1) {
        this.z304address1 = z304address1;
    }

    public String getZ304address2() {
        return z304address2;
    }

    public void setZ304address2(String z304address2) {
        this.z304address2 = z304address2;
    }

    public String getZ304address3() {
        return z304address3;
    }

    public void setZ304address3(String z304address3) {
        this.z304address3 = z304address3;
    }

    public String getZ304address4() {
        return z304address4;
    }

    public void setZ304address4(String z304address4) {
        this.z304address4 = z304address4;
    }

    public String getZ304zip() {
        return z304zip;
    }

    public void setZ304zip(String z304zip) {
        this.z304zip = z304zip;
    }

    public String getZ304EmailAddres() {
        return z304EmailAddres;
    }

    public void setZ304EmailAddres(String z304EmailAddres) {
        this.z304EmailAddres = z304EmailAddres;
    }

    public String getZ304Telephone() {
        return z304Telephone;
    }

    public void setZ304Telephone(String z304Telephone) {
        this.z304Telephone = z304Telephone;
    }

    public String getGetZ304Telephone2() {
        return getZ304Telephone2;
    }

    public void setGetZ304Telephone2(String getZ304Telephone2) {
        this.getZ304Telephone2 = getZ304Telephone2;
    }

    public String getZ304DateFrom() {
        return z304DateFrom;
    }

    public void setZ304DateFrom(String z304DateFrom) {
        this.z304DateFrom = z304DateFrom;
    }

    public String getZ304DateTo() {
        return z304DateTo;
    }

    public void setZ304DateTo(String z304DateTo) {
        this.z304DateTo = z304DateTo;
    }

    public String getZ304AddressType() {
        return z304AddressType;
    }

    public void setZ304AddressType(String z304AddressType) {
        this.z304AddressType = z304AddressType;
    }

    public String getRecordAction() {
        return recordAction;
    }

    public void setRecordAction(String recordAction) {
        this.recordAction = recordAction;
    }

    public void saveXML(Document doc, Element parent)


    {
        Element z304=doc.createElement("z304");

        Element recordAction=doc.createElement("record-action");
        recordAction.setNodeValue("A");
        z304.appendChild(recordAction);

        //TODO

       parent.appendChild(z304);
    }
}



