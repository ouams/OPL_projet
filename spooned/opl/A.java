package opl;


public class A {
    public static void main(java.lang.String[] args) {
        java.lang.String hello = new java.lang.String("HalloWorld");
        int num = 15;
        opl.A.initialize();
        opl.A.firstAction(hello, 4, true);
        opl.A.secondAction(num);
        opl.A.godMethod(hello, true);
    }

    private static void initialize() {
        opl.A.setStatement(true);
        opl.A.setConfig(false);
    }

    private static boolean setStatement(boolean _switch) {
        return _switch;
    }

    private static void setConfig(boolean _cfg) {
        if (_cfg)
            opl.A.setConfigFile("B.java");
        else
            java.lang.System.out.println("Configuration complete");
        
    }

    private static void setConfigFile(java.lang.String _path) {
        java.lang.System.out.println(_path);
    }

    private static void firstAction(java.lang.String str, int num, boolean _isTrue) {
        java.lang.System.out.println(("fonction foo " + str));
        opl.A.secondAction(num);
    }

    private static void secondAction(int num) {
        for (int i = 0 ; i < num ; i++) {
            java.lang.System.out.println(num);
        }
    }

    private static void godMethod(java.lang.String str, boolean isGodly) {
    }
}

