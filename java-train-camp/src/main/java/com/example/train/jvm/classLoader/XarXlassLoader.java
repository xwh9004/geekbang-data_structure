package com.example.train.jvm.classLoader;

import com.example.train.util.XarFileUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;

/**
 * <p><b>Description:</b>
 * 加载 xar压缩包中的xar
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 13:59 on 2020/11/12
 * @version V0.1
 * @classNmae XarClassLoader
 */
public class XarXlassLoader extends ClassLoader {


    public XarXlassLoader(){

    }

    public XarXlassLoader(boolean reLoad){
        this.reLoad =reLoad;
    }

    private boolean reLoad;

    public static void main(String[] args) throws Exception {
        String personXlass = "Person";
        XarXlassLoader classLoader = new XarXlassLoader();

        Object person = classLoader.findClass(personXlass).newInstance();
        Method method = person.getClass().getMethod("work");
        method.invoke(person);
//        person = null;
        classLoader = null;
        classLoader = new XarXlassLoader(true);
        Object person1 = classLoader.findClass(personXlass).newInstance();
        Method method1 = person1.getClass().getMethod("work");
        method1.invoke(person1);

        System.out.println("person.class=" +person.getClass().equals(person1.getClass()));

    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = new byte[1024*8];;
        int len = 0;
        try {
            URL url = null;
            if(reLoad){
                 url = getResource("entity1.xar");
            }else{
                 url = getResource("entity.xar");
            }
            InputStream in = XarFileUtil.file(new File(url.getFile()), name + ".xlass");
             len =in.read(bytes);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defineClass(name, bytes, 0, len);
    }

}
