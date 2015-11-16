package difflib;


public class DiffUtils {
    private static java.util.regex.Pattern unifiedDiffChunkRe = java.util.regex.Pattern.compile("^@@\\s+-(?:(\\d+)(?:,(\\d+))?)\\s+\\+(?:(\\d+)(?:,(\\d+))?)\\s+@@$");

    public static <T>difflib.Patch<T> diff(java.util.List<T> original, java.util.List<T> revised) {
        return difflib.DiffUtils.diff(original, revised, new difflib.myers.MyersDiff<T>());
    }

    public static <T>difflib.Patch<T> diff(java.util.List<T> original, java.util.List<T> revised, difflib.myers.Equalizer<T> equalizer) {
        if (equalizer != null) {
            return difflib.DiffUtils.diff(original, revised, new difflib.myers.MyersDiff<T>(equalizer));
        } 
        return difflib.DiffUtils.diff(original, revised, new difflib.myers.MyersDiff<T>());
    }

    public static <T>difflib.Patch<T> diff(java.util.List<T> original, java.util.List<T> revised, difflib.DiffAlgorithm<T> algorithm) {
        if (original == null) {
            throw new java.lang.IllegalArgumentException("original must not be null");
        } 
        if (revised == null) {
            throw new java.lang.IllegalArgumentException("revised must not be null");
        } 
        if (algorithm == null) {
            throw new java.lang.IllegalArgumentException("algorithm must not be null");
        } 
        return algorithm.diff(original, revised);
    }

    public static <T>java.util.List<T> patch(java.util.List<T> original, difflib.Patch<T> patch) throws difflib.PatchFailedException {
        return patch.applyTo(original);
    }

    public static <T>java.util.List<T> unpatch(java.util.List<T> revised, difflib.Patch<T> patch) {
        return patch.restore(revised);
    }

    public static difflib.Patch<java.lang.String> parseUnifiedDiff(java.util.List<java.lang.String> diff) {
        boolean inPrelude = true;
        java.util.List<java.lang.String[]> rawChunk = new java.util.ArrayList<java.lang.String[]>();
        difflib.Patch<java.lang.String> patch = new difflib.Patch<java.lang.String>();
        int old_ln = 0;
        int new_ln = 0;
        java.lang.String tag;
        java.lang.String rest;
        for (java.lang.String line : diff) {
            if (inPrelude) {
                if (line.startsWith("+++")) {
                    inPrelude = false;
                } 
                continue;
            } 
            java.util.regex.Matcher m = difflib.DiffUtils.unifiedDiffChunkRe.matcher(line);
            if (m.find()) {
                if ((rawChunk.size()) != 0) {
                    java.util.List<java.lang.String> oldChunkLines = new java.util.ArrayList<java.lang.String>();
                    java.util.List<java.lang.String> newChunkLines = new java.util.ArrayList<java.lang.String>();
                    for (java.lang.String[] raw_line : rawChunk) {
                        tag = raw_line[0];
                        rest = raw_line[1];
                        if ((tag.equals(" ")) || (tag.equals("-"))) {
                            oldChunkLines.add(rest);
                        } 
                        if ((tag.equals(" ")) || (tag.equals("+"))) {
                            newChunkLines.add(rest);
                        } 
                    }
                    patch.addDelta(new difflib.ChangeDelta<java.lang.String>(new difflib.Chunk<java.lang.String>((old_ln - 1) , oldChunkLines) , new difflib.Chunk<java.lang.String>((new_ln - 1) , newChunkLines)));
                    rawChunk.clear();
                } 
                old_ln = (m.group(1)) == null ? 1 : java.lang.Integer.parseInt(m.group(1));
                new_ln = (m.group(3)) == null ? 1 : java.lang.Integer.parseInt(m.group(3));
                if (old_ln == 0) {
                    old_ln += 1;
                } 
                if (new_ln == 0) {
                    new_ln += 1;
                } 
            } else {
                if ((line.length()) > 0) {
                    tag = line.substring(0, 1);
                    rest = line.substring(1);
                    if (((tag.equals(" ")) || (tag.equals("+"))) || (tag.equals("-"))) {
                        rawChunk.add(new java.lang.String[]{ tag , rest });
                    } 
                } else {
                    rawChunk.add(new java.lang.String[]{ " " , "" });
                }
            }
        }
        if ((rawChunk.size()) != 0) {
            java.util.List<java.lang.String> oldChunkLines = new java.util.ArrayList<java.lang.String>();
            java.util.List<java.lang.String> newChunkLines = new java.util.ArrayList<java.lang.String>();
            for (java.lang.String[] raw_line : rawChunk) {
                tag = raw_line[0];
                rest = raw_line[1];
                if ((tag.equals(" ")) || (tag.equals("-"))) {
                    oldChunkLines.add(rest);
                } 
                if ((tag.equals(" ")) || (tag.equals("+"))) {
                    newChunkLines.add(rest);
                } 
            }
            patch.addDelta(new difflib.ChangeDelta<java.lang.String>(new difflib.Chunk<java.lang.String>((old_ln - 1) , oldChunkLines) , new difflib.Chunk<java.lang.String>((new_ln - 1) , newChunkLines)));
            rawChunk.clear();
        } 
        return patch;
    }

