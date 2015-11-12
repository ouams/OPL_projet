package opl;


public class A {
    public static void main(java.lang.String[] args) {
        java.lang.String fooString = new java.lang.String("HalloWorld");
        int num = 15;
        opl.A.foo(fooString, 4);
        opl.A.faa(num);
    }

    private static void foo(java.lang.String str, int num) {
        java.lang.System.out.println(("fonction foo " + str));
        opl.A.faa(num);
    }

    private static void faa(int num) {
        for (int i = 0 ; i < num ; i++) {
            java.lang.System.out.println(num);
        }
    }
}

