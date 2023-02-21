package com.zjy.study.leetcodestudy.apiCase;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Author zjy
 * @Date 2023/2/21 13:13
 * @Description
 */
public class T_FunctionalInterface {
    public static void main(String[] args) {
        /**
         * Function 函数型接口 有一个输入，有一个输出
         * 只要是 函数式接口 可以用 lambda表达式简化
         */
        Function<String,String> fun = (str) -> str;//lambda表达式
        System.out.println(fun.apply("123"));
        /**
         * Predicate 断定型接口 有一个输入值 返回值是布尔值！
         */
        Predicate<String> predicate = str -> "Y".equals(str);
        System.out.println(predicate.test("N"));
        /**
         * Consumer 消费型接口 只接收参数，不返回值
         */
        Consumer<String> consumer = str -> System.out.println(str);
        consumer.accept("hello");
        /**
         * Supplier 供给型接口 不需参数，有返回值
         */
        Supplier<String> supplier = () -> "world";
        System.out.println(supplier.get());
    }
}
