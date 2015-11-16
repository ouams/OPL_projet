package shell;


class ThreadedStreamHandler extends java.lang.Thread {
    java.io.InputStream inputStream;

    java.lang.String adminPassword;

    java.io.OutputStream outputStream;

    java.io.PrintWriter printWriter;

    java.lang.StringBuilder outputBuffer = new java.lang.StringBuilder();

    private boolean sudoIsRequested = false;

    ThreadedStreamHandler(java.io.InputStream inputStream) {
        this.inputStream = inputStream;
    }

    ThreadedStreamHandler(java.io.InputStream inputStream ,java.io.OutputStream outputStream ,java.lang.String adminPassword) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
        this.printWriter = new java.io.PrintWriter(outputStream);
        this.adminPassword = adminPassword;
        this.sudoIsRequested = true;
    }

    public void run() {
        if (sudoIsRequested) {
            printWriter.println(adminPassword);
            printWriter.flush();
        } 
        java.io.BufferedReader bufferedReader = null;
        try {
            bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream));
            java.lang.String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                outputBuffer.append((line + "\n"));
            }
        } catch (java.io.IOException ioe) {
            ioe.printStackTrace();
        } catch (java.lang.Throwable t) {
            t.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (java.io.IOException e) {
            }
        }
    }

    private void doSleep(long millis) {
        try {
            java.lang.Thread.sleep(millis);
        } catch (java.lang.InterruptedException e) {
        }
    }

    public java.lang.StringBuilder getOutputBuffer() {
        return outputBuffer;
    }
}

