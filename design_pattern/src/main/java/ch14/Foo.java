package ch14;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Xu at 10:49 on 2019/12/11
 * @version V0.1
 * @classNmae Foo
 */
public class Foo {
    static boolean boolValue;

    public static void main(String[] args) {
        boolValue = true; // 将这个true替换为2或者3，再看看打印结果
        if (boolValue) System.out.println("Hello, Java!");
        if (boolValue == true) System.out.println("Hello, JVM!");
    }
}
