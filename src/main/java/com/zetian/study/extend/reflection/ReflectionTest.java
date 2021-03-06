package com.zetian.study.extend.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * Description   使用反射打印类的所有特性
 *
 * @author Zetian Wang
 * @date 2019/09/29
 **/
public class ReflectionTest {
    public static void main(String[] args) {
        //从命令行args或用户输入中读取类名
        String name;
        if (args.length > 0) {
            name = args[0];
        } else {
            Scanner in = new Scanner(System.in);
            System.out.println("请输入文件名（e.g.java.util.Date）:");
            name = in.next();
        }
        try {
            //打印类名和超类名(if !=Object)
            Class c1 = Class.forName(name);
            Class superc1 = c1.getSuperclass();
            String modifiers = Modifier.toString(c1.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
                System.out.print("class" + name);
            }
            if (superc1 != null && superc1 != Object.class) {
                System.out.print("extends" + superc1.getName());
            }
            System.out.print("\n{\n");
            printConstructors(c1);
            System.out.println();
            printMethods(c1);
            System.out.println();
            printFields(c1);
            System.out.println("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    /**
     * 打印类的所有构造函数
     */
    public static void printConstructors(Class c1) {
        //构建一个公用的构造函数
        Constructor[] constructors = c1.getDeclaredConstructors();
        for (Constructor c : constructors) {
            String name = c.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(name + " ");
                //打印参数类型
                Class[] paramTypes = c.getParameterTypes();
                for (int j = 0; j < paramTypes.length; j++) {
                    if (j > 0) {
                        System.out.println(",");
                        System.out.print(paramTypes[j].getName());
                    }
                    System.out.println(");");
                }
            }
        }
    }

    /**
     * 打印类的所有方法
     *
     * @param c1
     */
    public static void printMethods(Class c1) {
        Method[] methods = c1.getDeclaredMethods();
        for (Method m : methods) {

            Class retType = m.getReturnType();
            String name = m.getName();
            System.out.print("  ");
            //打印修饰符、返回类型和方法名称
            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
                System.out.print(retType.getName() + " " + name + "(");
            }
            //打印参数类型
            Class[] paramTypes = m.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0) {
                    System.out.print(",");
                    System.out.print(paramTypes[j].getName());
                }
                System.out.println(");");
            }
        }
    }

    /**
     * 打印类的所有字段
     *
     * @param c1
     */
    public static void printFields(Class c1) {
        Field[] fields = c1.getDeclaredFields();
        for (Field f : fields) {
            Class type = f.getType();
            String name = f.getName();
            System.out.print(" ");
            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
                System.out.println(type.getName() + " " + name + ";");
            }
        }
    }
}
