package com;

import org.junit.Test;

import java.sql.Connection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class test01 {

    public static void main(String[] args) {


        Stu s1 = new Stu(1,"嘻嘻");
        Stu s2 = new Stu(1,"嘻嘻");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }


    @Test
    public void testSort(){
        HashSet<Integer> hashSet = new HashSet<Integer>();
    }
}
