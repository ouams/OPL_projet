// default package (CtPackage.TOP_LEVEL_PACKAGE_NAME in Spoon= unnamed package)



public class FreqTableExampleOriginal {
    public static final int NUM_ASCII_CHAR = 128;

    public static void main(java.lang.String[] args) {
        int[] freqs = FreqTableExampleOriginal.createFreqTableURL("http://www.utexas.edu/");
        if ((freqs.length) == 0)
            java.lang.System.out.println("No frequency table created due to problems when reading from file");
        else {
            for (int i = 0 ; i < (NUM_ASCII_CHAR) ; i++) {
                java.lang.System.out.println(((((("charcater code: " + i) + " ,character: ") + ((char)(i))) + " ,frequency: ") + (freqs[i])));
            }
            java.lang.System.out.println(("Total characters in file: " + (FreqTableExampleOriginal.sum(freqs))));
        }
        freqs = new int[]{  };
        try {
            freqs = FreqTableExampleOriginal.createTable("ciaFactBook2008.txt");
        } catch (java.io.FileNotFoundException e) {
            java.lang.System.out.println(("File not found. Unable to create freq table" + e));
        } catch (java.io.IOException e) {
            java.lang.System.out.println(("Problem while reading from file. Unable to create freq table" + e));
        }
        if ((freqs.length) == 0)
            java.lang.System.out.println("No frequency table created due to problems when reading from file");
        else {
            for (int i = 0 ; i < (freqs.length) ; i++) {
                java.lang.System.out.println(((((("charcater code: " + i) + " ,character: ") + ((char)(i))) + " ,frequency: ") + (freqs[i])));
            }
            java.lang.System.out.println(("Total characters in file: " + (FreqTableExampleOriginal.sum(freqs))));
        }
    }

    private static int sum(int[] list) {
        assert list != null : "Failed precondition, sum: parameter list" + " may not be null.";
        int total = 0;
        for (int x : list) {
            total += x;
        }
        return total;
    }

    public static int[] createFreqTableURL(java.lang.String url) {
        if (url == null)
            throw new java.lang.IllegalArgumentException("Violation of precondition. parameter url must not be null.");
        
        int[] freqs = new int[NUM_ASCII_CHAR];
        try {
            java.net.URL inputURL = new java.net.URL(url);
            java.io.InputStreamReader in = new java.io.InputStreamReader(inputURL.openStream());
            while (in.ready()) {
                int c = in.read();
                if ((0 <= c) && (c < (freqs.length)))
                    (freqs[c])++;
                else
                    java.lang.System.out.println(((("Non ASCII char: " + c) + " ") + ((char)(c))));
                
            }
            in.close();
        } catch (java.net.MalformedURLException e) {
            java.lang.System.out.println("Bad URL.");
            freqs = new int[0];
        } catch (java.io.IOException e) {
            java.lang.System.out.println(("Unable to read from resource." + e));
            freqs = new int[0];
        }
        return freqs;
    }

    public static int[] createTable(java.lang.String fileName) throws java.io.FileNotFoundException, java.io.IOException {
        int[] freqs = new int[NUM_ASCII_CHAR];
        java.io.File f = new java.io.File(fileName);
        java.io.FileReader r = new java.io.FileReader(f);
        while (r.ready()) {
            int ch = r.read();
            if ((0 <= ch) && (ch < (freqs.length)))
                (freqs[ch])++;
            else
                java.lang.System.out.println(((char)(ch)));
            
        }
        r.close();
        return freqs;
    }
}

