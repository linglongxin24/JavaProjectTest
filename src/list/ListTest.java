package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yuandl on 2016-10-10.
 */
public class ListTest {
    public static void main(String args[]) {
        List<UserBean> list = new ArrayList<>();
        list.add(new UserBean("张三", 56));
        list.add(new UserBean("张2", 5));
        list.add(new UserBean("张6", 34));
        list.add(new UserBean("张5", 6));
        list.add(new UserBean("张9", 76));
        Collections.sort(list);//让list中的对象具有比较性即UserBean implements Comparable<list.UserBean>
        Collections.sort(list, new Comparator<UserBean>() {//自定义比较器
            @Override
            public int compare(UserBean o1, UserBean o2) {
                return o1.getAge()-o2.getAge();
            }
        });
        System.out.println(list);

    }
}
