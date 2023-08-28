package Verify;

public class StringLength {
    public static void main(String[] args) {
        String a = "";
        System.out.println(a.length());
        String b = null;
        System.out.println(b.length()); // will cause exception
    }
}
