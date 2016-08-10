package users4lib.readers;

import users4lib.model.AlephUser;
import users4lib.model.EZproxyUser;
import users4lib.model.Global;
import users4lib.model.User;

import java.util.List;

/**
 * Created by luizfr on 3/22/16.
 */
public interface UsersReader {

    public void setUserSource(String source);
    public List<String> getFieldsName();
    public String getFieldValue();
    public List<User> getUsers();

}
