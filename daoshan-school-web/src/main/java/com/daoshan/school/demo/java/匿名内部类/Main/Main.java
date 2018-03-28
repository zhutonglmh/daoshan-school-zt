package com.daoshan.school.demo.java.匿名内部类.Main;


import com.daoshan.school.demo.java.匿名内部类.Main.interfaces.Bird;

/**
 * 匿名内部类的使用
 */
public class Main {

    public void test(Bird bird){
        System.out.println(bird.getName() + "能够飞 " + bird.fly2() + "米");
    }

    public static void main(String[] args) {
        Main test = new Main();
        test.test(new Bird() {


            @Override
            public int fly2() {
                this.setName("哈哈哈哈");
                System.out.println("我会被自定调用哦！");
                return 0;
            }
            @Override
            public int fly() {
                this.setName("哈哈哈哈");
                System.out.println("我会被自定调用哦！");
                return 0;
            }
            public String getName() {
                return "哈哈哈哈";
            }

        });
    }
}
