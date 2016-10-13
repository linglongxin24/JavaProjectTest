package list;

import java.util.Comparator;

/**
 * Created by yuandl on 2016-10-10.
 */
public class UserComparator implements Comparator<UserBean> {
    @Override
    public int compare(UserBean o1, UserBean o2) {
        return o1.getAge()-o2.getAge();
    }
}
