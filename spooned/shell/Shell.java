package shell;


public abstract class Shell {
    public static java.lang.String exec(java.util.ArrayList<java.lang.String> cmd) {
        shell.ShellExec e = new shell.ShellExec(cmd);
        java.lang.String result = "";
        try {
            e.executeCommand();
            java.lang.StringBuilder output = e.getStandardOutputFromCommand();
            result = new java.lang.String(output);
            java.lang.System.out.println("Shell call went ok!");
        } catch (java.io.IOException err) {
            java.lang.System.out.println("MarkShark: There was some IO when executing a shell call.");
        } catch (java.lang.InterruptedException err) {
            java.lang.System.out.println("MarkShark: A shell call was interrupted.");
        }
        return result;
    }

    public static boolean isWindows() {
        java.lang.String os = java.lang.System.getProperty("os.name");
        if (os.contains("Windows")) {
            java.lang.System.out.println("I AM WINDOWS!!!!");
            return true;
        } 
        return false;
    }

    public static java.lang.String pythonCall(java.lang.String cmd) {
        java.util.ArrayList<java.lang.String> l = new java.util.ArrayList<java.lang.String>();
        java.lang.String command;
        if (shell.Shell.isWindows()) {
            command = "C:\\Python27\\python";
        } else {
            command = "python";
        }
        l.add(command);
        l.add(cmd);
        return shell.Shell.exec(l);
    }

    public static java.lang.String pythonCall(java.lang.String cmd, java.lang.String testIn) {
        java.util.ArrayList<java.lang.String> l = new java.util.ArrayList<java.lang.String>();
        java.lang.String command;
        if (shell.Shell.isWindows()) {
            command = "C:\\Python27\\python";
        } else {
            command = "python";
        }
        l.add(command);
        l.add(cmd);
        l.add(testIn);
        return shell.Shell.exec(l);
    }
}

