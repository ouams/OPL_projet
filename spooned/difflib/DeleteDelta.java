package difflib;


public class DeleteDelta<T> extends difflib.Delta<T> {
    public DeleteDelta(difflib.Chunk<T> original ,difflib.Chunk<T> revised) {
        super(original, revised);
    }

    @java.lang.Override
    public void applyTo(java.util.List<T> target) throws difflib.PatchFailedException {
        verify(target);
        int position = getOriginal().getPosition();
        int size = getOriginal().size();
        for (int i = 0 ; i < size ; i++) {
            target.remove(position);
        }
    }

    @java.lang.Override
    public void restore(java.util.List<T> target) {
        int position = getRevised().getPosition();
        java.util.List<T> lines = getOriginal().getLines();
        for (int i = 0 ; i < (lines.size()) ; i++) {
            target.add((position + i), lines.get(i));
        }
    }

    @java.lang.Override
    public difflib.Delta.TYPE getType() {
        return difflib.Delta.TYPE.DELETE;
    }

    @java.lang.Override
    public void verify(java.util.List<T> target) throws difflib.PatchFailedException {
        getOriginal().verify(target);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return ((("[DeleteDelta, position: " + (getOriginal().getPosition())) + ", lines: ") + (getOriginal().getLines())) + "]";
    }
}

