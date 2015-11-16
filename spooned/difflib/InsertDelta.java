package difflib;


public class InsertDelta<T> extends difflib.Delta<T> {
    public InsertDelta(difflib.Chunk<T> original ,difflib.Chunk<T> revised) {
        super(original, revised);
    }

    @java.lang.Override
    public void applyTo(java.util.List<T> target) throws difflib.PatchFailedException {
        verify(target);
        int position = getOriginal().getPosition();
        java.util.List<T> lines = getRevised().getLines();
        for (int i = 0 ; i < (lines.size()) ; i++) {
            target.add((position + i), lines.get(i));
        }
    }

    @java.lang.Override
    public void restore(java.util.List<T> target) {
        int position = getRevised().getPosition();
        int size = getRevised().size();
        for (int i = 0 ; i < size ; i++) {
            target.remove(position);
        }
    }

    @java.lang.Override
    public void verify(java.util.List<T> target) throws difflib.PatchFailedException {
        if ((getOriginal().getPosition()) > (target.size())) {
            throw new difflib.PatchFailedException(("Incorrect patch for delta: " + "delta original position > target size"));
        } 
    }

    public difflib.Delta.TYPE getType() {
        return difflib.Delta.TYPE.INSERT;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return ((("[InsertDelta, position: " + (getOriginal().getPosition())) + ", lines: ") + (getRevised().getLines())) + "]";
    }
}

