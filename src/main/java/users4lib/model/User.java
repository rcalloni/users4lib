package users4lib.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luizfr on 3/24/16.
 */
public class User {

    private List<Field> fields = new ArrayList<Field>();

    public void addField(Field field){
        fields.add(field);
    }


}
