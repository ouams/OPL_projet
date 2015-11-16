package types;


public class Writer {
    public void write(java.util.ArrayList<java.lang.String> outputs, java.lang.String path, java.lang.String name) {
        try {
            java.io.File file = new java.io.File(((path + name) + ".txt"));
            java.io.BufferedWriter output = new java.io.BufferedWriter(new java.io.FileWriter(file));
            for (java.lang.String s : outputs) {
                output.write(s);
                output.newLine();
            }
            output.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}

