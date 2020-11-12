package com.example.train.util;

import java.io.*;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * <p><b>Description:</b>
 * 利用zipFile
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 15:05 on 2020/11/12
 * @version V0.1
 * @classNmae XarFileUtil
 */
public class XarFileUtil {

    public static InputStream file(File xarFile,String fileName) throws IOException {

        ZipFile zipFile = new ZipFile(xarFile);
        ZipInputStream zin = new ZipInputStream(new FileInputStream(xarFile));

        ZipEntry ze = zipFile.getEntry(fileName);
        if(Objects.isNull(ze)){
            throw new FileNotFoundException(fileName + " can not be found!");
        }
        InputStream in = zipFile.getInputStream(ze);
        return in;
    }

    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = XarFileUtil.class.getClassLoader();
        File file =new File( classLoader.getResource("entity.xar").getFile());
        file(file,"Person.xlass");
    }

}
