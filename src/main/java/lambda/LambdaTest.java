package lambda;

import org.junit.Test;

import java.io.FilenameFilter;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * lambda表达式
 * lambda形参列表（接口中抽象方法的形参列表） lambda操作符（->） lambda体（重写的抽象方法的方法体）
 * 本质：作为函数式接口（@FunctionalInterface：只声明了一个抽象方法的接口）的实例
 *
 * @author xiejialin
 * @date 2020/12/01
 */
public class LambdaTest {

    /**
     * 语法格式1：无参，无返回值
     */
    @Test
    public void test1() {
        Runnable run = new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
            }
        };
        run.run();
        Runnable run1 = () -> System.out.println("run1");
        run1.run();
    }

    /**
     * 格式2：有参，无返回值
     */
    @Test
    public void test2() {
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("accept");

        // 省掉数据类型，类型推断；形参中只有一个参数可省略括号，lambda体只有一条语句可省略大括号
        Consumer<String> con1 = s -> System.out.println(s);
        con1.accept("accept1");
    }


    @Test
    public void test3() {
        // lambda体只有一条语句还可省略return
        Comparator<Integer> com = (com1, com2) -> com1.compareTo(com2);
        System.out.println(com.compare(12, 12));
    }

    /**
     * 方法引用
     * 格式：类或对象 :: 方法名
     */
    @Test
    public void test4() {
        Consumer<String> con = str -> System.out.println(str);
        con.accept("con");

        Consumer<String> con1 = System.out::println;
        con1.accept("con1");

        Comparator<String> com = String::compareTo;
        System.out.println(com.compare("a", "c"));
    }

    /**
     * 构造器引用
     */
    @Test
    public void test5() {
        Supplier<Student> sup = Student :: new;
        Student stu = sup.get();
    }
}

class Student {

}