    public static java.util.List<java.lang.String> generateUnifiedDiff(java.lang.String original, java.lang.String revised, java.util.List<java.lang.String> originalLines, difflib.Patch<java.lang.String> patch, int contextSize) {
        if (!(patch.getDeltas().isEmpty())) {
            java.util.List<java.lang.String> ret = new java.util.ArrayList<java.lang.String>();
            ret.add(("--- " + original));
            ret.add(("+++ " + revised));
            java.util.List<difflib.Delta<java.lang.String>> patchDeltas = new java.util.ArrayList<difflib.Delta<java.lang.String>>(patch.getDeltas());
            java.util.List<difflib.Delta<java.lang.String>> deltas = new java.util.ArrayList<difflib.Delta<java.lang.String>>();
            difflib.Delta<java.lang.String> delta = patchDeltas.get(0);
            deltas.add(delta);
            if ((patchDeltas.size()) > 1) {
                for (int i = 1 ; i < (patchDeltas.size()) ; i++) {
                    int position = delta.getOriginal().getPosition();
                    difflib.Delta<java.lang.String> nextDelta = patchDeltas.get(i);
                    if (((position + (delta.getOriginal().size())) + contextSize) >= ((nextDelta.getOriginal().getPosition()) - contextSize)) {
                        deltas.add(nextDelta);
                    } else {
                        java.util.List<java.lang.String> curBlock = difflib.DiffUtils.processDeltas(originalLines, deltas, contextSize);
                        ret.addAll(curBlock);
                        deltas.clear();
                        deltas.add(nextDelta);
                    }
                    delta = nextDelta;
                }
            } 
            java.util.List<java.lang.String> curBlock = difflib.DiffUtils.processDeltas(originalLines, deltas, contextSize);
            ret.addAll(curBlock);
            return ret;
        } 
        return new java.util.ArrayList<java.lang.String>();
    }

    private static java.util.List<java.lang.String> processDeltas(java.util.List<java.lang.String> origLines, java.util.List<difflib.Delta<java.lang.String>> deltas, int contextSize) {
        java.util.List<java.lang.String> buffer = new java.util.ArrayList<java.lang.String>();
        int origTotal = 0;
        int revTotal = 0;
        int line;
        difflib.Delta<java.lang.String> curDelta = deltas.get(0);
        int origStart = ((curDelta.getOriginal().getPosition()) + 1) - contextSize;
        if (origStart < 1) {
            origStart = 1;
        } 
        int revStart = ((curDelta.getRevised().getPosition()) + 1) - contextSize;
        if (revStart < 1) {
            revStart = 1;
        } 
        int contextStart = (curDelta.getOriginal().getPosition()) - contextSize;
        if (contextStart < 0) {
            contextStart = 0;
        } 
        for (line = contextStart ; line < (curDelta.getOriginal().getPosition()) ; line++) {
            buffer.add((" " + (origLines.get(line))));
            origTotal++;
            revTotal++;
        }
        buffer.addAll(difflib.DiffUtils.getDeltaText(curDelta));
        origTotal += curDelta.getOriginal().getLines().size();
        revTotal += curDelta.getRevised().getLines().size();
        int deltaIndex = 1;
        while (deltaIndex < (deltas.size())) {
            difflib.Delta<java.lang.String> nextDelta = deltas.get(deltaIndex);
            int intermediateStart = (curDelta.getOriginal().getPosition()) + (curDelta.getOriginal().getLines().size());
            for (line = intermediateStart ; line < (nextDelta.getOriginal().getPosition()) ; line++) {
                buffer.add((" " + (origLines.get(line))));
                origTotal++;
                revTotal++;
            }
            buffer.addAll(difflib.DiffUtils.getDeltaText(nextDelta));
            origTotal += nextDelta.getOriginal().getLines().size();
            revTotal += nextDelta.getRevised().getLines().size();
            curDelta = nextDelta;
            deltaIndex++;
        }
        contextStart = (curDelta.getOriginal().getPosition()) + (curDelta.getOriginal().getLines().size());
        for (line = contextStart ; (line < (contextStart + contextSize)) && (line < (origLines.size())) ; line++) {
            buffer.add((" " + (origLines.get(line))));
            origTotal++;
            revTotal++;
        }
        java.lang.StringBuffer header = new java.lang.StringBuffer();
        header.append("@@ -");
        header.append(origStart);
        header.append(",");
        header.append(origTotal);
        header.append(" +");
        header.append(revStart);
        header.append(",");
        header.append(revTotal);
        header.append(" @@");
        buffer.add(0, header.toString());
        return buffer;
    }

    private static java.util.List<java.lang.String> getDeltaText(difflib.Delta<java.lang.String> delta) {
        java.util.List<java.lang.String> buffer = new java.util.ArrayList<java.lang.String>();
        for (java.lang.String line : delta.getOriginal().getLines()) {
            buffer.add(("-" + line));
        }
        for (java.lang.String line : delta.getRevised().getLines()) {
            buffer.add(("+" + line));
        }
        return buffer;
    }
}

