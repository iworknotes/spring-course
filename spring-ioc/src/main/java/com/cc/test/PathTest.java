package com.cc.test;

/**
 * @ClassName PathTest
 * @Description
 * @Author hyl
 * @Date 02/19/2020 22:54
 **/
public class PathTest {

    public static void main(String[] args) {
        PathTest test = new PathTest();
        test.printPath();
    }

    public void printPath() {
        System.out.println(this.getClass().getResource("/").getPath());
        System.out.println(Thread.currentThread().getClass().getResource("/").getPath());
        System.out.println(this.getClass().getClassLoader().getResource("").getPath());
    }
}
