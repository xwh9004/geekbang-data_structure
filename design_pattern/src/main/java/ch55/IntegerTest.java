package ch55;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 14:52 on 2020/3/23
 * @version V0.1
 * @classNmae IntegerTest
 */
public class IntegerTest {

    public static void main(String[] args) {

        Integer i1 = 56;
        Integer i2 = 56;
        Integer i3 = 129;
        Integer i4 = 129;

        System.out.println(i1 == i2);   //true
        System.out.println(i3 == i4);   //false
    }
}
