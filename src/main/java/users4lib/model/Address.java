package users4lib.model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Created by luizfr on 3/21/16.
 */
public class Address {

    private String recordAction;
    private String z304Id;
    private String z304sequence;
    private String z304address1;
    private String z304address2;
    private String z304address3;
    private String z304address4;
    private String z304zip;
    private String z304EmailAddres;
    private String z304Telephone;
    private String z304Telephone2;
    private String z304DateFrom;
    private String z304DateTo;
    private String z304AddressType;

    public String getZ304Id() {
        return z304Id;
    }

    public void setZ304Id(String z304Id) {
        this.z304Id = z304Id;
    }

    public String getZ304sequence() {
        return z304sequence;
    }

    public void setZ304sequence(String z304sequence) {
        this.z304sequence = z304sequence;
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

    public String getZ304Telephone2() {
        return z304Telephone2;
    }

    public void setZ304Telephone2(String z304Telephone2) {
        this.z304Telephone2 = z304Telephone2;
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
        recordAction.appendChild(doc.createTextNode("A"));
        z304.appendChild(recordAction);

        //TODO
        Element z304Id=doc.createElement("z304-id");
        z304Id.appendChild(doc.createTextNode(this.z304Id));
        z304.appendChild(z304Id);


        Element getZ304sequence=doc.createElement("z304sequence");
        getZ304sequence.appendChild(doc.createTextNode(this.z304sequence));
        z304.appendChild(getZ304sequence);

        Element z304address1=doc.createElement("z304-address-1");
        z304address1.appendChild(doc.createTextNode(this.z304address1));
        z304.appendChild(z304address1);

        Element z304address2=doc.createElement("z304-address-2");
        z304address2.appendChild(doc.createTextNode(this.z304address2));
        z304.appendChild(z304address2);

        Element z304address3=doc.createElement("z304-address-3");
        z304address3.appendChild(doc.createTextNode(this.z304address3));
        z304.appendChild(z304address3);

        Element z304address4=doc.createElement("z304-address-4");
        z304address4.appendChild(doc.createTextNode(this.z304address4));
        z304.appendChild(z304address4);

        Element z304zip=doc.createElement("z304-zip");
        z304zip.appendChild(doc.createTextNode(this.z304zip));
        z304.appendChild(z304zip);

        Element z304EmailAddres=doc.createElement("z304-email-address");
        z304EmailAddres.appendChild(doc.createTextNode(this.z304EmailAddres));
        z304.appendChild(z304EmailAddres);

        Element z304Telephone=doc.createElement("z304-telephone");
        z304Telephone.appendChild(doc.createTextNode(this.z304Telephone));
        z304.appendChild(z304Telephone);

        Element z304Telephone2=doc.createElement("z304-telephone-2");
        z304Telephone2.appendChild(doc.createTextNode(this.z304Telephone2));
        z304.appendChild(z304Telephone2);

        Element z304DateFrom=doc.createElement("z304-date-from");
        z304DateFrom.appendChild(doc.createTextNode(this.z304DateFrom));
        z304.appendChild(z304DateFrom);

        Element z304DateTo=doc.createElement("z304-date-to");
        z304DateTo.appendChild(doc.createTextNode(this.z304DateTo));
        z304.appendChild(z304DateTo);

        Element z304AddressType=doc.createElement("z304-address-type");
        z304AddressType.appendChild(doc.createTextNode(this.z304AddressType));
        z304.appendChild(z304AddressType);


       parent.appendChild(z304);
    }
}



