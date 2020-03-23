package com.pattern.prototype;

import ch14.Example;
import lombok.Data;

import java.io.*;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 14:51 on 2020/3/5
 * @version V0.1
 * @classNmae Example
 */
@Data
public class Person implements Cloneable {


    private String name;

    private int age;

    private String cardNo;

    private String grade;

    private ClassRoom classRoom;



    public Person(){
        this.grade = "C";
        System.out.println("init something");
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
//        Person obj= (Person) super.clone();
//        obj.setClassRoom(new ClassRoom(classRoom.getRoomName()));

        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = null;
        Object obj =null;
        try {
            oo = new ObjectOutputStream(bo);
            oo.writeObject(this);
            ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
            ObjectInputStream oi = new ObjectInputStream(bi);
            obj= oi.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return obj;
    }
}
