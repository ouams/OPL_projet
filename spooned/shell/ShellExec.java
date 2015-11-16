package shell;


public class ShellExec {
    private java.util.List<java.lang.String> commandInformation;

    private java.lang.String adminPassword;

    private shell.ThreadedStreamHandler inputStreamHandler;

    private shell.ThreadedStreamHandler errorStreamHandler;

    public ShellExec(final java.util.List<java.lang.String> commandInformation) {
        if (commandInformation == null)
            throw new java.lang.NullPointerException("The commandInformation is required.");
        
        this.commandInformation = commandInformation;
        this.adminPassword = null;
    }

    public int executeCommand() throws java.io.IOException, java.lang.InterruptedException {
        int exitValue = -99;
        try {
            java.lang.ProcessBuilder pb = new java.lang.ProcessBuilder(commandInformation);
            java.lang.Process process = pb.start();
            java.io.OutputStream stdOutput = process.getOutputStream();
            java.io.InputStream inputStream = process.getInputStream();
            java.io.InputStream errorStream = process.getErrorStream();
            inputStreamHandler = new shell.ThreadedStreamHandler(inputStream , stdOutput , adminPassword);
            errorStreamHandler = new shell.ThreadedStreamHandler(errorStream);
            inputStreamHandler.start();
            errorStreamHandler.start();
            exitValue = process.waitFor();
            inputStreamHandler.interrupt();
            errorStreamHandler.interrupt();
            inputStreamHandler.join();
            errorStreamHandler.join();
        } catch (java.io.IOException e) {
            throw e;
        } catch (java.lang.InterruptedException e) {
            throw e;
        } finally {
            return exitValue;
        }
    }

    public java.lang.StringBuilder getStandardOutputFromCommand() {
        return inputStreamHandler.getOutputBuffer();
    }

    public java.lang.StringBuilder getStandardErrorFromCommand() {
        return errorStreamHandler.getOutputBuffer();
    }
}

