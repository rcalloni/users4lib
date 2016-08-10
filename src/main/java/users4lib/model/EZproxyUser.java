package users4lib.model;

/**
 * Created by Luiz Claudio Santos on 7/25/16.
 */
public class EZproxyUser implements User {

    private String id;
    private String ezProxyLine;

    public EZproxyUser(String ezProxyLine){
        this.ezProxyLine = ezProxyLine;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public String toEzproxy(){
        return id.toUpperCase() + ezProxyLine;
    }
}
