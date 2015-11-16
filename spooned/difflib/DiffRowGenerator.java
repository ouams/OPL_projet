package difflib;


public class DiffRowGenerator {
    private final boolean showInlineDiffs;

    private final boolean ignoreWhiteSpaces;

    private final boolean ignoreBlankLines;

    private final java.lang.String InlineOldTag;

    private final java.lang.String InlineNewTag;

    private final java.lang.String InlineOldCssClass;

    private final java.lang.String InlineNewCssClass;

    private final int columnWidth;

    private final difflib.myers.Equalizer<java.lang.String> equalizer;

    public static class Builder {
        private boolean showInlineDiffs = false;

        private boolean ignoreWhiteSpaces = false;

        private boolean ignoreBlankLines = false;

        private java.lang.String InlineOldTag = "span";

        private java.lang.String InlineNewTag = "span";

        private java.lang.String InlineOldCssClass = "editOldInline";

        private java.lang.String InlineNewCssClass = "editNewInline";

        private int columnWidth = 80;

        public difflib.DiffRowGenerator.Builder showInlineDiffs(boolean val) {
            showInlineDiffs = val;
            return this;
        }

        public difflib.DiffRowGenerator.Builder ignoreWhiteSpaces(boolean val) {
            ignoreWhiteSpaces = val;
            return this;
        }

        public difflib.DiffRowGenerator.Builder ignoreBlankLines(boolean val) {
            ignoreBlankLines = val;
            return this;
        }

        public difflib.DiffRowGenerator.Builder InlineOldTag(java.lang.String tag) {
            InlineOldTag = tag;
            return this;
        }

        public difflib.DiffRowGenerator.Builder InlineNewTag(java.lang.String tag) {
            InlineNewTag = tag;
            return this;
        }

        public difflib.DiffRowGenerator.Builder InlineOldCssClass(java.lang.String cssClass) {
            InlineOldCssClass = cssClass;
            return this;
        }

        public difflib.DiffRowGenerator.Builder InlineNewCssClass(java.lang.String cssClass) {
            InlineNewCssClass = cssClass;
            return this;
        }

        public difflib.DiffRowGenerator.Builder columnWidth(int width) {
            if (width > 0) {
                columnWidth = width;
            } 
            return this;
        }

        public difflib.DiffRowGenerator build() {
            return new difflib.DiffRowGenerator(this);
        }
    }

    private DiffRowGenerator(difflib.DiffRowGenerator.Builder builder) {
        showInlineDiffs = builder.showInlineDiffs;
        ignoreWhiteSpaces = builder.ignoreWhiteSpaces;
        ignoreBlankLines = builder.ignoreBlankLines;
        InlineOldTag = builder.InlineOldTag;
        InlineNewTag = builder.InlineNewTag;
        InlineOldCssClass = builder.InlineOldCssClass;
        InlineNewCssClass = builder.InlineNewCssClass;
        columnWidth = builder.columnWidth;
        equalizer = new difflib.myers.Equalizer<java.lang.String>() {
            public boolean equals(java.lang.String original, java.lang.String revised) {
                if (ignoreWhiteSpaces) {
                    original = original.trim().replaceAll("\\s+", " ");
                    revised = revised.trim().replaceAll("\\s+", " ");
                } 
                return original.equals(revised);
            }
        };
    }

    public java.util.List<difflib.DiffRow> generateDiffRows(java.util.List<java.lang.String> original, java.util.List<java.lang.String> revised) {
        return generateDiffRows(original, revised, difflib.DiffUtils.diff(original, revised, equalizer));
    }

    private java.util.List<java.lang.String> removeBlankLines(java.util.List<java.lang.String> lines) {
        java.util.List<java.lang.String> result = new java.util.ArrayList<java.lang.String>();
        for (java.lang.String line : lines) {
            if ((line.trim().length()) == 0) {
                result.add("");
            } 
            result.add(line);
        }
        return result;
    }

