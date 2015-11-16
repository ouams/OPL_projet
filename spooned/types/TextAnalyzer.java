package types;


public class TextAnalyzer {
    public TextAnalyzer() {
    }

    public static java.util.ArrayList<java.lang.String> getInput(java.lang.String filename) {
        java.util.ArrayList<java.lang.String> entry = new java.util.ArrayList<java.lang.String>();
        try {
            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(filename));
            java.lang.String line = reader.readLine();
            while (line != null) {
                entry.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (java.io.FileNotFoundException e) {
            java.lang.System.out.println("This is not a valid directory for the file path specified.");
        } catch (java.io.IOException e) {
        }
        return entry;
    }
}

