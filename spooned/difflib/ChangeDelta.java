package difflib;


public class ChangeDelta<T> extends difflib.Delta<T> {
    public ChangeDelta(difflib.Chunk<T> original ,difflib.Chunk<T> revised) {
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
        int i = 0;
        for (T line : getRevised().getLines()) {
            target.add((position + i), line);
            i++;
        }
    }

    @java.lang.Override
    public void restore(java.util.List<T> target) {
        int position = getRevised().getPosition();
        int size = getRevised().size();
        for (int i = 0 ; i < size ; i++) {
            target.remove(position);
        }
        int i = 0;
        for (T line : getOriginal().getLines()) {
            target.add((position + i), line);
            i++;
        }
    }

    public void verify(java.util.List<T> target) throws difflib.PatchFailedException {
        getOriginal().verify(target);
        if ((getOriginal().getPosition()) > (target.size())) {
            throw new difflib.PatchFailedException(("Incorrect patch for delta: " + "delta original position > target size"));
        } 
    }

    @java.lang.Override
    public java.lang.String toString() {
        return ((((("[ChangeDelta, position: " + (getOriginal().getPosition())) + ", lines: ") + (getOriginal().getLines())) + " to ") + (getRevised().getLines())) + "]";
    }

    @java.lang.Override
    public difflib.Delta.TYPE getType() {
        return difflib.Delta.TYPE.CHANGE;
    }
}

