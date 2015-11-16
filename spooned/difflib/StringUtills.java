package difflib;


public class StringUtills {
    public static <T>java.lang.String join(final java.lang.Iterable<T> objs, final java.lang.String delimiter) {
        java.util.Iterator<T> iter = objs.iterator();
        if (!(iter.hasNext())) {
            return "";
        } 
        java.lang.StringBuffer buffer = new java.lang.StringBuffer(java.lang.String.valueOf(iter.next()));
        while (iter.hasNext()) {
            buffer.append(delimiter).append(java.lang.String.valueOf(iter.next()));
        }
        return buffer.toString();
    }

    public static java.lang.String expandTabs(java.lang.String str) {
        return str.replace("\t", "    ");
    }

    public static java.lang.String htmlEntites(java.lang.String str) {
        return str.replace("<", "&lt;").replace(">", "&gt;");
    }

    public static java.lang.String normalize(java.lang.String str) {
        return difflib.StringUtills.expandTabs(difflib.StringUtills.htmlEntites(str));
    }

    public static java.util.List<java.lang.String> normalize(java.util.List<java.lang.String> list) {
        java.util.List<java.lang.String> result = new java.util.LinkedList<java.lang.String>();
        for (java.lang.String line : list) {
            result.add(difflib.StringUtills.normalize(line));
        }
        return result;
    }

    public static java.util.List<java.lang.String> wrapText(java.util.List<java.lang.String> list, int columnWidth) {
        java.util.List<java.lang.String> result = new java.util.LinkedList<java.lang.String>();
        for (java.lang.String line : list) {
            result.add(difflib.StringUtills.wrapText(line, columnWidth));
        }
        return result;
    }

    public static java.lang.String wrapText(java.lang.String line, int columnWidth) {
        int lenght = line.length();
        int delimiter = "<br>".length();
        int widthIndex = columnWidth;
        for (int count = 0 ; lenght > widthIndex ; count++) {
            line = ((line.subSequence(0, (widthIndex + (delimiter * count)))) + "<br>") + (line.substring((widthIndex + (delimiter * count))));
            widthIndex += columnWidth;
        }
        return line;
    }
}

