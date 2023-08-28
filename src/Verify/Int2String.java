package Verify;

import java.util.Collections;
import java.util.PriorityQueue;

public class Int2String {
    public static void main(String[] args) {
        String a = Integer.toString(123);
        System.out.println(a);
        int b = Integer.parseInt("123");
        System.out.println(b);
        int c = Integer.valueOf("123");
        System.out.println(c);
    }
}
