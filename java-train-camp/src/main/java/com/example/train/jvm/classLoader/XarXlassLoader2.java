package com.example.train.jvm.classLoader;

import com.example.train.util.XarFileUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
public class XarXlassLoader2 extends ClassLoader {



    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = new byte[1024*8];;
        int len = 0;
        try {
            URL url = getResource("entity1.xar");
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
