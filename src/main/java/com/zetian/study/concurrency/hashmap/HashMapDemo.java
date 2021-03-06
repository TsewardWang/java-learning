package com.zetian.study.concurrency.hashmap;
import java.util.HashMap;
import java.util.Set;

/**
 * Description
 *
 * @author Zetian Wang
 * @date 2019/11/02
 **/

public class HashMapDemo {
    public static void main(String[] args) {
        // 创建集合对象
        HashMap<Student, String> hm = new HashMap<Student, String>(1);

        // 创建学生对象
        Student s1 = new Student("貂蝉", 27);
        Student s2 = new Student("王昭君", 30);
        Student s3 = new Student("西施", 33);
        Student s4 = new Student("杨玉环", 35);
        Student s5 = new Student("貂蝉", 27);

        // 添加元素
        hm.put(s1, "111");
        hm.put(s2, "222");
        hm.put(s3, "333");
        hm.put(s4, "444");
        hm.put(s5, "555");

        // 遍历
        Set<Student> set = hm.keySet();
        for (Student key : set) {
            String value = hm.get(key);
            System.out.println(key.getName() + "   " + key.getAge() + "   " + value);
        }
    }
}
