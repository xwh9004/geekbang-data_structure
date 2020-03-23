package ch12;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 11:06 on 2019/12/18
 * @version V0.1
 * @classNmae Test
 */
public class Test implements Cloneable {

    public Test(){
        System.out.println("invoke Test()");
    }

    public static void main(String[] args) {
        Test test = new Test();
        try {
            test.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

}
