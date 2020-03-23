package com.pattern.prototype;

import org.junit.Test;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 15:05 on 2020/3/5
 * @version V0.1
 * @classNmae PrototypeTest
 */
public class PrototypeTest {

    @Test
    public void prototypeTest() throws CloneNotSupportedException {

        Person jesse = new Person();

        jesse.setAge(18);
        jesse.setCardNo("3625**********761X");
        jesse.setName("Jesse");
        jesse.setGrade("D");
        jesse.setClassRoom(new ClassRoom("room A"));
        System.out.println("jesse's classroom is  "+jesse.getClassRoom());
        //clone person;
        Person cloneObj = (Person) jesse.clone();
        System.out.println(cloneObj);
        System.out.println("cloneObj's classroom is  "+cloneObj.getClassRoom());
    }
}
