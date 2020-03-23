package ch55;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 15:03 on 2020/3/23
 * @version V0.1
 * @classNmae StringTest
 */
public class StringTest {

    public static void main(String[] args) {

        String s1 = "Jesse";
        String s2 = "Jesse";
        String s3 = new String("Jesse");

        String s4 = "Java";
        String s5 = "Java";
        String s6 = new String("Java");

        System.out.println(s1 == s2);   //true
        System.out.println(s1 == s3);   //false

        System.out.println(s4 == s5);   //true
        System.out.println(s5 == s6);   //false
    }
}
