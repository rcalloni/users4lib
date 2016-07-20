package users4lib.model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Created by luizfr on 3/21/16.
 */
public class Local {
    private String recrodAction;
    private String z305Id;
    private String z305SubLibrary;
    private String z305BorType;
    private String z305BorStatus;
    private String z305RegistrationDate;
    private String z305ExpiryDate;
    private String z305Delinq1;
    private String z305DelinqN1;
    private String z305Note;


    public String getZ305Id() {
        return z305Id;
    }

    public void setZ305Id(String z305Id) {
        this.z305Id = z305Id;
    }

    public String getZ305SubLibrary() {
        return z305SubLibrary;
    }

    public void setZ305SubLibrary(String z305SubLibrary) {
        this.z305SubLibrary = z305SubLibrary;
    }

    public String getZ305BorType() {
        return z305BorType;
    }

    public void setZ305BorType(String z305BorType) {
        this.z305BorType = z305BorType;
    }

    public String getZ305BorStatus() {
        return z305BorStatus;
    }

    public void setZ305BorStatus(String z305BorStatus) {
        this.z305BorStatus = z305BorStatus;
    }

    public String getZ305RegistrationDate() {
        return z305RegistrationDate;
    }

    public void setZ305RegistrationDate(String z305RegistrationDate) {
        this.z305RegistrationDate = z305RegistrationDate;
    }

    public String getZ305ExpiryDate() {
        return z305ExpiryDate;
    }

    public void setZ305ExpiryDate(String z305ExpiryDate) {
        this.z305ExpiryDate = z305ExpiryDate;
    }

    public String getZ305Delinq1() {
        return z305Delinq1;
    }

    public void setZ305Delinq1(String z305Delinq1) {
        this.z305Delinq1 = z305Delinq1;
    }

    public String getZ305DelinqN1() {
        return z305DelinqN1;
    }

    public void setZ305DelinqN1(String z305DelinqN1) {
        this.z305DelinqN1 = z305DelinqN1;
    }

    public String getZ305Note() {
        return z305Note;
    }

    public void setZ305Note(String z305Note) {
        this.z305Note = z305Note;
    }

    public String getRecrodAction() {
        return recrodAction;
    }

    public void setRecrodAction(String recrodAction)
    {
        this.recrodAction = recrodAction;
    }

    public void saveXML(Document doc, Element parent)
    {

        Element z305=doc.createElement("z305");

        Element recordAction=doc.createElement("record-action");
        recordAction.appendChild(doc.createTextNode("A"));
        z305.appendChild(recordAction);

        Element z305Id=doc.createElement("z305-id");
        z305Id.appendChild(doc.createTextNode(this.z305Id));
        z305.appendChild(z305Id);

         Element z305SubLibrary=doc.createElement("z305-sub-library");
        z305SubLibrary.appendChild(doc.createTextNode(this.z305SubLibrary));
        z305.appendChild(z305SubLibrary);

         Element z305BorType=doc.createElement("z305-bor-type");
        z305BorType.appendChild(doc.createTextNode(this.z305BorType));
        z305.appendChild(z305BorType);

         Element z305BorStatus=doc.createElement("z305-bor-status");
        z305BorStatus.appendChild(doc.createTextNode(this.z305BorStatus));
        z305.appendChild(z305BorStatus);

         Element z305RegistrationDate=doc.createElement("z305-registration-date");
        z305RegistrationDate.appendChild(doc.createTextNode(this.z305RegistrationDate));
        z305.appendChild(z305RegistrationDate);

         Element z305ExpiryDate=doc.createElement("z305-expiry-date");
        z305ExpiryDate.appendChild(doc.createTextNode(this.z305ExpiryDate));
        z305.appendChild(z305ExpiryDate);

         Element z305Delinq1=doc.createElement("z305-de-linq-1");
        z305Delinq1.appendChild(doc.createTextNode(this.z305Delinq1));
        z305.appendChild(z305Delinq1);

         Element z305DelinqN1=doc.createElement("z305-de-linq-n-1");
        z305DelinqN1.appendChild(doc.createTextNode(this.z305DelinqN1));
        z305.appendChild(z305DelinqN1);

         Element z305Note=doc.createElement("z305-note");
        z305Note.appendChild(doc.createTextNode(this.z305Note));
        z305.appendChild(z305Note);

        
        parent.appendChild(z305);

    }



}


