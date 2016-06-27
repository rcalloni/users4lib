package users4lib.readers;

import java.util.List;

/**
 * Created by luizfr on 3/22/16.
 */
public interface UsersReader {

    public void setUserSource(String source);
    public List<String> getFieldsName();
    public String getFieldValue();

}
