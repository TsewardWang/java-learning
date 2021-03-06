package com.zetian.study.collection.iterator;

/**
 * Description
 * 集合的遍历方式：
 * 1.toArray(),可以把集合转换成数组，然后遍历数组即可
 * 2.iterator(),可以返回一个迭代器对象，我们可以通过迭代器对象来迭代集合
 * <p>
 * Iterator：可以用于遍历集合
 * E next()  :返回下一个元素
 * boolean hasNext()  ：判断是否有元素可以获取
 * <p>
 * 注意：Exception in thread "main" java.util.NoSuchElementException
 * 使用next方法获取下一个元素，如果没有元素可以获取，则出现NoSuchElementException
 *
 * @author Zetian Wang
 * @date 2019/10/22
 **/

import java.util.*;


public class IteratorDemo {
    public static void main(String[] args) {
        method();
        //创建集合对象
        List<String> c = new ArrayList<String>();
        //添加元素
        c.add("hello");
        c.add("world");
        c.add("java");
        //获取迭代器对象
        Iterator it = c.iterator();
        // hasNext()  ：判断是否有元素可以获取
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    private static void method() {
        //创建集合对象
        List<String> stringList = new ArrayList<String>();
        //添加元素
        stringList.add("hello");
        stringList.add("world");
        stringList.add("w");
        //获取数组
        Object[] obj = stringList.toArray();
        //遍历数组对象
        for (int i = 0; i < obj.length; i++) {
            System.out.println(obj[i]);
        }
    }
}