    public java.util.List<difflib.DiffRow> generateDiffRows(java.util.List<java.lang.String> original, java.util.List<java.lang.String> revised, difflib.Patch<java.lang.String> patch) {
        original = difflib.StringUtills.normalize(original);
        revised = difflib.StringUtills.normalize(revised);
        original = difflib.StringUtills.wrapText(original, this.columnWidth);
        revised = difflib.StringUtills.wrapText(revised, this.columnWidth);
        java.util.List<difflib.DiffRow> diffRows = new java.util.ArrayList<difflib.DiffRow>();
        int endPos = 0;
        final java.util.List<difflib.Delta<java.lang.String>> deltaList = patch.getDeltas();
        for (int i = 0 ; i < (deltaList.size()) ; i++) {
            difflib.Delta<java.lang.String> delta = deltaList.get(i);
            difflib.Chunk<java.lang.String> orig = delta.getOriginal();
            difflib.Chunk<java.lang.String> rev = delta.getRevised();
            orig.setLines(difflib.StringUtills.normalize(((java.util.List<java.lang.String>)(orig.getLines()))));
            rev.setLines(difflib.StringUtills.normalize(((java.util.List<java.lang.String>)(rev.getLines()))));
            orig.setLines(difflib.StringUtills.wrapText(((java.util.List<java.lang.String>)(orig.getLines())), this.columnWidth));
            rev.setLines(difflib.StringUtills.wrapText(((java.util.List<java.lang.String>)(rev.getLines())), this.columnWidth));
            for (java.lang.String line : original.subList(endPos, orig.getPosition())) {
                diffRows.add(new difflib.DiffRow(difflib.DiffRow.Tag.EQUAL , line , line));
            }
            if (delta.getClass().equals(difflib.InsertDelta.class)) {
                endPos = (orig.last()) + 1;
                for (java.lang.String line : ((java.util.List<java.lang.String>)(rev.getLines()))) {
                    diffRows.add(new difflib.DiffRow(difflib.DiffRow.Tag.INSERT , "" , line));
                }
                continue;
            } 
            if (delta.getClass().equals(difflib.DeleteDelta.class)) {
                endPos = (orig.last()) + 1;
                for (java.lang.String line : ((java.util.List<java.lang.String>)(orig.getLines()))) {
                    diffRows.add(new difflib.DiffRow(difflib.DiffRow.Tag.DELETE , line , ""));
                }
                continue;
            } 
            if (showInlineDiffs) {
                addInlineDiffs(delta);
            } 
            if ((orig.size()) == (rev.size())) {
                for (int j = 0 ; j < (orig.size()) ; j++) {
                    diffRows.add(new difflib.DiffRow(difflib.DiffRow.Tag.CHANGE , ((java.lang.String)(orig.getLines().get(j))) , ((java.lang.String)(rev.getLines().get(j)))));
                }
            } else if ((orig.size()) > (rev.size())) {
                for (int j = 0 ; j < (orig.size()) ; j++) {
                    diffRows.add(new difflib.DiffRow(difflib.DiffRow.Tag.CHANGE , ((java.lang.String)(orig.getLines().get(j))) , ((rev.getLines().size()) > j ? ((java.lang.String)(rev.getLines().get(j))) : "")));
                }
            } else {
                for (int j = 0 ; j < (rev.size()) ; j++) {
                    diffRows.add(new difflib.DiffRow(difflib.DiffRow.Tag.CHANGE , ((orig.getLines().size()) > j ? ((java.lang.String)(orig.getLines().get(j))) : "") , ((java.lang.String)(rev.getLines().get(j)))));
                }
            }
            endPos = (orig.last()) + 1;
        }
        for (java.lang.String line : original.subList(endPos, original.size())) {
            diffRows.add(new difflib.DiffRow(difflib.DiffRow.Tag.EQUAL , line , line));
        }
        return diffRows;
    }

