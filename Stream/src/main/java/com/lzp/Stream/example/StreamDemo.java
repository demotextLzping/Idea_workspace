package com.lzp.Stream.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author: LZPing
 * @date: 2023-01-08 14:21
 * @Description
 */

public class StreamDemo {
    public static void main(String[] args) {
        List<Author> authors = getAuthors();
//        System.out.println(authors);

//        使用匿名内部类
        authors.stream()  //将集合转换为流
                .distinct() // 去重
                .filter(new Predicate<Author>() {
                    @Override
                    public boolean test(Author author) {
                        return author.getAge() < 18;
                    }
                })
                .forEach(new Consumer<Author>() {
                    @Override
                    public void accept(Author author) {
                        System.out.println(author.getName());
                    }
                });
//        使用lambda表达式
        authors.stream()  //将集合转换为流
                .distinct() // 去重
                .filter(author -> author.getAge() < 18)
                .forEach(author -> System.out.println(author.getName()));
    }

    private static List<Author> getAuthors() {
        //数据初始化
        Author author = new Author(1L, "蒙多", 33, "一个从菜刀中名物真理的祖安人", null);
        Author author2 = new Author(2L, "亚拉索", 15, "狂风页追逐不上他的思考速度", null);
        Author author3 = new Author(3L, "易", 14, "是这个世界再限制他的思想", null);
        Author author4 = new Author(3L, "易", 14, "是这个世界再限制他的思想", null);

        //书籍列表
        List<Book> book1 = new ArrayList<>();
        List<Book> book2 = new ArrayList<>();
        List<Book> book3 = new ArrayList<>();

        book1.add(new Book(1L, "刀的两侧是光明与黑暗", "哲学,爱情", 88, "用一把刀划分爱恨"));
        book1.add(new Book(2L, "一个人不能死在同一把刀下", "个人", 99, "讲述如何从失败中明悟真理"));

        book2.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
        book2.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
        book2.add(new Book(4L, "吹或不吹", "爱情,个人", 56, "一个哲学家的恋爱观注定很难把他所在的时代理解"));

        book3.add(new Book(5L, "你的剑就是我的剑", "爱情", 56, "无法想象一个五折对他的伴侣能这么宽容"));
        book3.add(new Book(6L, "风与剑", "个人传记", 100, "两个个哲学家会发生什么样的火花"));
        book3.add(new Book(6L, "风与剑", "个人传记", 100, "两个个哲学家会发生什么样的火花"));

        author.setBooks(book1);
        author2.setBooks(book2);
        author3.setBooks(book3);
        author4.setBooks(book2);

        List<Author> authorlist = new ArrayList<>(Arrays.asList(author, author2, author3, author4));
        return authorlist;
    }
}
