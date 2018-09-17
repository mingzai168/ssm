package com.spring.test.jvmtets;

class Jvmtest {

    public static void main(String[] args) {
        Object o = new Object();

        Jvmtest jvmtest = new Jvmtest();

        System.out.println(jvmtest.getClass().getClassLoader());
        System.out.println(jvmtest.getClass().getClassLoader().getParent());
        System.out.println(jvmtest.getClass().getClassLoader().getParent().getParent());

    }
}
