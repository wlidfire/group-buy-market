package cn.bugstack.test.flect;

import java.lang.reflect.Field;

public class ReflectionExample {
    public static void main(String[] args) throws Exception {
        // 创建Person实例
        Person person = new Person("John");

        // 获取Person类的Class对象
        Class<?> personClass = person.getClass();

        // 获取name字段对象
        Field nameField = personClass.getDeclaredField("name");

        // 如果字段是私有的，则需要设置可访问
        // 此处不设置可访问，则会报错
        nameField.setAccessible(true);

        // 打印原始的name字段值
        System.out.println("Original Name: " + nameField.get(person));

        // 修改name字段的值
        nameField.set(person, "Jane");

        // 打印修改后的name字段值
        System.out.println("Modified Name: " + nameField.get(person));
    }
}