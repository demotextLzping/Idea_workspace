package com.lzp.classloader;

import com.lzp.Hello;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @author: LZPing
 * @date: 2023-03-25 14:55
 * @Description 测试自定义C lassLoader
 */

public class TestClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File f = new File("D:/Idea_workspace/JVM/JVMStudy/src/main/java/", name.replaceAll("\\.", "/").concat(".class"));
        try {
            FileInputStream fis = new FileInputStream(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b;
            while ((b = fis.read()) != 0) {
                baos.write(b);
            }
            byte[] bytes = baos.toByteArray();
            baos.close();
            fis.close();
            return defineClass(name, bytes, 0, bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    public static void main(String[] args) throws Exception {
        ClassLoader l = new TestClassLoader();
        Class<?> clazz = l.loadClass("com.lzp.Hello");
//        System.out.println(clazz);
        Hello h = (Hello) clazz.newInstance();
        h.m();
        System.out.println(l.getClass().getClassLoader());
        System.out.println(l.getParent());
    }
}
