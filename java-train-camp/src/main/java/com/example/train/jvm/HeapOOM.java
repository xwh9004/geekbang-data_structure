package com.example.train.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 11:01 on 2020/10/28
 * @version V0.1
 * @classNmae HeapOOM
 */
public class HeapOOM {

    static class OOMObject {
    }
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
