package com.zjy.study.leetcodestudy.apiCase;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

/**
 * @Author zjy
 * @Date 2023/2/13 16:08
 * @Description
 *      探究深浅clone
 */
public class T_Clone {
    public static void main(String[] args) {
        Student student = new Student();
        student.setId(1);
        student.setName("zjy");
        Address address = new Address();
        address.setId(2);
        address.setDescribe("nb");
        student.setAddress(address);
        Student clone = student.clone();
        System.out.println("************");
        System.out.println("student == clone："+(student == clone));
        System.out.println("二级对象内容："+(student.getAddress() == clone.getAddress()));
        System.out.println("二级对象中内容："+(Objects.equals(student.getAddress().getDescribe(), clone.getAddress().getDescribe())));

        System.out.println("修改属性前");
        System.out.println(student);
        System.out.println(clone);
        student.setName("zg");
        address.setDescribe("tz");
        System.out.println("修改属性后");
        System.out.println(student);
        System.out.println(clone);
    }

    @ToString
    @Setter
    @Getter
    private static class Student implements Cloneable {
        private Integer id;
        private String name;
        private Address address;

        @Override
        public Student clone() {
            try {
                Student clone = (Student) super.clone();
                // 内部的引用对象决定拷贝与否就是深浅拷贝的判断
                clone.address = (Address) address.clone();
                // TODO: copy mutable state here, so the clone can't change the internals of the original
                return clone;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }
    }

    @ToString
    @Setter
    @Getter
    private static class Address implements Cloneable{
        private Integer id;
        private String describe;

        @Override
        public Address clone() {
            try {
                Address clone = (Address) super.clone();
                // TODO: copy mutable state here, so the clone can't change the internals of the original
                return clone;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }
    }
}
