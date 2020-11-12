package com.example.train.jvm;

import java.util.HashSet;
import java.util.Set;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 14:00 on 2020/10/28
 * @version V0.1
 * @classNmae RuntimeConstantPoolOOM
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
// 使用Set保持着常量池引用， 避免Full GC回收常量池行为
        Set<String> set = new HashSet<String>();
// 在short范围内足以让6MB的PermSize产生OOM了
        short i = 0;
        while (true) {
            set.add(String.valueOf(i++).intern());
        }
    }
}