    private void addInlineDiffs(difflib.Delta<java.lang.String> delta) {
        java.util.List<java.lang.String> orig = ((java.util.List<java.lang.String>)(delta.getOriginal().getLines()));
        java.util.List<java.lang.String> rev = ((java.util.List<java.lang.String>)(delta.getRevised().getLines()));
        java.util.LinkedList<java.lang.String> origList = new java.util.LinkedList<java.lang.String>();
        for (java.lang.Character character : difflib.DiffRowGenerator.join(orig, "\n").toCharArray()) {
            origList.add(character.toString());
        }
        java.util.LinkedList<java.lang.String> revList = new java.util.LinkedList<java.lang.String>();
        for (java.lang.Character character : difflib.DiffRowGenerator.join(rev, "\n").toCharArray()) {
            revList.add(character.toString());
        }
        java.util.List<difflib.Delta<java.lang.String>> inlineDeltas = difflib.DiffUtils.diff(origList, revList).getDeltas();
        if ((inlineDeltas.size()) < 3) {
            java.util.Collections.reverse(inlineDeltas);
            for (difflib.Delta<java.lang.String> inlineDelta : inlineDeltas) {
                difflib.Chunk<java.lang.String> inlineOrig = inlineDelta.getOriginal();
                difflib.Chunk<java.lang.String> inlineRev = inlineDelta.getRevised();
                if (inlineDelta.getClass().equals(difflib.DeleteDelta.class)) {
                    origList = difflib.DiffRowGenerator.wrapInTag(origList, inlineOrig.getPosition(), (((inlineOrig.getPosition()) + (inlineOrig.size())) + 1), this.InlineOldTag, this.InlineOldCssClass);
                } else if (inlineDelta.getClass().equals(difflib.InsertDelta.class)) {
                    revList = difflib.DiffRowGenerator.wrapInTag(revList, inlineRev.getPosition(), (((inlineRev.getPosition()) + (inlineRev.size())) + 1), this.InlineNewTag, this.InlineNewCssClass);
                } else if (inlineDelta.getClass().equals(difflib.ChangeDelta.class)) {
                    origList = difflib.DiffRowGenerator.wrapInTag(origList, inlineOrig.getPosition(), (((inlineOrig.getPosition()) + (inlineOrig.size())) + 1), this.InlineOldTag, this.InlineOldCssClass);
                    revList = difflib.DiffRowGenerator.wrapInTag(revList, inlineRev.getPosition(), (((inlineRev.getPosition()) + (inlineRev.size())) + 1), this.InlineNewTag, this.InlineNewCssClass);
                } 
            }
            java.lang.StringBuilder origResult = new java.lang.StringBuilder();
            java.lang.StringBuilder revResult = new java.lang.StringBuilder();
            for (java.lang.String character : origList) {
                origResult.append(character);
            }
            for (java.lang.String character : revList) {
                revResult.append(character);
            }
            delta.getOriginal().setLines(java.util.Arrays.asList(origResult.toString().split("\n")));
            delta.getRevised().setLines(java.util.Arrays.asList(revResult.toString().split("\n")));
        } 
    }

    public static java.util.LinkedList<java.lang.String> wrapInTag(java.util.LinkedList<java.lang.String> sequence, int startPosition, int endPosition, java.lang.String tag, java.lang.String cssClass) {
        java.util.LinkedList<java.lang.String> result = ((java.util.LinkedList<java.lang.String>)(sequence.clone()));
        java.lang.StringBuilder tagBuilder = new java.lang.StringBuilder();
        tagBuilder.append("<");
        tagBuilder.append(tag);
        if (cssClass != null) {
            tagBuilder.append(" class=\"");
            tagBuilder.append(cssClass);
            tagBuilder.append("\"");
        } 
        tagBuilder.append(">");
        java.lang.String startTag = tagBuilder.toString();
        tagBuilder.delete(0, tagBuilder.length());
        tagBuilder.append("</");
        tagBuilder.append(tag);
        tagBuilder.append(">");
        java.lang.String endTag = tagBuilder.toString();
        result.add(startPosition, startTag);
        result.add(endPosition, endTag);
        return result;
    }

    public static java.lang.String wrapInTag(java.lang.String line, java.lang.String tag, java.lang.String cssClass) {
        java.lang.StringBuilder tagBuilder = new java.lang.StringBuilder();
        tagBuilder.append("<");
        tagBuilder.append(tag);
        if (cssClass != null) {
            tagBuilder.append(" class=\"");
            tagBuilder.append(cssClass);
            tagBuilder.append("\"");
        } 
        tagBuilder.append(">");
        java.lang.String startTag = tagBuilder.toString();
        tagBuilder.delete(0, tagBuilder.length());
        tagBuilder.append("</");
        tagBuilder.append(tag);
        tagBuilder.append(">");
        java.lang.String endTag = tagBuilder.toString();
        return (startTag + line) + endTag;
    }

    private static <T>java.lang.String join(final java.lang.Iterable<T> objs, final java.lang.String delimiter) {
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
}

