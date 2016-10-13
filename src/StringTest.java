/**
 * Created by yuandl on 2016-10-09.
 */
public class StringTest {
    public static void main(String[] args) {
        stringDemo1();
        stringMethodDemo_4();
        Integer x = 129;//jdk1.5以后，自动装箱，如果装箱的是一个字节，那么该数据会被共享不会重新开辟空间。
        Integer y = 129;
        System.out.println(x==y);//
        System.out.println(x.equals(y));//true
    }

    /**
     * 演示字符串定义的第一种方式，并明确字符串常量池的特点.
     * 池中没有就建立，池中有，直接用。
     */
    private static void stringDemo1() {
        String s = "abc";//"abc"存储在字符串常量池中。
        // s = "nba";
        String s1 = "abc";
        System.out.println(s == s1);//true?
        // System.out.println("s="+s);

    }
    private static void stringMethodDemo_4() {
        System.out.println("abc".compareTo("aqz"));
    }
}
