package users4lib.model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Created by Luiz Claudio Santos on 7/26/16.
 */
public class PatronID {

    private String recordAction;
    private String z308KeyType;
    private String z308KeyData;
    private String z308Verification;
    private String z308VerificationType;
    private String z308Status;
    private String z308Encryption;

    public String getRecordAction() {
        return recordAction;
    }

    public void setRecordAction(String recordAction) {
        this.recordAction = recordAction;
    }

    public String getZ308KeyType() {
        return z308KeyType;
    }

    public void setZ308KeyType(String z308KeyType) {
        this.z308KeyType = z308KeyType;
    }

    public String getZ308VerificationType() {
        return z308VerificationType;
    }

    public void setZ308VerificationType(String z308VerificationType) {
        this.z308VerificationType = z308VerificationType;
    }

    public String getz308Status() {
        return z308Status;
    }

    public void setz308Status(String z308Status) {
        this.z308Status = z308Status;
    }

    public String getZ308Encryption() {
        return z308Encryption;
    }

    public void setZ308Encryption(String z308Encryption) {
        this.z308Encryption = z308Encryption;
    }

    public String getZ308KeyData() {
        return z308KeyData;
    }

    public void setZ308KeyData(String z308KeyData) {
        this.z308KeyData = z308KeyData;
    }

    public String getZ308Verification() {
        return z308Verification;
    }

    public void setZ308Verification(String z308Verification) {
        this.z308Verification = z308Verification;
    }

    public void saveXML(Document doc, Element parent){

        Element z308=doc.createElement("z308");

        Element recordActionElem=doc.createElement("record-action");
        recordActionElem.appendChild(doc.createTextNode(this.recordAction));
        z308.appendChild(recordActionElem);

        Element z308KeyTypeElem=doc.createElement("z308-key-type");
        z308KeyTypeElem.appendChild(doc.createTextNode(this.z308KeyType));
        z308.appendChild(z308KeyTypeElem);

        Element z308KeyDataElem=doc.createElement("z308-key-data");
        z308KeyDataElem.appendChild(doc.createTextNode(this.z308KeyData));
        z308.appendChild(z308KeyDataElem);


        Element z308VerificationElem=doc.createElement("z308-verification");
        z308VerificationElem.appendChild(doc.createTextNode(this.z308Verification));
        z308.appendChild(z308VerificationElem);

        Element z308VerificationTypeElem=doc.createElement("z308-verification-type");
        z308VerificationTypeElem.appendChild(doc.createTextNode(this.z308VerificationType));
        z308.appendChild(z308VerificationTypeElem);

        Element z308StatusElem=doc.createElement("z308-status");
        z308StatusElem.appendChild(doc.createTextNode(this.z308Status));
        z308.appendChild(z308StatusElem);

        Element z308EncryptionElem=doc.createElement("z308-encryption");
        z308EncryptionElem.appendChild(doc.createTextNode(this.z308Encryption));
        z308.appendChild(z308EncryptionElem);

        parent.appendChild(z308);
    }

}
