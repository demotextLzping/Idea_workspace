//package com.lzp.classloader;
//
//import com.lzp.Hello;
//
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//
///**
// * @author: LZPing
// * @date: 2023-03-25 15:36
// * @Description
// */
//
//public class TestClassLoaderWithEncription extends ClassLoader {
//    //加密 对该值进行异或加密，解密只需要再次异或
//    public static int seed = 0B1011011;
//
//    @Override
//    protected Class<?> findClass(String name) throws ClassNotFoundException {
//        File f = new File("D:/Idea_workspace/JVM/JVMStudy/src/main/java/", name.replaceAll(".", "/").concat(".class"));
//        try {
//            FileInputStream fis = new FileInputStream(f);
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            int b = 0;
//            while ((b = fis.read()) != 0) {
//                int i = b ^ seed;
//                baos.write(i);
//            }
//            byte[] bytes = baos.toByteArray();
//            baos.close();
//            fis.close();
//            return defineClass(name, bytes, 0, bytes.length);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return super.findClass(name);
//    }
//
//    public static void main(String[] args) throws Exception {
//        encFile("com.lzp.Hello");
//        ClassLoader l = new TestClassLoaderWithEncription();
//        Class<?> clazz = l.loadClass("com.lzp.Hello");
////        System.out.println(clazz);
//        Hello h = (Hello) clazz.newInstance();
//        h.m();
//        System.out.println(l.getClass().getClassLoader());
//        System.out.println(l.getParent());
//    }
//
//    private static void encFile(String name) throws Exception {
//        File f = new File("D:/Idea_workspace/JVM/JVMStudy/src/main/java/", name.replaceAll(".", "/").concat(".class"));
//        FileInputStream fis = new FileInputStream(f);
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        int b = 0;
//        while ((b = fis.read()) != 0) {
//            int i = b ^ seed;
//            baos.write(i);
//        }
//        fis.close();
//        baos.close();
//    }
//}
